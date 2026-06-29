<%-- 
    Document   : employee-report
    Created on : May 30, 2026, 11:55:42 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table class="data-table">

        <tr>
            <th>Nhân Viên</th>
            <th>Số Đơn Đã Tạo</th>
        </tr>

        <c:forEach items="${reports}" var="r">

            <tr>
                <td>${r.employeeName}</td>
                <td>${r.totalOrders}</td>
            </tr>

        </c:forEach>

    </table>
</html>
