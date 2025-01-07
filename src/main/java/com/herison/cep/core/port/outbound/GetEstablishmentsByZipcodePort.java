package com.herison.cep.core.port.outbound;

import com.herison.cep.core.domain.EstablishmentsByZipcode;

public interface GetEstablishmentsByZipcodePort {
    EstablishmentsByZipcode get(String zipcode);
}
