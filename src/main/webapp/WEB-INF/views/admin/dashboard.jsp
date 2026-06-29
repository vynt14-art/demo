<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

    <head>


        <meta charset="UTF-8">

        <title>Bảng Điều Khiển Quản Trị</title>

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/admin.css">

        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">


    </head>

    <body>

        <div class="dashboard-container">


            <!-- THANH BÊN -->

            <aside class="sidebar">

                <aside class="sidebar">

                    
                    <div class="logo">

                        <h2>🍽 Nhà Hàng</h2>

                    </div>

                    <ul>

                        <li class="active">
                            <a href="${pageContext.request.contextPath}/admin/dashboard">
                                <i class="fa-solid fa-chart-line"></i>
                                Bảng Điều Khiển
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/admin/employees">
                                <i class="fa-solid fa-users"></i>
                                Nhân Viên
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/admin/categories">
                                <i class="fa-solid fa-layer-group"></i>
                                Danh Mục
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/admin/menu">
                                <i class="fa-solid fa-utensils"></i>
                                Thực Đơn
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/admin/inventory">
                                <i class="fa-solid fa-box"></i>
                                Kho Hàng
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/admin/tables">
                                <i class="fa-solid fa-table"></i>
                                Bàn Ăn
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/admin/invoices">
                                <i class="fa-solid fa-clock-rotate-left"></i>
                                Lich Su Don
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/admin/reports/revenue">
                                <i class="fa-solid fa-file-invoice"></i>
                                Báo Cáo
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/logout">
                                <i class="fa-solid fa-right-from-bracket"></i>
                                Đăng Xuất
                            </a>
                        </li>

                    </ul>
                    

                </aside>


            </aside>

            <!-- NỘI DUNG CHÍNH -->

            <main class="main-content">

                <header class="topbar">

                    <h1>
                        Bảng Điều Khiển Quản Trị
                    </h1>

                    <div class="user-info">

                        Xin chào,

                        <strong>
                            ${user.username}
                        </strong>

                    </div>

                </header>

                <!-- THỐNG KÊ -->

                <section class="card-container">

                    <div class="card">

                        <h3>Doanh Thu Hôm Nay</h3>

                        <p>
                            ${todayRevenue}
                        </p>

                    </div>

                    <div class="card">

                        <h3>Doanh Thu Tháng</h3>

                        <p>
                            ${monthRevenue}
                        </p>

                    </div>

                    <div class="card">

                        <h3>Tổng Đơn Hàng</h3>

                        <p>
                            ${totalOrders}
                        </p>

                    </div>

                    <div class="card">

                        <h3>Nhân Viên</h3>

                        <p>
                            ${totalEmployees}
                        </p>

                    </div>

                </section>

                <!-- TRẠNG THÁI BÀN -->

                <section class="table-status">

                    <div class="status-card">

                        <h3>Bàn Đang Hoạt Động</h3>

                        <p>
                            ${occupiedTables}
                        </p>

                    </div>

                    <div class="status-card">

                        <h3>Bàn Trống</h3>

                        <p>
                            ${availableTables}
                        </p>

                    </div>

                    <div class="status-card">

                        <h3>Món Bán Chạy</h3>

                        <p>
                            ${bestSellingFood}
                        </p>

                    </div>

                </section>

            </main>


        </div>

    </body>

</html>
