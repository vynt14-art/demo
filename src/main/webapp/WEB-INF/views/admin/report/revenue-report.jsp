<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="UTF-8">

        <title>Báo Cáo Doanh Thu</title>

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/admin.css">

        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    </head>

    <body>

        <div class="dashboard-container">


            <!-- Sidebar -->

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
                        <a href="${pageContext.request.contextPath}/admin/reports/revenue">
                            Báo Cáo
                        </a>

                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/reports/export-excel"
                           class="btn btn-success">

                            <i class="fa-solid fa-file-excel"></i>

                            Xuất Excel

                        </a>
                    </li>

                </ul>

            </aside>

            <!-- Main -->

            <main class="main-content">

                <div class="topbar">

                    <h1>Báo Cáo Doanh Thu</h1>

                </div>

                <div class="card">

                    <h3>

                        <i class="fa-solid fa-chart-line"></i>

                        Thống Kê Doanh Thu Nhà Hàng

                    </h3>

                    <br>

                    <table class="data-table">

                        <thead>

                            <tr>

                                <th>Ngày</th>

                                <th>Doanh Thu (VNĐ)</th>

                            </tr>

                        </thead>

                        <tbody>

                            <c:set var="tongDoanhThu"
                                   value="0"/>

                            <c:forEach items="${reports}"
                                       var="r">

                                <tr>

                                    <td>

                                        ${r.reportDate}

                                    </td>

                                    <td>

                                        ${r.revenue}

                                    </td>

                                </tr>

                            </c:forEach>

                        </tbody>

                    </table>

                </div>

            </main>


        </div>

    </body>

</html>
