<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <head>

        <meta charset="UTF-8">

        <title>Bảng Điều Khiển Nhân Viên</title>

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/staff.css">

        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    </head>

    <body>

        <div class="dashboard-container">

            <!-- THANH BÊN -->

            <aside class="sidebar">

                <div class="logo">

                    <h2>🍽 Nhà Hàng</h2>

                </div>

                <ul>

                    <li class="active">
                        <a href="#">
                            <i class="fa-solid fa-house"></i>
                            Bảng Điều Khiển
                        </a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/staff/orders/add">
                            <i class="fa-solid fa-cart-plus"></i>
                            Tạo Đơn Hàng
                        </a>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fa-solid fa-receipt"></i>
                            Lịch Sử Đơn Hàng
                        </a>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fa-solid fa-bell"></i>
                            Thông Báo
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

            <!-- NỘI DUNG CHÍNH -->

            <main class="main-content">

                <!-- THANH TRÊN -->

                <header class="topbar">

                    <h1>Bảng Điều Khiển Nhân Viên</h1>

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

                        <h3>Bàn Đang Phục Vụ</h3>

                        <p>${occupiedTables}</p>

                    </div>

                    <div class="card">

                        <h3>Bàn Trống</h3>

                        <p>${availableTables}</p>

                    </div>

                    <div class="card">

                        <h3>Đơn Đang Phục Vụ</h3>

                        <p>${servingOrders}</p>

                    </div>

                    <div class="card">

                        <h3>Thông Báo Mới</h3>

                        <p>${newNotifications}</p>

                    </div>

                </section>

                <!-- THAO TÁC NHANH -->

                <section class="action-section">

                    <h2>Thao Tác Nhanh</h2>

                    <div class="action-grid">

                        <a href="${pageContext.request.contextPath}/staff/orders/add"
                           class="action-card">

                            <i class="fa-solid fa-cart-plus"></i>

                            <span>Tạo Đơn Hàng</span>

                        </a>

                        <a href="${pageContext.request.contextPath}/staff/orders"
                           class="action-card">
                            <i class="fa-solid fa-money-bill-wave"></i>

                            <span>Thanh Toán</span>

                        </a>

                        <a href="${pageContext.request.contextPath}/staff/orders"
                           class="action-card">

                            <i class="fa-solid fa-clock-rotate-left"></i>

                            <span>Lịch Sử Đơn Hàng</span>

                        </a>

                        <a href="${pageContext.request.contextPath}/staff/dashboard"
                           class="action-card">

                            <i class="fa-solid fa-bell"></i>

                            <span>Thông Báo</span>

                        </a>

                    </div>

                </section>

                <!-- THÔNG BÁO -->

                <section class="notification-section">

                    <h2>Thông Báo Mới Nhất</h2>

                    <table class="data-table">

                        <thead>

                            <tr>

                                <th>Thời Gian</th>

                                <th>Nội Dung</th>

                            </tr>

                        </thead>

                        <tbody>

                            <c:forEach items="${notifications}"
                                       var="notification">

                                <tr>

                                    <td>
                                        ${notification.createdAt}
                                    </td>

                                    <td>
                                        ${notification.message}
                                    </td>

                                </tr>

                            </c:forEach>

                        </tbody>

                    </table>

                </section>

            </main>

        </div>

    </body>

</html>