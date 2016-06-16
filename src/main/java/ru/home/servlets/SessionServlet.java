package ru.home.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ivan on 17.06.16.
 */
public class SessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String str = req.getParameter("textinput");
        session.setAttribute("inputtext",str);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showsession.jsp");
        dispatcher.forward(req,resp);
    }
}
