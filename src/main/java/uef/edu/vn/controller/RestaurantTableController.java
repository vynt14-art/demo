package uef.edu.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uef.edu.vn.model.RestaurantTable;
import uef.edu.vn.service.RestaurantTableService;

@Controller
@RequestMapping("/admin/tables")
public class RestaurantTableController {

    @Autowired
    private RestaurantTableService tableService;

// ==========================
// DANH SÁCH BÀN
// ==========================
    @GetMapping
    public String tableList(Model model) {

        List<RestaurantTable> tables
                = tableService.findAll();

        model.addAttribute(
                "tables",
                tables);

        return "admin/table/table-list";
    }

// ==========================
// FORM THÊM
// ==========================
    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute(
                "table",
                new RestaurantTable());

        return "admin/table/table-add";
    }

// ==========================
// LƯU BÀN
// ==========================
    @PostMapping("/save")
    public String saveTable(
            @ModelAttribute RestaurantTable table) {

        tableService.save(table);

        return "redirect:/admin/tables";
    }

// ==========================
// FORM SỬA
// ==========================
    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable int id,
            Model model) {

        RestaurantTable table
                = tableService.findById(id);

        if (table == null) {

            return "redirect:/admin/tables";
        }

        model.addAttribute(
                "table",
                table);

        return "admin/table/table-edit";
    }

// ==========================
// CẬP NHẬT
// ==========================
    @PostMapping("/update")
    public String updateTable(
            @ModelAttribute RestaurantTable table) {

        tableService.update(table);

        return "redirect:/admin/tables";
    }

// ==========================
// XÓA
// ==========================
    @GetMapping("/delete/{id}")
    public String deleteTable(
            @PathVariable int id) {

        tableService.delete(id);

        return "redirect:/admin/tables";
    }

// ==========================
// CHI TIẾT
// ==========================
    @GetMapping("/detail/{id}")
    public String detailTable(
            @PathVariable int id,
            Model model) {

        RestaurantTable table
                = tableService.findById(id);

        if (table == null) {

            return "redirect:/admin/tables";
        }

        model.addAttribute(
                "table",
                table);

        return "admin/table/table-detail";
    }

// ==========================
// TÌM KIẾM
// ==========================
    @GetMapping("/search")
    public String searchTable(
            @RequestParam String keyword,
            Model model) {

        List<RestaurantTable> tables
                = tableService.searchByName(
                        keyword);

        model.addAttribute(
                "tables",
                tables);

        return "admin/table/table-list";
    }

// ==========================
// BÀN TRỐNG
// ==========================
    @GetMapping("/available")
    public String availableTables(
            Model model) {

        model.addAttribute(
                "tables",
                tableService.findAvailableTables());

        return "admin/table/table-list";
    }

}
