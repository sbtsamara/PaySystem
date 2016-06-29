package ru.home.dao;

import ru.home.appMain.AppMain;
import ru.home.utils.DbHelper;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Иван on 11.06.2016.
 */
@Entity
@Table(name = "HOAS", schema = "PAYMENT")
//@NamedQuery(name="HOAS.findAll", query ="SELECT * FROM HOAS")
public class Hoa {
    private int hoaId;
    private String hoaName;
    private String hoaAddress;
    private String hoaWebsite;
    private String hoaPhone;
    private Collection<Address> addressesByHoaId;

    public Hoa(int hoaId, String hoaName, String hoaAddress, String hoaWebsite, String hoaPhone) {
        this.hoaId = hoaId;
        this.hoaName = hoaName;
        this.hoaAddress = hoaAddress;
        this.hoaWebsite = hoaWebsite;
        this.hoaPhone = hoaPhone;
    }

    public Hoa() {
    }

    @Id
    @Column(name = "HOA_ID", nullable = false, precision = 0)
    public int getHoaId() {
        return hoaId;
    }

    public void setHoaId(int hoaId) {
        this.hoaId = hoaId;
    }

    @Basic
    @Column(name = "HOA_NAME", nullable = false, length = 255)
    public String getHoaName() {
        return hoaName;
    }

    public void setHoaName(String hoaName) {
        this.hoaName = hoaName;
    }

    @Basic
    @Column(name = "HOA_ADDRESS", nullable = false, length = 255)
    public String getHoaAddress() {
        return hoaAddress;
    }

    public void setHoaAddress(String hoaAddress) {
        this.hoaAddress = hoaAddress;
    }

    @Basic
    @Column(name = "HOA_WEBSITE", nullable = true, length = 255)
    public String getHoaWebsite() {
        return hoaWebsite;
    }

    public void setHoaWebsite(String hoaWebsite) {
        this.hoaWebsite = hoaWebsite;
    }

    @Basic
    @Column(name = "HOA_PHONE", nullable = true, length = 255)
    public String getHoaPhone() {
        return hoaPhone;
    }

    public void setHoaPhone(String hoaPhone) {
        this.hoaPhone = hoaPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hoa hoasEnt = (Hoa) o;

        if (hoaId != hoasEnt.hoaId) return false;
        if (hoaName != null ? !hoaName.equals(hoasEnt.hoaName) : hoasEnt.hoaName != null) return false;
        if (hoaAddress != null ? !hoaAddress.equals(hoasEnt.hoaAddress) : hoasEnt.hoaAddress != null) return false;
        if (hoaWebsite != null ? !hoaWebsite.equals(hoasEnt.hoaWebsite) : hoasEnt.hoaWebsite != null) return false;
        if (hoaPhone != null ? !hoaPhone.equals(hoasEnt.hoaPhone) : hoasEnt.hoaPhone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hoaId;
        result = 31 * result + (hoaName != null ? hoaName.hashCode() : 0);
        result = 31 * result + (hoaAddress != null ? hoaAddress.hashCode() : 0);
        result = 31 * result + (hoaWebsite != null ? hoaWebsite.hashCode() : 0);
        result = 31 * result + (hoaPhone != null ? hoaPhone.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "hoasByHoaId")
    public Collection<Address> getAddressesByHoaId() {
        return addressesByHoaId;
    }

    public void setAddressesByHoaId(Collection<Address> addressesByHoaId) {
        this.addressesByHoaId = addressesByHoaId;
    }
}
