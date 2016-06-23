package ru.home.dao;

import ru.home.utils.BooleanConverter;

import javax.persistence.*;
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
    private Abonent abonentByAbonentId;
    private Collection<Payment> paymentsByChargeId;

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
        if (abonentByAbonentId != null ? !abonentByAbonentId.equals(charge.abonentByAbonentId) : charge.abonentByAbonentId != null)
            return false;
        return paymentsByChargeId != null ? paymentsByChargeId.equals(charge.paymentsByChargeId) : charge.paymentsByChargeId == null;

    }

    @Override
    public int hashCode() {
        int result = chargeId;
        result = 31 * result + abonentId;
        result = 31 * result + chargeAmount;
        result = 31 * result + (periodBeginDate != null ? periodBeginDate.hashCode() : 0);
        result = 31 * result + (periodEndDate != null ? periodEndDate.hashCode() : 0);
        result = 31 * result + (chargePaid != null ? chargePaid.hashCode() : 0);
        result = 31 * result + (abonentByAbonentId != null ? abonentByAbonentId.hashCode() : 0);
        result = 31 * result + (paymentsByChargeId != null ? paymentsByChargeId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ABONENT_ID", referencedColumnName = "ABONENT_ID", insertable = false, updatable = false)
    public Abonent getAbonentByAbonentId() {
        return abonentByAbonentId;
    }

    public void setAbonentByAbonentId(Abonent abonentsByAbonentId) {
        this.abonentByAbonentId = abonentsByAbonentId;
    }

    @OneToMany(mappedBy = "chargeByChargeId")
    public Collection<Payment> getPaymentsByChargeId() {
        return paymentsByChargeId;
    }

    public void setPaymentsByChargeId(Collection<Payment> paymentsesByChargeId) {
        this.paymentsByChargeId = paymentsesByChargeId;
    }
}
