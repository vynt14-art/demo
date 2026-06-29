<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"
           uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>POS - Tao don hang</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/staff.css">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

        <style>
            .pos-container {
                display: flex;
                gap: 20px;
            }

            .menu-panel {
                width: 60%;
                background: #fff;
                border-radius: 8px;
                padding: 20px;
                box-shadow: 0 2px 10px rgba(0,0,0,.08);
            }

            .cart-panel {
                width: 40%;
                background: #fff;
                border-radius: 8px;
                padding: 20px;
                box-shadow: 0 2px 10px rgba(0,0,0,.08);
            }

            .menu-grid {
                display: grid;
                grid-template-columns: repeat(2, minmax(0, 1fr));
                gap: 15px;
            }

            .menu-card {
                border: 1px solid #ddd;
                border-radius: 8px;
                padding: 15px;
                background: #fafafa;
            }

            .menu-card h4 {
                margin: 0 0 10px;
            }

            .menu-image {
                width: 100%;
                aspect-ratio: 4 / 3;
                object-fit: cover;
                border-radius: 8px;
                background: #eee;
                margin-bottom: 10px;
            }

            .menu-card p {
                margin: 10px 0;
                color: #d85c5c;
                font-weight: bold;
            }

            .btn-add {
                width: 100%;
                background: #28a745;
                color: white;
                border: none;
                padding: 10px;
                border-radius: 8px;
                cursor: pointer;
            }

            .form-group {
                margin-bottom: 15px;
            }

            .form-group label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }

            .form-control {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 8px;
            }

            .cart-item {
                border-bottom: 1px solid #eee;
                padding: 10px 0;
            }

            .qty-group {
                display: flex;
                align-items: center;
                gap: 10px;
                margin-top: 10px;
            }

            .qty-btn {
                width: 30px;
                height: 30px;
                border: none;
                border-radius: 5px;
                background: #d85c5c;
                color: white;
                cursor: pointer;
            }

            .note-input {
                width: 100%;
                margin-top: 10px;
                padding: 8px;
                border: 1px solid #ddd;
                border-radius: 6px;
            }

            .total-box {
                margin-top: 20px;
                padding-top: 15px;
                border-top: 2px solid #ddd;
            }

            .total-price {
                font-size: 24px;
                color: #d85c5c;
                font-weight: bold;
            }

            .btn-submit {
                width: 100%;
                margin-top: 20px;
                padding: 12px;
                background: #d85c5c;
                color: white;
                border: none;
                border-radius: 8px;
                cursor: pointer;
                font-size: 16px;
            }
        </style>
    </head>

    <body>
        <div class="dashboard-container">
            <aside class="sidebar">
                <div class="logo">
                    <h2>Nha Hang</h2>
                </div>

                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}/staff/dashboard">
                            Dashboard
                        </a>
                    </li>
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/staff/orders/add">
                            POS Tao Don
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/staff/orders">
                            Danh Sach Don Hang
                        </a>
                    </li>
                </ul>
            </aside>

            <main class="main-content">
                <div class="page-actions">
                    <a href="${pageContext.request.contextPath}/staff/orders"
                       class="btn btn-primary">
                        Tro ve danh sach don
                    </a>
                    <a href="${pageContext.request.contextPath}/staff/dashboard"
                       class="btn btn-primary">
                        Ve dashboard
                    </a>
                </div>

                <h1>
                    <i class="fa-solid fa-cash-register"></i>
                    POS Tao Don Hang
                </h1>

                <form action="${pageContext.request.contextPath}/staff/orders/save"
                      method="post"
                      onsubmit="return prepareSubmit()">
                    <input type="hidden"
                           name="orderItems"
                           id="orderItems">

                    <div class="pos-container">
                        <div class="menu-panel">
                            <h3>Danh sach mon an</h3>

                            <div class="menu-grid">
                                <c:forEach items="${menuItems}"
                                           var="item">
                                    <div class="menu-card">
                                        <c:if test="${not empty item.imagePath}">
                                            <c:choose>
                                                <c:when test="${fn:startsWith(item.imagePath, '/')}">
                                                    <c:set var="menuImageUrl"
                                                           value="${pageContext.request.contextPath}${item.imagePath}"/>
                                                </c:when>
                                                <c:when test="${fn:startsWith(item.imagePath, 'resources/')}">
                                                    <c:set var="menuImageUrl"
                                                           value="${pageContext.request.contextPath}/${item.imagePath}"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:set var="menuImageUrl"
                                                           value="${pageContext.request.contextPath}/resources/images/menu/${item.imagePath}"/>
                                                </c:otherwise>
                                            </c:choose>
                                            <img src="${menuImageUrl}"
                                                 alt="${item.itemName}"
                                                 class="menu-image">
                                        </c:if>
                                        <h4>${item.itemName}</h4>
                                        <p>${item.price} VND</p>
                                        <button type="button"
                                                class="btn-add"
                                                data-id="${item.menuItemId}"
                                                data-name="${item.itemName}"
                                                data-price="${item.price}"
                                                onclick="addItemFromButton(this)">
                                            <i class="fa-solid fa-plus"></i>
                                            Them mon
                                        </button>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>

                        <div class="cart-panel">
                            <div class="form-group">
                                <label>Ten khach hang</label>
                                <input type="text"
                                       name="customerName"
                                       class="form-control"
                                       required>
                            </div>

                            <div class="form-group">
                                <label>Ban an</label>
                                <select name="tableId"
                                        class="form-control"
                                        required>
                                    <c:forEach items="${tables}"
                                               var="table">
                                        <option value="${table.tableId}">
                                            ${table.tableName} (${table.capacity} cho)
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <h3>Hoa don tam</h3>
                            <div id="cartItems"></div>

                            <div class="total-box">
                                <div class="total-price">
                                    Tong tien:
                                    <span id="totalPrice">0</span>
                                    VND
                                </div>
                            </div>

                            <button type="submit"
                                    class="btn-submit">
                                <i class="fa-solid fa-paper-plane"></i>
                                Gui bep
                            </button>
                        </div>
                    </div>
                </form>
            </main>
        </div>

        <script>
            let cart = [];

            function addItemFromButton(button) {
                const id = parseInt(button.dataset.id);
                const name = button.dataset.name;
                const price = parseFloat(button.dataset.price);

                addItem(id, name, price);
            }

            function addItem(id, name, price) {
                let item = cart.find(x => x.menuItemId === id);

                if (item) {
                    item.quantity++;
                } else {
                    cart.push({
                        menuItemId: id,
                        itemName: name,
                        price: price,
                        quantity: 1,
                        note: ""
                    });
                }

                renderCart();
            }

            function increase(id) {
                let item = cart.find(x => x.menuItemId === id);

                if (item) {
                    item.quantity++;
                }

                renderCart();
            }

            function decrease(id) {
                let item = cart.find(x => x.menuItemId === id);

                if (item) {
                    item.quantity--;

                    if (item.quantity <= 0) {
                        cart = cart.filter(x => x.menuItemId !== id);
                    }
                }

                renderCart();
            }

            function updateNote(id, value) {
                let item = cart.find(x => x.menuItemId === id);

                if (item) {
                    item.note = value;
                }
            }

            function renderCart() {
                let html = "";
                let total = 0;

                for (let i = 0; i < cart.length; i++) {
                    let item = cart[i];
                    let subtotal = item.price * item.quantity;
                    total += subtotal;

                    html +=
                        '<div class="cart-item">' +
                        '<h4>' + item.itemName + '</h4>' +
                        '<div class="qty-group">' +
                        '<button type="button" class="qty-btn" onclick="decrease(' + item.menuItemId + ')">-</button>' +
                        '<span>' + item.quantity + '</span>' +
                        '<button type="button" class="qty-btn" onclick="increase(' + item.menuItemId + ')">+</button>' +
                        '</div>' +
                        '<input type="text" class="note-input" placeholder="Ghi chu" value="' + item.note + '" oninput="updateNote(' + item.menuItemId + ', this.value)">' +
                        '<p>' + subtotal.toLocaleString() + ' VND</p>' +
                        '</div>';
                }

                document.getElementById("cartItems").innerHTML = html;
                document.getElementById("totalPrice").innerText = total.toLocaleString();
            }

            function prepareSubmit() {
                if (cart.length === 0) {
                    alert("Vui long chon it nhat 1 mon an!");
                    return false;
                }

                document.getElementById("orderItems").value = JSON.stringify(cart);
                return true;
            }
        </script>
    </body>
</html>
