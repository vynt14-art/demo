package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import uef.edu.vn.model.OrderDetail;

@Repository
public class OrderDetailRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<OrderDetail> rowMapper
            = new RowMapper<OrderDetail>() {

        @Override
        public OrderDetail mapRow(
                ResultSet rs,
                int rowNum)
                throws SQLException {

            OrderDetail detail
                    = new OrderDetail();

            detail.setOrderDetailId(
                    rs.getInt("order_detail_id"));

            detail.setOrderId(
                    rs.getInt("order_id"));

            detail.setMenuItemId(
                    rs.getInt("menu_item_id"));

            try {

                detail.setMenuItemName(
                        rs.getString("item_name"));

            } catch (SQLException ignored) {

                detail.setMenuItemName(null);
            }

            detail.setQuantity(
                    rs.getInt("quantity"));

            detail.setUnitPrice(
                    rs.getBigDecimal("unit_price"));

            detail.setSubtotal(
                    rs.getBigDecimal("subtotal"));

            detail.setNote(
                    rs.getString("note"));

            return detail;
        }
    };

    public List<OrderDetail> findByOrderId(
            int orderId) {

        String sql
                = "SELECT od.*, m.item_name "
                + "FROM order_details od "
                + "LEFT JOIN menu_items m "
                + "ON od.menu_item_id = m.menu_item_id "
                + "WHERE od.order_id=? "
                + "ORDER BY od.order_detail_id";

        return jdbcTemplate.query(
                sql,
                rowMapper,
                orderId);
    }

    public int save(
            OrderDetail detail) {

        String sql
                = "INSERT INTO order_details "
                + "(order_id, menu_item_id, quantity, unit_price, subtotal, note) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                detail.getOrderId(),
                detail.getMenuItemId(),
                detail.getQuantity(),
                detail.getUnitPrice(),
                detail.getSubtotal(),
                detail.getNote());
    }

    public int deleteByOrderId(
            int orderId) {

        String sql
                = "DELETE FROM order_details "
                + "WHERE order_id=?";

        return jdbcTemplate.update(
                sql,
                orderId);
    }

}
