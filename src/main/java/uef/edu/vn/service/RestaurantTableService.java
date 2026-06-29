package uef.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uef.edu.vn.model.RestaurantTable;
import uef.edu.vn.repository.RestaurantTableRepository;

@Service
public class RestaurantTableService {

    @Autowired
    private RestaurantTableRepository tableRepository;

// ==========================
// DANH SÁCH BÀN
// ==========================
    public List<RestaurantTable> findAll() {

        return tableRepository.findAll();
    }

// ==========================
// TÌM THEO ID
// ==========================
    public RestaurantTable findById(int tableId) {

        return tableRepository.findById(
                tableId);
    }

// ==========================
// THÊM BÀN
// ==========================
    public int save(
            RestaurantTable table) {

        return tableRepository.save(
                table);
    }

// ==========================
// CẬP NHẬT BÀN
// ==========================
    public int update(
            RestaurantTable table) {

        return tableRepository.update(
                table);
    }

// ==========================
// XÓA BÀN
// ==========================
    public int delete(int tableId) {

        return tableRepository.delete(
                tableId);
    }

// ==========================
// ĐẾM SỐ BÀN
// ==========================
    public int countTables() {

        return tableRepository.countTables();
    }

    public int countByStatus(
            String status) {

        return tableRepository.countByStatus(
                status);
    }

    public int updateStatus(
            int tableId,
            String status) {

        return tableRepository.updateStatus(
                tableId,
                status);
    }

// ==========================
// TÌM KIẾM
// ==========================
    public List<RestaurantTable> searchByName(
            String keyword) {

        return tableRepository.searchByName(
                keyword);
    }

// ==========================
// BÀN TRỐNG
// ==========================
    public List<RestaurantTable> findAvailableTables() {

        return tableRepository.findAvailableTables();
    }

}
