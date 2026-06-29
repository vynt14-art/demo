<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="UTF-8">

        <title>Thêm Bàn Ăn</title>

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/admin.css">

    </head>

    <body>

        <div class="main-content">

            <h1>Thêm Bàn Ăn</h1>

            <form action="${pageContext.request.contextPath}/admin/tables/save"
                  method="post">

                <label>Tên Bàn</label>

                <input type="text"
                       name="tableName"
                       class="form-control"
                       required>

                <br>

                <label>Sức Chứa</label>

                <input type="number"
                       name="capacity"
                       class="form-control"
                       min="1"
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

                    Lưu

                </button>

                <a href="${pageContext.request.contextPath}/admin/tables"
                   class="btn btn-danger">

                    Hủy

                </a>

            </form>

        </div>

    </body>

</html>

