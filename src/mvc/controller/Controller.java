package mvc.controller;

import common.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Map<Class<?>, Convertor<?>> map = new HashMap<>();

    private ApplicationContext ctx;

    public ApplicationContext getApplicationContext() {
        return ctx;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ctx = (ApplicationContext) config.getServletContext().getAttribute("ctx");

        map.put(String.class, (p) -> p);
        map.put(Long.class, (p) -> Long.parseLong(p.trim()));
    }

    @SuppressWarnings("unchecked")
    protected <T> T getParam(HttpServletRequest req, String param, Class<T> clazz) {
        return (T) map.get(clazz).convert(req.getParameter(param));
    }

    public static interface Convertor<T> {
        T convert(String param);
    }
}
