package mvc.controller;

import entity.UserM;
import service.UserMService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserEditController extends Controller {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            UserM userM = new UserM();
            userM.setId(getParam(req, "id", Long.class));
            userM.setName(getParam(req, "name", String.class));
            userM.setEmail(getParam(req, "email", String.class));
            userM.setPassword(getParam(req, "password", String.class));
            userM.setRole(getParam(req, "role", String.class));
            UserMService service = getApplicationContext().getBean(UserMService.class);
            service.update(userM);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/users/list");
    }
}
