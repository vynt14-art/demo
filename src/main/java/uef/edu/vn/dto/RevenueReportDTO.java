package uef.edu.vn.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class RevenueReportDTO {

    private Date reportDate;

    private BigDecimal revenue;

    public RevenueReportDTO() {
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "RevenueReportDTO{"
                + "reportDate=" + reportDate
                + ", revenue=" + revenue
                + '}';
    }
    

}
