package com.herison.cep.adapter.inbound.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class EstablishmentsByZipcodeResponse {

    private AddressZipCodeResponse addressZipCodeResponse;
    private List<EstablishmentResponse> establishmentResponseList;

    public static EstablishmentsByZipcodeResponse fromDomain(String zipcode){
        return null;
    }
}
