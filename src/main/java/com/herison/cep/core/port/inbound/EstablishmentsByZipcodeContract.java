package com.herison.cep.core.port.inbound;


import com.herison.cep.core.domain.EstablishmentsByZipcode;

public interface EstablishmentsByZipcodeContract {
    EstablishmentsByZipcode excute(String zipcode);
}
