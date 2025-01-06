package com.herison.cep.infrastructure;

import com.herison.cep.core.port.inbound.AddressZipcodeContract;
import com.herison.cep.core.usecase.AddressZipcodeUseCase;
import com.herison.cep.infrastructure.contract.GetAddressClientContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public AddressZipcodeContract createAddressUseCasePort(GetAddressClientContract getAddressClientContract) {
        return new AddressZipcodeUseCase(getAddressClientContract);
    }

}
