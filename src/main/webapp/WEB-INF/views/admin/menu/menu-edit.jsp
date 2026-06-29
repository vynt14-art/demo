<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

    <head>

        
        <meta charset="UTF-8">

        <title>Cập Nhật Món Ăn</title>

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

                    <h1>Cập Nhật Món Ăn</h1>

                </div>

                <div class="card">

                    <form action="${pageContext.request.contextPath}/admin/menu/update"
                          method="post">

                        <input type="hidden"
                               name="menuItemId"
                               value="${menuItem.menuItemId}">

                        <input type="hidden"
                               name="mediaId"
                               value="${menuItem.mediaId}">

                        <div style="margin-bottom:20px;">

                            <label>Danh Mục</label>

                            <select name="categoryId"
                                    class="form-control"
                                    required>

                                <c:forEach items="${categories}"
                                           var="category">

                                    <option value="${category.categoryId}"
                                            ${category.categoryId == menuItem.categoryId ? 'selected' : ''}>

                                        ${category.categoryName}

                                    </option>

                                </c:forEach>

                            </select>

                        </div>

                        <div style="margin-bottom:20px;">

                            <label>Tên Món Ăn</label>

                            <input type="text"
                                   name="itemName"
                                   class="form-control"
                                   value="${menuItem.itemName}"
                                   required>

                        </div>

                        <div style="margin-bottom:20px;">

                            <label>Mô Tả</label>

                            <textarea name="description"
                                      rows="5"
                                      class="form-control">${menuItem.description}</textarea>

                        </div>

                        <div style="margin-bottom:20px;">

                            <label>Giá Bán (VNĐ)</label>

                            <input type="number"
                                   name="price"
                                   class="form-control"
                                   value="${menuItem.price}"
                                   min="0"
                                   required>

                        </div>

                        <div style="margin-bottom:20px;">

                            <label>Anh mon an</label>

                            <div class="image-path-row">
                                <span class="image-plus">+</span>
                                <input type="text"
                                       name="imagePath"
                                       class="form-control"
                                       value="${menuItem.imagePath}"
                                       placeholder="/resources/images/menu/ten-mon.jpg">
                            </div>

                        </div>

                        <div style="margin-bottom:20px;">

                            <label>Trạng Thái</label>

                            <select name="status"
                                    class="form-control">

                                <option value="AVAILABLE"
                                        ${menuItem.status == 'AVAILABLE' ? 'selected' : ''}>

                                    Đang Bán

                                </option>

                                <option value="OUT_OF_STOCK"
                                        ${menuItem.status == 'OUT_OF_STOCK' ? 'selected' : ''}>

                                    Hết Món

                                </option>

                            </select>

                        </div>

                        <button type="submit"
                                class="btn btn-primary">

                            <i class="fa-solid fa-floppy-disk"></i>

                            Cập Nhật

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
