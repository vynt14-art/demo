<%-- 
    Document   : employee-add
    Created on : May 30, 2026, 10:11:31 AM
    Author     : ACER
--%>

<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<!DOCTYPE html>

<html>

    <head>

        
        <meta charset="UTF-8">

        <title>Thêm Nhân Viên</title>

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/admin.css">

        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        

    </head>

    <body>

        <div class="dashboard-container">

            
            <aside class="sidebar">

                <div class="logo">

                    <h2>🍽 Restaurant</h2>

                </div>

                <ul>

                    <li>
                        <a href="${pageContext.request.contextPath}/admin/dashboard">
                            Dashboard
                        </a>
                    </li>

                    <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/employees">
                            Nhân Viên
                        </a>
                    </li>

                </ul>

            </aside>

            <main class="main-content">

                <div class="topbar">

                    <h1>Thêm Nhân Viên</h1>

                </div>

                <form action="${pageContext.request.contextPath}/admin/employees/save"
                      method="post">

                    <div class="card">

                        <h2 style="margin-bottom:20px;">
                            Thông Tin Tài Khoản
                        </h2>

                        <div style="margin-bottom:15px;">

                            <label>Tên đăng nhập</label>

                            <input type="text"
                                   name="username"
                                   class="form-control"
                                   required>

                        </div>

                        <div style="margin-bottom:15px;">

                            <label>Mật khẩu</label>

                            <input type="password"
                                   name="password"
                                   class="form-control"
                                   minlength="6"
                                   required>

                            <small>Mat khau toi thieu 6 ky tu</small>

                        </div>

                        <div style="margin-bottom:20px;">

                            <label>Chức vụ</label>

                            <select name="role"
                                    class="form-control">

                                <option value="STAFF">
                                    Nhân viên phục vụ
                                </option>

                                <option value="KITCHEN">
                                    Nhân viên bếp
                                </option>

                                <option value="ADMIN">
                                    Quản trị viên
                                </option>

                            </select>

                        </div>

                    </div>

                    <br>

                    <div class="card">

                        <h2 style="margin-bottom:20px;">
                            Thông Tin Nhân Viên
                        </h2>

                        <div style="margin-bottom:15px;">

                            <label>Anh nhan vien</label>

                            <div class="image-path-row">
                                <span class="image-plus">+</span>
                                <input type="text"
                                       name="imagePath"
                                       class="form-control"
                                       placeholder="/resources/images/employees/ten-anh.jpg">
                            </div>

                            <small>Copy anh vao resources/images/employees roi nhap link tai day</small>

                        </div>

                        <div style="margin-bottom:15px;">

                            <label>Ho va ten</label>

                            <input type="text"
                                   name="fullName"
                                   class="form-control"
                                   required>

                        </div>

                        <div style="margin-bottom:15px;">

                            <label>Số điện thoại</label>

                            <input type="text"
                                   name="phone"
                                   class="form-control">

                        </div>

                        <div style="margin-bottom:15px;">

                            <label>Email</label>

                            <input type="email"
                                   name="email"
                                   class="form-control">

                        </div>

                        <div style="margin-bottom:15px;">

                            <label>Địa chỉ</label>

                            <input type="text"
                                   name="address"
                                   class="form-control">

                        </div>

                        <div style="margin-bottom:15px;">

                            <label>Ngày vào làm</label>

                            <input type="date"
                                   name="hireDate"
                                   class="form-control">

                        </div>

                        <div style="margin-bottom:20px;">

                            <label>Lương</label>

                            <input type="number"
                                   name="salary"
                                   class="form-control"
                                   min="0">

                        </div>

                        <button type="submit"
                                class="btn btn-primary">

                            <i class="fa-solid fa-floppy-disk"></i>

                            Lưu Nhân Viên

                        </button>

                        <a href="${pageContext.request.contextPath}/admin/employees"
                           class="btn btn-danger">

                            Hủy

                        </a>

                    </div>

                </form>

            </main>
            

        </div>

    </body>

</html>
