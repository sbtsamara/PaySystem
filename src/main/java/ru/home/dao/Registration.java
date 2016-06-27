package ru.home.dao;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Иван on 27.06.2016.
 */
@Entity
@Table(name = "REGISTRATIONS", schema = "PAYMENT", catalog = "")
public class Registration {
    private int regId;
    private int serviceId;
    //Дата в формате ММ/dd/yyyy
    private Date regDate;
    private String regValue;
    private Service serviceByServiceId;

    @Id
    @Column(name = "REG_ID", nullable = false, precision = 0)
    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    @Basic
    @Column(name = "SERVICE_ID", nullable = false, precision = 0)
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Temporal(TemporalType.DATE)
    @Basic
    @Column(name = "REG_DATE", nullable = false)
    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Basic
    @Column(name = "REG_VALUE", nullable = true, length = 20)
    public String getRegValue() {
        return regValue;
    }

    public void setRegValue(String regValue) {
        this.regValue = regValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registration that = (Registration) o;

        if (regId != that.regId) return false;
        if (serviceId != that.serviceId) return false;
        if (regDate != null ? !regDate.equals(that.regDate) : that.regDate != null) return false;
        if (regValue != null ? !regValue.equals(that.regValue) : that.regValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = regId;
        result = 31 * result + serviceId;
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + (regValue != null ? regValue.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "SERVICE_ID", nullable = false)
    public Service getServiceByServiceId() {
        return serviceByServiceId;
    }

    public void setServiceByServiceId(Service serviceByServiceId) {
        this.serviceByServiceId = serviceByServiceId;
    }
}
