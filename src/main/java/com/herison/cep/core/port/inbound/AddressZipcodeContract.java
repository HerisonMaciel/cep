package com.herison.cep.core.port.inbound;

import com.herison.cep.core.domain.AddressZipCode;

public interface AddressZipcodeContract {

    AddressZipCode execute(String zipcode);

}
