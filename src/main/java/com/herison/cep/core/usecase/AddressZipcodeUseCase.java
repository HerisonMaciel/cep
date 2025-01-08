package com.herison.cep.core.usecase;

import com.herison.cep.core.dtos.AddressResponse;
import com.herison.cep.core.port.inbound.AddressZipcodeContract;
import com.herison.cep.infrastructure.contract.GetAddressClientContract;

public class AddressZipcodeUseCase implements AddressZipcodeContract {

    private final GetAddressClientContract getAddressClientContract;

    public AddressZipcodeUseCase(GetAddressClientContract getAddressClientContract) {
        this.getAddressClientContract = getAddressClientContract;
    }

    @Override
    public AddressResponse execute(String zipcode) {
        try {
            return getAddressClientContract.searchZipCode(zipcode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
