package ru.home.dao;

import javax.persistence.*;

/**
 * Created by Иван on 11.06.2016.
 */
@Entity
@Table(name = "RESIDENTS", schema = "PAYMENT")
//@NamedQuery(name="RESIDENTS.findAll", query ="SELECT * FROM RESIDENTS")
public class Resident {
    private int residentId;
    private int addressId;
    private String residentName;
    private int mainOwner;
    private Address addressesByAddressId;

    public Resident() {
    }

    public Resident(int residentId, int addressId, String residentName, int mainOwner) {

        this.residentId = residentId;
        this.addressId = addressId;
        this.residentName = residentName;
        this.mainOwner = mainOwner;
    }

    @Id
    @Column(name = "RESIDENT_ID", nullable = false, precision = 0)
    public int getResidentId() {
        return residentId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
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
    @Column(name = "RESIDENT_NAME", nullable = false, length = 50)
    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    @Basic
    @Column(name = "MAIN_OWNER", nullable = false, precision = 0)
    public int getMainOwner() {
        return mainOwner;
    }

    public void setMainOwner(int mainOwner) {
        this.mainOwner = mainOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resident that = (Resident) o;

        if (residentId != that.residentId) return false;
        if (addressId != that.addressId) return false;
        if (mainOwner != that.mainOwner) return false;
        if (residentName != null ? !residentName.equals(that.residentName) : that.residentName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = residentId;
        result = 31 * result + addressId;
        result = 31 * result + (residentName != null ? residentName.hashCode() : 0);
        result = 31 * result + mainOwner;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false, insertable = false, updatable = false)
    public Address getAddressesByAddressId() {
        return addressesByAddressId;
    }

    public void setAddressesByAddressId(Address addressesByAddressId) {
        this.addressesByAddressId = addressesByAddressId;
    }
}
