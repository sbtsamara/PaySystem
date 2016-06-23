package ru.home.dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Иван on 11.06.2016.
 */
@Entity
@Table(name = "ROLES", schema = "PAYMENT")
//@NamedQuery(name="ROLES.findAll", query ="SELECT * FROM ROLES")
public class Role {
    private String roleId;
    private String roleName;
    private Collection<User> usersesByRoleId;

    public Role(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Role() {
    }

    @Id
    @Column(name = "ROLE_ID", nullable = false, length = 20)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "ROLE_NAME", nullable = true, length = 255)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role rolesEnt = (Role) o;

        if (roleId != null ? !roleId.equals(rolesEnt.roleId) : rolesEnt.roleId != null) return false;
        if (roleName != null ? !roleName.equals(rolesEnt.roleName) : rolesEnt.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "rolesByRoleId")
    public Collection<User> getUsersesByRoleId() {
        return usersesByRoleId;
    }

    public void setUsersesByRoleId(Collection<User> usersesByRoleId) {
        this.usersesByRoleId = usersesByRoleId;
    }


}
