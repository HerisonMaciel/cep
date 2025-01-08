package com.herison.cep.core.usecase;

import com.herison.cep.core.dtos.EstablishmentResponse;
import com.herison.cep.core.port.inbound.EstablishmentContract;
import com.herison.cep.infrastructure.contract.GetEstablishmentClientContract;

import java.util.List;

public class EstablishmentUseCase implements EstablishmentContract {


    private final GetEstablishmentClientContract getEstablishmentClientContract;

    public EstablishmentUseCase(GetEstablishmentClientContract getEstablishmentClientContract) {
        this.getEstablishmentClientContract = getEstablishmentClientContract;
    }

    public List<EstablishmentResponse> execute(String zipcode){
        try {
            return getEstablishmentClientContract.searchEstablishment(zipcode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
