package com.herison.cep.core.usecase;

import com.herison.cep.core.domain.AddressZipCode;
import com.herison.cep.core.dtos.AddressResponse;
import com.herison.cep.core.port.inbound.AddressZipcodeContract;
import com.herison.cep.infrastructure.GetAddressClient;

public class AddressZipcodeUseCase implements AddressZipcodeContract {

    private final GetAddressClient getAddressClient;

    public AddressZipcodeUseCase(GetAddressClient getAddressClient) {
        this.getAddressClient = getAddressClient;
    }

    @Override
    public AddressZipCode execute(String zipcode) {
        AddressResponse addressResponse = getAddressClient.buscarCep(zipcode);
        System.out.println("CORE: " + addressResponse.toString());
        return null;
    }

}
