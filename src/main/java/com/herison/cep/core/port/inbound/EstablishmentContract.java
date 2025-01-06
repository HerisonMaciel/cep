package com.herison.cep.core.port.inbound;

import com.herison.cep.core.domain.Establishment;

public interface EstablishmentContract {

    Establishment execute(String zipcode);

}
