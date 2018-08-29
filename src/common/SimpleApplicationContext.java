package common;

import dao.impl.UserMDaoImpl;
import service.UserMService;
import service.impl.UserMServiceImpl;
import util.Connector;
import util.H2Connector;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class SimpleApplicationContext implements ApplicationContext {

    private Map<Class<?>, Object> map = new HashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> clazz) {
        return (T) map.get(clazz);
    }

    public void init() {
        Connector connector = new H2Connector();
        connector.init();

        Connection connection = connector.getConnection();

        UserMDaoImpl dao = new UserMDaoImpl();
        dao.setConnection(connection);

        UserMServiceImpl service = new UserMServiceImpl();
        service.setUserMDao(dao);

        map.put(UserMService.class, service);
    }
}
