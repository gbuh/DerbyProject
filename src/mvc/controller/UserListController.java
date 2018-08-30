package mvc.controller;

import entity.UserM;
import service.UserMService;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListController extends Controller {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<UserM> userMs = getApplicationContext().getBean(UserMService.class).findAll();
        req.setAttribute("users", userMs);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/users/list.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserM userM = new UserM();

        userM.setId(getParam(req, "id", Long.class));
        userM.setName(req.getParameter("name"));
        userM.setEmail(req.getParameter("email"));
        userM.setPassword(req.getParameter("password"));
        userM.setRole(req.getParameter("role"));
        UserMService service = getApplicationContext().getBean(UserMService.class);
        service.insert(userM);
        resp.sendRedirect(req.getContextPath() + "/users/list");
    }
}
