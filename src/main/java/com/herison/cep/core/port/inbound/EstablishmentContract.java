package com.herison.cep.core.port.inbound;

import com.herison.cep.core.dtos.EstablishmentResponse;

public interface EstablishmentContract {

    EstablishmentResponse execute(String zipcode);

}
