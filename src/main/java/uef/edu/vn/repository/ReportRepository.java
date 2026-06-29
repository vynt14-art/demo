package uef.edu.vn.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import uef.edu.vn.dto.EmployeeReportDTO;
import uef.edu.vn.dto.FoodReportDTO;
import uef.edu.vn.dto.RevenueReportDTO;

@Repository
public class ReportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

// ==========================
// DOANH THU
// ==========================
    public List<RevenueReportDTO> revenueReport() {

        String sql
                = "SELECT DATE(payment_time) report_date, "
                + "SUM(total_amount) revenue "
                + "FROM invoices "
                + "GROUP BY DATE(payment_time) "
                + "ORDER BY report_date DESC";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    RevenueReportDTO dto
                    = new RevenueReportDTO();

                    dto.setReportDate(
                            rs.getDate("report_date"));

                    dto.setRevenue(
                            rs.getBigDecimal("revenue"));

                    return dto;
                });
    }

// ==========================
// MÓN ĂN BÁN CHẠY
// ==========================
    public List<FoodReportDTO> foodReport() {

        String sql
                = "SELECT m.item_name, "
                + "SUM(od.quantity) total_quantity "
                + "FROM order_details od "
                + "JOIN menu_items m "
                + "ON od.menu_item_id = m.menu_item_id "
                + "GROUP BY m.item_name "
                + "ORDER BY total_quantity DESC";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    FoodReportDTO dto
                    = new FoodReportDTO();

                    dto.setFoodName(
                            rs.getString("item_name"));

                    dto.setQuantitySold(
                            rs.getInt("total_quantity"));

                    return dto;
                });
    }

// ==========================
// NHÂN VIÊN
// ==========================
    public List<EmployeeReportDTO> employeeReport() {

        String sql
                = "SELECT e.full_name, "
                + "COUNT(o.order_id) total_orders "
                + "FROM employees e "
                + "LEFT JOIN orders o "
                + "ON e.employee_id = o.employee_id "
                + "GROUP BY e.employee_id,e.full_name "
                + "ORDER BY total_orders DESC";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    EmployeeReportDTO dto
                    = new EmployeeReportDTO();

                    dto.setEmployeeName(
                            rs.getString("full_name"));

                    dto.setTotalOrders(
                            rs.getInt("total_orders"));

                    return dto;
                });
    }

}
