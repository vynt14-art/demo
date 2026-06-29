<%-- 
    Document   : employee-edit
    Created on : May 30, 2026, 10:19:40 AM
    Author     : ACER
--%>

<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<!DOCTYPE html>

<html>

    <head>

        
        <meta charset="UTF-8">

        <title>Cập Nhật Nhân Viên</title>

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/admin.css">

        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        

    </head>

    <body>

        <div class="dashboard-container">

            
            <aside class="sidebar">

                <div class="logo">

                    <h2>🍽 Restaurant</h2>

                </div>

                <ul>

                    <li>
                        <a href="${pageContext.request.contextPath}/admin/dashboard">
                            Dashboard
                        </a>
                    </li>

                    <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/employees">
                            Nhân Viên
                        </a>
                    </li>

                </ul>

            </aside>

            <main class="main-content">

                <div class="topbar">

                    <h1>Cập Nhật Nhân Viên</h1>

                </div>

                <form action="${pageContext.request.contextPath}/admin/employees/update"
                      method="post">

                    <input type="hidden"
                           name="employeeId"
                           value="${employee.employeeId}">

                    <input type="hidden"
                           name="userId"
                           value="${employee.userId}">

                    <input type="hidden"
                           name="mediaId"
                           value="${employee.mediaId}">

                    <div class="card">

                        <h2 style="margin-bottom:20px;">

                            Thông Tin Nhân Viên

                        </h2>

                        <div style="margin-bottom:15px;">

                            <label>Anh nhan vien</label>

                            <div class="image-path-row">
                                <span class="image-plus">+</span>
                                <input type="text"
                                       name="imagePath"
                                       class="form-control"
                                       value="${employee.imagePath}"
                                       placeholder="/resources/images/employees/ten-anh.jpg">
                            </div>

                        </div>

                        <div style="margin-bottom:15px;">

                            <label>Ho va ten</label>

                            <input type="text"
                                   name="fullName"
                                   class="form-control"
                                   value="${employee.fullName}"
                                   required>

                        </div>

                        <div style="margin-bottom:15px;">

                            <label>Số điện thoại</label>

                            <input type="text"
                                   name="phone"
                                   class="form-control"
                                   value="${employee.phone}">

                        </div>

                        <div style="margin-bottom:15px;">

                            <label>Email</label>

                            <input type="email"
                                   name="email"
                                   class="form-control"
                                   value="${employee.email}">

                        </div>

                        <div style="margin-bottom:15px;">

                            <label>Địa chỉ</label>

                            <input type="text"
                                   name="address"
                                   class="form-control"
                                   value="${employee.address}">

                        </div>

                        <div style="margin-bottom:15px;">

                            <label>Ngày vào làm</label>

                            <input type="date"
                                   name="hireDate"
                                   class="form-control"
                                   value="${employee.hireDate}">

                        </div>

                        <div style="margin-bottom:20px;">

                            <label>Lương</label>

                            <input type="number"
                                   name="salary"
                                   class="form-control"
                                   value="${employee.salary}"
                                   min="0">

                        </div>

                        <button type="submit"
                                class="btn btn-primary">

                            <i class="fa-solid fa-floppy-disk"></i>

                            Cập Nhật

                        </button>

                        <a href="${pageContext.request.contextPath}/admin/employees"
                           class="btn btn-danger">

                            Hủy

                        </a>

                    </div>

                </form>

            </main>
            

        </div>

    </body>

</html>
