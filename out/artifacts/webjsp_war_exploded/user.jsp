<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List" %>
<%@ page import="cc.openhome.model.Blah" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Locale" %><%--
    * created by on 12/2/18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>其他用户</title>
</head>
<body>
<c:choose>
    <c:when test="${requestScope.blahs != null}">
        <div class="leftPanel">
            <img src="/img/mao.jpeg" alt="blabla 微博" width="120" height="100"/>
            <br><br>${requestScope.username}的微博
        </div>
        <table style="text-align: left;width: 510px; height: 88px"
               border="0" cellpadding="2" cellspacing="2">
            <thread>
                <tr>
                    <th>
                        <hr>
                    </th>
                </tr>
            </thread>
            <tbody>
            <c:forEach var="blah" items="${requestScope.blahs}">
                <tr>
                    <td style="vertical-align: top;">${blah.username}<br>
                        <c:out value="${blah.txt}"/><br>
                        <fmt:formatDate value="${blah.date}" type="both"
                                        dateStyle="full" timeStyle="full"/>
                        <hr>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <hr style="width: 100%; height: 1px;">
    </c:when>
    <c:otherwise>
        <h1 style="color: rgb(255,0,0);">
                ${requestScope.username} 用户不存在
        </h1>
    </c:otherwise>
</c:choose>
</body>
</html>
