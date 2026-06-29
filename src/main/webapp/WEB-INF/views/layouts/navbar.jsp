<%-- 
    Document   : navbar
    Created on : May 27, 2026, 11:42:15 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>

    .navbar{
        width:100%;
        background:#c85c5c;
        padding:14px 40px;
        display:flex;
        align-items:center;
        justify-content:space-between;
    }

    .navbar ul{
        list-style:none;
        display:flex;
        gap:25px;
    }

    .navbar ul li a{
        text-decoration:none;
        color:white;
        font-size:16px;
        font-weight:600;
        transition:0.3s;
    }

    .navbar ul li a:hover{
        color:#ffe6e6;
    }

    .logout-btn{
        background:white;
        color:#c85c5c;
        padding:10px 18px;
        border-radius:8px;
        text-decoration:none;
        font-weight:700;
        transition:0.3s;
    }

    .logout-btn:hover{
        background:#ffe6e6;
    }

</style>

<nav class="navbar">

    <ul>
        <li><a href="/home">Trang Chủ</a></li>
        <li><a href="/menu">Thực Đơn</a></li>
        <li><a href="/orders">Đơn Hàng</a></li>
        <li><a href="/tables">Bàn</a></li>
        <li><a href="/reports">Thống Kê</a></li>
    </ul>

    <a href="/logout" class="logout-btn">
        Đăng Xuất
    </a>

</nav>
