<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<!DOCTYPE html>

<html>

    <head>

        
        <meta charset="UTF-8">

        <title>Chi Tiết Danh Mục</title>

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

                </ul>

            </aside>

            <!-- MAIN -->

            <main class="main-content">

                <div class="topbar">

                    <h1>Chi Tiết Danh Mục</h1>

                </div>

                <div class="card">

                    <h2 style="margin-bottom:25px;">

                        Thông Tin Danh Mục

                    </h2>

                    <table class="data-table">

                        <tbody>

                            <tr>

                                <th width="250">

                                    Mã Danh Mục

                                </th>

                                <td>

                                    ${category.categoryId}

                                </td>

                            </tr>

                            <tr>

                                <th>

                                    Tên Danh Mục

                                </th>

                                <td>

                                    ${category.categoryName}

                                </td>

                            </tr>

                            <tr>

                                <th>

                                    Mô Tả

                                </th>

                                <td>

                                    ${category.description}

                                </td>

                            </tr>

                        </tbody>

                    </table>

                    <div style="margin-top:25px;">

                        <a href="${pageContext.request.contextPath}/admin/categories/edit/${category.categoryId}"
                           class="btn btn-warning">

                            <i class="fa-solid fa-pen"></i>

                            Chỉnh Sửa

                        </a>

                        <a href="${pageContext.request.contextPath}/admin/categories"
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

