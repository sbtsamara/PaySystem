package ru.home.dao;

import javax.persistence.*;

/**
 * Created by Иван on 11.06.2016.
 */
@Entity
@Table(name = "PAYMENTS", schema = "PAYMENT")
//@NamedQuery(name="PAYMENTS.findAll", query ="SELECT * FROM PAYMENTS")
public class Payment {
    private int paymentId;
    private int chargeId;
    private int paymentAmount;
    private Charge chargesByChargeId;

    public Payment() {
    }

    public Payment(int paymentId, int chargeId, int paymentAmount) {

        this.paymentId = paymentId;
        this.chargeId = chargeId;
        this.paymentAmount = paymentAmount;
    }

    @Id
    @Column(name = "PAYMENT_ID", nullable = false, precision = 0)
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Basic
    @Column(name = "CHARGE_ID", nullable = true, precision = 0)
    public int getChargeId() {
        return chargeId;
    }

    public void setChargeId(int chargeId) {
        this.chargeId = chargeId;
    }

    @Basic
    @Column(name = "PAYMENT_AMOUNT", nullable = true, precision = 2)
    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment that = (Payment) o;

        if (paymentId != that.paymentId) return false;
        if (chargeId != that.chargeId) return false;
        if (paymentAmount != that.paymentAmount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentId;
        result = 31 * result + chargeId;
        result = 31 * result + paymentAmount;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CHARGE_ID", referencedColumnName = "CHARGE_ID", insertable = false, updatable = false)
    public Charge getChargesByChargeId() {
        return chargesByChargeId;
    }

    public void setChargesByChargeId(Charge chargesByChargeId) {
        this.chargesByChargeId = chargesByChargeId;
    }
}
