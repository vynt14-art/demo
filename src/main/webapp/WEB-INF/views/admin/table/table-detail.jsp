<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="UTF-8">

        <title>Chi Tiết Bàn Ăn</title>

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/admin.css">

    </head>

    <body>

        <div class="main-content">

            <h1>Chi Tiết Bàn Ăn</h1>

            <table class="data-table">

                <tr>

                    <th>Mã Bàn</th>

                    <td>${table.tableId}</td>

                </tr>

                <tr>

                    <th>Tên Bàn</th>

                    <td>${table.tableName}</td>

                </tr>

                <tr>

                    <th>Sức Chứa</th>

                    <td>${table.capacity}</td>

                </tr>

                <tr>

                    <th>Trạng Thái</th>

                    <td>${table.status}</td>

                </tr>

            </table>

            <br>

            <a href="${pageContext.request.contextPath}/admin/tables/edit/${table.tableId}"
               class="btn btn-warning">

                Chỉnh Sửa

            </a>

            <a href="${pageContext.request.contextPath}/admin/tables"
               class="btn btn-primary">

                Quay Lại

            </a>

        </div>

    </body>

</html>

