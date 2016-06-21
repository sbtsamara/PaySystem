package ru.home.servlets;

import ru.home.dao.RoleId;
import ru.home.dao.User;
import ru.home.utils.DbHelper;
import ru.home.utils.PasswordEncoder;

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
            if (user!=null && PasswordEncoder.stringVsMd5(password,user.getUserPassword())){
                session.setAttribute("user",user);
                //перенаправление на кабинет для соответствующей роли.
                if (user.getRoleId()== RoleId.RES) super.forward("/residentPage.jsp",req,resp);
//СЮДА ДОБАВЛЯТЬ СВОЁ ПЕРЕНАПРАВЛЕНИЕ
            }else {
                super.forward("/error.jsp",req,resp);
            }
        }
    }

}
