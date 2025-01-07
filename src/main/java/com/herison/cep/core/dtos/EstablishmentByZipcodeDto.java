package com.herison.cep.core.dtos;

import java.util.List;

public record EstablishmentByZipcodeDto(
        String zipcode,
        AddressResponse addressResponse,
        List<EstablishmentResponse> establishmentResponse) {

}
