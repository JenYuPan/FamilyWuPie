<%--
  Created by IntelliJ IDEA.
  User: forev
  Date: 2025/4/24
  Time: 上午 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>訂購成功!</title>
  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleSuccess.css">
  <script type="text/javascript" src="<%= request.getContextPath() %>/javaScript/scriptSuccess.js" defer></script>
</head>
<body>
  <h1 class="title">訂購成功</h1>
  <div id = "orderInfo" class="title3"></div>
  <p>!!請記得您的訂單編號!!</p>
  <button onclick="location.href='orderPage.jsp'">返回點餐首頁</button>
  <p>頁面將於10秒後自動跳轉</p>

</body>
</html>
