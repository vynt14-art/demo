package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import uef.edu.vn.model.Order;
import uef.edu.vn.dto.OrderHistoryDTO;

@Repository
public class OrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Order> rowMapper
            = new RowMapper<Order>() {

        @Override
        public Order mapRow(
                ResultSet rs,
                int rowNum)
                throws SQLException {

            Order order
                    = new Order();

            order.setOrderId(
                    rs.getInt("order_id"));

            order.setTableId(
                    rs.getInt("table_id"));

            order.setEmployeeId(
                    rs.getInt("employee_id"));

            order.setCustomerName(
                    rs.getString("customer_name"));

            order.setOrderTime(
                    rs.getTimestamp("order_time"));

            order.setStatus(
                    rs.getString("status"));

            order.setTotalAmount(
                    rs.getBigDecimal("total_amount"));

            return order;
        }
    };

    public List<Order> findAll() {

        String sql
                = "SELECT * FROM orders "
                + "ORDER BY order_id DESC";

        return jdbcTemplate.query(
                sql,
                rowMapper);
    }

    public Order findById(
            int orderId) {

        String sql
                = "SELECT * FROM orders "
                + "WHERE order_id=?";

        List<Order> orders
                = jdbcTemplate.query(
                        sql,
                        rowMapper,
                        orderId);

        return orders.isEmpty()
                ? null
                : orders.get(0);
    }

    public int save(
            Order order) {

        String sql
                = "INSERT INTO orders "
                + "(table_id, employee_id, customer_name, status, total_amount) "
                + "VALUES (?, ?, ?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                order.getTableId(),
                order.getEmployeeId(),
                order.getCustomerName(),
                order.getStatus(),
                order.getTotalAmount());
    }

    public int update(
            Order order) {

        String sql
                = "UPDATE orders "
                + "SET table_id=?, "
                + "employee_id=?, "
                + "customer_name=?, "
                + "status=?, "
                + "total_amount=? "
                + "WHERE order_id=?";

        return jdbcTemplate.update(
                sql,
                order.getTableId(),
                order.getEmployeeId(),
                order.getCustomerName(),
                order.getStatus(),
                order.getTotalAmount(),
                order.getOrderId());
    }

    public int updateStatus(
            int orderId,
            String status) {

        String sql
                = "UPDATE orders "
                + "SET status=? "
                + "WHERE order_id=?";

        return jdbcTemplate.update(
                sql,
                status,
                orderId);
    }

    public List<Order> findByStatus(
            String status) {

        String sql
                = "SELECT * FROM orders "
                + "WHERE status=? "
                + "ORDER BY order_time DESC";

        return jdbcTemplate.query(
                sql,
                rowMapper,
                status);
    }

    public int countAll() {

        String sql
                = "SELECT COUNT(*) FROM orders";

        Integer count
                = jdbcTemplate.queryForObject(
                        sql,
                        Integer.class);

        return count == null ? 0 : count;
    }

    public int countByStatus(
            String status) {

        String sql
                = "SELECT COUNT(*) "
                + "FROM orders "
                + "WHERE status = ?";

        Integer count
                = jdbcTemplate.queryForObject(
                        sql,
                        Integer.class,
                        status);

        return count == null ? 0 : count;
    }

    public List<Order> findByEmployeeId(
            int employeeId) {

        String sql
                = "SELECT * FROM orders "
                + "WHERE employee_id = ? "
                + "ORDER BY order_time DESC";

        return jdbcTemplate.query(
                sql,
                rowMapper,
                employeeId);
    }

    public List<OrderHistoryDTO> findOrderHistory(
            Date fromDate,
            Date toDate) {

        StringBuilder sql
                = new StringBuilder();

        sql.append("SELECT o.order_id, o.order_time, o.customer_name, ");
        sql.append("o.total_amount, o.status, ");
        sql.append("e.full_name employee_name, ");
        sql.append("t.table_name, ");
        sql.append("i.payment_method, i.payment_time ");
        sql.append("FROM orders o ");
        sql.append("LEFT JOIN employees e ON o.employee_id = e.employee_id ");
        sql.append("LEFT JOIN restaurant_tables t ON o.table_id = t.table_id ");
        sql.append("LEFT JOIN invoices i ON o.order_id = i.order_id ");
        sql.append("WHERE 1 = 1 ");

        List<Object> params
                = new ArrayList<>();

        if (fromDate != null) {

            sql.append("AND DATE(o.order_time) >= ? ");
            params.add(fromDate);
        }

        if (toDate != null) {

            sql.append("AND DATE(o.order_time) <= ? ");
            params.add(toDate);
        }

        sql.append("ORDER BY o.order_time DESC, o.order_id DESC");

        return jdbcTemplate.query(
                sql.toString(),
                (rs, rowNum) -> {

                    OrderHistoryDTO dto
                            = new OrderHistoryDTO();

                    dto.setOrderId(
                            rs.getInt("order_id"));

                    dto.setOrderTime(
                            rs.getTimestamp("order_time"));

                    dto.setCustomerName(
                            rs.getString("customer_name"));

                    dto.setTotalAmount(
                            rs.getBigDecimal("total_amount"));

                    dto.setStatus(
                            rs.getString("status"));

                    dto.setEmployeeName(
                            rs.getString("employee_name"));

                    dto.setTableName(
                            rs.getString("table_name"));

                    dto.setPaymentMethod(
                            rs.getString("payment_method"));

                    dto.setPaymentTime(
                            rs.getTimestamp("payment_time"));

                    return dto;
                },
                params.toArray());
    }

    public int delete(
            int orderId) {

        String sql
                = "DELETE FROM orders "
                + "WHERE order_id=?";

        return jdbcTemplate.update(
                sql,
                orderId);
    }

    public int getLastOrderId() {

        String sql
                = "SELECT MAX(order_id) FROM orders";

        Integer id
                = jdbcTemplate.queryForObject(
                        sql,
                        Integer.class);

        return id == null ? 0 : id;
    }

}
