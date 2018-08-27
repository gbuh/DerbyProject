package controller;

import dao.impl.UserMDaoImpl;
import entity.UserM;
import service.UserMService;
import service.impl.UserMServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Connection conn;

    @Override
    public void init() throws ServletException {
        //DROP TABLE userm
        String sql =
                "CREATE TABLE userm (user_id BIGINT NOT NULL PRIMARY KEY, user_name VARCHAR(50), user_email VARCHAR(50), user_password VARCHAR(50), user_role VARCHAR(50))";
        String ins1 =
                "INSERT INTO userm (user_id, user_name, user_email, user_password, user_role) VALUES (1, 'Igor', 'igor@mail.ru', '12345', 'admin')";
        String ins2 =
                "INSERT INTO userm (user_id, user_name, user_email, user_password, user_role) VALUES (2, 'Harry', 'harry@mail.ru', '12345', 'user')";
        try {
            Class.forName("org.h2.Driver");//org.apache.derby.jdbc.EmbeddedDriver
            conn = DriverManager.getConnection("jdbc:h2:mem:.testdb");//jdbc:derby:.testdb;create=true
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            PreparedStatement ps1 = conn.prepareStatement(ins1);
            ps1.executeUpdate();
            PreparedStatement ps2 = conn.prepareStatement(ins2);
            ps2.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            conn = DriverManager.getConnection("jdbc:h2:mem:.testdb");//jdbc:derby:.testdb;create=true
            UserMDaoImpl dao = new UserMDaoImpl();
            dao.setConnection(conn);
            UserMServiceImpl service = new UserMServiceImpl();
            service.setUserMDao(dao);
            List<UserM> userMs = service.findAll();
            req.setAttribute("users", userMs);
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/views/users/list.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
}
