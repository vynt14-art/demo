package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import uef.edu.vn.model.Invoice;

@Repository
public class InvoiceRepository {


@Autowired
private JdbcTemplate jdbcTemplate;

private final RowMapper<Invoice> rowMapper =
        new RowMapper<Invoice>() {

    @Override
    public Invoice mapRow(
            ResultSet rs,
            int rowNum)
            throws SQLException {

        Invoice invoice =
                new Invoice();

        invoice.setInvoiceId(
                rs.getInt("invoice_id"));

        invoice.setOrderId(
                rs.getInt("order_id"));

        invoice.setPaymentMethod(
                rs.getString("payment_method"));

        invoice.setTotalAmount(
                rs.getBigDecimal("total_amount"));

        invoice.setPaymentTime(
                rs.getTimestamp("payment_time"));

        return invoice;
    }
};

// ==========================
// DANH SÁCH HÓA ĐƠN
// ==========================

public List<Invoice> findAll() {

    String sql =
            "SELECT * " +
            "FROM invoices " +
            "ORDER BY invoice_id DESC";

    return jdbcTemplate.query(
            sql,
            rowMapper);
}

// ==========================
// TÌM THEO ID
// ==========================

public Invoice findById(
        int invoiceId) {

    String sql =
            "SELECT * " +
            "FROM invoices " +
            "WHERE invoice_id = ?";

    List<Invoice> invoices =
            jdbcTemplate.query(
                    sql,
                    rowMapper,
                    invoiceId);

    return invoices.isEmpty()
            ? null
            : invoices.get(0);
}

// ==========================
// TÌM THEO ORDER
// ==========================

public Invoice findByOrderId(
        int orderId) {

    String sql =
            "SELECT * " +
            "FROM invoices " +
            "WHERE order_id = ?";

    List<Invoice> invoices =
            jdbcTemplate.query(
                    sql,
                    rowMapper,
                    orderId);

    return invoices.isEmpty()
            ? null
            : invoices.get(0);
}

// ==========================
// THÊM HÓA ĐƠN
// ==========================

public int save(
        Invoice invoice) {

    String sql =
            "INSERT INTO invoices " +
            "(order_id, payment_method, total_amount) " +
            "VALUES (?, ?, ?)";

    return jdbcTemplate.update(
            sql,
            invoice.getOrderId(),
            invoice.getPaymentMethod(),
            invoice.getTotalAmount());
}

// ==========================
// XÓA HÓA ĐƠN
// ==========================

public int delete(
        int invoiceId) {

    String sql =
            "DELETE FROM invoices " +
            "WHERE invoice_id = ?";

    return jdbcTemplate.update(
            sql,
            invoiceId);
}

// ==========================
// TỔNG DOANH THU
// ==========================

public Double getTotalRevenue() {

    String sql =
            "SELECT IFNULL(SUM(total_amount),0) " +
            "FROM invoices";

    return jdbcTemplate.queryForObject(
            sql,
            Double.class);
}

public Double getTodayRevenue() {

    String sql =
            "SELECT IFNULL(SUM(total_amount),0) " +
            "FROM invoices " +
            "WHERE DATE(payment_time) = CURRENT_DATE";

    return jdbcTemplate.queryForObject(
            sql,
            Double.class);
}

public Double getMonthRevenue() {

    String sql =
            "SELECT IFNULL(SUM(total_amount),0) " +
            "FROM invoices " +
            "WHERE YEAR(payment_time) = YEAR(CURRENT_DATE) " +
            "AND MONTH(payment_time) = MONTH(CURRENT_DATE)";

    return jdbcTemplate.queryForObject(
            sql,
            Double.class);
}

// ==========================
// SỐ HÓA ĐƠN
// ==========================

public Integer countInvoices() {

    String sql =
            "SELECT COUNT(*) " +
            "FROM invoices";

    return jdbcTemplate.queryForObject(
            sql,
            Integer.class);
}


}
