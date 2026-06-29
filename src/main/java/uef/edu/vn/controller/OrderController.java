package uef.edu.vn.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import uef.edu.vn.dto.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uef.edu.vn.model.MenuItem;
import uef.edu.vn.model.Employee;
import uef.edu.vn.model.Invoice;
import uef.edu.vn.model.Order;
import uef.edu.vn.model.OrderDetail;
import uef.edu.vn.model.RestaurantTable;
import uef.edu.vn.model.User;
import uef.edu.vn.service.EmployeeService;
import uef.edu.vn.service.InvoiceService;
import uef.edu.vn.service.MenuService;
import uef.edu.vn.service.NotificationService;
import uef.edu.vn.service.OrderService;
import uef.edu.vn.service.RestaurantTableService;

@Controller
@RequestMapping("/staff/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestaurantTableService tableService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public String orderList(
            Model model,
            HttpSession session) {

        User user
                = (User) session.getAttribute("loggedUser");

        Employee employee
                = user == null
                ? null
                : employeeService.findByUserId(user.getUserId());

        List<Order> orders
                = employee == null
                ? orderService.findAll()
                : orderService.findByEmployeeId(employee.getEmployeeId());

        model.addAttribute(
                "orders",
                orders);

        return "staff/order/order-list";
    }

    @GetMapping("/detail/{id}")
    public String detail(
            @PathVariable int id,
            Model model) {

        Order order
                = orderService.findById(id);

        List<OrderDetail> details
                = orderService.findDetails(id);

        model.addAttribute(
                "order",
                order);

        model.addAttribute(
                "details",
                details);

        model.addAttribute(
                "menuItems",
                menuService.findAvailableItems());

        return "staff/order/order-detail";
    }

    @GetMapping("/add")
    public String addForm(
            Model model) {

        List<RestaurantTable> tables
                = tableService.findAvailableTables();

        List<MenuItem> menuItems
                = menuService.findAvailableItems();

        model.addAttribute(
                "tables",
                tables);

        model.addAttribute(
                "menuItems",
                menuItems);

        return "staff/order/create-order";
    }

    @PostMapping("/save")
    public String save(
            @RequestParam String customerName,
            @RequestParam int tableId,
            @RequestParam String orderItems,
            HttpSession session)
            throws Exception {

        ObjectMapper mapper
                = new ObjectMapper();

        List<OrderItemDTO> items
                = mapper.readValue(
                        orderItems,
                        new TypeReference<List<OrderItemDTO>>() {
                });

        RestaurantTable selectedTable
                = tableService.findById(tableId);

        if (selectedTable == null
                || !"AVAILABLE".equals(selectedTable.getStatus())) {

            return "redirect:/staff/orders/add";
        }

        Order order
                = new Order();

        order.setCustomerName(
                customerName);

        order.setTableId(
                tableId);

        User user
                = (User) session.getAttribute("loggedUser");

        Employee employee
                = user == null
                ? null
                : employeeService.findByUserId(user.getUserId());

        order.setEmployeeId(
                employee == null ? 1 : employee.getEmployeeId());

        order.setStatus(
                "PENDING");

        order.setTotalAmount(
                BigDecimal.ZERO);

        orderService.save(order);

        int orderId
                = orderService.getLastOrderId();

        BigDecimal total
                = BigDecimal.ZERO;

        for (OrderItemDTO item : items) {

            MenuItem menuItem
                    = menuService.findById(
                            item.getMenuItemId());

            OrderDetail detail
                    = new OrderDetail();

            detail.setOrderId(
                    orderId);

            detail.setMenuItemId(
                    item.getMenuItemId());

            detail.setQuantity(
                    item.getQuantity());

            detail.setUnitPrice(
                    menuItem.getPrice());

            BigDecimal subtotal
                    = menuItem.getPrice()
                            .multiply(
                                    BigDecimal.valueOf(
                                            item.getQuantity()));

            detail.setSubtotal(
                    subtotal);

            detail.setNote(
                    item.getNote());

            orderService.saveDetail(
                    detail);

            total
                    = total.add(
                            subtotal);
        }

        order.setOrderId(
                orderId);

        order.setTotalAmount(
                total);

        orderService.update(
                order);

        tableService.updateStatus(
                tableId,
                "OCCUPIED");

        notificationService.create(
                orderId,
                "Don hang #" + orderId + " da gui xuong bep");

        return "redirect:/staff/orders";

    }

    @GetMapping("/payment/{id}")
    public String payment(
            @PathVariable int id,
            Model model) {

        Order order
                = orderService.findById(id);

        model.addAttribute(
                "order",
                order);

        model.addAttribute(
                "details",
                orderService.findDetails(id));

        return "staff/order/payment";
    }

    @PostMapping("/pay/{id}")
    public String pay(
            @PathVariable int id,
            @RequestParam(defaultValue = "CASH") String paymentMethod,
            @RequestParam(defaultValue = "false") boolean printBill) {

        Order order
                = orderService.findById(id);

        if (order == null) {

            return "redirect:/staff/orders";
        }

        if (invoiceService.findByOrderId(id) == null) {

            Invoice invoice
                    = new Invoice();

            invoice.setOrderId(id);
            invoice.setPaymentMethod(paymentMethod);
            invoice.setTotalAmount(order.getTotalAmount());

            invoiceService.save(invoice);
        }

        orderService.updateStatus(
                id,
                "PAID");

        tableService.updateStatus(
                order.getTableId(),
                "AVAILABLE");

        if (printBill) {

            return "redirect:/staff/orders/receipt/" + id;
        }

        return "redirect:/staff/orders";
    }

    @GetMapping("/receipt/{id}")
    public String receipt(
            @PathVariable int id,
            Model model) {

        model.addAttribute(
                "order",
                orderService.findById(id));

        model.addAttribute(
                "details",
                orderService.findDetails(id));

        model.addAttribute(
                "invoice",
                invoiceService.findByOrderId(id));

        return "staff/order/receipt";
    }

    @PostMapping("/add-item/{id}")
    public String addItem(
            @PathVariable int id,
            @RequestParam int menuItemId,
            @RequestParam(defaultValue = "1") int quantity,
            @RequestParam(required = false) String note) {

        Order order
                = orderService.findById(id);

        MenuItem menuItem
                = menuService.findById(menuItemId);

        if (order == null
                || menuItem == null
                || "PAID".equals(order.getStatus())) {

            return "redirect:/staff/orders/detail/" + id;
        }

        int safeQuantity
                = Math.max(1, quantity);

        OrderDetail detail
                = new OrderDetail();

        detail.setOrderId(id);
        detail.setMenuItemId(menuItemId);
        detail.setQuantity(safeQuantity);
        detail.setUnitPrice(menuItem.getPrice());
        detail.setNote(note);

        BigDecimal subtotal
                = menuItem.getPrice()
                        .multiply(
                                BigDecimal.valueOf(safeQuantity));

        detail.setSubtotal(subtotal);

        orderService.saveDetail(detail);

        BigDecimal currentTotal
                = order.getTotalAmount() == null
                ? BigDecimal.ZERO
                : order.getTotalAmount();

        order.setTotalAmount(
                currentTotal.add(subtotal));

        orderService.update(order);

        notificationService.create(
                id,
                "Don hang #" + id + " vua them mon " + menuItem.getItemName());

        return "redirect:/staff/orders/detail/" + id;
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable int id) {

        orderService.delete(id);

        return "redirect:/staff/orders";
    }

    @GetMapping("/pending")
    public String pendingOrders(
            Model model) {

        model.addAttribute(
                "orders",
                orderService.findByStatus(
                        "PENDING"));

        return "kitchen/pending-orders";
    }

    @GetMapping("/cooking")
    public String cookingOrders(
            Model model) {

        model.addAttribute(
                "orders",
                orderService.findByStatus(
                        "COOKING"));

        return "kitchen/cooking-orders";
    }

    @PostMapping("/cooking/{id}")
    public String startCooking(
            @PathVariable int id) {

        orderService.updateStatus(
                id,
                "COOKING");

        return "redirect:/staff/orders/pending";
    }

    @PostMapping("/ready/{id}")
    public String completeOrder(
            @PathVariable int id) {

        orderService.updateStatus(
                id,
                "READY");

        return "redirect:/staff/orders/cooking";
    }

}
