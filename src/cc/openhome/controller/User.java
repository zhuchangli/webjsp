package cc.openhome.controller;
/*
 * created by on 12/2/18
 */

import cc.openhome.model.Blah;
import cc.openhome.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/user/*"},
        initParams = {
                @WebInitParam(name = "USER_VIEW",value = "/user.jsp")
        }
)

public class User extends HttpServlet {
    private String USER_VIEW;

    public void init(){
        USER_VIEW = getServletConfig().getInitParameter("USER_VIEW");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = (UserService) getServletContext().getAttribute("userService");

        String usrname = req.getPathInfo().substring(1);
        if(userService.isUerExisted(usrname)){
            Blah blah = new Blah();
            blah.setUsername(usrname);
            List<Blah> blahs = userService.getBlahs(blah);

            req.setAttribute("blahs",blahs);
        }
        req.setAttribute("username",usrname);
        req.getRequestDispatcher(USER_VIEW).forward(req,resp);
    }
}
