package ru.home.dao;

import ru.home.utils.BooleanConverter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Иван on 11.06.2016.
 */
@Entity
@Table(name = "CHARGES", schema = "PAYMENT")
//@NamedQuery(name="CHARGES.findAll", query ="SELECT * FROM CHARGES")
public class Charge {
    private int chargeId;
    private int abonentId;
    private int chargeAmount;
    //Дата в формате ММ/dd/yyyy
    private Date periodBeginDate;
    private Date periodEndDate;
    private Boolean chargePaid;
    private Abonent abonentsByAbonentId;
    private Collection<Payment> paymentsesByChargeId;

    public Charge() {
    }

    public Charge(int chargeId, int abonentId, int chargeAmount, Date periodBeginDate, Date periodEndDate, Boolean chargePaid) {

        this.chargeId = chargeId;
        this.abonentId = abonentId;
        this.chargeAmount = chargeAmount;
        this.periodBeginDate = periodBeginDate;
        this.periodEndDate = periodEndDate;
        this.chargePaid = chargePaid;
    }

    @Id
    @Column(name = "CHARGE_ID", nullable = false, precision = 0)
    public int getChargeId() {
        return chargeId;
    }

    public void setChargeId(int chargeId) {
        this.chargeId = chargeId;
    }

    @Basic
    @Column(name = "ABONENT_ID", nullable = true, precision = 0)
    public int getAbonentId() {
        return abonentId;
    }

    public void setAbonentId(int abonentId) {
        this.abonentId = abonentId;
    }

    @Basic
    @Column(name = "CHARGE_AMOUNT", nullable = true, precision = 2)
    public int getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(int chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "PERIOD_BEGIN_DATE", nullable = true)
    public Date getPeriodBeginDate() {
        return periodBeginDate;
    }

    public void setPeriodBeginDate(Date periodBeginDate) {
        this.periodBeginDate = periodBeginDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "PERIOD_END_DATE", nullable = true)
    public Date getPeriodEndDate() {
        return periodEndDate;
    }

    public void setPeriodEndDate(Date periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    @Basic
    @Column(name = "CHARGE_PAID", nullable = true, precision = 0)
    @Convert(converter = BooleanConverter.class)
    public Boolean getChargePaid() {
        return chargePaid;
    }

    public void setChargePaid(Boolean chargePaid) {
        this.chargePaid = chargePaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Charge charge = (Charge) o;

        if (chargeId != charge.chargeId) return false;
        if (abonentId != charge.abonentId) return false;
        if (chargeAmount != charge.chargeAmount) return false;
        if (periodBeginDate != null ? !periodBeginDate.equals(charge.periodBeginDate) : charge.periodBeginDate != null)
            return false;
        if (periodEndDate != null ? !periodEndDate.equals(charge.periodEndDate) : charge.periodEndDate != null)
            return false;
        if (chargePaid != null ? !chargePaid.equals(charge.chargePaid) : charge.chargePaid != null) return false;
        if (abonentsByAbonentId != null ? !abonentsByAbonentId.equals(charge.abonentsByAbonentId) : charge.abonentsByAbonentId != null)
            return false;
        return paymentsesByChargeId != null ? paymentsesByChargeId.equals(charge.paymentsesByChargeId) : charge.paymentsesByChargeId == null;

    }

    @Override
    public int hashCode() {
        int result = chargeId;
        result = 31 * result + abonentId;
        result = 31 * result + chargeAmount;
        result = 31 * result + (periodBeginDate != null ? periodBeginDate.hashCode() : 0);
        result = 31 * result + (periodEndDate != null ? periodEndDate.hashCode() : 0);
        result = 31 * result + (chargePaid != null ? chargePaid.hashCode() : 0);
        result = 31 * result + (abonentsByAbonentId != null ? abonentsByAbonentId.hashCode() : 0);
        result = 31 * result + (paymentsesByChargeId != null ? paymentsesByChargeId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ABONENT_ID", referencedColumnName = "ABONENT_ID", insertable = false, updatable = false)
    public Abonent getAbonentsByAbonentId() {
        return abonentsByAbonentId;
    }

    public void setAbonentsByAbonentId(Abonent abonentsByAbonentId) {
        this.abonentsByAbonentId = abonentsByAbonentId;
    }

    @OneToMany(mappedBy = "chargesByChargeId")
    public Collection<Payment> getPaymentsesByChargeId() {
        return paymentsesByChargeId;
    }

    public void setPaymentsesByChargeId(Collection<Payment> paymentsesByChargeId) {
        this.paymentsesByChargeId = paymentsesByChargeId;
    }
}
