<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Doi ngu nhan vien</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/admin.css">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    </head>

    <body>
        <div class="dashboard-container">
            <aside class="sidebar">
                <div class="logo">
                    <h2>Restaurant</h2>
                </div>
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/dashboard">
                            <i class="fa-solid fa-chart-line"></i>
                            Dashboard
                        </a>
                    </li>
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/employees">
                            <i class="fa-solid fa-users"></i>
                            Nhan Vien
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/menu">
                            <i class="fa-solid fa-utensils"></i>
                            Thuc Don
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/tables">
                            <i class="fa-solid fa-table"></i>
                            Ban An
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/logout">
                            <i class="fa-solid fa-right-from-bracket"></i>
                            Dang Xuat
                        </a>
                    </li>
                </ul>
            </aside>

            <main class="main-content admin-dark-page">
                <div class="page-heading">
                    <div>
                        <h1>Doi Ngu Nhan Vien</h1>
                        <p>Danh sach nhan vien duoc phan loai theo bo phan.</p>
                    </div>
                    <a href="${pageContext.request.contextPath}/admin/employees/add"
                       class="round-action"
                       title="Them nhan vien">
                        <i class="fa-solid fa-plus"></i>
                    </a>
                </div>

                <form action="${pageContext.request.contextPath}/admin/employees/search"
                      method="get"
                      class="compact-filter">
                    <input type="text"
                           name="keyword"
                           placeholder="Tim nhan vien..."
                           value="${keyword}">
                    <button type="submit">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
                </form>

                <c:set var="roles" value="ADMIN,KITCHEN,STAFF"/>
                <c:forEach items="${roles.split(',')}"
                           var="roleName">
                    <section class="employee-section">
                        <h2>
                            <c:choose>
                                <c:when test="${roleName eq 'ADMIN'}">Quan ly</c:when>
                                <c:when test="${roleName eq 'KITCHEN'}">Bep</c:when>
                                <c:otherwise>Phuc vu</c:otherwise>
                            </c:choose>
                        </h2>

                        <div class="employee-card-grid">
                            <c:forEach items="${employees}"
                                       var="employee">
                                <c:if test="${employee.role eq roleName}">
                                    <article class="employee-card">
                                        <div class="employee-card-top">
                                            <div class="employee-avatar">
                                                <c:choose>
                                                    <c:when test="${not empty employee.imagePath}">
                                                        <img src="${pageContext.request.contextPath}${employee.imagePath}"
                                                             alt="${employee.fullName}">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <i class="fa-solid fa-user"></i>
                                                    </c:otherwise>
                                                </c:choose>
                                                <span class="online-dot"></span>
                                            </div>
                                            <div>
                                                <h3>${employee.fullName}</h3>
                                                <span class="role-pill">${employee.role}</span>
                                            </div>
                                        </div>

                                        <div class="employee-meta">
                                            <span>Trang thai</span>
                                            <strong>
                                                <c:choose>
                                                    <c:when test="${employee.accountStatus}">Dang lam</c:when>
                                                    <c:otherwise>Nghi</c:otherwise>
                                                </c:choose>
                                            </strong>
                                            <span>Ca lam viec</span>
                                            <strong>
                                                <c:choose>
                                                    <c:when test="${employee.role eq 'KITCHEN'}">Sang (06:00 - 14:00)</c:when>
                                                    <c:when test="${employee.role eq 'STAFF'}">Chieu (14:00 - 22:00)</c:when>
                                                    <c:otherwise>Toan thoi gian</c:otherwise>
                                                </c:choose>
                                            </strong>
                                        </div>

                                        <div class="card-actions">
                                            <a href="${pageContext.request.contextPath}/admin/employees/detail/${employee.employeeId}">
                                                Chi tiet
                                            </a>
                                            <a href="${pageContext.request.contextPath}/admin/employees/edit/${employee.employeeId}">
                                                Sua
                                            </a>
                                            <a href="${pageContext.request.contextPath}/admin/employees/delete/${employee.employeeId}"
                                               onclick="return confirm('Xoa nhan vien nay?')">
                                                Xoa
                                            </a>
                                        </div>
                                    </article>
                                </c:if>
                            </c:forEach>
                        </div>
                    </section>
                </c:forEach>
            </main>
        </div>
    </body>
</html>
