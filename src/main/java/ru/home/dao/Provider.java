package ru.home.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Иван on 11.06.2016.
 */
@Entity
@Table(name = "PROVIDERS", schema = "PAYMENT")
//@NamedQuery(name="PROVIDERS.findAll", query ="SELECT * FROM PROVIDERS")
public class Provider {
    private int providerId;
    private String providerName;
    private String providerAddress;
    private Collection<Service> servicesByProviderId;

    public Provider() {
    }

    public Provider(int providerId, String providerName, String providerAddress) {

        this.providerId = providerId;
        this.providerName = providerName;
        this.providerAddress = providerAddress;
    }

    public Provider(String providerName, String providerAddress)
    {
        this.providerId = new Provider().getProviderId();
        this.providerName = providerName;
        this.providerAddress = providerAddress;
    }

    @Id
    @GenericGenerator(name = "nextval", strategy = "increment")
    @GeneratedValue(generator = "nextval")
    @Column(name = "PROVIDER_ID", nullable = false, unique = true/*, precision = 0 */)
    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    @Basic
    @Column(name = "PROVIDER_NAME", nullable = true, length = 20)
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @Basic
    @Column(name = "PROVIDER_ADDRESS", nullable = true, length = 50)
    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Provider that = (Provider) o;

        if (providerId != that.providerId) return false;
        if (providerName != null ? !providerName.equals(that.providerName) : that.providerName != null) return false;
        if (providerAddress != null ? !providerAddress.equals(that.providerAddress) : that.providerAddress != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = providerId;
        result = 31 * result + (providerName != null ? providerName.hashCode() : 0);
        result = 31 * result + (providerAddress != null ? providerAddress.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "providerByProviderId")
    public Collection<Service> getServicesByProviderId() {
        return servicesByProviderId;
    }

    public void setServicesByProviderId(Collection<Service> servicesByProviderId) {
        this.servicesByProviderId = servicesByProviderId;
    }
}
