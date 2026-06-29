package uef.edu.vn.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Employee {

    private int employeeId;

    private int userId;

    private Integer mediaId;

    private String fullName;

    private String phone;

    private String email;

    private String address;

    private Date hireDate;

    private BigDecimal salary;

    private String role;

    private boolean accountStatus;

    private String imagePath;

    public Employee() {
    }

    public Employee(int employeeId,
            int userId,
            Integer mediaId,
            String fullName,
            String phone,
            String email,
            String address,
            Date hireDate,
            BigDecimal salary) {

        this.employeeId = employeeId;
        this.userId = userId;
        this.mediaId = mediaId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
