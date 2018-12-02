package cc.openhome.web;

import cc.openhome.model.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class GossiListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce){
        ServletContext context = sce.getServletContext();
        String USERS = sce.getServletContext().getInitParameter("USERS");
        context.setAttribute("userService",new UserService(USERS));
    }
    public void contextDestroyed(ServletContextEvent sce){}
}
