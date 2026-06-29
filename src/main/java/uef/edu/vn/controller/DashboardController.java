package uef.edu.vn.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uef.edu.vn.model.User;
import uef.edu.vn.service.EmployeeService;
import uef.edu.vn.service.InventoryService;
import uef.edu.vn.service.InvoiceService;
import uef.edu.vn.service.MenuService;
import uef.edu.vn.service.NotificationService;
import uef.edu.vn.service.OrderService;
import uef.edu.vn.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class DashboardController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestaurantTableService tableService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private InventoryService inventoryService;

    // ==========================
    // ADMIN DASHBOARD
    // ==========================
    @GetMapping("/admin/dashboard")
    public String adminDashboard(
            HttpSession session,
            Model model) {

        User user
                = (User) session.getAttribute(
                        "loggedUser");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute(
                "user",
                user);

        model.addAttribute(
                "todayRevenue",
                invoiceService.getTodayRevenue());

        model.addAttribute(
                "monthRevenue",
                invoiceService.getMonthRevenue());

        model.addAttribute(
                "totalOrders",
                orderService.countAll());

        model.addAttribute(
                "totalEmployees",
                employeeService.countEmployees());

        model.addAttribute(
                "occupiedTables",
                tableService.countByStatus("OCCUPIED"));

        model.addAttribute(
                "availableTables",
                tableService.countByStatus("AVAILABLE"));

        model.addAttribute(
                "bestSellingFood",
                menuService.findBestSellingFoodName());

        return "admin/dashboard";
    }

    // ==========================
    // STAFF DASHBOARD
    // ==========================
    @GetMapping("/staff/dashboard")
    public String staffDashboard(
            HttpSession session,
            Model model) {

        User user
                = (User) session.getAttribute(
                        "loggedUser");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute(
                "user",
                user);

        model.addAttribute(
                "occupiedTables",
                tableService.countByStatus("OCCUPIED"));

        model.addAttribute(
                "availableTables",
                tableService.countByStatus("AVAILABLE"));

        model.addAttribute(
                "servingOrders",
                orderService.countByStatus("PENDING")
                + orderService.countByStatus("COOKING")
                + orderService.countByStatus("READY"));

        model.addAttribute(
                "newNotifications",
                notificationService.countUnread());

        model.addAttribute(
                "notifications",
                notificationService.findLatest(5));

        return "staff/dashboard";
    }

    // ==========================
    // KITCHEN DASHBOARD
    // ==========================
    @GetMapping("/kitchen/dashboard")
    public String kitchenDashboard(
            HttpSession session,
            Model model) {

        User user
                = (User) session.getAttribute(
                        "loggedUser");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute(
                "user",
                user);

        model.addAttribute(
                "pendingOrders",
                orderService.countByStatus("PENDING"));

        model.addAttribute(
                "cookingOrders",
                orderService.countByStatus("COOKING"));

        model.addAttribute(
                "completedOrders",
                orderService.countByStatus("READY"));

        model.addAttribute(
                "outOfStockItems",
                menuService.countByStatus("OUT_OF_STOCK"));

        model.addAttribute(
                "pendingOrderList",
                orderService.findByStatus("PENDING"));

        model.addAttribute(
                "lowInventoryList",
                inventoryService.findLowStockItems());

        return "kitchen/dashboard";
    }
}
