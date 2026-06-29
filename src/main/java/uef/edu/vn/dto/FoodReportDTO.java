package uef.edu.vn.dto;

import java.math.BigDecimal;

public class FoodReportDTO {

    private String foodName;

    private int quantitySold;

    private BigDecimal revenue;

    public FoodReportDTO() {
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "FoodReportDTO{"
                + "foodName='" + foodName + '\''
                + ", quantitySold=" + quantitySold
                + ", revenue=" + revenue
                + '}';
    }

}
