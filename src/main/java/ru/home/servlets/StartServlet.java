package ru.home.servlets;

import ru.home.appMain.AppMain;
import ru.home.dao.RoleEnum;
import ru.home.dao.User;
import ru.home.utils.DbHelper;
import ru.home.utils.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            HttpSession session = req.getSession();

            String login = req.getParameter("login");
            session.setAttribute("loginAttribute",login);

            String password = req.getParameter("password");
            session.setAttribute("passwordAttribute",password);

            User user = DbHelper.getEm().find(User.class,login);

            //Проверка пароля
            if (user!=null && user.getUserPassword().equals(PasswordEncoder.md5Apache(password))){
                session.setAttribute("user",user);
                //перенаправление на кабинет для соответствующей роли.
                if (user.getRoleEnum()== RoleEnum.RESIDENT) super.forward("/residentPage.jsp",req,resp);

            }else {
                super.forward("/error.jsp",req,resp);
            }
        }
        //проверка нажатия кнопки registration
        else if (req.getParameter("register")!=null)
        {
            super.forward("/registration.jsp",req,resp);
        }
    }

}
