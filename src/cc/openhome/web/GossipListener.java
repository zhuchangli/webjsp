package cc.openhome.web;/*
 * created by on 12/10/18
 */

import cc.openhome.model.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class GossipListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/gossip");
            ServletContext context = sce.getServletContext();
            context.setAttribute("userService",
                    new UserService(new AccountDAOjdbcImpl(dataSource),
                    new BlahDAOJdbcImpl(dataSource)));
        }catch (NamingException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
