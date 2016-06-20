package ru.home.servises;

import org.hibernate.SessionFactory;
import org.infinispan.factories.annotations.Inject;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.home.dao.User;
import ru.home.utils.DbHelper;

import javax.inject.Named;

/**
 * Created by ivan on 20.06.16.
 */
public class ServiceUser implements UserDetailsService{

    private SessionFactory sessionFactory;

    public ServiceUser() {
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User result = DbHelper.getEm().find(User.class,username);

        if (result==null)
        {
            throw new UsernameNotFoundException("username " + username + "not found");
        }

        return result;
    }
}
