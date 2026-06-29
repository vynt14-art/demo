<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="UTF-8">

        <title>Cập Nhật Bàn Ăn</title>

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/admin.css">

    </head>

    <body>

        <div class="main-content">

            <h1>Cập Nhật Bàn Ăn</h1>

            <form action="${pageContext.request.contextPath}/admin/tables/update"
                  method="post">

                <input type="hidden"
                       name="tableId"
                       value="${table.tableId}">

                <label>Tên Bàn</label>

                <input type="text"
                       name="tableName"
                       value="${table.tableName}"
                       class="form-control"
                       required>

                <br>

                <label>Sức Chứa</label>

                <input type="number"
                       name="capacity"
                       value="${table.capacity}"
                       class="form-control"
                       required>

                <br>

                <label>Trạng Thái</label>

                <select name="status"
                        class="form-control">

                    <option value="AVAILABLE">

                        Trống

                    </option>

                    <option value="OCCUPIED">

                        Đang Sử Dụng

                    </option>

                    <option value="RESERVED">

                        Đã Đặt

                    </option>

                </select>

                <br>

                <button type="submit"
                        class="btn btn-primary">

                    Cập Nhật

                </button>

                <a href="${pageContext.request.contextPath}/admin/tables"
                   class="btn btn-danger">

                    Hủy

                </a>

            </form>

        </div>

    </body>

</html>

