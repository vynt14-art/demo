<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<!DOCTYPE html>

<html>

    <head>

        
        <meta charset="UTF-8">

        <title>Chi Tiết Nguyên Liệu</title>

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
                        <a href="${pageContext.request.contextPath}/admin/inventory">

                            <i class="fa-solid fa-boxes-stacked"></i>

                            Kho Nguyên Liệu

                        </a>
                    </li>

                </ul>

            </aside>

            <!-- MAIN CONTENT -->

            <main class="main-content">

                <div class="topbar">

                    <h1>Chi Tiết Nguyên Liệu</h1>

                </div>

                <div class="card">

                    <h2 style="margin-bottom:25px;">

                        Thông Tin Nguyên Liệu

                    </h2>

                    <table class="data-table">

                        <tbody>

                            <tr>

                                <th width="250">

                                    Mã Nguyên Liệu

                                </th>

                                <td>

                                    ${inventory.inventoryId}

                                </td>

                            </tr>

                            <tr>

                                <th>

                                    Tên Nguyên Liệu

                                </th>

                                <td>

                                    ${inventory.ingredientName}

                                </td>

                            </tr>

                            <tr>

                                <th>

                                    Đơn Vị Tính

                                </th>

                                <td>

                                    ${inventory.unit}

                                </td>

                            </tr>

                            <tr>

                                <th>

                                    Số Lượng Hiện Có

                                </th>

                                <td>

                                    ${inventory.quantity}

                                </td>

                            </tr>

                            <tr>

                                <th>

                                    Số Lượng Tối Thiểu

                                </th>

                                <td>

                                    ${inventory.minimumQuantity}

                                </td>

                            </tr>

                            <tr>

                                <th>

                                    Tình Trạng Kho

                                </th>

                                <td>

                        <c:choose>

                            <c:when test="${inventory.quantity <= inventory.minimumQuantity}">

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

                        </tr>

                        <tr>

                            <th>

                                Cập Nhật Lần Cuối

                            </th>

                            <td>

                                ${inventory.lastUpdated}

                            </td>

                        </tr>

                        </tbody>

                    </table>

                    <div style="margin-top:25px;">

                        <a href="${pageContext.request.contextPath}/admin/inventory/edit/${inventory.inventoryId}"
                           class="btn btn-warning">

                            <i class="fa-solid fa-pen"></i>

                            Chỉnh Sửa

                        </a>

                        <a href="${pageContext.request.contextPath}/admin/inventory"
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

