package com.herison.cep.adapter.outbound.repository;

import com.herison.cep.core.domain.EstablishmentsByZipcode;
import com.herison.cep.core.port.outbound.GetEstablishmentsByZipcodePort;
import org.springframework.stereotype.Component;

@Component
public class GetEstablishmentByZipcode implements GetEstablishmentsByZipcodePort {

    private final EstablishmentByZipcodeRepository establishmentByZipcodeRepository;

    public GetEstablishmentByZipcode(EstablishmentByZipcodeRepository establishmentByZipcodeRepository) {
        this.establishmentByZipcodeRepository = establishmentByZipcodeRepository;
    }

    @Override
    public EstablishmentsByZipcode get(String zipcode) {

        var response = establishmentByZipcodeRepository.findByZipcode(zipcode);

        if(response != null){
            EstablishmentsByZipcode establishmentByZipcode = new EstablishmentsByZipcode();
            establishmentByZipcode.setZipcode(response.getZipcode());
            establishmentByZipcode.setAddressZipCode(response.getAddressZipCode());
            establishmentByZipcode.setEstablishmentList(response.getEstablishmentList());
            establishmentByZipcode.setCreatedAt(response.getCreatedAt());
            establishmentByZipcode.setUpdatedAt(response.getUpdatedAt());
            return establishmentByZipcode;
        }

        return null;
    }
}
