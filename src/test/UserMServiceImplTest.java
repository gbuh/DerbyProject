package test;

import dao.impl.UserMDaoImpl;
import entity.UserM;
import service.impl.UserMServiceImpl;
import util.Connector;
import util.H2Connector;

import java.util.List;

public class UserMServiceImplTest {
    public static void main(String[] args) {

        Connector connector = new H2Connector();
        //connector.getConnection();
        connector.init();

        UserMDaoImpl dao = new UserMDaoImpl();
        dao.setConnection(connector.getConnection());
        UserMServiceImpl service = new UserMServiceImpl();
        service.setUserMDao(dao);
        
        UserM userM = new UserM();
        userM.setId(3L);
        userM.setName("Joe");
        userM.setEmail("joe@mail.ru");
        userM.setPassword("12345");
        userM.setRole("manager");
        service.insert(userM);

        List<UserM> users = service.findAll();
        for (UserM user : users) {
            output(user);
        }

        service.delete(3L);
        
        users = service.findAll();
        for (UserM user : users) {
            output(user);
        }
    }

    private static void output(UserM user) {
        System.out.printf("User: id=%d, name=%s, email=%s, password=%s, role=%s\n", user.getId(),
                user.getName(), user.getEmail(), user.getPassword(), user.getRole().toString());
    }
}
