package ru.home.servlets;

import ru.home.appMain.AppMain;
import ru.home.dao.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivan on 14.06.16.
 */
public class StartServlet extends DispatcherServlet {
    private static final long serialVersionUID = -5455450010404864908L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //проверка нажатия кнопки логин
        if (req.getParameter("enter")!=null){
            User user = AppMain.em.find(User.class,req.getParameter("login"));
            super.forward("/myServlet",req,resp);
        }
        //проверка нажатия кнопки registration
        else if (req.getParameter("register")!=null)
        {
            super.forward("/registration.jsp",req,resp);
        }
    }

}
