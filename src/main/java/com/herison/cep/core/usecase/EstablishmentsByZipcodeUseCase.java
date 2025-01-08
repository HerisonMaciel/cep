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
import com.herison.cep.core.port.outbound.GetEstablishmentsByZipcodePort;
import com.herison.cep.core.port.outbound.SaveEstablishmentsByZipcodePort;
import com.herison.cep.infrastructure.exception.ZipCodeIncorrectException;

import java.util.List;
import java.util.Optional;

public class EstablishmentsByZipcodeUseCase implements EstablishmentsByZipcodeContract {

    private final AddressZipcodeContract addressZipcodeContract;
    private final EstablishmentContract establishmentContract;
    private final SaveEstablishmentsByZipcodePort saveEstablishmentsByZipcodePort;
    private final GetEstablishmentsByZipcodePort getEstablishmentsByZipcodePort;

    public EstablishmentsByZipcodeUseCase(AddressZipcodeContract addressZipcodeContract,
                                          EstablishmentContract establishmentContract,
                                          SaveEstablishmentsByZipcodePort saveEstablishmentsByZipcodePort,
                                          GetEstablishmentsByZipcodePort getEstablishmentsByZipcodePort) {
        this.addressZipcodeContract = addressZipcodeContract;
        this.establishmentContract = establishmentContract;
        this.saveEstablishmentsByZipcodePort = saveEstablishmentsByZipcodePort;
        this.getEstablishmentsByZipcodePort = getEstablishmentsByZipcodePort;
    }

    @Override
    public EstablishmentsByZipcodeResponse execute(String zipcode) {
        var zipcodeFormt = checkZipCodeFormat(zipcode);

        return Optional.ofNullable(getEstablishmentsByZipcodePort.get(zipcodeFormt))
                .map(this::mapEntityToResponse)
                .orElseGet(() -> handleNewZipcode(zipcodeFormt));
    }

    private EstablishmentsByZipcodeResponse mapEntityToResponse(EstablishmentsByZipcode existingEntity) {
        var response = EstablishmentsByZipcodeMapper.toDto(existingEntity);
        response.setCreatedAt(existingEntity.getCreatedAt());
        response.setUpdatedAt(existingEntity.getUpdatedAt());
        return response;
    }

    private EstablishmentsByZipcodeResponse handleNewZipcode(String zipcode) {
        var addressResponse = addressZipcodeContract.execute(zipcode);
        var establishmentResponse = establishmentContract.execute(zipcode);

        var dto = junction(zipcode, addressResponse, establishmentResponse);

        EstablishmentsByZipcode entity = EstablishmentsByZipcodeMapper.toEntity(dto);
        var savedEntity = saveEstablishmentsByZipcodePort.save(entity);

        return EstablishmentsByZipcodeMapper.toDto(savedEntity);
    }

    private EstablishmentByZipcodeDto junction(String zipcode, AddressResponse addressResponse, List<EstablishmentResponse> establishmentResponse) {
        return new EstablishmentByZipcodeDto(zipcode, addressResponse, establishmentResponse);
    }


    private String checkZipCodeFormat(String zipcode) {
        if (zipcode == null || zipcode.isEmpty()) {
            throw new NullPointerException("Zipcode cannot be null or empty.");
        }

        String zipCodeFormat = zipcode.replaceAll("[^\\d]", "");
        if (zipCodeFormat.length() != 8) {
            throw new ZipCodeIncorrectException(zipcode);
        }
        return zipCodeFormat;
    }
}

