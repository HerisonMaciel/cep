package com.herison.cep.adapter.inbound.response;

import com.herison.cep.core.dtos.AddressResponse;
import com.herison.cep.core.dtos.EstablishmentResponse;
import lombok.Data;

import java.util.List;



public class EstablishmentsByZipcodeResponse {

    private AddressResponse addressResponse;
    private List<EstablishmentResponse> EstablishmentResponseList;

    public EstablishmentsByZipcodeResponse(AddressResponse addressResponse, List<EstablishmentResponse> establishmentResponseList) {
        this.addressResponse = addressResponse;
        EstablishmentResponseList = establishmentResponseList;
    }

    public static EstablishmentsByZipcodeResponse fromDomain(String zipcode){
        return null;
    }

    public AddressResponse getAddressResponse() {
        return addressResponse;
    }

    public void setAddressResponse(AddressResponse addressResponse) {
        this.addressResponse = addressResponse;
    }

    public List<EstablishmentResponse> getEstablishmentResponseList() {
        return EstablishmentResponseList;
    }

    public void setEstablishmentResponseList(List<EstablishmentResponse> establishmentResponseList) {
        EstablishmentResponseList = establishmentResponseList;
    }

    @Override
    public String toString() {
        return "EstablishmentsByZipcodeResponse{" +
                "addressResponse=" + addressResponse +
                ", EstablishmentResponseList=" + EstablishmentResponseList +
                '}';
    }
}
