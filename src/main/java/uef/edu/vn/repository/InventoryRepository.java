package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import uef.edu.vn.model.Inventory;

@Repository
public class InventoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Inventory> rowMapper
            = new RowMapper<Inventory>() {

        @Override
        public Inventory mapRow(
                ResultSet rs,
                int rowNum)
                throws SQLException {

            Inventory inventory
                    = new Inventory();

            inventory.setInventoryId(
                    rs.getInt("inventory_id"));

            inventory.setIngredientName(
                    rs.getString("ingredient_name"));

            inventory.setUnit(
                    rs.getString("unit"));

            inventory.setQuantity(
                    rs.getBigDecimal("quantity"));

            inventory.setMinimumQuantity(
                    rs.getBigDecimal("minimum_quantity"));

            inventory.setLastUpdated(
                    rs.getTimestamp("last_updated"));

            return inventory;
        }
    };

// ==========================
// DANH SÁCH NGUYÊN LIỆU
// ==========================
    public List<Inventory> findAll() {

        String sql
                = "SELECT * "
                + "FROM inventory "
                + "ORDER BY ingredient_name";

        return jdbcTemplate.query(
                sql,
                rowMapper);
    }

// ==========================
// TÌM THEO ID
// ==========================
    public Inventory findById(
            int inventoryId) {

        String sql
                = "SELECT * "
                + "FROM inventory "
                + "WHERE inventory_id = ?";

        List<Inventory> inventories
                = jdbcTemplate.query(
                        sql,
                        rowMapper,
                        inventoryId);

        return inventories.isEmpty()
                ? null
                : inventories.get(0);
    }

// ==========================
// THÊM NGUYÊN LIỆU
// ==========================
    public int save(
            Inventory inventory) {

        String sql
                = "INSERT INTO inventory "
                + "(ingredient_name, unit, quantity, minimum_quantity) "
                + "VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                inventory.getIngredientName(),
                inventory.getUnit(),
                inventory.getQuantity(),
                inventory.getMinimumQuantity());
    }

// ==========================
// CẬP NHẬT
// ==========================
    public int update(
            Inventory inventory) {

        String sql
                = "UPDATE inventory "
                + "SET ingredient_name = ?, "
                + "unit = ?, "
                + "quantity = ?, "
                + "minimum_quantity = ? "
                + "WHERE inventory_id = ?";

        return jdbcTemplate.update(
                sql,
                inventory.getIngredientName(),
                inventory.getUnit(),
                inventory.getQuantity(),
                inventory.getMinimumQuantity(),
                inventory.getInventoryId());
    }

// ==========================
// XÓA
// ==========================
    public int delete(
            int inventoryId) {

        String sql
                = "DELETE FROM inventory "
                + "WHERE inventory_id = ?";

        return jdbcTemplate.update(
                sql,
                inventoryId);
    }

// ==========================
// ĐẾM NGUYÊN LIỆU
// ==========================
    public int countInventoryItems() {

        String sql
                = "SELECT COUNT(*) "
                + "FROM inventory";

        return jdbcTemplate.queryForObject(
                sql,
                Integer.class);
    }

// ==========================
// TÌM KIẾM
// ==========================
    public List<Inventory> searchByName(
            String keyword) {

        String sql
                = "SELECT * "
                + "FROM inventory "
                + "WHERE ingredient_name LIKE ? "
                + "ORDER BY ingredient_name";

        return jdbcTemplate.query(
                sql,
                rowMapper,
                "%" + keyword + "%");
    }

// ==========================
// NGUYÊN LIỆU SẮP HẾT
// ==========================
    public List<Inventory> findLowStockItems() {

        String sql
                = "SELECT * "
                + "FROM inventory "
                + "WHERE quantity <= minimum_quantity";

        return jdbcTemplate.query(
                sql,
                rowMapper);
    }

    public int countLowStockItems() {

        String sql
                = "SELECT COUNT(*) "
                + "FROM inventory "
                + "WHERE quantity <= minimum_quantity";

        Integer count
                = jdbcTemplate.queryForObject(
                        sql,
                        Integer.class);

        return count == null ? 0 : count;
    }

    public int countOutOfStockItems() {

        String sql
                = "SELECT COUNT(*) "
                + "FROM inventory "
                + "WHERE quantity <= 0";

        Integer count
                = jdbcTemplate.queryForObject(
                        sql,
                        Integer.class);

        return count == null ? 0 : count;
    }

}
