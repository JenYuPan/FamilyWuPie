<%--
  Created by IntelliJ IDEA.
  User: forev
  Date: 2025/4/24
  Time: 下午 02:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>訂單取消</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleCancel.css">
    <script type="text/javascript" src="<%= request.getContextPath() %>/javaScript/scriptcancel.js" defer></script>
</head>
<body>
<h1 class="title">訂單取消</h1>
<p class="title3">您的訂單已取消，如有需要請重新點餐。</p>
<p style="color: gray;">頁面將於 8 秒後自動跳轉回點餐頁面</p>
<button onclick="location.href='orderPage.jsp'">返回點餐頁面</button>

</body>
</html>
