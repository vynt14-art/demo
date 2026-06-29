<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

    <head>

        
        <meta charset="UTF-8">

        <title>Thêm Món Ăn</title>

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

                    <li>
                        <a href="${pageContext.request.contextPath}/admin/categories">
                            Danh Mục
                        </a>
                    </li>

                    <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/menu">
                            Thực Đơn
                        </a>
                    </li>

                </ul>

            </aside>

            <!-- MAIN -->

            <main class="main-content">

                <div class="topbar">

                    <h1>Thêm Món Ăn</h1>

                </div>

                <div class="card">

                    <form action="${pageContext.request.contextPath}/admin/menu/save"
                          method="post">

                        <!-- DANH MỤC -->

                        <div style="margin-bottom:20px;">

                            <label>Danh Mục</label>

                            <select name="categoryId"
                                    class="form-control"
                                    required>

                                <option value="">
                                    -- Chọn Danh Mục --
                                </option>

                                <c:forEach items="${categories}"
                                           var="category">

                                    <option value="${category.categoryId}">

                                        ${category.categoryName}

                                    </option>

                                </c:forEach>

                            </select>

                        </div>

                        <!-- TÊN MÓN -->

                        <div style="margin-bottom:20px;">

                            <label>Tên Món Ăn</label>

                            <input type="text"
                                   name="itemName"
                                   class="form-control"
                                   required>

                        </div>

                        <!-- MÔ TẢ -->

                        <div style="margin-bottom:20px;">

                            <label>Mô Tả</label>

                            <textarea name="description"
                                      rows="5"
                                      class="form-control"></textarea>

                        </div>

                        <!-- GIÁ -->

                        <div style="margin-bottom:20px;">

                            <label>Giá Bán (VNĐ)</label>

                            <input type="number"
                                   name="price"
                                   class="form-control"
                                   min="0"
                                   required>

                        </div>

                        <!-- ẢNH -->

                        <div style="margin-bottom:20px;">

                            <label>Anh mon an</label>

                            <div class="image-path-row">
                                <span class="image-plus">+</span>
                                <input type="text"
                                       name="imagePath"
                                       class="form-control"
                                       placeholder="/resources/images/menu/ten-mon.jpg">
                            </div>

                            <small>

                                Copy anh vao resources/images/menu roi nhap link tai day

                            </small>

                        </div>

                        <!-- TRẠNG THÁI -->

                        <div style="margin-bottom:20px;">

                            <label>Trạng Thái</label>

                            <select name="status"
                                    class="form-control">

                                <option value="AVAILABLE">

                                    Đang Bán

                                </option>

                                <option value="OUT_OF_STOCK">

                                    Hết Món

                                </option>

                            </select>

                        </div>

                        <button type="submit"
                                class="btn btn-primary">

                            <i class="fa-solid fa-floppy-disk"></i>

                            Lưu Món Ăn

                        </button>

                        <a href="${pageContext.request.contextPath}/admin/menu"
                           class="btn btn-danger">

                            Hủy

                        </a>

                    </form>

                </div>

            </main>
            

        </div>

    </body>

</html>
