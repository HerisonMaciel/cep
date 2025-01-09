package com.herison.cep.core.port.inbound;

import com.herison.cep.adapter.inbound.response.EstablishmentsByZipcodeResponse;

public interface EstablishmentsByZipcodeContract {

    EstablishmentsByZipcodeResponse execute(String zipcode);

}
