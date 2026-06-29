package uef.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uef.edu.vn.model.Category;
import uef.edu.vn.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

// ==========================
// LẤY DANH SÁCH
// ==========================
    public List<Category> findAll() {

        return categoryRepository.findAll();
    }

// ==========================
// TÌM THEO ID
// ==========================
    public Category findById(int categoryId) {

        return categoryRepository.findById(
                categoryId);
    }

// ==========================
// THÊM DANH MỤC
// ==========================
    public int save(Category category) {

        return categoryRepository.save(
                category);
    }

// ==========================
// CẬP NHẬT DANH MỤC
// ==========================
    public int update(Category category) {

        return categoryRepository.update(
                category);
    }

// ==========================
// XÓA DANH MỤC
// ==========================
    public int delete(int categoryId) {

        return categoryRepository.delete(
                categoryId);
    }

// ==========================
// ĐẾM DANH MỤC
// ==========================
    public int countCategories() {

        return categoryRepository.countCategories();
    }

// ==========================
// TÌM KIẾM
// ==========================
    public List<Category> searchByName(
            String keyword) {

        return categoryRepository.searchByName(
                keyword);
    }

}
