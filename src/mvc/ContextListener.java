package mvc;

import dao.impl.UserMDaoImpl;
import service.impl.UserMServiceImpl;
import util.Connector;
import util.H2Connector;

import java.sql.Connection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        Connector connector = new H2Connector();
        connector.init();
        Connection connection = connector.getConnection();
        UserMDaoImpl dao = new UserMDaoImpl();
        dao.setConnection(connection);
        UserMServiceImpl service = new UserMServiceImpl();
        service.setUserMDao(dao);
        sce.getServletContext().setAttribute("service", service);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
