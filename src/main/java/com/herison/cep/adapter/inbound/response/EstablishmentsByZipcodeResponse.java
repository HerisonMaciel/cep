package com.herison.cep.adapter.inbound.response;

import com.herison.cep.core.dtos.AddressResponse;
import com.herison.cep.core.dtos.EstablishmentResponse;

import java.time.LocalDateTime;
import java.util.List;

public class EstablishmentsByZipcodeResponse {

    private String zipcode;
    private AddressResponse addressResponse;
    private List<EstablishmentResponse> EstablishmentResponseList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public EstablishmentsByZipcodeResponse(String zipcode, AddressResponse addressResponse,
                                           List<EstablishmentResponse> establishmentResponseList,
                                           LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.zipcode = zipcode;
        this.addressResponse = addressResponse;
        EstablishmentResponseList = establishmentResponseList;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String id) {
        this.zipcode = zipcode;
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
        return "EstablishmentsByZipcodeResponse{" +
                "id='" + zipcode + '\'' +
                ", addressResponse=" + addressResponse +
                ", EstablishmentResponseList=" + EstablishmentResponseList +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
