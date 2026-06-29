package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import uef.edu.vn.model.MenuItem;

@Repository
public class MenuRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<MenuItem> rowMapper
            = new RowMapper<MenuItem>() {

        @Override
        public MenuItem mapRow(
                ResultSet rs,
                int rowNum)
                throws SQLException {

            MenuItem menuItem
                    = new MenuItem();

            menuItem.setMenuItemId(
                    rs.getInt("menu_item_id"));

            menuItem.setCategoryId(
                    rs.getInt("category_id"));

            menuItem.setMediaId(
                    rs.getObject(
                            "media_id",
                            Integer.class));

            menuItem.setItemName(
                    rs.getString("item_name"));

            menuItem.setDescription(
                    rs.getString("description"));

            menuItem.setPrice(
                    rs.getBigDecimal("price"));

            menuItem.setStatus(
                    rs.getString("status"));

            try {
                menuItem.setImagePath(rs.getString("image_path"));
            } catch (SQLException ignored) {
                menuItem.setImagePath(null);
            }

            if (menuItem.getImagePath() == null
                    || menuItem.getImagePath().trim().isEmpty()) {

                menuItem.setImagePath(
                        buildDefaultMenuImagePath(
                                menuItem.getItemName()));
            }

            return menuItem;
        }
    };

    private String buildDefaultMenuImagePath(
            String itemName) {

        if (itemName == null
                || itemName.trim().isEmpty()) {

            return null;
        }

        String normalized
                = Normalizer.normalize(
                        itemName.trim(),
                        Normalizer.Form.NFD)
                        .replaceAll("\\p{M}", "")
                        .replace("đ", "d")
                        .replace("Đ", "D")
                        .replaceAll("[^A-Za-z0-9]+", "-")
                        .replaceAll("(^-)|(-$)", "");

        if (normalized.isEmpty()) {

            return null;
        }

        String fileName
                = normalized.substring(0, 1).toUpperCase()
                + normalized.substring(1)
                + ".jpg";

        return "/resources/images/menu/" + fileName;
    }

// ==========================
// DANH SÁCH MÓN ĂN
// ==========================
    public List<MenuItem> findAll() {

        String sql
                = "SELECT mi.*, m.file_path image_path "
                + "FROM menu_items mi "
                + "LEFT JOIN media m ON mi.media_id = m.media_id "
                + "ORDER BY mi.menu_item_id DESC";

        return jdbcTemplate.query(
                sql,
                rowMapper);
    }

// ==========================
// TÌM THEO ID
// ==========================
    public MenuItem findById(
            int menuItemId) {

        String sql
                = "SELECT mi.*, m.file_path image_path "
                + "FROM menu_items mi "
                + "LEFT JOIN media m ON mi.media_id = m.media_id "
                + "WHERE mi.menu_item_id = ?";

        List<MenuItem> items
                = jdbcTemplate.query(
                        sql,
                        rowMapper,
                        menuItemId);

        return items.isEmpty()
                ? null
                : items.get(0);
    }

// ==========================
// THÊM MÓN ĂN
// ==========================
    public int save(
            MenuItem menuItem) {

        String sql
                = "INSERT INTO menu_items "
                + "(category_id, media_id, item_name, description, price, status) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                menuItem.getCategoryId(),
                menuItem.getMediaId(),
                menuItem.getItemName(),
                menuItem.getDescription(),
                menuItem.getPrice(),
                menuItem.getStatus());
    }

// ==========================
// CẬP NHẬT
// ==========================
    public int update(
            MenuItem menuItem) {

        String sql
                = "UPDATE menu_items "
                + "SET category_id = ?, "
                + "media_id = ?, "
                + "item_name = ?, "
                + "description = ?, "
                + "price = ?, "
                + "status = ? "
                + "WHERE menu_item_id = ?";

        return jdbcTemplate.update(
                sql,
                menuItem.getCategoryId(),
                menuItem.getMediaId(),
                menuItem.getItemName(),
                menuItem.getDescription(),
                menuItem.getPrice(),
                menuItem.getStatus(),
                menuItem.getMenuItemId());
    }

// ==========================
// XÓA
// ==========================
    public int delete(
            int menuItemId) {

        String sql
                = "DELETE FROM menu_items "
                + "WHERE menu_item_id = ?";

        return jdbcTemplate.update(
                sql,
                menuItemId);
    }

// ==========================
// ĐẾM MÓN ĂN
// ==========================
    public int countMenuItems() {

        String sql
                = "SELECT COUNT(*) "
                + "FROM menu_items";

        return jdbcTemplate.queryForObject(
                sql,
                Integer.class);
    }

// ==========================
// TÌM KIẾM
// ==========================
    public List<MenuItem> searchByName(
            String keyword) {

        String sql
                = "SELECT mi.*, m.file_path image_path "
                + "FROM menu_items mi "
                + "LEFT JOIN media m ON mi.media_id = m.media_id "
                + "WHERE mi.item_name LIKE ? "
                + "ORDER BY mi.item_name";

        return jdbcTemplate.query(
                sql,
                rowMapper,
                "%" + keyword + "%");
    }

// ==========================
// THEO DANH MỤC
// ==========================
    public List<MenuItem> findByCategory(
            int categoryId) {

        String sql
                = "SELECT mi.*, m.file_path image_path "
                + "FROM menu_items mi "
                + "LEFT JOIN media m ON mi.media_id = m.media_id "
                + "WHERE mi.category_id = ?";

        return jdbcTemplate.query(
                sql,
                rowMapper,
                categoryId);
    }

// ==========================
// MÓN ĐANG BÁN
// ==========================
    public List<MenuItem> findAvailableItems() {

        String sql
                = "SELECT mi.*, m.file_path image_path "
                + "FROM menu_items mi "
                + "LEFT JOIN media m ON mi.media_id = m.media_id "
                + "WHERE mi.status = 'AVAILABLE'";

        return jdbcTemplate.query(
                sql,
                rowMapper);
    }

    public int countByStatus(
            String status) {

        String sql
                = "SELECT COUNT(*) "
                + "FROM menu_items "
                + "WHERE status = ?";

        Integer count
                = jdbcTemplate.queryForObject(
                        sql,
                        Integer.class,
                        status);

        return count == null ? 0 : count;
    }

    public String findBestSellingFoodName() {

        String sql
                = "SELECT m.item_name "
                + "FROM order_details od "
                + "JOIN menu_items m ON od.menu_item_id = m.menu_item_id "
                + "GROUP BY m.menu_item_id, m.item_name "
                + "ORDER BY SUM(od.quantity) DESC "
                + "LIMIT 1";

        List<String> names
                = jdbcTemplate.query(
                        sql,
                        (rs, rowNum) -> rs.getString("item_name"));

        return names.isEmpty() ? "Chua co du lieu" : names.get(0);
    }

    public int updateStatus(
            int menuItemId,
            String status) {

        String sql
                = "UPDATE menu_items "
                + "SET status = ? "
                + "WHERE menu_item_id = ?";

        return jdbcTemplate.update(
                sql,
                status,
                menuItemId);
    }

}
