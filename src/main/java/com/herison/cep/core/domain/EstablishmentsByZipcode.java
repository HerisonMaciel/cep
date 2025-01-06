package com.herison.cep.core.domain;

import java.util.List;

public class EstablishmentsByZipcode {

    private String id;
    private AddressZipCode addressZipCode;
    private List<Establishment> establishmentList;

    public EstablishmentsByZipcode(){}

    public EstablishmentsByZipcode(AddressZipCode addressZipCode, List<Establishment> establishmentList) {
        this.addressZipCode = addressZipCode;
        this.establishmentList = establishmentList;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EstablishmentsByZipcode{" +
                "addressZipCode=" + addressZipCode +
                ", establishmentList=" + establishmentList +
                '}';
    }
}
