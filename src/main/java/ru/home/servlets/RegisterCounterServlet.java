package ru.home.servlets;

import ru.home.dao.Registration;
import ru.home.dao.Service;
import ru.home.utils.DbHelper;

import javax.persistence.TypedQuery;
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
        ArrayList<Registration> registrations = new ArrayList<Registration>();
        TypedQuery<Registration> query = DbHelper.getEm().createQuery("SELECT c FROM Registration c",Registration.class);
        for (Registration registration :query.getResultList()) {
            if (registration.getServiceId()==service.getServiceId()){
                registrations.add(registration);
            }
        }
        service.setRegistrationsByServiceId(registrations);
        req.getSession().setAttribute("service",service);
        req.getSession().setAttribute("registrations",registrations);
        super.forward("/registerCounter.jsp",req,resp);
    }
}
