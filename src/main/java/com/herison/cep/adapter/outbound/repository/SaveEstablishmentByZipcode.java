package com.herison.cep.adapter.outbound.repository;

import com.herison.cep.core.domain.EstablishmentsByZipcode;
import com.herison.cep.core.port.outbound.SaveEstablishmentsByZipcodePort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SaveEstablishmentByZipcode implements SaveEstablishmentsByZipcodePort {

    private final EstablishmentByZipcodeRepository establishmentByZipcodeRepository;

    public SaveEstablishmentByZipcode(EstablishmentByZipcodeRepository establishmentByZipcodeRepository) {
        this.establishmentByZipcodeRepository = establishmentByZipcodeRepository;
    }


    @Override
    @Transactional
    public EstablishmentsByZipcode save(EstablishmentsByZipcode establishmentsByZipcode) {
        try {
            EstablishmentByZipcodeEntity establishmentByZipcodeEntity = new EstablishmentByZipcodeEntity();
            establishmentByZipcodeEntity.setZipcode(establishmentsByZipcode.getZipcode());
            establishmentByZipcodeEntity.setAddressZipCode(establishmentsByZipcode.getAddressZipCode());
            establishmentByZipcodeEntity.setEstablishmentList(establishmentsByZipcode.getEstablishmentList());

            establishmentByZipcodeEntity = establishmentByZipcodeRepository.save(establishmentByZipcodeEntity);

            establishmentsByZipcode.setCreatedAt(establishmentByZipcodeEntity.getCreatedAt());
            establishmentsByZipcode.setUpdatedAt(establishmentByZipcodeEntity.getUpdatedAt());

        } catch (Exception e) {
            throw new RuntimeException("Error saving EstablishmentByZipcode", e);
        }

        return establishmentsByZipcode;
    }

}
