package ru.home.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivan on 25.06.16.
 */
public class BackServlet extends DispatcherServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String to = (String) req.getSession().getAttribute("back");
        super.forward(to,req,resp);
    }
}
