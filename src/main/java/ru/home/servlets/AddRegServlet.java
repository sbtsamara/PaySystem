package ru.home.servlets;

import ru.home.dao.Registration;
import ru.home.utils.DbHelper;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by ivan on 28.06.16.
 */
public class AddRegServlet extends DispatcherServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("value");
        String serviceId = (String) req.getSession().getAttribute("serviceId");
        String date = req.getParameter("date");
        if (date.equals("")||value.equals("")){
            req.getSession().setAttribute("checker","false");
            super.forward("/registerCounter.jsp",req,resp);
        }else req.getSession().setAttribute("checker","true");
        String formatDate = date.split("-")[1]+"/"+date.split("-")[2]+"/"+date.split("-")[0];
        Registration registration = new Registration(DbHelper.getNewId(Registration.class),Integer.parseInt(serviceId),new Date(formatDate),value);
        EntityManager entityManager = DbHelper.getEm();
        entityManager.getTransaction().begin();
        entityManager.merge(registration);
        entityManager.getTransaction().commit();
        super.forward("/registerCounterServlet",req,resp);

    }
}
