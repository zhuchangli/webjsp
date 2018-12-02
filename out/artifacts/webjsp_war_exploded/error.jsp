<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: zili
  Date: 11/28/18
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta content="text/html;charset=UTF-8" http-equiv="Content-Type">
    <title>新增会员失败</title>
</head>
<body>
     <h1>新增会员失败</h1>
     <ul style="color: rgb(255,0,0);">
         <%
             List<String> errors = (List<String>) request.getAttribute("error");
             for (String error : errors){
         %>
              <li><%= error %></li>
         <%
             }
         %>
     </ul>
<a href="register.html">返回注册页面</a>
</body>
</html>
