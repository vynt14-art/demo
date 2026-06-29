<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<!DOCTYPE html>

<html>

    <head>

        
        <meta charset="UTF-8">

        <title>Cập Nhật Danh Mục</title>

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

            <!-- MAIN CONTENT -->

            <main class="main-content">

                <div class="topbar">

                    <h1>Cập Nhật Danh Mục</h1>

                </div>

                <div class="card">

                    <form action="${pageContext.request.contextPath}/admin/categories/update"
                          method="post">

                        <input type="hidden"
                               name="categoryId"
                               value="${category.categoryId}">

                        <div style="margin-bottom:20px;">

                            <label>

                                Tên Danh Mục

                            </label>

                            <input type="text"
                                   name="categoryName"
                                   class="form-control"
                                   value="${category.categoryName}"
                                   required>

                        </div>

                        <div style="margin-bottom:20px;">

                            <label>

                                Mô Tả

                            </label>

                            <textarea name="description"
                                      class="form-control"
                                      rows="5">${category.description}</textarea>

                        </div>

                        <button type="submit"
                                class="btn btn-primary">

                            <i class="fa-solid fa-floppy-disk"></i>

                            Cập Nhật

                        </button>

                        <a href="${pageContext.request.contextPath}/admin/categories"
                           class="btn btn-danger">

                            <i class="fa-solid fa-arrow-left"></i>

                            Quay Lại

                        </a>

                    </form>

                </div>

            </main>
            

        </div>

    </body>

</html>

