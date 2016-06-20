package ru.home.utils;

import ru.home.appMain.AppMain;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Locale;

/**
 * Created by ivan on 12.06.16.
 */
public class DbHelper {
    static {
        Locale.setDefault(Locale.ENGLISH);
    }
    private static final EntityManager em = Persistence.
            createEntityManagerFactory("NewPersistenceUnit").createEntityManager();


    public static Integer getNewId(Class clazz){
        Query q  = DbHelper.em.createQuery("SELECT c FROM "+clazz.getSimpleName()+" c",clazz);

        return q.getResultList().size()+1;
    }
    public static EntityManager getEm(){
        return em;
    }
}
