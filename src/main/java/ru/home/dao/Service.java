package ru.home.dao;

import ru.home.utils.BooleanConverter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Иван on 11.06.2016.
 */
@Entity
@Table(name = "SERVICES", schema = "PAYMENT", catalog = "")
//@NamedQuery(name="SERVICES.findAll", query ="SELECT * FROM SERVICES")
public class Service {
    private int serviceId;
    private String serviceName;
    private int providerId;
    private Boolean isMeter;
    private Collection<Abonent> abonentsByServiceId;
    private Provider providerByProviderId;
    private Collection<Registration> registrationsByServiceId;

    public Service() {
    }

    public Service(int serviceId, String serviceName, int providerId, Boolean isMeter) {

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
    @Convert(converter = BooleanConverter.class)
    public Boolean getIsMeter() {
        return isMeter;
    }

    public void setIsMeter(Boolean isMeter) {
        this.isMeter = isMeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (serviceId != service.serviceId) return false;
        if (providerId != service.providerId) return false;
        if (isMeter != service.isMeter) return false;
        if (serviceName != null ? !serviceName.equals(service.serviceName) : service.serviceName != null) return false;
        if (abonentsByServiceId != null ? !abonentsByServiceId.equals(service.abonentsByServiceId) : service.abonentsByServiceId != null)
            return false;
        return providerByProviderId != null ? providerByProviderId.equals(service.providerByProviderId) : service.providerByProviderId == null;

    }

    @Override
    public int hashCode() {
        int result = serviceId;
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + providerId;
        result = 31 * result + (isMeter ? 1 : 0);
        result = 31 * result + (abonentsByServiceId != null ? abonentsByServiceId.hashCode() : 0);
        result = 31 * result + (providerByProviderId != null ? providerByProviderId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "serviceByServiceId")
    public Collection<Abonent> getAbonentsByServiceId() {
        return abonentsByServiceId;
    }

    public void setAbonentsByServiceId(Collection<Abonent> abonentsesByServiceId) {
        this.abonentsByServiceId = abonentsesByServiceId;
    }

    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID", referencedColumnName = "PROVIDER_ID", nullable = false, insertable = false, updatable = false)
    public Provider getProviderByProviderId() {
        return providerByProviderId;
    }

    public void setProviderByProviderId(Provider providersByProviderId) {
        this.providerByProviderId = providersByProviderId;
    }

    @OneToMany(mappedBy = "serviceByServiceId")
    public Collection<Registration> getRegistrationsByServiceId() {
        return registrationsByServiceId;
    }

    public void setRegistrationsByServiceId(Collection<Registration> registrationsByServiceId) {
        this.registrationsByServiceId = registrationsByServiceId;
    }
}
