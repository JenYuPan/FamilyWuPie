<%--
  Created by IntelliJ IDEA.
  User: forev
  Date: 2025/4/23
  Time: 上午 09:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>吳家餡餅 選擇付款方式</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/stylePay.css">
    <script type="text/javascript" src="<%= request.getContextPath() %>/javaScript/script.js"></script>
</head>
<body>

<div>
    <h1 class="title">吳家餡餅</h1>
</div>
<div>
    <h2 class="title3">請選擇付款方式</h2>
</div>
<table class="payTable">
    <tr>
        <td>
            <input type="button" name="cash" value="現金支付" class="payButton"
                   onclick="submitPayment()">
        </td>
    </tr>
    <tr>
        <td>
            <input type="button" name="LinePay" value="linePay" class="payButton"
                   onclick="alert('LinePay 尚未開放')">
        </td>
    </tr>
    <tr>
        <td>
            <input type="button" name="creditCard" value="信用卡支付" class="payButton"
                   onclick="alert('信用卡 尚未開放')">
        </td>
    </tr>
</table>
<div>
    <input type="button" name="rollBack" value="取消訂單-回上一頁" class="rollBackButton"
           onclick="alert('回到上一頁'),history.go(-1)">
</div>

</body>
</html>
