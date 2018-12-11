<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="openhome" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:setDataSource dataSource="jdbc/gossip"/>
<%--
  Date: 11/28/18 : 10:55 AM
--%>

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

<sql:query sql="SELECT * FROM t_blah WHERE name = ?" var="messages">
    <sql:param value="${sessionScope.login}"/>
</sql:query>
<c:set var = "blahs" value="${messages.rows}" scope="request"/>

<openhome:Blahs/>
<hr style="width: 100px; height: 1px">
</body>
</html>
