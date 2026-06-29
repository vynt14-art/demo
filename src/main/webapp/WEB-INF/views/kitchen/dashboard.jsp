<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

    <head>


        <meta charset="UTF-8">

        <title>Bảng Điều Khiển Nhà Bếp</title>

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/kitchen.css">

        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">


    </head>

    <body>

        <div class="dashboard-container">


            <!-- THANH BÊN -->

            <aside class="sidebar">

                <div class="logo">

                    <h2>🍳 Nhà Bếp</h2>

                </div>

                <ul>

                    <li class="active">

                        <a href="#">

                            <i class="fa-solid fa-house"></i>

                            Bảng Điều Khiển

                        </a>

                    </li>

                    <li>

                        <a href="${pageContext.request.contextPath}/kitchen/pending">

                        <i class="fa-solid fa-clock"></i>

                        Đơn Chờ Nấu

                        </a>

                    </li>

                    <li>

                       <a href="${pageContext.request.contextPath}/kitchen/cooking">

                        <i class="fa-solid fa-fire"></i>

                        Đơn Đang Nấu

                        </a>

                    </li>

                    <li>

                       <a href="${pageContext.request.contextPath}/kitchen/completed">

                            <i class="fa-solid fa-check"></i>

                            Đơn Hoàn Thành

                        </a>

                    </li>

                    <li>

                        <a href="#">

                            <i class="fa-solid fa-triangle-exclamation"></i>

                            Hết Món

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

                    <h1>Bảng Điều Khiển Nhà Bếp</h1>

                    <div class="user-info">

                        Xin chào,

                        <strong>${user.username}</strong>

                    </div>

                </header>

                <!-- THỐNG KÊ -->

                <section class="card-container">

                    <div class="card">

                        <h3>Đơn Chờ Nấu</h3>

                        <p>${pendingOrders}</p>

                    </div>

                    <div class="card">

                        <h3>Đơn Đang Nấu</h3>

                        <p>${cookingOrders}</p>

                    </div>

                    <div class="card">

                        <h3>Đơn Hoàn Thành</h3>

                        <p>${completedOrders}</p>

                    </div>

                    <div class="card">

                        <h3>Món Hết Hàng</h3>

                        <p>${outOfStockItems}</p>

                    </div>

                </section>

                <!-- DANH SÁCH ĐƠN CHỜ NẤU -->

                <section class="order-section">

                    <h2>Danh Sách Đơn Chờ Nấu</h2>

                    <table class="data-table">

                        <thead>

                            <tr>

                                <th>Mã Đơn</th>

                                <th>Bàn</th>

                                <th>Thời Gian</th>

                                <th>Trạng Thái</th>

                                <th>Thao Tác</th>

                            </tr>

                        </thead>

                        <tbody>

                            <c:forEach items="${pendingOrderList}"
                                       var="order">

                                <tr>

                                    <td>#${order.orderId}</td>

                                    <td>${order.tableId}</td>

                                    <td>${order.orderTime}</td>

                                    <td>

                                        <span class="badge badge-pending">

                                            CHỜ NẤU

                                        </span>

                                    </td>

                                    <td>

                                        <a href="${pageContext.request.contextPath}/kitchen/detail/${order.orderId}"
                                           class="btn btn-primary">

                                            Chi Tiết

                                        </a>

                                        <a href="${pageContext.request.contextPath}/kitchen/start/${order.orderId}"
                                           class="btn btn-primary">

                                            Bắt Đầu Nấu

                                        </a>

                                    </td>

                                </tr>

                            </c:forEach>

                        </tbody>

                    </table>

                </section>

                <!-- CẢNH BÁO KHO -->

                <section class="inventory-section">

                    <h2>Cảnh Báo Nguyên Liệu Sắp Hết</h2>

                    <table class="data-table">

                        <thead>

                            <tr>

                                <th>Tên Nguyên Liệu</th>

                                <th>Số Lượng Hiện Tại</th>

                                <th>Mức Tối Thiểu</th>

                            </tr>

                        </thead>

                        <tbody>

                            <c:forEach items="${lowInventoryList}"
                                       var="item">

                                <tr>

                                    <td>${item.ingredientName}</td>

                                    <td>${item.quantity}</td>

                                    <td>${item.minimumQuantity}</td>

                                </tr>

                            </c:forEach>

                        </tbody>

                    </table>

                </section>

            </main>


        </div>

    </body>

</html>
