<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="openhome" tagdir="/WEB-INF/tags" %>
<%--
  Date: 12/2/18 1:38 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>微博blabla</title>
    <link rel="stylesheet" href="css/index.css" type="text/css">
</head>
<body>
<div style="float:left ">
    <img src="img/index.jpg" alt="首页照片" width="120" height="100">
    <div>
        <a href="register.jsp">还不是会员?</a>
        <p>
        <div style="color: rgb(255,0,0);">
            ${requestScope.error}
        </div>
        <form method="post" action="login.do">
            <table bgcolor="#cccccc">
                <tr>
                    <td colspan="2">会员登录</td>
                </tr>
                <tr>
                    <td>名称:</td>
                        <td><input type="text" name="username" value="${param.username}"></td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input type="password" name="password" value="${param.password}"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="登录"></td>
                </tr>
            </table>
        </form>
        </p>
    </div>
</div>
<div style="float:left;margin-left: 120px">
    <h1>blabla微博</h1>
    <ul>
        <li>侃大山</li>
        <li>闲聊聊</li>
        <li>瞎写写</li>
    </ul>
    <openhome:Blahs/>
</div>
</body>
</html>
