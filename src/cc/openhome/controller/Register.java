package cc.openhome.controler;

import cc.openhome.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/register.do"},
        initParams = {@WebInitParam(name = "SUCESS_VIEW",value = "sucess.jsp"),
        @WebInitParam(name = "ERROR_VIEW",value = "error.jsp")}
)
public class    Register extends HttpServlet {
    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmedPasswd = req.getParameter("confirmedPasswd");

        UserService userService = (UserService)
                getServletContext().getAttribute("userService");

        List<String> errors = new ArrayList<String>();

        if (userService.isInvalidEmail(email)) {
            errors.add("未填写邮件或邮件格式不正确");
        }

        if(userService.isInvalidUsername(username)){
            errors.add("用户名为空或已经存在");
        }

        if(userService.isInvalidPassword(password,confirmedPasswd)){
            errors.add("请确认密码格式并在此确认密码");
        }


        String resultPage = ERROR_VIEW;
        if(!errors.isEmpty()){
            req.setAttribute("errors",errors);
        }else {
            resultPage = SUCCESS_VIEW;
            userService.createUserData(email,username,password);
        }

        req.getRequestDispatcher(resultPage).forward(req,resp);
    }

}
