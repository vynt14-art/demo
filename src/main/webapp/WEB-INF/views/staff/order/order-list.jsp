<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
    <head>

        <meta charset="UTF-8">

        <title>Danh Sách Đơn Hàng</title>

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/staff.css">

    </head>

    <body>

        <div class="main-content">

            <div class="page-actions">
                <a href="${pageContext.request.contextPath}/staff/dashboard"
                   class="btn btn-primary">
                    Ve dashboard
                </a>
            </div>

            <h1>Danh Sách Đơn Hàng</h1>

            <a href="${pageContext.request.contextPath}/staff/orders/add">

                Tạo Đơn Mới

            </a>

            <table class="data-table">

                <thead>

                    <tr>

                        <th>Mã Đơn</th>

                        <th>Bàn</th>

                        <th>Nhân Viên</th>

                        <th>Tổng Tiền</th>

                        <th>Trạng Thái</th>

                        <th>Thao Tác</th>

                    </tr>

                </thead>

                <tbody>

                    <c:forEach items="${orders}"
                               var="order">

                        <tr>

                            <td>${order.orderId}</td>

                            <td>${order.tableId}</td>

                            <td>${order.employeeId}</td>

                            <td>${order.totalAmount}</td>

                            <td>${order.status}</td>

                            <td>

                                <a href="${pageContext.request.contextPath}/staff/orders/detail/${order.orderId}">
                                    Chi Tiết
                                </a>

                                |

                                <a href="${pageContext.request.contextPath}/staff/orders/payment/${order.orderId}">
                                    Thanh Toán
                                </a>

                            </td>

                        </tr>

                    </c:forEach>

                </tbody>

            </table>

        </div>

    </body>
</html>
