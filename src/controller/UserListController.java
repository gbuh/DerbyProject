package controller;

import entity.UserM;
import service.UserMService;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserMService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        service = (UserMService) config.getServletContext().getAttribute("service");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<UserM> userMs = service.findAll();
        req.setAttribute("users", userMs);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/users/list.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserM userM = new UserM();
        try {
            userM.setId(Long.parseLong(req.getParameter("id")));
        } catch (NumberFormatException e) {
        }
        userM.setName(req.getParameter("name"));
        userM.setEmail(req.getParameter("email"));
        userM.setPassword(req.getParameter("password"));
        userM.setRole(req.getParameter("role"));
        service.insert(userM);
        resp.sendRedirect(req.getContextPath() + "/users/list");
    }
}
