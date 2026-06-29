<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Lich su don hang</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/admin.css">
    </head>

    <body>
        <div class="main-content">

            <h1>Lich su don hang</h1>

            <form action="${pageContext.request.contextPath}/admin/invoices"
                  method="get">
                <label>Tu ngay</label>
                <input type="date"
                       name="fromDate"
                       value="${fromDate}">

                <label>Den ngay</label>
                <input type="date"
                       name="toDate"
                       value="${toDate}">

                <button type="submit"
                        class="btn btn-primary">
                    Tim
                </button>

                <a class="btn btn-success"
                   href="${pageContext.request.contextPath}/admin/invoices/export-excel?fromDate=${fromDate}&toDate=${toDate}">
                    Xuat Excel
                </a>
            </form>

            <br>

            <table class="data-table">
                <thead>
                    <tr>
                        <th>Ma don</th>
                        <th>Thoi gian tao</th>
                        <th>Nhan vien</th>
                        <th>Ban</th>
                        <th>Khach hang</th>
                        <th>Tong tien</th>
                        <th>Phuong thuc thanh toan</th>
                        <th>Thoi gian thanh toan</th>
                        <th>Trang thai</th>
                        <th>Thao tac</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${orders}"
                               var="order">
                        <tr>
                            <td>${order.orderId}</td>
                            <td>${order.orderTime}</td>
                            <td>${order.employeeName}</td>
                            <td>${order.tableName}</td>
                            <td>${order.customerName}</td>
                            <td>${order.totalAmount}</td>
                            <td>${order.paymentMethod}</td>
                            <td>${order.paymentTime}</td>
                            <td>${order.status}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/invoices/detail/${order.orderId}">
                                    Chi tiet
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
    </body>
</html>
