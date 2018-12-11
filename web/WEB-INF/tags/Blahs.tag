<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:setDataSource dataSource="jdbc/gossip"/>

<c:choose>
    <c:when test="${requestScope.blahs == null}">
        <c:set var="messages"
               value="${applicationScope.userService.newest}"
               scope="page"/>
    </c:when>
    <c:otherwise>
       <c:set var ="messages" value="${requestScope.blahs}"/>
       <c:set var="isIndex" value="false"/>
    </c:otherwise>
</c:choose>

<table style="text-align: left;width: 510px;height: 88px"
border="0" cellpadding="2" cellspacing="2">
<thread>
    <tr>
        <th>
            <hr>
        </th>
    </tr>
</thread>
<tbody>

<c:forEach var="blah" items="${messages}">
    <tr>
        <td style="vertical-align: top;">${blah.username}<br>
            <c:out value="${blah.txt}"/><br>
            <fmt:formatDate value="${blah.date}" type="both"
                            dateStyle="full" timeStyle="full"/>
            <c:if test="${isIndex == false}">
                <a href="delete.do?message=${blah.date.time}">删除</a>
            </c:if>
            <hr>
        </td>
    </tr>
</c:forEach>
</tbody>
</table>
<c:remove var="blahs" scope="page"/>