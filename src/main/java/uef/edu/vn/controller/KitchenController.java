package uef.edu.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uef.edu.vn.service.OrderService;
import uef.edu.vn.service.MenuService;
import uef.edu.vn.service.NotificationService;

@Controller
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private NotificationService notificationService;

// ==========================
// DASHBOARD BẾP
// ==========================
    @GetMapping
    public String dashboard() {

        return "redirect:/kitchen/dashboard";
    }

// ==========================
// ĐƠN CHỜ CHẾ BIẾN
// ==========================
    @GetMapping("/pending")
    public String pendingOrders(
            Model model) {

        model.addAttribute(
                "orders",
                orderService.findByStatus(
                        "PENDING"));

        return "kitchen/pending-orders";
    }

    @GetMapping("/detail/{id}")
    public String orderDetail(
            @PathVariable int id,
            Model model) {

        model.addAttribute(
                "order",
                orderService.findById(id));

        model.addAttribute(
                "details",
                orderService.findDetails(id));

        return "kitchen/order-detail";
    }

// ==========================
// ĐƠN ĐANG CHẾ BIẾN
// ==========================
    @GetMapping("/cooking")
    public String cookingOrders(
            Model model) {

        model.addAttribute(
                "orders",
                orderService.findByStatus(
                        "COOKING"));

        return "kitchen/cooking-orders";
    }

// ==========================
// ĐƠN HOÀN THÀNH
// ==========================
    @GetMapping("/completed")
    public String completedOrders(
            Model model) {

        model.addAttribute(
                "orders",
                orderService.findByStatus(
                        "READY"));

        return "kitchen/completed-orders";
    }

// ==========================
// NHẬN ĐƠN
// ==========================
    @GetMapping("/start/{id}")
    public String startCooking(
            @PathVariable int id) {

        orderService.updateStatus(
                id,
                "COOKING");

        return "redirect:/kitchen/pending";
    }

// ==========================
// HOÀN THÀNH
// ==========================
    @GetMapping("/complete/{id}")
    public String completeOrder(
            @PathVariable int id) {

        orderService.updateStatus(
                id,
                "READY");

        notificationService.create(
                id,
                "Don hang #" + id + " da san sang phuc vu");

        return "redirect:/kitchen/cooking";
    }

    @PostMapping("/out-of-stock/{id}")
    public String markOutOfStock(
            @PathVariable int id) {

        menuService.updateStatus(
                id,
                "OUT_OF_STOCK");

        notificationService.create(
                null,
                "Mon #" + id + " da het hang");

        return "redirect:/kitchen/dashboard";
    }

}
