package ru.home.appMain;

import ru.home.dao.Address;
import ru.home.dao.Hoa;
import ru.home.dao.Role;
import ru.home.dao.User;
import ru.home.utils.DbHelper;
import ru.home.utils.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Locale;

/**
 * Created by Иван on 11.06.2016.
 */
public class AppMain {

    public static void main(String[] args) {

/*------------- Добавление записей в базу
        EntityManager em = DbHelper.getEm();
        em.getTransaction().begin();
        Role roleRes = new Role("RES", "Resident");
        Role roleProv = new Role("PROV","Provider employee");
        Role roleAdmin = new Role("ADM","Administrator");
        Role roleHoas = new Role("HOA", "Hoa employee");

        em.merge(roleRes);
        em.merge(roleHoas);
        em.merge(roleProv);
        em.merge(roleAdmin);
        em.getTransaction().commit();

        em.getTransaction().begin();
        int hoaId = DbHelper.getNewId(Hoa.class);
        Hoa hoa1 = new Hoa(hoaId++,"Mercury","Ленина 42","wwww.vvv.com","222-22-22");
        Hoa hoa2 = new Hoa(hoaId++,"Матрёна","Пушкина 22","wwww.ссс.com","8-800-555-35-35");
        Hoa hoa3 = new Hoa(hoaId++,"Супер ТСЖ","Суворова 12","wwww.vk.com","222-22-23");
        Hoa hoa4 = new Hoa(hoaId++,"Ораньжевая желеточка","Революционная 22","wwww.fb.com","02");
        em.merge(hoa1);
        em.merge(hoa2);
        em.merge(hoa3);
        em.merge(hoa4);
        em.getTransaction().commit();

        em.getTransaction().begin();
        int addressId = DbHelper.getNewId(Address.class);
        Address address1 = new Address(addressId++, 2,2,2,"Пушкина",22,null,245);
        Address address2 = new Address(addressId++, 4,1,2,"Пушкина",22,null,247);
        Address address3 = new Address(addressId++, 1,3,2,"Пушкина",22,null,241);
        Address address4 = new Address(addressId++, 1,1,3,"Суворова",12,null,2);
        Address address5 = new Address(addressId++, 2,3,4,"Революционная",22,null,6);
        Address address6 = new Address(addressId++, 3,3,1,"Ленина",42,null,3);
        em.merge(address1);
        em.merge(address2);
        em.merge(address3);
        em.merge(address4);
        em.merge(address5);
        em.merge(address6);
        em.getTransaction().commit();

        em.getTransaction().begin();
        User administrator = new User("Admin",PasswordEncoder.md5Apache("Admin"),1,"ADM");
        User providerEmp = new User("Prov",PasswordEncoder.md5Apache("Prov"),1,"PROV");
        User resident = new User("Resident",PasswordEncoder.md5Apache("Resident"),3,"RES");
        User hoasEmp = new User("HoasEmp",PasswordEncoder.md5Apache("Hoas"),4,"HOA");
        em.merge(administrator);
        em.merge(providerEmp);
        em.merge(resident);
        em.merge(hoasEmp);

        em.getTransaction().commit();
        em.close();
*/

/*-------------- Вытаскивание из базы по первичному ключу.
        User admin = em.find(User.class,"Admin");
*/

/*-------------- Получение списка всех записей в таблице
        TypedQuery<Role> query = DbHelper.getEm().createQuery("SELECT c FROM Role c",Role.class);
        for (Role role :query.getResultList()) {
            System.out.println(role.getRoleName());
        }
*/
    }


}
