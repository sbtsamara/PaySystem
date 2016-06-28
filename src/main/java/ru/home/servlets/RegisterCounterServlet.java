package ru.home.servlets;

import ru.home.dao.Registration;
import ru.home.dao.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ivan on 28.06.16.
 */
public class RegisterCounterServlet extends DispatcherServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Service service = (Service) req.getSession().getAttribute("service");
        ArrayList<Registration> registrations = new ArrayList<Registration>(service.getRegistrationsByServiceId());
        req.getSession().setAttribute("registrations",registrations);
        super.forward("/registerCounter.jsp",req,resp);
    }
}
