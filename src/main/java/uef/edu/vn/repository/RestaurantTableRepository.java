package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import uef.edu.vn.model.RestaurantTable;

@Repository
public class RestaurantTableRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<RestaurantTable> rowMapper
            = new RowMapper<RestaurantTable>() {

        @Override
        public RestaurantTable mapRow(
                ResultSet rs,
                int rowNum)
                throws SQLException {

            RestaurantTable table
                    = new RestaurantTable();

            table.setTableId(
                    rs.getInt("table_id"));

            table.setTableName(
                    rs.getString("table_name"));

            table.setCapacity(
                    rs.getInt("capacity"));

            table.setStatus(
                    rs.getString("status"));

            try {
                table.setCurrentOrderId(rs.getObject("current_order_id", Integer.class));
                table.setCurrentOrderStatus(rs.getString("current_order_status"));
                table.setCurrentTotalAmount(rs.getBigDecimal("current_total_amount"));
                table.setCurrentItemCount(rs.getObject("current_item_count", Integer.class));
                table.setCurrentOrderTime(rs.getTimestamp("current_order_time"));
            } catch (SQLException ignored) {
                table.setCurrentOrderId(null);
            }

            return table;
        }
    };

// ==========================
// DANH SÁCH BÀN
// ==========================
    public List<RestaurantTable> findAll() {

        String sql
                = "SELECT rt.*, o.order_id current_order_id, "
                + "o.status current_order_status, "
                + "o.total_amount current_total_amount, "
                + "o.order_time current_order_time, "
                + "IFNULL(SUM(od.quantity), 0) current_item_count "
                + "FROM restaurant_tables rt "
                + "LEFT JOIN orders o ON rt.table_id = o.table_id "
                + "AND o.status IN ('PENDING','COOKING','READY') "
                + "LEFT JOIN order_details od ON o.order_id = od.order_id "
                + "GROUP BY rt.table_id, rt.table_name, rt.capacity, rt.status, "
                + "o.order_id, o.status, o.total_amount, o.order_time "
                + "ORDER BY rt.table_name";

        return jdbcTemplate.query(
                sql,
                rowMapper);
    }

// ==========================
// TÌM THEO ID
// ==========================
    public RestaurantTable findById(
            int tableId) {

        String sql
                = "SELECT * "
                + "FROM restaurant_tables "
                + "WHERE table_id = ?";

        List<RestaurantTable> tables
                = jdbcTemplate.query(
                        sql,
                        rowMapper,
                        tableId);

        return tables.isEmpty()
                ? null
                : tables.get(0);
    }

// ==========================
// THÊM BÀN
// ==========================
    public int save(
            RestaurantTable table) {

        String sql
                = "INSERT INTO restaurant_tables "
                + "(table_name, capacity, status) "
                + "VALUES (?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                table.getTableName(),
                table.getCapacity(),
                table.getStatus());
    }

// ==========================
// CẬP NHẬT BÀN
// ==========================
    public int update(
            RestaurantTable table) {

        String sql
                = "UPDATE restaurant_tables "
                + "SET table_name = ?, "
                + "capacity = ?, "
                + "status = ? "
                + "WHERE table_id = ?";

        return jdbcTemplate.update(
                sql,
                table.getTableName(),
                table.getCapacity(),
                table.getStatus(),
                table.getTableId());
    }

// ==========================
// XÓA BÀN
// ==========================
    public int delete(
            int tableId) {

        String sql
                = "DELETE FROM restaurant_tables "
                + "WHERE table_id = ?";

        return jdbcTemplate.update(
                sql,
                tableId);
    }

// ==========================
// ĐẾM SỐ BÀN
// ==========================
    public int countTables() {

        String sql
                = "SELECT COUNT(*) "
                + "FROM restaurant_tables";

        return jdbcTemplate.queryForObject(
                sql,
                Integer.class);
    }

    public int countByStatus(
            String status) {

        String sql
                = "SELECT COUNT(*) "
                + "FROM restaurant_tables "
                + "WHERE status = ?";

        Integer count
                = jdbcTemplate.queryForObject(
                        sql,
                        Integer.class,
                        status);

        return count == null ? 0 : count;
    }

    public int updateStatus(
            int tableId,
            String status) {

        String sql
                = "UPDATE restaurant_tables "
                + "SET status = ? "
                + "WHERE table_id = ?";

        return jdbcTemplate.update(
                sql,
                status,
                tableId);
    }

// ==========================
// TÌM KIẾM
// ==========================
    public List<RestaurantTable> searchByName(
            String keyword) {

        String sql
                = "SELECT * "
                + "FROM restaurant_tables "
                + "WHERE table_name LIKE ? "
                + "ORDER BY table_name";

        return jdbcTemplate.query(
                sql,
                rowMapper,
                "%" + keyword + "%");
    }

// ==========================
// BÀN TRỐNG
// ==========================
    public List<RestaurantTable> findAvailableTables() {

        String sql
                = "SELECT * "
                + "FROM restaurant_tables "
                + "WHERE status = 'AVAILABLE' "
                + "ORDER BY table_name";

        return jdbcTemplate.query(
                sql,
                rowMapper);
    }

}
