package xyz.drafter.cap4.other; /**
 * @author drafter
 * @date 2019/12/9
 * @desciption
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class OrderListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        System.out.println("orderListener.....OrderListener");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("orderListener.....contextDestroyed");
    }
}
