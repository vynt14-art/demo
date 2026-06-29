package uef.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uef.edu.vn.model.MenuItem;
import uef.edu.vn.repository.MenuRepository;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

// ==========================
// DANH SÁCH MÓN ĂN
// ==========================
    public List<MenuItem> findAll() {

        return menuRepository.findAll();
    }

// ==========================
// TÌM THEO ID
// ==========================
    public MenuItem findById(
            int id) {

        return menuRepository.findById(
                id);

    }

// ==========================
// THÊM MÓN ĂN
// ==========================
    public int save(MenuItem menuItem) {

        return menuRepository.save(
                menuItem);
    }

// ==========================
// CẬP NHẬT MÓN ĂN
// ==========================
    public int update(MenuItem menuItem) {

        return menuRepository.update(
                menuItem);
    }

// ==========================
// XÓA MÓN ĂN
// ==========================
    public int delete(int menuItemId) {

        return menuRepository.delete(
                menuItemId);
    }

// ==========================
// ĐẾM SỐ MÓN ĂN
// ==========================
    public int countMenuItems() {

        return menuRepository.countMenuItems();
    }

// ==========================
// TÌM KIẾM
// ==========================
    public List<MenuItem> searchByName(
            String keyword) {

        return menuRepository.searchByName(
                keyword);
    }

// ==========================
// THEO DANH MỤC
// ==========================
    public List<MenuItem> findByCategory(
            int categoryId) {

        return menuRepository.findByCategory(
                categoryId);
    }

// ==========================
// MÓN ĐANG BÁN
// ==========================
    public List<MenuItem> findAvailableItems() {

        return menuRepository.findAvailableItems();
    }

    public int countByStatus(
            String status) {

        return menuRepository.countByStatus(
                status);
    }

    public String findBestSellingFoodName() {

        return menuRepository.findBestSellingFoodName();
    }

    public int updateStatus(
            int menuItemId,
            String status) {

        return menuRepository.updateStatus(
                menuItemId,
                status);
    }

}
