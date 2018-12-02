<%--
  Date: 11/28/18 : 10:55 AM
--%>
<%@ page import="cc.openhome.model.UserService" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Locale" %>
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
         <img src="img/weibo.jpg" alt="微博" width="120" height="100"/>
         <br><br>
         <a href='logout.do?username="${sessionScope.login}"'>
             注销${sessionScope.login}
         </a>
     </div>
     <form method="post" action="message.do">
         分享新鲜事...<br>
     <%
         String blabla = (String) request.getAttribute("blabla");
         if(blabla != null){
     %>
             信息要在140字以内<br>
     <%
         }
     %>
         <textarea cols="60" rows="4" name="blabla">
             ${ requestScope.blabla }</textarea><br>
         <button type="submit">送出</button>
     </form>
     <table style="text-align: left;width: 510px; height: 80px;"
            border="0" cellpadding="2" cellspacing="2">
         <thead>
               <tr>
                   <th><hr></th>
               </tr>
         </thead>
         <tbody>
    <%
        DateFormat dateFormat = DateFormat.getDateTimeInstance(
                DateFormat.FULL,DateFormat.FULL,Locale.CHINA);

        UserService userService = (UserService) application.getAttribute("userService");

        // p230 书上方法不能解决
        // List<Blah> blahs = (List<Blah>) request.getAttribute("blahs");

        List<Blah> blahs = userService.getBlahs(blah);;
             for(Blah blah1 : blahs){
    %>
         <tr>
             <td style="vertical-align: top;">
                 <%=blah1.getUsername()%><br>
                 <%=blah1.getTxt()%><br>
                 <%=dateFormat.format(blah1.getDate())%>
             <a href="delete.do?message=<%=blah1.getDate().getTime() %>">删除</a>
                 <hr>
             </td>
         </tr>
    <%
        }
    %>
         </tbody>
     </table>
     <hr style="width: 100px; height: 1px">
</body>
</html>
