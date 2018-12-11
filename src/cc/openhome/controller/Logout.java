package cc.openhome.controller;

import cc.openhome.model.Account;
import cc.openhome.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = {"/logout.do"},
           initParams = {@WebInitParam(name = "LOGIN-VIEW", value = "index.jsp")}
)
public class Logout extends HttpServlet {
    private String LOGIN_VIEW ;

    @Override
    public void init() throws ServletException {
        LOGIN_VIEW = getServletConfig().getInitParameter("LOGIN_VIEW");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("account") != null){
            /*
            Account a = (Account) req.getSession().getAttribute("account");
            UserService userService = (UserService) getServletContext().getAttribute("userService");
            userService.delete(a);
            */
            req.getSession().invalidate();
        }
        resp.sendRedirect(LOGIN_VIEW);
    }
}
