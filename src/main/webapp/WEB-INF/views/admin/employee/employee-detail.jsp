<%-- 
    Document   : employee-detail
    Created on : May 30, 2026, 10:21:31 AM
    Author     : ACER
--%>

<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<!DOCTYPE html>

<html>

    <head>

        
        <meta charset="UTF-8">

        <title>Chi Tiết Nhân Viên</title>

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/admin.css">

        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        

    </head>

    <body>

        <div class="dashboard-container">

            
            <!-- SIDEBAR -->

            <aside class="sidebar">

                <div class="logo">

                    <h2>🍽 Restaurant</h2>

                </div>

                <ul>

                    <li>
                        <a href="${pageContext.request.contextPath}/admin/dashboard">
                            <i class="fa-solid fa-chart-line"></i>
                            Dashboard
                        </a>
                    </li>

                    <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/employees">
                            <i class="fa-solid fa-users"></i>
                            Nhân Viên
                        </a>
                    </li>

                </ul>

            </aside>

            <!-- MAIN -->

            <main class="main-content">

                <div class="topbar">

                    <h1>Chi Tiết Nhân Viên</h1>

                </div>

                <div class="card">

                    <h2 style="margin-bottom:25px;">
                        Thông Tin Nhân Viên
                    </h2>

                    <table class="data-table">

                        <tbody>

                            <tr>
                                <th width="250">Mã Nhân Viên</th>
                                <td>${employee.employeeId}</td>
                            </tr>

                            <tr>
                                <th>Mã Tài Khoản</th>
                                <td>${employee.userId}</td>
                            </tr>

                            <tr>
                                <th>Họ Và Tên</th>
                                <td>${employee.fullName}</td>
                            </tr>

                            <tr>
                                <th>Số Điện Thoại</th>
                                <td>${employee.phone}</td>
                            </tr>

                            <tr>
                                <th>Email</th>
                                <td>${employee.email}</td>
                            </tr>

                            <tr>
                                <th>Địa Chỉ</th>
                                <td>${employee.address}</td>
                            </tr>

                            <tr>
                                <th>Ngày Vào Làm</th>
                                <td>${employee.hireDate}</td>
                            </tr>

                            <tr>
                                <th>Mức Lương</th>
                                <td>${employee.salary}</td>
                            </tr>

                        </tbody>

                    </table>

                    <div style="margin-top:25px;">

                        <a href="${pageContext.request.contextPath}/admin/employees/edit/${employee.employeeId}"
                           class="btn btn-warning">

                            <i class="fa-solid fa-pen"></i>

                            Chỉnh Sửa

                        </a>

                        <a href="${pageContext.request.contextPath}/admin/employees"
                           class="btn btn-primary">

                            <i class="fa-solid fa-arrow-left"></i>

                            Quay Lại

                        </a>

                    </div>

                </div>

            </main>
            

        </div>

    </body>

</html>

