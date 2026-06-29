package uef.edu.vn.model;

import java.math.BigDecimal;

public class MenuItem {

    private int menuItemId;

    private int categoryId;

    private Integer mediaId;

    private String itemName;

    private BigDecimal price;

    private String description;

    private String status;

    private String imagePath;

    public MenuItem() {
    }

    public MenuItem(int menuItemId,
            int categoryId,
            Integer mediaId,
            String itemName,
            BigDecimal price,
            String description,
            String status) {

        this.menuItemId = menuItemId;
        this.categoryId = categoryId;
        this.mediaId = mediaId;
        this.itemName = itemName;
        this.price = price;
        this.description = description;
        this.status = status;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
