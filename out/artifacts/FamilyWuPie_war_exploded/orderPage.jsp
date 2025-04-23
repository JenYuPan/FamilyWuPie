<%--
  Created by IntelliJ IDEA.
  User: forev
  Date: 2025/4/19
  Time: 下午 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>吳家餡餅</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
    <script type="text/javascript" src="<%= request.getContextPath() %>/javaScript/script.js"></script>
</head>
<body>

<div>
    <h1 class="title">吳家餡餅 <input type="button" value="點我結帳" name="checkButton" onclick="checkOut()"></h1>
</div>

<table class="orderTable">
    <tr>
        <td>
            <div class="item">
                <img src="foodPic/beefPie.jpg" class="food">

                <span class="item-name">牛肉餡餅 50$<br>
                    _<br>""
                    <span class="num-control">
                        <img src="foodPic/mi.png" class="num" onclick="decrease('beefRd')">
                        <input type="text" value="0" id="beefRd" class="num-input">
                        <img src="foodPic/plus.png" class="num" onclick="increase('beefRd')">
                    </span>

                </span>

            </div>
        </td>
        <td>
            <div class="item">
                <img src="foodPic/porkPie.jpg" class="food">
                <span class="item-name">豬肉餡餅 50$<br>
                    _<br>""
                    <span class="num-control">
                        <img src="foodPic/mi.png" class="num" onclick="decrease('porkRd')">
                        <input type="text" value="0" id="porkRd" class="num-input">
                        <img src="foodPic/plus.png" class="num" onclick="increase('porkRd')">
                    </span>

                </span>
            </div>
        </td>
        <td>
            <div class="item">
                <img src="foodPic/coldNoodle.jpg" class="food">
                <span class="item-name">涼麵 50$<br>
                    _<br>""
                    <span class="num-control">
                        <img src="foodPic/mi.png" class="num" onclick="decrease('coldNoodleRd')">
                        <input type="text" value="0" id="coldNoodleRd" class="num-input">
                        <img src="foodPic/plus.png" class="num" onclick="increase('coldNoodleRd')">
                    </span>

                </span>
            </div>
        </td>
    </tr>
    <tr>
        <td>
            <div class="item">
                <img src="foodPic/winterMelonTea.jpg" class="food">
                <span class="item-name">冬瓜茶 20$<br>
                    _<br>""
                    <span class="num-control">
                        <img src="foodPic/mi.png" class="num" onclick="decrease('winterMelonTeaRd')">
                        <input type="text" value="0" id="winterMelonTeaRd" class="num-input">
                        <img src="foodPic/plus.png" class="num" onclick="increase('winterMelonTeaRd')">
                    </span>

                </span>
            </div>
        </td>
        <td>
            <div class="item">
                <img src="foodPic/soyMilk.jpg" class="food">
                <span class="item-name">有糖豆漿 20$<br>
                    _<br>""
                    <span class="num-control">
                        <img src="foodPic/mi.png" class="num" onclick="decrease('soyMilkRd')">
                        <input type="text" value="0" id="soyMilkRd" class="num-input">
                        <img src="foodPic/plus.png" class="num" onclick="increase('soyMilkRd')">
                    </span>

                </span>
            </div>
        </td>
        <td>
            <div class="item">
                <img src="foodPic/soyMilk.jpg" class="food">
                <span class="item-name">無糖豆漿 20$<br>
                    _<br>""
                    <span class="num-control">
                        <img src="foodPic/mi.png" class="num" onclick="decrease('sugarFreeSoyMilkRd')">
                        <input type="text" value="0" id="sugarFreeSoyMilkRd" class="num-input">
                        <img src="foodPic/plus.png" class="num" onclick="increase('sugarFreeSoyMilkRd')">
                    </span>

                </span>
            </div>

        </td>
    </tr>
</table>
<%--<div class="cart-hover-zone" id="cartHoverZone"></div> 太不穩定--%>
<%--案鈕的部分達不到預期效果--%>
<%--<div class="cart-wrapper" id="cartWrapper">--%>
<%--    <div class="cart-label-button" id="cartLabelButton">--%>
<%--        <p>購物車</p>--%>
<%--    </div>--%>

<%--    <div class="cart-panel" id="cartPanel">--%>

<%--        <h2>您的購物車</h2>--%>
<%--        <ul id="cartItems">--%>
<%--            <li>牛肉餡餅 * 1 - $50</li>--%>
<%--            <li>豆漿 * 2 - $40</li>--%>
<%--        </ul>--%>
<%--        <div class="cart-total">總價：$90</div>--%>
<%--    </div>--%>
<%--</div>--%>
</body>
</html>
