package com.herison.cep.adapter.inbound.response;

import com.herison.cep.core.dtos.AddressResponse;
import com.herison.cep.core.dtos.EstablishmentResponse;

import java.util.List;

public class EstablishmentsByZipcodeResponse {

    private String id;
    private AddressResponse addressResponse;
    private List<EstablishmentResponse> EstablishmentResponseList;

    public EstablishmentsByZipcodeResponse(AddressResponse addressResponse, List<EstablishmentResponse> establishmentResponseList) {
        this.addressResponse = addressResponse;
        EstablishmentResponseList = establishmentResponseList;
    }

    public EstablishmentsByZipcodeResponse(String id, AddressResponse addressResponse, List<EstablishmentResponse> establishmentResponseList) {
        this.id = id;
        this.addressResponse = addressResponse;
        EstablishmentResponseList = establishmentResponseList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
