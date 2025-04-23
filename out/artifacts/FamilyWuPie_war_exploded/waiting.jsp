<%--
  Created by IntelliJ IDEA.
  User: forev
  Date: 2025/4/23
  Time: 上午 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>吳家餡餅-等待付款中</title>
    <script type="text/javascript" src="<%= request.getContextPath() %>/javaScript/scriptwaiting.js" defer></script>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleWating.css">
</head>
<body>
    <h1 class="title">訂單等待付款中...</h1>

    <div id="orderInfo" class="title3"></div>

    <div id="statusMessage" class="title">請稍後，等待櫃台人員確認...</div>

</body>

</html>
