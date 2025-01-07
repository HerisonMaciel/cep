package com.herison.cep.core.port.inbound;

import com.herison.cep.core.dtos.EstablishmentResponse;

import java.util.List;

public interface EstablishmentContract {

    List<EstablishmentResponse> execute(String zipcode);

}
