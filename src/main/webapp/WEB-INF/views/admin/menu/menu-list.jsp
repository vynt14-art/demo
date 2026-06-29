<%-- 
    Document   : menu-list
    Created on : May 27, 2026, 11:24:43 AM
    Author     : ACER
--%>

<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"
           uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>

    <head>

        
        <meta charset="UTF-8">

        <title>Quản Lý Thực Đơn</title>

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

                    <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/menu">

                            <i class="fa-solid fa-utensils"></i>

                            Thực Đơn

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

            <!-- MAIN CONTENT -->

            <main class="main-content">

                <div class="topbar">

                    <h1>Quản Lý Thực Đơn</h1>

                </div>

                <!-- TÌM KIẾM -->

                <form action="${pageContext.request.contextPath}/admin/menu/search"
                      method="get"
                      style="display:flex; gap:10px; margin-bottom:20px;">

                    <input type="text"
                           name="keyword"
                           value="${keyword}"
                           placeholder="Nhập tên món ăn..."
                           class="form-control">

                    <button type="submit"
                            class="btn btn-primary">

                        <i class="fa-solid fa-magnifying-glass"></i>

                        Tìm Kiếm

                    </button>

                </form>

                <!-- NÚT THÊM -->

                <div style="margin-bottom:20px;">

                    <a href="${pageContext.request.contextPath}/admin/menu/add"
                       class="btn btn-primary">

                        <i class="fa-solid fa-plus"></i>

                        Thêm Món Ăn

                    </a>

                </div>

                <!-- DANH SÁCH MÓN ĂN -->

                <table class="data-table">

                    <thead>

                        <tr>

                            <th width="80">ID</th>

                            <th width="90">Anh</th>

                            <th>Tên Món</th>

                            <th width="120">Mã Danh Mục</th>

                            <th width="150">Giá Bán</th>

                            <th width="150">Trạng Thái</th>

                            <th width="300">Thao Tác</th>

                        </tr>

                    </thead>

                    <tbody>

                    <c:choose>

                        <c:when test="${not empty menuItems}">

                            <c:forEach items="${menuItems}"
                                       var="item">

                                <tr>

                                    <td>

                                        ${item.menuItemId}

                                    </td>

                                    <td>
                                        <c:choose>
                                            <c:when test="${not empty item.imagePath}">
                                                <c:choose>
                                                    <c:when test="${fn:startsWith(item.imagePath, '/')}">
                                                        <c:set var="menuImageUrl"
                                                               value="${pageContext.request.contextPath}${item.imagePath}"/>
                                                    </c:when>
                                                    <c:when test="${fn:startsWith(item.imagePath, 'resources/')}">
                                                        <c:set var="menuImageUrl"
                                                               value="${pageContext.request.contextPath}/${item.imagePath}"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:set var="menuImageUrl"
                                                               value="${pageContext.request.contextPath}/resources/images/menu/${item.imagePath}"/>
                                                    </c:otherwise>
                                                </c:choose>
                                                <img src="${menuImageUrl}"
                                                     alt="${item.itemName}"
                                                     style="width:56px;height:56px;object-fit:cover;border-radius:8px;">
                                            </c:when>
                                            <c:otherwise>
                                                <span class="image-plus">+</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>

                                    <td>

                                        ${item.itemName}

                                    </td>

                                    <td>

                                        ${item.categoryId}

                                    </td>

                                    <td>

                                        ${item.price}

                                    </td>

                                    <td>

                                <c:choose>

                                    <c:when test="${item.status eq 'AVAILABLE'}">

                                        <span class="badge badge-ready">

                                            Đang Bán

                                        </span>

                                    </c:when>

                                    <c:otherwise>

                                        <span class="badge badge-pending">

                                            Hết Món

                                        </span>

                                    </c:otherwise>

                                </c:choose>

                                </td>

                                <td>

                                    <a href="${pageContext.request.contextPath}/admin/menu/detail/${item.menuItemId}"
                                       class="btn btn-success">

                                        Chi Tiết

                                    </a>

                                    <a href="${pageContext.request.contextPath}/admin/menu/edit/${item.menuItemId}"
                                       class="btn btn-warning">

                                        Sửa

                                    </a>

                                    <a href="${pageContext.request.contextPath}/admin/menu/delete/${item.menuItemId}"
                                       class="btn btn-danger"
                                       onclick="return confirm('Bạn có chắc muốn xóa món ăn này?')">

                                        Xóa

                                    </a>

                                </td>

                                </tr>

                            </c:forEach>

                        </c:when>

                        <c:otherwise>

                            <tr>

                                <td colspan="6"
                                    style="text-align:center;padding:20px;">

                                    Chưa có dữ liệu món ăn

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
