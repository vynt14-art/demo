package uef.edu.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uef.edu.vn.model.Inventory;
import uef.edu.vn.service.InventoryService;

@Controller
@RequestMapping("/admin/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

// ==========================
// DANH SÁCH NGUYÊN LIỆU
// ==========================
    @GetMapping
    public String inventoryList(Model model) {

        List<Inventory> inventories
                = inventoryService.findAll();

        model.addAttribute(
                "inventories",
                inventories);

        return "admin/inventory/inventory-list";
    }

// ==========================
// FORM THÊM
// ==========================
    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute(
                "inventory",
                new Inventory());

        return "admin/inventory/inventory-add";
    }

// ==========================
// LƯU NGUYÊN LIỆU
// ==========================
    @PostMapping("/save")
    public String saveInventory(
            @ModelAttribute Inventory inventory) {

        inventoryService.save(
                inventory);

        return "redirect:/admin/inventory";
    }

// ==========================
// FORM SỬA
// ==========================
    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable("id") int id,
            Model model) {

        Inventory inventory
                = inventoryService.findById(id);

        if (inventory == null) {

            return "redirect:/admin/inventory";
        }

        model.addAttribute(
                "inventory",
                inventory);

        return "admin/inventory/inventory-edit";
    }

// ==========================
// CẬP NHẬT
// ==========================
    @PostMapping("/update")
    public String updateInventory(
            @ModelAttribute Inventory inventory) {

        inventoryService.update(
                inventory);

        return "redirect:/admin/inventory";
    }

// ==========================
// XÓA
// ==========================
    @GetMapping("/delete/{id}")
    public String deleteInventory(
            @PathVariable("id") int id) {

        inventoryService.delete(id);

        return "redirect:/admin/inventory";
    }

// ==========================
// CHI TIẾT
// ==========================
    @GetMapping("/detail/{id}")
    public String inventoryDetail(
            @PathVariable("id") int id,
            Model model) {

        Inventory inventory
                = inventoryService.findById(id);

        if (inventory == null) {

            return "redirect:/admin/inventory";
        }

        model.addAttribute(
                "inventory",
                inventory);

        return "admin/inventory/inventory-detail";
    }

// ==========================
// TÌM KIẾM
// ==========================
    @GetMapping("/search")
    public String searchInventory(
            @RequestParam("keyword") String keyword,
            Model model) {

        List<Inventory> inventories
                = inventoryService.searchByName(
                        keyword);

        model.addAttribute(
                "inventories",
                inventories);

        model.addAttribute(
                "keyword",
                keyword);

        return "admin/inventory/inventory-list";
    }

// ==========================
// NGUYÊN LIỆU SẮP HẾT
// ==========================
    @GetMapping("/low-stock")
    public String lowStockItems(
            Model model) {

        List<Inventory> inventories
                = inventoryService.findLowStockItems();

        model.addAttribute(
                "inventories",
                inventories);

        model.addAttribute(
                "isLowStock",
                true);

        return "admin/inventory/inventory-list";
    }

}
