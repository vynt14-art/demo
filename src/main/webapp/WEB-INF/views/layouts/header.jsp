<%-- 
    Document   : header
    Created on : May 27, 2026, 11:42:02 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    *{
        margin:0;
        padding:0;
        box-sizing:border-box;
        font-family:'Segoe UI',sans-serif;
    }

    body{
        background:#f8f5f0;
    }

    .main-header{
        width:100%;
        background:#ffffff;
        padding:18px 40px;
        display:flex;
        justify-content:space-between;
        align-items:center;
        box-shadow:0 2px 10px rgba(0,0,0,0.08);
        border-bottom:3px solid #d96b6b;
    }

    .logo{
        display:flex;
        align-items:center;
        gap:12px;
    }

    .logo img{
        width:55px;
        height:55px;
        border-radius:50%;
        object-fit:cover;
    }

    .logo h2{
        color:#b14545;
        font-size:28px;
        font-weight:700;
    }

    .header-right{
        display:flex;
        align-items:center;
        gap:20px;
    }

    .header-user{
        display:flex;
        align-items:center;
        gap:10px;
    }

    .header-user img{
        width:45px;
        height:45px;
        border-radius:50%;
        object-fit:cover;
        border:2px solid #d96b6b;
    }

    .header-user span{
        color:#444;
        font-weight:600;
    }
</style>

<header class="main-header">

    <div class="logo">
        <img src="https://cdn-icons-png.flaticon.com/512/3075/3075977.png">
        <h2>Hotel Restaurant</h2>
    </div>

    <div class="header-right">

        <div class="header-user">
            <img src="https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg">
            <span>${sessionScope.fullName}</span>
        </div>

    </div>

</header>
