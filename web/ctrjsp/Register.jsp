<%@ page import="cc.openhome.model.UserService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
    * created by on 12/3/18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<%
    String email = request.getParameter("email");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String confirmedPasswd = request.getParameter("confirmPwd");

    UserService userService = (UserService)
            application.getAttribute("userService");

    List<String> errors = new ArrayList<String>();

    if (userService.isInvalidEmail(email)) {

    }
    if(userService.isInvalidUsername(username)){
        errors.add("用户名为空或已经存在");
    }

    if(userService.isInvalidPassword(password,confirmedPasswd)){
        errors.add("请确认密码格式并在此确认密码");
    }

    String resultPage = config.getInitParameter("SUCESS_VIEW");
    if(!errors.isEmpty()){
        request.setAttribute("errors",errors);
    }else {
        resultPage = config.getInitParameter("ERROR_VIEW");
        userService.createUserData(email,username,password);
    }

    request.getRequestDispatcher(resultPage).forward(request,response);
%>
</body>
</html>
