package com.herison.cep.core.port.inbound;

import com.herison.cep.core.domain.AddressZipCode;
import com.herison.cep.core.dtos.AddressResponse;

public interface AddressZipcodeContract {

    AddressResponse execute(String zipcode);

}
