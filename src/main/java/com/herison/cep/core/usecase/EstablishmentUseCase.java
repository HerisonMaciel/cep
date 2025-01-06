package com.herison.cep.core.usecase;

import com.herison.cep.core.dtos.EstablishmentResponse;
import com.herison.cep.core.port.inbound.EstablishmentContract;
import com.herison.cep.core.utils.CheckZipCodeFormat;
import com.herison.cep.infrastructure.contract.GetEstablishmentClientContract;
import com.herison.cep.infrastructure.exception.ZipCodeIncorrectException;

public class EstablishmentUseCase implements EstablishmentContract {


    private final GetEstablishmentClientContract getEstablishmentClientContract;
    //private final CheckZipCodeFormat checkZipCodeFormat;

    public EstablishmentUseCase(GetEstablishmentClientContract getEstablishmentClientContract) {
        this.getEstablishmentClientContract = getEstablishmentClientContract;
    }

    public EstablishmentResponse execute(String zipcode){
        var zipCodeFormat = checkZipCodeFormat(zipcode);
        return getEstablishmentClientContract.searchEstablishment(zipCodeFormat);
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
