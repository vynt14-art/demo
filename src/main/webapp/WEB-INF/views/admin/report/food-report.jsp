<%-- 
    Document   : food-report
    Created on : May 30, 2026, 12:02:18 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table class="data-table">

        <tr>
            <th>Món Ăn</th>
            <th>Số Lượng Bán</th>
        </tr>

        <c:forEach items="${reports}" var="r">

            <tr>
                <td>${r.foodName}</td>
                <td>${r.quantitySold}</td>
            </tr>

        </c:forEach>

    </table>
</html>
