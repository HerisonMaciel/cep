package com.herison.cep.core.domain;

import java.time.LocalDateTime;
import java.util.List;

public class EstablishmentsByZipcode {

    private String zipcode;
    private AddressZipCode addressZipCode;
    private List<Establishment> establishmentList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public EstablishmentsByZipcode(){}

    public EstablishmentsByZipcode(String zipcode, AddressZipCode addressZipCode, List<Establishment> establishmentList) {
        this.zipcode = zipcode;
        this.addressZipCode = addressZipCode;
        this.establishmentList = establishmentList;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setAddressZipCode(AddressZipCode addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public AddressZipCode getAddressZipCode() {
        return addressZipCode;
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

    @Override
    public String toString() {
        return "EstablishmentsByZipcode{" +
                "zipcode='" + zipcode + '\'' +
                ", addressZipCode=" + addressZipCode +
                ", establishmentList=" + establishmentList +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
