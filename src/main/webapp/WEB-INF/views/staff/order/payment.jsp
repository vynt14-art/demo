<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Thanh Toan</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/staff.css">
    </head>

    <body>
        <div class="main-content">

            <div class="page-actions">
                <a href="${pageContext.request.contextPath}/staff/orders"
                   class="btn btn-primary">
                    Tro ve danh sach don
                </a>
                <a href="${pageContext.request.contextPath}/staff/dashboard"
                   class="btn btn-primary">
                    Ve dashboard
                </a>
            </div>

            <h1>Thanh Toan Hoa Don</h1>

            <table class="data-table">
                <tr>
                    <th>Ma don</th>
                    <td>${order.orderId}</td>
                </tr>
                <tr>
                    <th>Ban</th>
                    <td>${order.tableId}</td>
                </tr>
                <tr>
                    <th>Khach hang</th>
                    <td>${order.customerName}</td>
                </tr>
                <tr>
                    <th>Tong tien</th>
                    <td>${order.totalAmount} VND</td>
                </tr>
                <tr>
                    <th>Trang thai</th>
                    <td>${order.status}</td>
                </tr>
            </table>

            <h3>Danh sach mon</h3>

            <table class="data-table">
                <thead>
                    <tr>
                        <th>Mon</th>
                        <th>SL</th>
                        <th>Don gia</th>
                        <th>Thanh tien</th>
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
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <form action="${pageContext.request.contextPath}/staff/orders/pay/${order.orderId}"
                  method="post"
                  class="payment-form">

                <label for="paymentMethod">Phuong thuc thanh toan</label>
                <select id="paymentMethod"
                        name="paymentMethod">
                    <option value="CASH">Tien mat</option>
                    <option value="QR">QR</option>
                </select>

                <div class="qr-box">
                    <p>Demo QR: ${order.totalAmount} VND</p>
                </div>

                <div class="print-question">
                    <p>Co in bill khong?</p>
                    <label>
                        <input type="radio"
                               name="printBill"
                               value="true"
                               checked>
                        Co, in bill
                    </label>
                    <label>
                        <input type="radio"
                               name="printBill"
                               value="false">
                        Khong
                    </label>
                </div>

                <button type="submit"
                        class="btn btn-success">
                    Xac nhan thanh toan
                </button>
            </form>

        </div>
    </body>
</html>
