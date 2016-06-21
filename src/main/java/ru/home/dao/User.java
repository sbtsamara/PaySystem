package ru.home.dao;

import ru.home.utils.RoleIdConverter;

import javax.persistence.*;

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
    private RoleId roleId;
    private Address addressByAddressId;
    private Role rolesByRoleId;

    public User(String userId, String userPassword, int addressId, RoleId roleId) {
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
    @Convert(converter = RoleIdConverter.class)
    public RoleId getRoleId() {
        return roleId;
    }

    public void setRoleId(RoleId roleId) {
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

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", addressId=" + addressId +
                ", roleId=" + roleId +
                ", addressByAddressId=" + addressByAddressId +
                ", rolesByRoleId=" + rolesByRoleId +
                '}';
    }
}
