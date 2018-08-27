package controller;

import dao.impl.UserMDaoImpl;
import entity.UserM;
import service.impl.UserMServiceImpl;
import util.Connector;
import util.DerbyConnector;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Connector connector;

    @Override
    public void init() throws ServletException {
        connector = new DerbyConnector();
        connector.getConnection();
        connector.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Connection connection = null;
        try {
            connection = connector.getConnection();
            UserMDaoImpl dao = new UserMDaoImpl();
            dao.setConnection(connection);
            UserMServiceImpl service = new UserMServiceImpl();
            service.setUserMDao(dao);
            List<UserM> userMs = service.findAll();
            req.setAttribute("users", userMs);
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/views/users/list.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Connection connection = null;
        UserM userM = null;
        try {
            try {
                userM.setId(Long.parseLong(req.getParameter("id")));
            } catch (NumberFormatException e) {
            }
            userM.setName(req.getParameter("name"));
            userM.setEmail(req.getParameter("email"));
            userM.setPassword(req.getParameter("password"));
            userM.setRole(req.getParameter("role"));
            connection = connector.getConnection();
            UserMDaoImpl dao = new UserMDaoImpl();
            dao.setConnection(connection);
            UserMServiceImpl service = new UserMServiceImpl();
            service.setUserMDao(dao);
            service.insert(userM);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        resp.sendRedirect(req.getContextPath() + "/derby-proj/users/list");
    }
}
