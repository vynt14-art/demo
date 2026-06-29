package uef.edu.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uef.edu.vn.model.Category;
import uef.edu.vn.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

// ==========================
// DANH SÁCH DANH MỤC
// ==========================
    @GetMapping
    public String categoryList(Model model) {

        List<Category> categories
                = categoryService.findAll();

        model.addAttribute(
                "categories",
                categories);

        return "admin/category/category-list";
    }

// ==========================
// FORM THÊM
// ==========================
    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute(
                "category",
                new Category());

        return "admin/category/category-add";
    }

// ==========================
// LƯU DANH MỤC
// ==========================
    @PostMapping("/save")
    public String saveCategory(
            @ModelAttribute Category category) {

        categoryService.save(category);

        return "redirect:/admin/categories";
    }

// ==========================
// FORM SỬA
// ==========================
    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable("id") int id,
            Model model) {

        Category category
                = categoryService.findById(id);

        if (category == null) {

            return "redirect:/admin/categories";
        }

        model.addAttribute(
                "category",
                category);

        return "admin/category/category-edit";
    }

// ==========================
// CẬP NHẬT
// ==========================
    @PostMapping("/update")
    public String updateCategory(
            @ModelAttribute Category category) {

        categoryService.update(category);

        return "redirect:/admin/categories";
    }

// ==========================
// XÓA
// ==========================
    @GetMapping("/delete/{id}")
    public String deleteCategory(
            @PathVariable("id") int id) {

        categoryService.delete(id);

        return "redirect:/admin/categories";
    }

// ==========================
// CHI TIẾT
// ==========================
    @GetMapping("/detail/{id}")
    public String categoryDetail(
            @PathVariable("id") int id,
            Model model) {

        Category category
                = categoryService.findById(id);

        if (category == null) {

            return "redirect:/admin/categories";
        }

        model.addAttribute(
                "category",
                category);

        return "admin/category/category-detail";
    }

// ==========================
// TÌM KIẾM
// ==========================
    @GetMapping("/search")
    public String searchCategory(
            @RequestParam("keyword") String keyword,
            Model model) {

        List<Category> categories
                = categoryService.searchByName(
                        keyword);

        model.addAttribute(
                "categories",
                categories);

        model.addAttribute(
                "keyword",
                keyword);

        return "admin/category/category-list";
    }

}
