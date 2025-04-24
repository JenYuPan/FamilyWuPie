<%@ page import="java.util.*" %>
<%@ page import="model.OrderTempStore" %><%--
  Created by IntelliJ IDEA.
  User: forev
  Date: 2025/4/23
  Time: 下午 01:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
<%--    String orderId = request.getParameter("orderId");--%>
<%--    List<Map<String, Object>> items = OrderTempStore.get(orderId);--%>
<%--    int total = OrderTempStore.getTotal(orderId);--%>
<%--%>--%>
<html>
<head>
    <title>吳家餡餅櫃台畫面</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleCounter.css">
    <script type="text/javascript" src="<%= request.getContextPath() %>/javaScript/scriptcounter.js" defer></script>


</head>
<body>
    <h1 class="title">目前訂單:</h1>

    <div id="orderBlock" >
        <p style="margin-left:20px">目前沒有待處理的訂單</p>
    </div>




</form>
</body>
</html>
