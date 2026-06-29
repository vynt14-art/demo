package uef.edu.vn.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Inventory {

    private int inventoryId;

    private String ingredientName;

    private BigDecimal quantity;

    private String unit;

    private BigDecimal minimumQuantity;

    private Timestamp lastUpdated;

    public Inventory() {
    }

    public Inventory(int inventoryId,
            String ingredientName,
            BigDecimal quantity,
            String unit,
            BigDecimal minimumQuantity,
            Timestamp lastUpdated) {

        this.inventoryId = inventoryId;
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.unit = unit;
        this.minimumQuantity = minimumQuantity;
        this.lastUpdated = lastUpdated;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(BigDecimal minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
