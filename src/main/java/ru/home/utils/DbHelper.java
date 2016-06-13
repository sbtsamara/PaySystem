package ru.home.utils;

import ru.home.appMain.AppMain;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by ivan on 12.06.16.
 */
public class DbHelper {
    public static Integer getNewId(Class clazz){
        Query q  = AppMain.em.createQuery("SELECT c FROM "+clazz.getSimpleName()+" c",clazz);

        return q.getResultList().size()+1;
    }
}
