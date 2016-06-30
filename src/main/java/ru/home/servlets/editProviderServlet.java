package ru.home.servlets;

import ru.home.dao.Provider;
import ru.home.utils.DbHelper;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Vo4ik on 24.06.2016.
 */
public class editProviderServlet extends DispatcherServlet
{
    private static final long serialVersionUID = -8743675432897954234L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        // Добавление поставщика
        if(req.getParameter("addNewProvider") != null)
        {
            try
            {
                DbHelper.getEm().getTransaction().begin();
                String provName = req.getParameter("newProviderName");
                String provAddress = req.getParameter("newProviderAddress");
                Provider prov = new Provider(provName, provAddress);
                DbHelper.getEm().merge(prov);
                DbHelper.getEm().getTransaction().commit();
                super.forward("/successAddProvider.jsp", req, resp);
            }
            catch(Exception e){
                DbHelper.getEm().getTransaction().rollback();
                super.forward("/errorAddProvider.jsp", req, resp);
            }
        }
        // Редактирование поставщика
//        Provider prov = (Provider) q.getResultList().get(0);
        if(req.getParameter("Edit_provider") != null)
        {
//            req.setAttribute("providerSelect", req.getParameter("providerSelect"));
            super.forward("/editProviderPage.jsp", req, resp);
        }
        if(req.getParameter("editProvider") != null)
        {
            TypedQuery<Provider> result = DbHelper.getEm().createQuery("SELECT c FROM Provider c where providerId = " +req.getParameter("providerSelect"),Provider.class);
            if(result != null)
            {
                try
                {
                    Provider prov = result.getResultList().get(0);
                    prov.setProviderAddress(req.getParameter("newProviderAddress"));
                    prov.setProviderName(req.getParameter("newProviderName"));
                    DbHelper.getEm().getTransaction().begin();
                    DbHelper.getEm().merge(prov);
                    DbHelper.getEm().getTransaction().commit();
                    super.forward("/successEditProvider.jsp", req, resp); // Перенаправление в случае успеха
                }
                catch(Exception e)
                {
                    req.setAttribute("er", e.getStackTrace().toString());
                    super.forward("/errorEditProvider.jsp", req, resp);   // Перенаправление в случае неудачи
                }
            }
            else
            {
                super.forward("/errorEditProvider.jsp", req, resp);   // Перенаправление в случае неудачи
            }
        }

        // Удаление поставщика
        if(req.getParameter("delete_provider") != null)
        {
            TypedQuery<Provider> result = DbHelper.getEm().createQuery("SELECT c FROM Provider c where providerId = " +req.getParameter("providerSelect"),Provider.class);
            if(result != null)
            {
                try
                {
                    DbHelper.getEm().getTransaction().begin();
                    DbHelper.getEm().remove(result.getResultList().get(0));
                    DbHelper.getEm().getTransaction().commit();
                    DbHelper.getEm().clear();
                    super.forward("/successDeleteProvider.jsp", req, resp); // Перенаправление в случае успеха
                }
                catch(Exception e)
                {
                    super.forward("/errorDeleteProvider.jsp", req, resp);   // Перенаправление в случае неудачи
                }
            }
            else
            {
                super.forward("/errorDeleteProvider.jsp", req, resp);   // Перенаправление в случае неудачи
            }
        }
    }
}
