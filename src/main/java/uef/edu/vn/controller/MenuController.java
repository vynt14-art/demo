package uef.edu.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uef.edu.vn.model.Category;
import uef.edu.vn.model.MenuItem;
import uef.edu.vn.service.CategoryService;
import uef.edu.vn.service.MediaService;
import uef.edu.vn.service.MenuService;

@Controller
@RequestMapping("/admin/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MediaService mediaService;

// ==========================
// DANH SÁCH MÓN ĂN
// ==========================
    @GetMapping
    public String menuList(Model model) {

        List<MenuItem> menuItems
                = menuService.findAll();

        model.addAttribute(
                "menuItems",
                menuItems);

        return "admin/menu/menu-list";
    }

// ==========================
// FORM THÊM
// ==========================
    @GetMapping("/add")
    public String showAddForm(Model model) {

        List<Category> categories
                = categoryService.findAll();

        model.addAttribute(
                "categories",
                categories);

        model.addAttribute(
                "menuItem",
                new MenuItem());

        return "admin/menu/menu-add";
    }

// ==========================
// LƯU MÓN ĂN
// ==========================
    @PostMapping("/save")
    public String saveMenuItem(
            @ModelAttribute MenuItem menuItem,
            @RequestParam(required = false) String imagePath) {

        menuItem.setMediaId(
                mediaService.saveImagePath(
                        imagePath,
                        "MENU"));

        menuService.save(menuItem);

        return "redirect:/admin/menu";
    }

// ==========================
// FORM SỬA
// ==========================
    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable("id") int id,
            Model model) {

        MenuItem menuItem
                = menuService.findById(id);

        if (menuItem == null) {

            return "redirect:/admin/menu";
        }

        List<Category> categories
                = categoryService.findAll();

        model.addAttribute(
                "categories",
                categories);

        model.addAttribute(
                "menuItem",
                menuItem);

        return "admin/menu/menu-edit";
    }

// ==========================
// CẬP NHẬT
// ==========================
    @PostMapping("/update")
    public String updateMenuItem(
            @ModelAttribute MenuItem menuItem,
            @RequestParam(required = false) String imagePath) {

        Integer mediaId
                = mediaService.saveImagePath(
                        imagePath,
                        "MENU");

        if (mediaId != null) {

            menuItem.setMediaId(mediaId);
        }

        menuService.update(menuItem);

        return "redirect:/admin/menu";
    }

// ==========================
// XÓA
// ==========================
    @GetMapping("/delete/{id}")
    public String deleteMenuItem(
            @PathVariable("id") int id) {

        menuService.delete(id);

        return "redirect:/admin/menu";
    }

// ==========================
// CHI TIẾT
// ==========================
    @PostMapping("/status/{id}")
    public String updateStatus(
            @PathVariable("id") int id,
            @RequestParam String status) {

        menuService.updateStatus(
                id,
                status);

        return "redirect:/admin/menu";
    }

    @GetMapping("/detail/{id}")
    public String menuDetail(
            @PathVariable("id") int id,
            Model model) {

        MenuItem menuItem
                = menuService.findById(id);

        if (menuItem == null) {

            return "redirect:/admin/menu";
        }

        model.addAttribute(
                "menuItem",
                menuItem);

        return "admin/menu/menu-detail";
    }

// ==========================
// TÌM KIẾM
// ==========================
    @GetMapping("/search")
    public String searchMenu(
            @RequestParam("keyword") String keyword,
            Model model) {

        List<MenuItem> menuItems
                = menuService.searchByName(
                        keyword);

        model.addAttribute(
                "menuItems",
                menuItems);

        model.addAttribute(
                "keyword",
                keyword);

        return "admin/menu/menu-list";
    }

// ==========================
// LỌC THEO DANH MỤC
// ==========================
    @GetMapping("/category/{categoryId}")
    public String filterByCategory(
            @PathVariable int categoryId,
            Model model) {

        List<MenuItem> menuItems
                = menuService.findByCategory(
                        categoryId);

        model.addAttribute(
                "menuItems",
                menuItems);

        return "admin/menu/menu-list";
    }

}
