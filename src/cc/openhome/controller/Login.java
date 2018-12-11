package cc.openhome.controller;

import cc.openhome.model.Account;
import cc.openhome.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(urlPatterns = {"/login.do"}, initParams = {
        @WebInitParam(name = "SUCESS_VIEW", value = "member.jsp"),
        @WebInitParam(name = "ERROR_VIEW", value = "index.jsp")}
)

public class Login extends HttpServlet {
    private String SUCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        SUCESS_VIEW = getServletConfig().getInitParameter("SUCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("password");

        Account account = new Account(username,pwd);

        UserService userService = (UserService) getServletContext().getAttribute("userService");

        String page = ERROR_VIEW;

        if (userService.isUserExisted(account) && userService.checkLogin(account)) {

             req.getSession().setAttribute("login", username);
            //req.getSession().setAttribute("login", account);

            page = SUCESS_VIEW;
        } else {
            req.setAttribute("error", "名称或密码错误");
            page = ERROR_VIEW;
        }
        req.getRequestDispatcher(page).forward(req, resp);
    }
}
