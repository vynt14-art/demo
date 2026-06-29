<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<!DOCTYPE html>

<html>

    <head>

        
        <meta charset="UTF-8">

        <title>Thêm Danh Mục</title>

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/admin.css">

        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        

    </head>

    <body>

        <div class="dashboard-container">

            
            <!-- SIDEBAR -->

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

                    <li>
                        <a href="${pageContext.request.contextPath}/admin/employees">
                            Nhân Viên
                        </a>
                    </li>

                    <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/categories">
                            Danh Mục
                        </a>
                    </li>

                </ul>

            </aside>

            <!-- MAIN -->

            <main class="main-content">

                <div class="topbar">

                    <h1>Thêm Danh Mục Mới</h1>

                </div>

                <div class="card">

                    <form action="${pageContext.request.contextPath}/admin/categories/save"
                          method="post">

                        <div style="margin-bottom:20px;">

                            <label>
                                Tên Danh Mục
                            </label>

                            <input type="text"
                                   name="categoryName"
                                   class="form-control"
                                   placeholder="Ví dụ: Món Chính"
                                   required>

                        </div>

                        <div style="margin-bottom:20px;">

                            <label>
                                Mô Tả
                            </label>

                            <textarea name="description"
                                      class="form-control"
                                      rows="5"
                                      placeholder="Nhập mô tả danh mục..."></textarea>

                        </div>

                        <button type="submit"
                                class="btn btn-primary">

                            <i class="fa-solid fa-floppy-disk"></i>

                            Lưu Danh Mục

                        </button>

                        <a href="${pageContext.request.contextPath}/admin/categories"
                           class="btn btn-danger">

                            <i class="fa-solid fa-xmark"></i>

                            Hủy

                        </a>

                    </form>

                </div>

            </main>
            

        </div>

    </body>

</html>

