package uef.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uef.edu.vn.model.Inventory;
import uef.edu.vn.repository.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

// ==========================
// DANH SÁCH NGUYÊN LIỆU
// ==========================
    public List<Inventory> findAll() {

        return inventoryRepository.findAll();
    }

// ==========================
// TÌM THEO ID
// ==========================
    public Inventory findById(int inventoryId) {

        return inventoryRepository.findById(
                inventoryId);
    }

// ==========================
// THÊM NGUYÊN LIỆU
// ==========================
    public int save(Inventory inventory) {

        return inventoryRepository.save(
                inventory);
    }

// ==========================
// CẬP NHẬT NGUYÊN LIỆU
// ==========================
    public int update(Inventory inventory) {

        return inventoryRepository.update(
                inventory);
    }

// ==========================
// XÓA NGUYÊN LIỆU
// ==========================
    public int delete(int inventoryId) {

        return inventoryRepository.delete(
                inventoryId);
    }

// ==========================
// ĐẾM SỐ NGUYÊN LIỆU
// ==========================
    public int countInventoryItems() {

        return inventoryRepository.countInventoryItems();
    }

// ==========================
// TÌM KIẾM
// ==========================
    public List<Inventory> searchByName(
            String keyword) {

        return inventoryRepository.searchByName(
                keyword);
    }

// ==========================
// NGUYÊN LIỆU SẮP HẾT
// ==========================
    public List<Inventory> findLowStockItems() {

        return inventoryRepository.findLowStockItems();
    }

    public int countLowStockItems() {

        return inventoryRepository.countLowStockItems();
    }

    public int countOutOfStockItems() {

        return inventoryRepository.countOutOfStockItems();
    }

}
