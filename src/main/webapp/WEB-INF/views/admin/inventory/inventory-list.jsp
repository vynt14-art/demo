<%-- 
    Document   : inventory-list
    Created on : May 29, 2026, 6:57:34 PM
    Author     : ACER
--%>

<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

    <head>

        
        <meta charset="UTF-8">

        <title>Quản Lý Kho Nguyên Liệu</title>

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
                            Dashboard
                        </a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/admin/employees">
                            Nhân Viên
                        </a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/admin/categories">
                            Danh Mục
                        </a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/admin/menu">
                            Thực Đơn
                        </a>
                    </li>

                    <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/inventory">
                            Kho Nguyên Liệu
                        </a>
                    </li>

                </ul>

            </aside>

            <!-- MAIN -->

            <main class="main-content">

                <div class="topbar">

                    <h1>Quản Lý Kho Nguyên Liệu</h1>

                </div>

                <!-- TÌM KIẾM -->

                <form action="${pageContext.request.contextPath}/admin/inventory/search"
                      method="get"
                      style="display:flex; gap:10px; margin-bottom:20px;">

                    <input type="text"
                           name="keyword"
                           value="${keyword}"
                           placeholder="Nhập tên nguyên liệu..."
                           class="form-control">

                    <button type="submit"
                            class="btn btn-primary">

                        <i class="fa-solid fa-magnifying-glass"></i>

                        Tìm Kiếm

                    </button>

                </form>

                <!-- CHỨC NĂNG -->

                <div style="margin-bottom:20px;">

                    <a href="${pageContext.request.contextPath}/admin/inventory/add"
                       class="btn btn-primary">

                        <i class="fa-solid fa-plus"></i>

                        Thêm Nguyên Liệu

                    </a>

                    <a href="${pageContext.request.contextPath}/admin/inventory/low-stock"
                       class="btn btn-warning">

                        <i class="fa-solid fa-triangle-exclamation"></i>

                        Nguyên Liệu Sắp Hết

                    </a>

                </div>

                <!-- BẢNG -->

                <table class="data-table">

                    <thead>

                        <tr>

                            <th>ID</th>

                            <th>Tên Nguyên Liệu</th>

                            <th>Đơn Vị</th>

                            <th>Số Lượng</th>

                            <th>Tồn Tối Thiểu</th>

                            <th>Cập Nhật</th>

                            <th>Trạng Thái</th>

                            <th>Thao Tác</th>

                        </tr>

                    </thead>

                    <tbody>

                        <c:choose>

                            <c:when test="${not empty inventories}">

                                <c:forEach items="${inventories}"
                                           var="item">

                                    <tr>

                                        <td>${item.inventoryId}</td>

                                        <td>${item.ingredientName}</td>

                                        <td>${item.unit}</td>

                                        <td>${item.quantity}</td>

                                        <td>${item.minimumQuantity}</td>

                                        <td>${item.lastUpdated}</td>

                                        <td>

                                            <c:choose>

                                                <c:when test="${item.quantity <= item.minimumQuantity}">

                                                    <span class="badge badge-pending">

                                                        Sắp Hết

                                                    </span>

                                                </c:when>

                                                <c:otherwise>

                                                    <span class="badge badge-ready">

                                                        Bình Thường

                                                    </span>

                                                </c:otherwise>

                                            </c:choose>

                                        </td>

                                        <td>

                                            <a href="${pageContext.request.contextPath}/admin/inventory/detail/${item.inventoryId}"
                                               class="btn btn-success">

                                                Chi Tiết

                                            </a>

                                            <a href="${pageContext.request.contextPath}/admin/inventory/edit/${item.inventoryId}"
                                               class="btn btn-warning">

                                                Sửa

                                            </a>

                                            <a href="${pageContext.request.contextPath}/admin/inventory/delete/${item.inventoryId}"
                                               class="btn btn-danger"
                                               onclick="return confirm('Bạn có chắc muốn xóa nguyên liệu này?')">

                                                Xóa

                                            </a>

                                        </td>

                                    </tr>

                                </c:forEach>

                            </c:when>

                            <c:otherwise>

                                <tr>

                                    <td colspan="8"
                                        style="text-align:center;padding:20px;">

                                        Chưa có dữ liệu nguyên liệu

                                    </td>

                                </tr>

                            </c:otherwise>

                        </c:choose>

                    </tbody>

                </table>

            </main>
            

        </div>

    </body>

</html>

