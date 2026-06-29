package uef.edu.vn.model;

public class Category {

    private int categoryId;

    private Integer mediaId;

    private String categoryName;

    private String description;

    public Category() {
    }

    public Category(int categoryId,
            Integer mediaId,
            String categoryName,
            String description) {

        this.categoryId = categoryId;
        this.mediaId = mediaId;
        this.categoryName = categoryName;
        this.description = description;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
