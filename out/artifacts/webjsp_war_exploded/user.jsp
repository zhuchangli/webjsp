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
<%
    List<Blah> blahs = (List<Blah>) request.getAttribute("blahs");
    if(blahs != null){
%>
    <div class="leftPanel">
        <img src="img/mi.png" alt="blabla 微博"/>
        <br><br>${requestScope.username}的微博
    </div>
    <table style="text-align: left;width: 510px; height: 88px"
    border="0" cellpadding="2" cellspacing="2">
        <thread>
            <tr>
                <th><hr></th>
            </tr>
        </thread>
        <tbody>
<%
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,
            DateFormat.FULL, Locale.CHINA);
    for(Blah blah : blahs){
%>
        <tr>
            <td style="vertical-align: top;">
                <%= blah.getUsername() %>
                <%= blah.getTxt() %><br>
                <%= dateFormat.format(blah.getDate())%>
            </td>
        </tr>
        </tbody>
    </table>
    <hr style="width: 100%;height: 1px;">

<%
    }
%>
<%
   }
    else{
%>
    <h1 style="color: rgb(255,0,0);">
        ${requestScope.username} 用户不存在
    </h1>
<%
    }
%>
</body>
</html>
