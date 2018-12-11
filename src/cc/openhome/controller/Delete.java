package cc.openhome.controller;

import cc.openhome.model.Blah;
import cc.openhome.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = {"/delete.do"},
           initParams = {
               @WebInitParam(name = "SUCCESS_VIEW",value = "member.jsp")
           }
)
public class Delete extends HttpServlet {
    //private final String USERS = "/home/zili/Documents/myjava/users";
    private String SUCCESS_VIEW ;
    private String ERROR_VIEW ;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = (String) req.getSession().getAttribute("login");
        String message = req.getParameter("message");

        Blah blah = new Blah();
        blah.setUsername(username);
        blah.setDate(new Date(Long.parseLong(message)));

        UserService userService = (UserService) getServletContext().getAttribute("userService");
        userService.deleteBlah(blah);

        resp.sendRedirect(SUCCESS_VIEW);
    }
}
