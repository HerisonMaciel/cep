package com.herison.cep.core.port.outbound;

import com.herison.cep.core.domain.EstablishmentsByZipcode;

public interface SaveEstablishmentsByZipcodePort {
    EstablishmentsByZipcode save(EstablishmentsByZipcode establishmentsByZipcode);
}
