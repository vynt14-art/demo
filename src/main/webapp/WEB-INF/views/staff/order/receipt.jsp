<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Bill thanh toan</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/staff.css">
    </head>

    <body>
        <div class="main-content receipt-page">

            <div class="page-actions no-print">
                <button type="button"
                        class="btn btn-success"
                        onclick="window.print()">
                    In bill
                </button>
                <a href="${pageContext.request.contextPath}/staff/orders"
                   class="btn btn-primary">
                    Tro ve danh sach don
                </a>
                <a href="${pageContext.request.contextPath}/staff/dashboard"
                   class="btn btn-primary">
                    Ve dashboard
                </a>
            </div>

            <section class="receipt">
                <div class="receipt-header">
                    <h1>NHA HANG</h1>
                    <p>Hoa don thanh toan</p>
                </div>

                <div class="receipt-info">
                    <p><strong>Ma don:</strong> ${order.orderId}</p>
                    <p><strong>Ma hoa don:</strong> ${invoice.invoiceId}</p>
                    <p><strong>Ban:</strong> ${order.tableId}</p>
                    <p><strong>Khach hang:</strong> ${order.customerName}</p>
                    <p><strong>Thoi gian:</strong> ${invoice.paymentTime}</p>
                    <p><strong>Thanh toan:</strong> ${invoice.paymentMethod}</p>
                </div>

                <table class="receipt-table">
                    <thead>
                        <tr>
                            <th>Mon</th>
                            <th>SL</th>
                            <th>Gia</th>
                            <th>Tien</th>
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

                <div class="receipt-total">
                    Tong cong: ${order.totalAmount} VND
                </div>

                <p class="receipt-thanks">
                    Cam on quy khach. Hen gap lai!
                </p>
            </section>

        </div>

        <script>
            window.addEventListener("load", function () {
                setTimeout(function () {
                    window.print();
                }, 300);
            });
        </script>
    </body>
</html>
