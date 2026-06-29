package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import uef.edu.vn.model.User;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<User> rowMapper = new RowMapper<User>() {

        @Override
        public User mapRow(ResultSet rs, int rowNum)
                throws SQLException {

            User user = new User();

            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setStatus(rs.getBoolean("status"));
            user.setCreatedAt(rs.getTimestamp("created_at"));

            return user;
        }
    };

// ==========================
// LOGIN
// ==========================
    public User login(String username, String password) {

        String sql
                = "SELECT * FROM users "
                + "WHERE username = ? "
                + "AND password = ? "
                + "AND status = 1";

        List<User> users = jdbcTemplate.query(
                sql,
                rowMapper,
                username,
                password
        );

        return users.isEmpty() ? null : users.get(0);
    }

    public int getLastUserId() {

        String sql
                = "SELECT MAX(user_id) FROM users";

        Integer id
                = jdbcTemplate.queryForObject(
                        sql,
                        Integer.class);

        return id == null ? 0 : id;
    }
// ==========================
// FIND BY USERNAME
// ==========================

    public User findByUsername(String username) {

        String sql
                = "SELECT * FROM users "
                + "WHERE username = ?";

        List<User> users = jdbcTemplate.query(
                sql,
                rowMapper,
                username
        );

        return users.isEmpty() ? null : users.get(0);
    }

// ==========================
// FIND BY ID
// ==========================
    public User findById(int userId) {

        String sql
                = "SELECT * FROM users "
                + "WHERE user_id = ?";

        List<User> users = jdbcTemplate.query(
                sql,
                rowMapper,
                userId
        );

        return users.isEmpty() ? null : users.get(0);
    }

// ==========================
// FIND ALL
// ==========================
    public List<User> findAll() {

        String sql
                = "SELECT * FROM users "
                + "ORDER BY user_id DESC";

        return jdbcTemplate.query(
                sql,
                rowMapper
        );
    }

// ==========================
// INSERT
// ==========================
    public int save(User user) {

        String sql
                = "INSERT INTO users "
                + "(username, password, role, status) "
                + "VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.isStatus()
        );
    }

// ==========================
// UPDATE PASSWORD
// ==========================
    public int updatePassword(int userId,
            String password) {

        String sql
                = "UPDATE users "
                + "SET password = ? "
                + "WHERE user_id = ?";

        return jdbcTemplate.update(
                sql,
                password,
                userId
        );
    }

// ==========================
// UPDATE ROLE
// ==========================
    public int updateRole(int userId,
            String role) {

        String sql
                = "UPDATE users "
                + "SET role = ? "
                + "WHERE user_id = ?";

        return jdbcTemplate.update(
                sql,
                role,
                userId
        );
    }

// ==========================
// UPDATE STATUS
// ==========================
    public int updateStatus(int userId,
            boolean status) {

        String sql
                = "UPDATE users "
                + "SET status = ? "
                + "WHERE user_id = ?";

        return jdbcTemplate.update(
                sql,
                status,
                userId
        );
    }

// ==========================
// DELETE
// ==========================
    public int delete(int userId) {

        String sql
                = "DELETE FROM users "
                + "WHERE user_id = ?";

        return jdbcTemplate.update(
                sql,
                userId
        );
    }

// ==========================
// COUNT USERS
// ==========================
    public int countUsers() {

        String sql
                = "SELECT COUNT(*) FROM users";

        Integer count = jdbcTemplate.queryForObject(
                sql,
                Integer.class
        );

        return count != null ? count : 0;
    }

}
