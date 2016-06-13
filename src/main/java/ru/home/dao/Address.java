package ru.home.dao;

import ru.home.appMain.AppMain;
import ru.home.utils.DbHelper;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Иван on 11.06.2016.
 */
@Entity
@Table(name = "ADDRESSES", schema = "PAYMENT")
//@NamedQuery(name="ADDRESSES.findAll", query ="SELECT * FROM ADDRESSES")
public class Address {
    private int addressId;
    private int residentCnt;
    private int registeredCnt;
    private int hoaId;
    private String street;
    private int house;
    private String building;
    private int apartment;
    private Collection<Abonent> abonentsesByAddressId;
    private Hoa hoasByHoaId;
    private Collection<Resident> residentsesByAddressId;
    private Collection<User> usersesByAddressId;

    public Address(int addressId, int residentCnt, int registeredCnt, int hoaId, String street, int house, String building, int apartment) {
        this.addressId = addressId;
        this.residentCnt = residentCnt;
        this.registeredCnt = registeredCnt;
        this.hoaId = hoaId;
        this.street = street;
        this.house = house;
        this.building = building;
        this.apartment = apartment;
    }

    public Address() {
    }

    @Id
    @Column(name = "ADDRESS_ID", nullable = false, precision = 0)
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "RESIDENT_CNT", nullable = false, precision = 0)
    public int getResidentCnt() {
        return residentCnt;
    }

    public void setResidentCnt(int residentCnt) {
        this.residentCnt = residentCnt;
    }

    @Basic
    @Column(name = "REGISTERED_CNT", nullable = false, precision = 0)
    public int getRegisteredCnt() {
        return registeredCnt;
    }

    public void setRegisteredCnt(int registeredCnt) {
        this.registeredCnt = registeredCnt;
    }

    @Basic
    @Column(name = "HOA_ID", nullable = false, precision = 0)
    public int getHoaId() {
        return hoaId;
    }

    public void setHoaId(int hoaId) {
        this.hoaId = hoaId;
    }

    @Basic
    @Column(name = "STREET", nullable = true, length = 255)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "HOUSE", nullable = true, precision = 0)
    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Basic
    @Column(name = "BUILDING", nullable = true, length = 255)
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Basic
    @Column(name = "APARTMENT", nullable = true, precision = 0)
    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address that = (Address) o;

        if (addressId != that.addressId) return false;
        if (residentCnt != that.residentCnt) return false;
        if (registeredCnt != that.registeredCnt) return false;
        if (hoaId != that.hoaId) return false;
        if (house != that.house) return false;
        if (apartment != that.apartment) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (building != null ? !building.equals(that.building) : that.building != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId;
        result = 31 * result + residentCnt;
        result = 31 * result + registeredCnt;
        result = 31 * result + hoaId;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + house;
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + apartment;
        return result;
    }

    @OneToMany(mappedBy = "addressesByAddressId")
    public Collection<Abonent> getAbonentsesByAddressId() {
        return abonentsesByAddressId;
    }

    public void setAbonentsesByAddressId(Collection<Abonent> abonentsesByAddressId) {
        this.abonentsesByAddressId = abonentsesByAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "HOA_ID", referencedColumnName = "HOA_ID", nullable = false, insertable = false, updatable = false)
    public Hoa getHoasByHoaId() {
        return hoasByHoaId;
    }

    public void setHoasByHoaId(Hoa hoasByHoaId) {
        this.hoasByHoaId = hoasByHoaId;
    }

    @OneToMany(mappedBy = "addressesByAddressId")
    public Collection<Resident> getResidentsesByAddressId() {
        return residentsesByAddressId;
    }

    public void setResidentsesByAddressId(Collection<Resident> residentsesByAddressId) {
        this.residentsesByAddressId = residentsesByAddressId;
    }

    @OneToMany(mappedBy = "addressesByAddressId")
    public Collection<User> getUsersesByAddressId() {
        return usersesByAddressId;
    }

    public void setUsersesByAddressId(Collection<User> usersesByAddressId) {
        this.usersesByAddressId = usersesByAddressId;
    }
}
