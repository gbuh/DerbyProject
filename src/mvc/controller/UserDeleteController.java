package mvc.controller;

import service.UserMService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteController extends Controller {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Long id = getParam(req, "id", Long.class);
            UserMService service = getApplicationContext().getBean(UserMService.class);
            service.delete(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/users/list");
    }
}
