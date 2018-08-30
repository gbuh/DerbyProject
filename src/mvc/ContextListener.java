package mvc;

import common.SimpleApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // ServletContextListener.super.contextInitialized(sce);

        SimpleApplicationContext ctx = new SimpleApplicationContext();
        ctx.init();
        sce.getServletContext().setAttribute("ctx", ctx);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // ServletContextListener.super.contextDestroyed(sce);
    }
}
