<%@ page import="cc.openhome.model.UserService" %><%--
    * created by on 12/3/18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    String pag;
    String name = request.getParameter("username");
    String passwd = request.getParameter("password");
    UserService userService = (UserService) application.getAttribute("userService");
    if(userService.checkLogin(name,passwd)) {
        request.getSession().setAttribute("login",name);
        pag = config.getInitParameter("SUCESS_VIEW");
%>
<%
    }
    else {
        request.setAttribute("error","名称或密码错误");
        pag = config.getInitParameter("ERROR_VIEW");
%>
<%
    }
    request.getRequestDispatcher(pag).forward(request,response);
%>
</body>
</html>
