package ru.home.dao;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.home.appMain.AppMain;
import ru.home.utils.DbHelper;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Иван on 11.06.2016.
 */
@Entity
@Table(name = "USERS", schema = "PAYMENT")
//@NamedQuery(name="USERS.findAll", query ="SELECT * FROM USERS")
public class User{
    private String userId;
    private String userPassword;
    private int addressId;
    private String roleId;
    private Address addressByAddressId;
    private Role rolesByRoleId;

    public User(String userId, String userPassword, int addressId, String roleId) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.addressId = addressId;
        this.roleId = roleId;
    }

    public User() {
    }

    @Id
    @Column(name = "USER_ID", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_PASSWORD", nullable = false, length = 30)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "ADDRESS_ID", nullable = false, precision = 0)
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "ROLE_ID", nullable = true, length = 20)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User usersEnt = (User) o;

        if (addressId != usersEnt.addressId) return false;
        if (userId != null ? !userId.equals(usersEnt.userId) : usersEnt.userId != null) return false;
        if (userPassword != null ? !userPassword.equals(usersEnt.userPassword) : usersEnt.userPassword != null)
            return false;
        if (roleId != null ? !roleId.equals(usersEnt.roleId) : usersEnt.roleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + addressId;
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false, insertable = false, updatable = false)
    public Address getAddressesByAddressId() {
        return addressByAddressId;
    }

    public void setAddressesByAddressId(Address addressesByAddressId) {
        this.addressByAddressId = addressesByAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID", insertable = false, updatable = false)
    public Role getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(Role rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;

    }

    @Transient
    public RoleEnum getRoleEnum(){
        if (roleId.equals("RES"))return RoleEnum.RESIDENT;
        if (roleId.equals("HOA"))return RoleEnum.HOA_EMP;
        if (roleId.equals("PROV"))return RoleEnum.PROVIDER_EMP;
        if (roleId.equals("ADM"))return RoleEnum.ADMIN;
        return null;
    }
}
