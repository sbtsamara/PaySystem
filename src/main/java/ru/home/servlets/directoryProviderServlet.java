package ru.home.servlets;

import ru.home.dao.Provider;
import ru.home.utils.DbHelper;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Vo4ik on 24.06.2016.
 */
public class directoryProviderServlet extends DispatcherServlet
{
    private static final long serialVersionUID = -7334584545351864908L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            ArrayList<Provider> providers = new ArrayList<Provider>();
            TypedQuery<Provider> query = DbHelper.getEm().createQuery("SELECT c FROM Provider c order by providerId",Provider.class);
            for (Provider provider : query.getResultList()) {
                providers.add(provider);
            }
            req.setAttribute("providers", providers);
            super.forward("/directoryProviderPage.jsp", req, resp);
        }
        catch (Exception e)
        {
            super.forward("/othersError.jsp", req, resp);
        }

    }
}
