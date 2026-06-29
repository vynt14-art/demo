<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Chi tiet don hang</title>
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

            <h1>Chi tiet don hang</h1>

            <h3>Ma don: ${order.orderId}</h3>
            <h3>Ban: ${order.tableId}</h3>
            <h3>Khach hang: ${order.customerName}</h3>
            <h3>Trang thai: ${order.status}</h3>
            <h3>Tong tien: ${order.totalAmount}</h3>

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

            <c:if test="${order.status ne 'PAID'}">
                <h3>Them mon cho ban</h3>

                <form action="${pageContext.request.contextPath}/staff/orders/add-item/${order.orderId}"
                      method="post">
                    <select name="menuItemId"
                            required>
                        <c:forEach items="${menuItems}"
                                   var="item">
                            <option value="${item.menuItemId}">
                                ${item.itemName} - ${item.price} VND
                            </option>
                        </c:forEach>
                    </select>

                    <input type="number"
                           name="quantity"
                           min="1"
                           value="1"
                           required>

                    <input type="text"
                           name="note"
                           placeholder="Ghi chu mon">

                    <button type="submit"
                            class="btn btn-success">
                        Them mon
                    </button>
                </form>
            </c:if>

        </div>
    </body>
</html>
