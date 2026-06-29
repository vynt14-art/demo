<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<!DOCTYPE html>

<html>

    <head>

        
        <meta charset="UTF-8">

        <title>Thêm Nguyên Liệu</title>

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

                    <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/inventory">
                            Kho Nguyên Liệu
                        </a>
                    </li>

                </ul>

            </aside>

            <!-- MAIN -->

            <main class="main-content">

                <div class="topbar">

                    <h1>Thêm Nguyên Liệu</h1>

                </div>

                <div class="card">

                    <form action="${pageContext.request.contextPath}/admin/inventory/save"
                          method="post">

                        <div style="margin-bottom:20px;">

                            <label>Tên Nguyên Liệu</label>

                            <input type="text"
                                   name="ingredientName"
                                   class="form-control"
                                   required>

                        </div>

                        <div style="margin-bottom:20px;">

                            <label>Đơn Vị Tính</label>

                            <select name="unit"
                                    class="form-control"
                                    required>

                                <option value="">-- Chọn Đơn Vị --</option>

                                <option value="Kg">Kg</option>

                                <option value="Gram">Gram</option>

                                <option value="Lít">Lít</option>

                                <option value="ml">ml</option>

                                <option value="Chai">Chai</option>

                                <option value="Lon">Lon</option>

                                <option value="Gói">Gói</option>

                                <option value="Cái">Cái</option>

                            </select>

                        </div>

                        <div style="margin-bottom:20px;">

                            <label>Số Lượng Hiện Có</label>

                            <input type="number"
                                   step="0.01"
                                   min="0"
                                   name="quantity"
                                   class="form-control"
                                   required>

                        </div>

                        <div style="margin-bottom:20px;">

                            <label>Số Lượng Tối Thiểu</label>

                            <input type="number"
                                   step="0.01"
                                   min="0"
                                   name="minimumQuantity"
                                   class="form-control"
                                   required>

                        </div>

                        <button type="submit"
                                class="btn btn-primary">

                            <i class="fa-solid fa-floppy-disk"></i>

                            Lưu Nguyên Liệu

                        </button>

                        <a href="${pageContext.request.contextPath}/admin/inventory"
                           class="btn btn-danger">

                            Hủy

                        </a>

                    </form>

                </div>

            </main>
            

        </div>

    </body>

</html>

