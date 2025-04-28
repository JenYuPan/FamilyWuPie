<%--
  Created by IntelliJ IDEA.
  User: forev
  Date: 2025/4/28
  Time: 下午 05:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>每日銷售結報</title>
    <script type="text/javascript" src="<%= request.getContextPath() %>/javaScript/scriptmanager.js" defer></script>
</head>
<body>
    <h1 class="title">吳嘉餡餅店-每日銷售狀況</h1>

    <div id="message" style="color: red; font-weight: bold; margin-bottom: 20px">
        請於晚上 八點 後查詢。
    </div>

    <div id="saleReport">

    </div>

</body>
</html>
