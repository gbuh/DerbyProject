package mvc.controller;

import service.UserMService;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserMService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        service = (UserMService) config.getServletContext().getAttribute("service");
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            service.delete(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/users/list");
    }
}
