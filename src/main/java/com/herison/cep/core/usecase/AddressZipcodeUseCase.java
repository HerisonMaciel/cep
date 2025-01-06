package com.herison.cep.core.usecase;

import com.herison.cep.core.domain.AddressZipCode;
import com.herison.cep.core.dtos.AddressResponse;
import com.herison.cep.core.port.inbound.AddressZipcodeContract;
import com.herison.cep.infrastructure.contract.GetAddressClientContract;
import com.herison.cep.infrastructure.exception.ZipCodeIncorrectException;

public class AddressZipcodeUseCase implements AddressZipcodeContract {

    private final GetAddressClientContract getAddressClientContract;

    public AddressZipcodeUseCase(GetAddressClientContract getAddressClientContract) {
        this.getAddressClientContract = getAddressClientContract;
    }

    @Override
    public AddressResponse execute(String zipcode) {

        var zipCodeFormat = checkZipCodeFormat(zipcode);
        return getAddressClientContract.buscarCep(zipCodeFormat);
    }

    private String checkZipCodeFormat(String zipcode){

        if (zipcode == null || zipcode.isEmpty()) {throw new NullPointerException();}

        String zipCodeFormat = zipcode.replaceAll("[^\\d]", "");

        if (zipCodeFormat.length() != 8) {
            throw new ZipCodeIncorrectException(zipcode);
        }
        return zipCodeFormat;
    }

}
