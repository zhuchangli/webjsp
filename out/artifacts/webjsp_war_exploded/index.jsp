<%--
  Created by IntelliJ IDEA.
  User: zili
  Date: 12/2/18
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>微博blabla</title>
  </head>
  <body>

  <img src="img/index.jpg" alt="首页照片" width="120" height="100">
  <div>
    <a href="register.jsp">还不是会员?</a><p>
    <div style="color: rgb(255,0,0);">
    ${requestScope.error}
  </div>
    <form method="post" action="login.jsp">
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
  </body>
</html>
