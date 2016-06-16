package ru.home.servlets;

import org.infinispan.factories.annotations.Inject;
import ru.home.I1impl;
import ru.home.IServise;
import ru.home.dao.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivan on 17.06.16.
 */
public class MainServlet extends HttpServlet {

    private IServise iServise;


    @Override
    public void init() throws ServletException{

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        iServise.setI(new I1impl());
        String item = iServise.getItem();
        req.getSession().setAttribute("item",item);
        resp.sendRedirect("show.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
