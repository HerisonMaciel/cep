package com.herison.cep.adapter.outbound.repository;

import com.herison.cep.core.domain.AddressZipCode;
import com.herison.cep.core.domain.Establishment;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@Document(collection = "establishments_by_zipcode")
public class EstablishmentByZipcodeEntity {

    @Id
    private String zipcode;
    private AddressZipCode addressZipCode;
    private List<Establishment> establishmentList;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Version
    private Integer version;

    public EstablishmentByZipcodeEntity() {}

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public AddressZipCode getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(AddressZipCode addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public List<Establishment> getEstablishmentList() {
        return establishmentList;
    }

    public void setEstablishmentList(List<Establishment> establishmentList) {
        this.establishmentList = establishmentList;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "EstablishmentByZipcodeEntity{" +
                "zipcode='" + zipcode + '\'' +
                ", addressZipCode=" + addressZipCode +
                ", establishmentList=" + establishmentList +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", version=" + version +
                '}';
    }
}

