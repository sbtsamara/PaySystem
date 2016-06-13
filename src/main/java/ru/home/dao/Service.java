package ru.home.dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Иван on 11.06.2016.
 */
@Entity
@Table(name = "SERVICES", schema = "PAYMENT")
//@NamedQuery(name="SERVICES.findAll", query ="SELECT * FROM SERVICES")
public class Service {
    private int serviceId;
    private String serviceName;
    private int providerId;
    private int isMeter;
    private Collection<Abonent> abonentsesByServiceId;
    private Provider providersByProviderId;

    public Service() {
    }

    public Service(int serviceId, String serviceName, int providerId, int isMeter) {

        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.providerId = providerId;
        this.isMeter = isMeter;
    }

    @Id
    @Column(name = "SERVICE_ID", nullable = false, precision = 0)
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "SERVICE_NAME", nullable = false, length = 255)
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Basic
    @Column(name = "PROVIDER_ID", nullable = false, precision = 0)
    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    @Basic
    @Column(name = "IS_METER", nullable = false, precision = 0)
    public int getIsMeter() {
        return isMeter;
    }

    public void setIsMeter(int isMeter) {
        this.isMeter = isMeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service that = (Service) o;

        if (serviceId != that.serviceId) return false;
        if (providerId != that.providerId) return false;
        if (isMeter != that.isMeter) return false;
        if (serviceName != null ? !serviceName.equals(that.serviceName) : that.serviceName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceId;
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + providerId;
        result = 31 * result + isMeter;
        return result;
    }

    @OneToMany(mappedBy = "servicesByServiceId")
    public Collection<Abonent> getAbonentsesByServiceId() {
        return abonentsesByServiceId;
    }

    public void setAbonentsesByServiceId(Collection<Abonent> abonentsesByServiceId) {
        this.abonentsesByServiceId = abonentsesByServiceId;
    }

    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID", referencedColumnName = "PROVIDER_ID", nullable = false, insertable = false, updatable = false)
    public Provider getProvidersByProviderId() {
        return providersByProviderId;
    }

    public void setProvidersByProviderId(Provider providersByProviderId) {
        this.providersByProviderId = providersByProviderId;
    }
}
