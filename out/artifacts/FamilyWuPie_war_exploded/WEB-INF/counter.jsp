<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="model.OrderTempStore" %><%--
  Created by IntelliJ IDEA.
  User: forev
  Date: 2025/4/23
  Time: 下午 01:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String orderId = request.getParameter("orderId");
    List<Map<String, Object>> items = OrderTempStore.get(orderId);
    int total = OrderTempStore.getTotal(orderId);
%>
<html>
<head>
    <title>吳家餡餅櫃台畫面</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
<h1 class="title">目前訂單:<%= orderId %></h1>

    <% if(items != null) { %>
        <ul>
            <% for (Map<String, Object> item : items) { %>
                <li>
                    <%= item.get("name") %> &nbsp; <%= item.get("price")%> X <%= item.get("quantity")%>
                </li>
            <% } %>
        </ul>
        <p><strong>總金額是： &nbsp; <%=total%> &nbsp; 元</strong></p>
    <% } else { %>
        <p>尚無訂單</p>
    <% } %>

<form method="post" action="confirmPayment">
    <input type="hidden" name="orderId" value="<%= orderId %>">
    <input type="submit" value="已付款" class="payed">
</form>
<%--這裡的servlet都還沒寫--%>

<form method="post" action="cancelPayment">
    <input type="hidden" name="orderId" value="<%= orderId %>">
    <input type="submit" value="取消訂單" class="payed">
</form>
</body>
</html>
