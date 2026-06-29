<%-- 
    Document   : access-denied
    Created on : May 27, 2026, 11:20:12 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">
        <title>Không Có Quyền Truy Cập</title>

        <style>

            *{
                margin:0;
                padding:0;
                box-sizing:border-box;
                font-family:'Segoe UI',sans-serif;
            }

            body{
                width:100%;
                height:100vh;
                background:#f8f5f0;
                display:flex;
                justify-content:center;
                align-items:center;
            }

            .denied-container{
                width:600px;
                background:white;
                border-radius:25px;
                padding:60px;
                text-align:center;
                box-shadow:0 10px 35px rgba(0,0,0,0.12);
            }

            .denied-container img{
                width:180px;
                margin-bottom:25px;
            }

            .denied-container h1{
                color:#b14545;
                font-size:42px;
                margin-bottom:15px;
            }

            .denied-container p{
                color:#666;
                font-size:18px;
                line-height:1.7;
                margin-bottom:35px;
            }

            .back-btn{
                display:inline-block;
                padding:14px 30px;
                background:#c85c5c;
                color:white;
                text-decoration:none;
                border-radius:12px;
                font-weight:700;
                transition:0.3s;
            }

            .back-btn:hover{
                background:#a94444;
            }

        </style>

    </head>

    <body>

        <div class="denied-container">

            <img src="https://cdn-icons-png.flaticon.com/512/1828/1828843.png">

            <h1>403</h1>

            <p>
                Bạn không có quyền truy cập vào trang này.
                Vui lòng quay lại trang phù hợp với vai trò của bạn.
            </p>

            <a href="login" class="back-btn">
                Quay Lại Đăng Nhập
            </a>

        </div>

    </body>
</html>
