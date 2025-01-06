package com.herison.cep.adapter.outbound.repository;

import com.herison.cep.core.domain.EstablishmentsByZipcode;
import com.herison.cep.core.port.outbound.SaveEstablishmentsByZipcodePort;
import org.springframework.stereotype.Component;

@Component
public class SaveEstablishmentByZipcode implements SaveEstablishmentsByZipcodePort {

    private final EstablishmentByZipcodeRepository establishmentByZipcodeRepository;

    public SaveEstablishmentByZipcode(EstablishmentByZipcodeRepository establishmentByZipcodeRepository) {
        this.establishmentByZipcodeRepository = establishmentByZipcodeRepository;
    }

    @Override
    public EstablishmentsByZipcode save(EstablishmentsByZipcode establishmentsByZipcode) {

        EstablishmentByZipcodeEntity establishmentByZipcodeEntity = new EstablishmentByZipcodeEntity();

        establishmentByZipcodeEntity.setAddressZipCode(establishmentsByZipcode.getAddressZipCode());
        establishmentByZipcodeEntity.setEstablishmentList(establishmentsByZipcode.getEstablishmentList());

        establishmentsByZipcode.setId(establishmentByZipcodeRepository.save(establishmentByZipcodeEntity).getId());

        return establishmentsByZipcode;
    }

}
