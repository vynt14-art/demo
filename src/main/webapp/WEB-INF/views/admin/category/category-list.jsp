<%-- 
    Document   : category-list
    Created on : May 29, 2026, 6:56:28 PM
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

        <title>Quản Lý Danh Mục</title>

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

                    <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/categories">

                            <i class="fa-solid fa-layer-group"></i>

                            Danh Mục

                        </a>
                    </li>

                    <li>
                        <a href="#">

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

                    <h1>Quản Lý Danh Mục Món Ăn</h1>

                </div>

                <!-- TÌM KIẾM -->

                <form action="${pageContext.request.contextPath}/admin/categories/search"
                      method="get"
                      style="display:flex; gap:10px; margin-bottom:20px;">

                    <input type="text"
                           name="keyword"
                           value="${keyword}"
                           placeholder="Nhập tên danh mục..."
                           class="form-control">

                    <button type="submit"
                            class="btn btn-primary">

                        <i class="fa-solid fa-magnifying-glass"></i>

                        Tìm Kiếm

                    </button>

                </form>

                <!-- NÚT THÊM -->

                <div style="margin-bottom:20px;">

                    <a href="${pageContext.request.contextPath}/admin/categories/add"
                       class="btn btn-primary">

                        <i class="fa-solid fa-plus"></i>

                        Thêm Danh Mục

                    </a>

                </div>

                <!-- BẢNG DANH MỤC -->

                <table class="data-table">

                    <thead>

                        <tr>

                            <th width="120">Mã DM</th>

                            <th>Tên Danh Mục</th>

                            <th>Mô Tả</th>

                            <th width="280">Thao Tác</th>

                        </tr>

                    </thead>

                    <tbody>

                    <c:choose>

                        <c:when test="${not empty categories}">

                            <c:forEach items="${categories}"
                                       var="category">

                                <tr>

                                    <td>

                                        ${category.categoryId}

                                    </td>

                                    <td>

                                        ${category.categoryName}

                                    </td>

                                    <td>

                                        ${category.description}

                                    </td>

                                    <td>

                                        <a href="${pageContext.request.contextPath}/admin/categories/detail/${category.categoryId}"
                                           class="btn btn-success">

                                            Chi Tiết

                                        </a>

                                        <a href="${pageContext.request.contextPath}/admin/categories/edit/${category.categoryId}"
                                           class="btn btn-warning">

                                            Sửa

                                        </a>

                                        <a href="${pageContext.request.contextPath}/admin/categories/delete/${category.categoryId}"
                                           class="btn btn-danger"
                                           onclick="return confirm('Bạn có chắc muốn xóa danh mục này?')">

                                            Xóa

                                        </a>

                                    </td>

                                </tr>

                            </c:forEach>

                        </c:when>

                        <c:otherwise>

                            <tr>

                                <td colspan="4"
                                    style="text-align:center; padding:20px;">

                                    Chưa có dữ liệu danh mục

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

