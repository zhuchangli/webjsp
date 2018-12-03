<%@ page import="cc.openhome.model.UserService" %>
<%@ page import="cc.openhome.model.Blah" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %><%--
    * created by on 12/3/18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息处理</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    String username = (String) request.getSession().getAttribute("login");
    UserService userService = (UserService) application.getAttribute("userService");
    Blah blah = new Blah();
    blah.setUsername(username);

    String blabla = request.getParameter("blabla");
    if(blabla != null && blabla.length() != 0){
        if(blabla.length() < 140){
            blah.setDate(new Date());
            blah.setTxt(blabla);
            userService.addBlah(blah);
        }
        else {
            request.setAttribute("blabla",blabla);
        }
    }

    String pag = config.getInitParameter("MEMBER_VIEW");
    List<Blah> blahs = userService.getBlahs(blah);
    request.setAttribute("blahs",blahs);
    request.getRequestDispatcher(pag).forward(request,response);
%>
</body>
</html>
