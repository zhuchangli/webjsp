<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error" %>
<%--
  Date: 12/2/18
  Time: 4:01 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>微博blabla</title>
</head>
<body>
<img src="img/index.jpg" alt="首页照片" width="120" height="100"/>

<c:if test ="${requestScope.errrors != null}">
    <h1>新会员失败</h1>
    <ul style="color: rgb(255,0,0);">
        <c:forEach var="error" items="${requestScope.errors}">
            <li>${error}</li>
        </c:forEach>
    </ul>
</c:if>

 <h1>会员注册</h1>
 <form method="post" action="register.do">
     <table bgcolor="#cccccc">
         <tr>
             <td>邮件地址: </td>
             <td><input type="text" name="email"
             value="${param.email}" size="25" maxlength="100">
             </td>
         </tr>
         <tr>
         <td>名称(最大字符): </td>
         <td><input type="text" name="username"
         value="${param.username}" size="25" maxlength="16"></td>
         </tr>
         <tr>
             <td>密码</td>
             <td><input type="password" name="password"
             value="${param.password}" size="25" maxlength="16"></td>
         </tr>
         <tr>
             <td>确认密码</td>
             <td><input type="password" name="confirmPwd"
                        value="${param.confirmPwd}" size="25" maxlength="16"></td>
         </tr>
         <tr>
             <td><input type="submit"
                        value="注册" size="25"></td>
         </tr>
     </table>
 </form>
</body>
</html>
