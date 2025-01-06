package com.herison.cep.adapter.outbound.repository;

import com.herison.cep.core.domain.AddressZipCode;
import com.herison.cep.core.domain.Establishment;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "establishments_by_zipcode")
public class EstablishmentByZipcodeEntity {

    @Id
    private String id;
    private AddressZipCode addressZipCode;
    private List<Establishment> establishmentList;

    public EstablishmentByZipcodeEntity() {}

    public EstablishmentByZipcodeEntity(AddressZipCode addressZipCode, List<Establishment> establishmentList) {
        this.addressZipCode = addressZipCode;
        this.establishmentList = establishmentList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}
