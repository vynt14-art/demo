<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Quan ly ban an</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/admin.css">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    </head>

    <body>
        <div class="main-content admin-dark-page">
            <div class="page-heading">
                <div>
                    <h1>Quan Ly Don Hang</h1>
                    <p>Giam sat trang thai ban va xu ly hoa don thoi gian thuc.</p>
                </div>
                <div class="table-toolbar">
                    <form action="${pageContext.request.contextPath}/admin/tables/search"
                          method="get"
                          class="compact-filter">
                        <input type="text"
                               name="keyword"
                               placeholder="Tim ban...">
                        <button type="submit">
                            <i class="fa-solid fa-filter"></i>
                            Loc Trang Thai
                        </button>
                    </form>
                    <a href="${pageContext.request.contextPath}/admin/tables/add"
                       class="round-action"
                       title="Them ban">
                        <i class="fa-solid fa-plus"></i>
                    </a>
                </div>
            </div>

            <div class="table-card-grid">
                <c:forEach items="${tables}"
                           var="table">
                    <article class="table-card ${table.status eq 'AVAILABLE' ? 'empty' : ''}">
                        <div class="table-card-head">
                            <div>
                                <h2>${table.tableName}</h2>
                                <span class="table-status-dot">
                                    <c:choose>
                                        <c:when test="${table.status eq 'AVAILABLE'}">Ban trong</c:when>
                                        <c:when test="${table.status eq 'OCCUPIED'}">Dang an</c:when>
                                        <c:otherwise>Cho thanh toan</c:otherwise>
                                    </c:choose>
                                </span>
                            </div>
                            <div class="table-icon">
                                <c:choose>
                                    <c:when test="${table.status eq 'AVAILABLE'}">
                                        <i class="fa-solid fa-chair"></i>
                                    </c:when>
                                    <c:when test="${table.status eq 'OCCUPIED'}">
                                        <i class="fa-solid fa-utensils"></i>
                                    </c:when>
                                    <c:otherwise>
                                        <i class="fa-solid fa-money-bill"></i>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>

                        <c:choose>
                            <c:when test="${table.status eq 'AVAILABLE'}">
                                <div class="empty-table-box">
                                    <i class="fa-solid fa-chair"></i>
                                    <h3>Ban Trong</h3>
                                    <p>San sang de phuc vu khach moi</p>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="table-bill-box">
                                    <span>Tong tien</span>
                                    <strong>${table.currentTotalAmount}</strong>
                                    <span>So luong mon</span>
                                    <strong>${table.currentItemCount} mon</strong>
                                    <span>Thoi gian</span>
                                    <strong>${table.currentOrderTime}</strong>
                                </div>
                            </c:otherwise>
                        </c:choose>

                        <div class="card-actions">
                            <a href="${pageContext.request.contextPath}/admin/tables/detail/${table.tableId}">
                                Chi tiet
                            </a>
                            <a href="${pageContext.request.contextPath}/admin/tables/edit/${table.tableId}">
                                Sua
                            </a>
                            <a href="${pageContext.request.contextPath}/admin/tables/delete/${table.tableId}"
                               onclick="return confirm('Xoa ban nay?')">
                                Xoa
                            </a>
                        </div>
                    </article>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
