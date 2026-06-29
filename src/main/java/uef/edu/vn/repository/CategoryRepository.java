package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import uef.edu.vn.model.Category;

@Repository
public class CategoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Category> rowMapper
            = new RowMapper<Category>() {

        @Override
        public Category mapRow(
                ResultSet rs,
                int rowNum)
                throws SQLException {

            Category category
                    = new Category();

            category.setCategoryId(
                    rs.getInt("category_id"));

            category.setCategoryName(
                    rs.getString("category_name"));

            category.setDescription(
                    rs.getString("description"));

            return category;
        }
    };

    // ==========================
    // LẤY DANH SÁCH
    // ==========================
    public List<Category> findAll() {

        String sql
                = "SELECT * "
                + "FROM categories "
                + "ORDER BY category_name";

        return jdbcTemplate.query(
                sql,
                rowMapper);
    }

    // ==========================
    // TÌM THEO ID
    // ==========================
    public Category findById(
            int categoryId) {

        String sql
                = "SELECT * "
                + "FROM categories "
                + "WHERE category_id = ?";

        List<Category> categories
                = jdbcTemplate.query(
                        sql,
                        rowMapper,
                        categoryId);

        return categories.isEmpty()
                ? null
                : categories.get(0);
    }

    // ==========================
    // THÊM
    // ==========================
    public int save(
            Category category) {

        String sql
                = "INSERT INTO categories "
                + "(category_name, description) "
                + "VALUES (?, ?)";

        return jdbcTemplate.update(
                sql,
                category.getCategoryName(),
                category.getDescription());
    }

    // ==========================
    // CẬP NHẬT
    // ==========================
    public int update(
            Category category) {

        String sql
                = "UPDATE categories "
                + "SET category_name = ?, "
                + "description = ? "
                + "WHERE category_id = ?";

        return jdbcTemplate.update(
                sql,
                category.getCategoryName(),
                category.getDescription(),
                category.getCategoryId());
    }

    // ==========================
    // XÓA
    // ==========================
    public int delete(
            int categoryId) {

        String sql
                = "DELETE FROM categories "
                + "WHERE category_id = ?";

        return jdbcTemplate.update(
                sql,
                categoryId);
    }

    // ==========================
    // ĐẾM DANH MỤC
    // ==========================
    public int countCategories() {

        String sql
                = "SELECT COUNT(*) "
                + "FROM categories";

        return jdbcTemplate.queryForObject(
                sql,
                Integer.class);
    }

    // ==========================
    // TÌM KIẾM
    // ==========================
    public List<Category> searchByName(
            String keyword) {

        String sql
                = "SELECT * "
                + "FROM categories "
                + "WHERE category_name LIKE ? "
                + "ORDER BY category_name";

        return jdbcTemplate.query(
                sql,
                rowMapper,
                "%" + keyword + "%");
    }
}
