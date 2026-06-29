package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import uef.edu.vn.model.Notification;

@Repository
public class NotificationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Notification> rowMapper
            = new RowMapper<Notification>() {

        @Override
        public Notification mapRow(
                ResultSet rs,
                int rowNum)
                throws SQLException {

            Notification notification
                    = new Notification();

            notification.setNotificationId(
                    rs.getInt("notification_id"));

            notification.setOrderId(
                    rs.getObject("order_id", Integer.class));

            notification.setMessage(
                    rs.getString("message"));

            notification.setRead(
                    rs.getBoolean("is_read"));

            notification.setCreatedAt(
                    rs.getTimestamp("created_at"));

            return notification;
        }
    };

    public List<Notification> findLatest(
            int limit) {

        String sql
                = "SELECT * FROM notifications "
                + "ORDER BY created_at DESC "
                + "LIMIT ?";

        return jdbcTemplate.query(
                sql,
                rowMapper,
                limit);
    }

    public int countUnread() {

        String sql
                = "SELECT COUNT(*) "
                + "FROM notifications "
                + "WHERE is_read = 0";

        Integer count
                = jdbcTemplate.queryForObject(
                        sql,
                        Integer.class);

        return count == null ? 0 : count;
    }

    public int save(
            Notification notification) {

        String sql
                = "INSERT INTO notifications "
                + "(order_id, message, is_read) "
                + "VALUES (?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                notification.getOrderId(),
                notification.getMessage(),
                notification.isRead());
    }
}
