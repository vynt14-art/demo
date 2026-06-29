<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Don cho nau</title>
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
                <a href="${pageContext.request.contextPath}/kitchen/cooking"
                   class="btn btn-primary">
                    Don dang nau
                </a>
            </div>

            <h1>Don cho nau</h1>

            <table class="data-table">
                <tr>
                    <th>Ma don</th>
                    <th>Ban</th>
                    <th>Thoi gian</th>
                    <th>Tong tien</th>
                    <th>Thao tac</th>
                </tr>

                <c:forEach items="${orders}"
                           var="order">
                    <tr>
                        <td>${order.orderId}</td>
                        <td>${order.tableId}</td>
                        <td>${order.orderTime}</td>
                        <td>${order.totalAmount}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/kitchen/detail/${order.orderId}"
                               class="btn btn-primary">
                                Chi tiet mon
                            </a>
                            |
                            <a href="${pageContext.request.contextPath}/kitchen/start/${order.orderId}"
                               class="btn btn-warning">
                                Nhan don
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>
