<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Chi tiet don hang</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/admin.css">
    </head>

    <body>
        <div class="main-content">

            <h1>Chi tiet don hang</h1>

            <table class="data-table">
                <tr>
                    <th>Ma don</th>
                    <td>${order.orderId}</td>
                </tr>
                <tr>
                    <th>Thoi gian tao</th>
                    <td>${order.orderTime}</td>
                </tr>
                <tr>
                    <th>Ban</th>
                    <td>${order.tableId}</td>
                </tr>
                <tr>
                    <th>Nhan vien</th>
                    <td>${order.employeeId}</td>
                </tr>
                <tr>
                    <th>Khach hang</th>
                    <td>${order.customerName}</td>
                </tr>
                <tr>
                    <th>Tong tien</th>
                    <td>${order.totalAmount}</td>
                </tr>
                <tr>
                    <th>Trang thai don</th>
                    <td>${order.status}</td>
                </tr>
                <tr>
                    <th>Phuong thuc thanh toan</th>
                    <td>${invoice.paymentMethod}</td>
                </tr>
                <tr>
                    <th>Thoi gian thanh toan</th>
                    <td>${invoice.paymentTime}</td>
                </tr>
            </table>

            <h3>Danh sach mon</h3>

            <table class="data-table">
                <thead>
                    <tr>
                        <th>Mon an</th>
                        <th>So luong</th>
                        <th>Don gia</th>
                        <th>Thanh tien</th>
                        <th>Ghi chu</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${details}"
                               var="detail">
                        <tr>
                            <td>
                                <c:choose>
                                    <c:when test="${not empty detail.menuItemName}">
                                        ${detail.menuItemName}
                                    </c:when>
                                    <c:otherwise>
                                        #${detail.menuItemId}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>${detail.quantity}</td>
                            <td>${detail.unitPrice}</td>
                            <td>${detail.subtotal}</td>
                            <td>${detail.note}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <br>

            <a href="${pageContext.request.contextPath}/admin/invoices"
               class="btn btn-primary">
                Quay lai lich su don
            </a>

        </div>
    </body>
</html>
