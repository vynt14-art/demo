<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>


<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="UTF-8">

        <title>Login - Hotel Restaurant</title>

        <link rel="stylesheet"
              href="<c:url value='/resources/css/login.css'/>">

        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    </head>

    <body>

        <div class="login-container">

            <div class="login-card">

                <div class="logo-section">

                    <img
                        src="${pageContext.request.contextPath}/resources/images/logo.png"
                        alt="Logo"
                        class="logo">

                    <h1>Hotel Restaurant</h1>

                    <p>
                        Restaurant Management System
                    </p>

                </div>

                <c:if test="${not empty error}">

                    <div class="error-message">

                        <i class="fa-solid fa-circle-exclamation"></i>

                        ${error}

                    </div>

                </c:if>

                <form action="${pageContext.request.contextPath}/login"
                      method="post">

                    <div class="input-group">

                        <label>

                            <i class="fa-solid fa-user"></i>

                            Username

                        </label>

                        <input type="text"
                               name="username"
                               placeholder="Enter username"
                               required>

                    </div>

                    <div class="input-group">

                        <label>

                            <i class="fa-solid fa-lock"></i>

                            Password

                        </label>

                        <input type="password"
                               id="passwordInput"
                               name="password"
                               placeholder="Enter password"
                               minlength="6"
                               required>

                        <button type="button"
                                class="btn-toggle-password"
                                onclick="togglePassword()">
                            <i class="fa-solid fa-eye"></i>
                            Xem mat khau
                        </button>

                    </div>

                    <button type="submit"
                            class="btn-login">

                        <i class="fa-solid fa-right-to-bracket"></i>

                        Login

                    </button>

                </form>

                <div class="footer-text">

                    © 2026 Hotel Restaurant Management

                </div>

            </div>

        </div>

        <script>
            function togglePassword() {
                const input = document.getElementById("passwordInput");
                input.type = input.type === "password" ? "text" : "password";
            }
        </script>

    </body>

</html>
