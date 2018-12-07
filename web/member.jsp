<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="openhome" tagdir="/WEB-INF/tags" %>

<%--
  Date: 11/28/18 : 10:55 AM
--%>
<%@ page import="cc.openhome.model.UserService" %>
<%@ page import="java.util.List" %>
<%@ page import="cc.openhome.model.Blah" %>
<%
    String username = (String) request.getSession().getAttribute("login");
    Blah blah = new Blah();
    blah.setUsername(username);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta content="text/html;charset=UTF-8" http-equiv="Content-Type">
    <title>微博</title>
    <link rel="stylesheet" href="css/member.css" type="text/css">
</head>
<body>
<div class="leftPanel">
    <img src="img/mi.png" alt="微博" width="120" height="100"/>
    <br><br>
    <a href='logout.do?username="${sessionScope.login}"'>
        注销${sessionScope.login}
    </a>
</div>
<form method="post" action="message.do">
    分享新鲜事...<br>

    <c:if test="${requestScope.blabla != null}">
        信息要在140 字以内
    </c:if>


    <textarea cols="60" rows="4" name="blabla">
        ${ requestScope.blabla }</textarea><br>
    <button type="submit">送出</button>
</form>
<%
    UserService userService = (UserService) application.getAttribute("userService");
    List<Blah> blahs = userService.getBlahs(blah);
    request.setAttribute("blahs", blahs);
%>
<openhome:Blahs/>
<hr style="width: 100px; height: 1px">
</body>
</html>
