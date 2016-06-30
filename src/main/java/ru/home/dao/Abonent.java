package ru.home.dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Иван on 11.06.2016.
 */
@Entity
@Table(name = "ABONENTS", schema = "PAYMENT")
//@NamedQuery(name="ABONENTS.findAll", query ="SELECT * FROM ABONENTS")
public class Abonent {
    private int abonentId;
    private int serviceId;
    private int abonentAccount;
    private int addressId;
    private Service serviceByServiceId;
    private Address addressByAddressId;
    private Collection<Charge> chargesByAbonentId;

    public Abonent(int abonentId, int serviceId, int abonentAccount, int addressId) {
        this.abonentId = abonentId;
        this.serviceId = serviceId;
        this.abonentAccount = abonentAccount;
        this.addressId = addressId;
    }

    public Abonent() {
    }

    @Id
    @Column(name = "ABONENT_ID", nullable = false, precision = 0)
    public int getAbonentId() {
        return abonentId;
    }

    public void setAbonentId(int abonentId) {
        this.abonentId = abonentId;
    }

    @Basic
    @Column(name = "SERVICE_ID", nullable = false, precision = 0)
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "ABONENT_ACCOUNT", nullable = false, precision = 0)
    public int getAbonentAccount() {
        return abonentAccount;
    }

    public void setAbonentAccount(int abonentAccount) {
        this.abonentAccount = abonentAccount;
    }

    @Basic
    @Column(name = "ADDRESS_ID", nullable = false, precision = 0)
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Abonent that = (Abonent) o;

        if (abonentId != that.abonentId) return false;
        if (serviceId != that.serviceId) return false;
        if (abonentAccount != that.abonentAccount) return false;
        if (addressId != that.addressId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = abonentId;
        result = 31 * result + serviceId;
        result = 31 * result + abonentAccount;
        result = 31 * result + addressId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "SERVICE_ID", nullable = false, insertable = false, updatable = false)
    public Service getServiceByServiceId() {
        return serviceByServiceId;
    }

    public void setServiceByServiceId(Service servicesByServiceId) {
        this.serviceByServiceId = servicesByServiceId;
    }

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false, insertable = false, updatable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressesByAddressId) {
        this.addressByAddressId = addressesByAddressId;
    }

    @OneToMany(mappedBy = "abonentByAbonentId")
    public Collection<Charge> getChargesByAbonentId() {
        return chargesByAbonentId;
    }

    public void setChargesByAbonentId(Collection<Charge> chargesByAbonentId) {
        this.chargesByAbonentId = chargesByAbonentId;
    }
}
