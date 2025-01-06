package com.herison.cep.core.usecase;

import com.herison.cep.adapter.inbound.response.EstablishmentsByZipcodeResponse;
import com.herison.cep.core.dtos.AddressResponse;
import com.herison.cep.core.dtos.EstablishmentByZipcodeDto;
import com.herison.cep.core.dtos.EstablishmentResponse;
import com.herison.cep.core.port.inbound.AddressZipcodeContract;
import com.herison.cep.core.port.inbound.EstablishmentContract;
import com.herison.cep.core.port.inbound.EstablishmentsByZipcodeContract;

public class EstablishmentsByZipcodeUseCase implements EstablishmentsByZipcodeContract {

    private final AddressZipcodeContract addressZipcodeContract;
    private final EstablishmentContract establishmentContract;


    public EstablishmentsByZipcodeUseCase(AddressZipcodeContract addressZipcodeContract, EstablishmentContract establishmentContract) {
        this.addressZipcodeContract = addressZipcodeContract;
        this.establishmentContract = establishmentContract;
    }

    @Override
    public EstablishmentsByZipcodeResponse execute(String zipcode){

        var addressResponse = addressZipcodeContract.execute(zipcode);
        var establishmentResponse = establishmentContract.execute(zipcode);

        var dto = junction(addressResponse, establishmentResponse);


        System.out.println("Address: " + dto.addressResponse().toString());
        System.out.println("establishment: " + dto.establishmentResponse().toString());



        return null;
    }

    private EstablishmentByZipcodeDto junction(
            AddressResponse addressResponse,
            EstablishmentResponse establishmentResponse){
        return new EstablishmentByZipcodeDto(addressResponse, establishmentResponse);
    }

}
