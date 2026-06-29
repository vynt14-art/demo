<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Chi tiet mon can nau</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/kitchen.css">
    </head>

    <body>
        <div class="main-content">

            <div class="page-actions">
                <a href="${pageContext.request.contextPath}/kitchen/dashboard"
                   class="btn btn-primary">
                    Ve dashboard
                </a>
                <a href="${pageContext.request.contextPath}/kitchen/pending"
                   class="btn btn-primary">
                    Don cho nau
                </a>
                <a href="${pageContext.request.contextPath}/kitchen/cooking"
                   class="btn btn-primary">
                    Don dang nau
                </a>
            </div>

            <h1>Chi tiet mon can nau</h1>

            <h3>Ma don: ${order.orderId}</h3>
            <h3>Ban: ${order.tableId}</h3>
            <h3>Thoi gian: ${order.orderTime}</h3>
            <h3>Trang thai: ${order.status}</h3>

            <table class="data-table">
                <thead>
                    <tr>
                        <th>Mon an</th>
                        <th>So luong</th>
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
                            <td>${detail.note}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <c:choose>
                <c:when test="${order.status eq 'PENDING'}">
                    <a href="${pageContext.request.contextPath}/kitchen/start/${order.orderId}"
                       class="btn btn-warning">
                        Bat dau nau
                    </a>
                </c:when>
                <c:when test="${order.status eq 'COOKING'}">
                    <a href="${pageContext.request.contextPath}/kitchen/complete/${order.orderId}"
                       class="btn btn-success">
                        Hoan thanh mon
                    </a>
                </c:when>
            </c:choose>

        </div>
    </body>
</html>
