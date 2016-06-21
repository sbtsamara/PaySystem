package ru.home.servlets;

import ru.home.dao.User;
import ru.home.utils.DbHelper;
import ru.home.utils.PasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ivan on 20.06.16.
 */
public class ChangePassword extends DispatcherServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String old = (String) req.getParameter("old_password");
        String newPass = (String) req.getParameter("new_password");
        String confirm = (String) req.getParameter("confirm");
        PrintWriter out = resp.getWriter();

        if (PasswordEncoder.md5Apache(old).equals(user.getUserPassword()) && newPass.equals(confirm) && newPass.length()>=5){

            DbHelper.getEm().getTransaction().begin();
            user.setUserPassword(PasswordEncoder.md5Apache(newPass));
            DbHelper.getEm().getTransaction().commit();
            out.write("<script>alert (\"Пароль изменен\" );</script>");
            super.forward("/residentPage.jsp",req,resp);


        }else{
            out.write("<script>alert (\"Пароль не верный\" );</script>");

        }

        out.flush();
        out.close();
    }
}
