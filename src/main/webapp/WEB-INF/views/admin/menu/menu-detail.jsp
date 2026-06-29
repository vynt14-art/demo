<%-- 
    Document   : menu-detail
    Created on : May 27, 2026, 11:25:27 AM
    Author     : ACER
--%>

<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<!DOCTYPE html>

<html>

    <head>

        
        <meta charset="UTF-8">

        <title>Chi Tiết Món Ăn</title>

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

                </ul>

            </aside>

            <!-- MAIN CONTENT -->

            <main class="main-content">

                <div class="topbar">

                    <h1>Chi Tiết Món Ăn</h1>

                </div>

                <div class="card">

                    <h2 style="margin-bottom:25px;">

                        Thông Tin Món Ăn

                    </h2>

                    <table class="data-table">

                        <tbody>

                            <tr>

                                <th width="250">

                                    Mã Món Ăn

                                </th>

                                <td>

                                    ${menuItem.menuItemId}

                                </td>

                            </tr>

                            <tr>

                                <th>

                                    Mã Danh Mục

                                </th>

                                <td>

                                    ${menuItem.categoryId}

                                </td>

                            </tr>

                            <tr>

                                <th>

                                    Tên Món Ăn

                                </th>

                                <td>

                                    ${menuItem.itemName}

                                </td>

                            </tr>

                            <tr>

                                <th>

                                    Mô Tả

                                </th>

                                <td>

                                    ${menuItem.description}

                                </td>

                            </tr>

                            <tr>

                                <th>

                                    Giá Bán

                                </th>

                                <td>

                                    ${menuItem.price} VNĐ

                                </td>

                            </tr>

                            <tr>

                                <th>

                                    Media ID

                                </th>

                                <td>

                                    ${menuItem.mediaId}

                                </td>

                            </tr>

                            <tr>

                                <th>

                                    Trạng Thái

                                </th>

                                <td>

                        <c:choose>

                            <c:when test="${menuItem.status == 'AVAILABLE'}">

                                Đang Bán

                            </c:when>

                            <c:otherwise>

                                Hết Món

                            </c:otherwise>

                        </c:choose>

                        </td>

                        </tr>

                        </tbody>

                    </table>

                    <div style="margin-top:25px;">

                        <a href="${pageContext.request.contextPath}/admin/menu/edit/${menuItem.menuItemId}"
                           class="btn btn-warning">

                            <i class="fa-solid fa-pen"></i>

                            Chỉnh Sửa

                        </a>

                        <a href="${pageContext.request.contextPath}/admin/menu"
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

