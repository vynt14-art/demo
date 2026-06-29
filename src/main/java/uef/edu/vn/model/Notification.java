package uef.edu.vn.model;

import java.sql.Timestamp;

public class Notification {

    private int notificationId;

    private Integer orderId;

    private String message;

    private boolean isRead;

    private Timestamp createdAt;

    public Notification() {
    }

    public Notification(int notificationId,
            Integer orderId,
            String message,
            boolean isRead,
            Timestamp createdAt) {

        this.notificationId = notificationId;
        this.orderId = orderId;
        this.message = message;
        this.isRead = isRead;
        this.createdAt = createdAt;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
