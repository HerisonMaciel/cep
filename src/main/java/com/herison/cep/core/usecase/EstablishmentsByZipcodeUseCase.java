package com.herison.cep.core.usecase;

import com.herison.cep.adapter.inbound.response.EstablishmentsByZipcodeResponse;
import com.herison.cep.core.domain.EstablishmentsByZipcode;
import com.herison.cep.core.dtos.AddressResponse;
import com.herison.cep.core.dtos.EstablishmentByZipcodeDto;
import com.herison.cep.core.dtos.EstablishmentResponse;
import com.herison.cep.core.mapper.EstablishmentsByZipcodeMapper;
import com.herison.cep.core.port.inbound.AddressZipcodeContract;
import com.herison.cep.core.port.inbound.EstablishmentContract;
import com.herison.cep.core.port.inbound.EstablishmentsByZipcodeContract;
import com.herison.cep.core.port.outbound.SaveEstablishmentsByZipcodePort;

public class EstablishmentsByZipcodeUseCase implements EstablishmentsByZipcodeContract {

    private final AddressZipcodeContract addressZipcodeContract;
    private final EstablishmentContract establishmentContract;
    private final SaveEstablishmentsByZipcodePort saveEstablishmentsByZipcodePort;


    public EstablishmentsByZipcodeUseCase(AddressZipcodeContract addressZipcodeContract, EstablishmentContract establishmentContract, SaveEstablishmentsByZipcodePort saveEstablishmentsByZipcodePort) {
        this.addressZipcodeContract = addressZipcodeContract;
        this.establishmentContract = establishmentContract;
        this.saveEstablishmentsByZipcodePort = saveEstablishmentsByZipcodePort;
    }

    @Override
    public EstablishmentsByZipcodeResponse execute(String zipcode){

        var addressResponse = addressZipcodeContract.execute(zipcode);
        var establishmentResponse = establishmentContract.execute(zipcode);

        var dto = junction(addressResponse, establishmentResponse);

        EstablishmentsByZipcode entity = EstablishmentsByZipcodeMapper.toEntity(dto);

        var response = saveEstablishmentsByZipcodePort.save(entity);

        return EstablishmentsByZipcodeMapper.toDto(response);
    }

    private EstablishmentByZipcodeDto junction(
            AddressResponse addressResponse,
            EstablishmentResponse establishmentResponse){
        return new EstablishmentByZipcodeDto(addressResponse, establishmentResponse);
    }

}
