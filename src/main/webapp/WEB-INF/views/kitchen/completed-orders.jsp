<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Don hoan thanh</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/kitchen.css">
    </head>

    <body>
        <div class="main-content">

            <h1>Don da hoan thanh</h1>

            <table class="data-table">
                <tr>
                    <th>Ma don</th>
                    <th>Ban</th>
                    <th>Thoi gian</th>
                    <th>Tong tien</th>
                    <th>Trang thai</th>
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
                            <span class="badge badge-ready">
                                Hoan thanh
                            </span>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/kitchen/detail/${order.orderId}"
                               class="btn btn-primary">
                                Chi tiet
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>
