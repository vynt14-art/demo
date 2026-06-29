package uef.edu.vn.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Invoice {

    private int invoiceId;

    private int orderId;

    private String paymentMethod;

    private BigDecimal totalAmount;

    private Timestamp paymentTime;

    public Invoice() {
    }

    public Invoice(
            int invoiceId,
            int orderId,
            String paymentMethod,
            BigDecimal totalAmount,
            Timestamp paymentTime) {

        this.invoiceId = invoiceId;
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
        this.paymentTime = paymentTime;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Override
    public String toString() {
        return "Invoice{"
                + "invoiceId=" + invoiceId
                + ", orderId=" + orderId
                + ", paymentMethod='" + paymentMethod + '\''
                + ", totalAmount=" + totalAmount
                + ", paymentTime=" + paymentTime
                + '}';
    }

}
