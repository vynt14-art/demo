package uef.edu.vn.model;

public class RestaurantTable {

    private int tableId;

    private String tableName;

    private int capacity;

    private String status;

    private Integer currentOrderId;

    private String currentOrderStatus;

    private java.math.BigDecimal currentTotalAmount;

    private Integer currentItemCount;

    private java.sql.Timestamp currentOrderTime;

    public RestaurantTable() {
    }

    public RestaurantTable(int tableId,
            String tableName,
            int capacity,
            String status) {

        this.tableId = tableId;
        this.tableName = tableName;
        this.capacity = capacity;
        this.status = status;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCurrentOrderId() {
        return currentOrderId;
    }

    public void setCurrentOrderId(Integer currentOrderId) {
        this.currentOrderId = currentOrderId;
    }

    public String getCurrentOrderStatus() {
        return currentOrderStatus;
    }

    public void setCurrentOrderStatus(String currentOrderStatus) {
        this.currentOrderStatus = currentOrderStatus;
    }

    public java.math.BigDecimal getCurrentTotalAmount() {
        return currentTotalAmount;
    }

    public void setCurrentTotalAmount(java.math.BigDecimal currentTotalAmount) {
        this.currentTotalAmount = currentTotalAmount;
    }

    public Integer getCurrentItemCount() {
        return currentItemCount;
    }

    public void setCurrentItemCount(Integer currentItemCount) {
        this.currentItemCount = currentItemCount;
    }

    public java.sql.Timestamp getCurrentOrderTime() {
        return currentOrderTime;
    }

    public void setCurrentOrderTime(java.sql.Timestamp currentOrderTime) {
        this.currentOrderTime = currentOrderTime;
    }
}
