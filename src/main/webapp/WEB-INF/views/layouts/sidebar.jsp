<%-- 
    Document   : sidebar
    Created on : May 27, 2026, 11:42:27 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>

    .sidebar{
        width:250px;
        height:100vh;
        background:#ffffff;
        position:fixed;
        left:0;
        top:0;
        padding-top:120px;
        box-shadow:2px 0 10px rgba(0,0,0,0.08);
    }

    .sidebar ul{
        list-style:none;
    }

    .sidebar ul li{
        margin:10px 0;
    }

    .sidebar ul li a{
        display:block;
        padding:15px 25px;
        text-decoration:none;
        color:#444;
        font-weight:600;
        transition:0.3s;
        border-left:4px solid transparent;
    }

    .sidebar ul li a:hover{
        background:#fff1f1;
        color:#b14545;
        border-left:4px solid #c85c5c;
    }

</style>

<div class="sidebar">

    <ul>

        <li>
            <a href="/dashboard">
                Dashboard
            </a>
        </li>

        <li>
            <a href="/menu">
                Quản Lí Thực Đơn
            </a>
        </li>

        <li>
            <a href="/orders">
                Quản Lí Đơn Hàng
            </a>
        </li>

        <li>
            <a href="/tables">
                Quản Lí Bàn
            </a>
        </li>

        <li>
            <a href="/employees">
                Nhân Viên
            </a>
        </li>

    </ul>

</div>
