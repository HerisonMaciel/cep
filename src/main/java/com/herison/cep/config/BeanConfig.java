package com.herison.cep.config;

import com.herison.cep.core.port.inbound.AddressZipcodeContract;
import com.herison.cep.core.usecase.AddressZipcodeUseCase;
import com.herison.cep.infrastructure.GetAddressClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public AddressZipcodeContract createAddressUseCasePort(GetAddressClient getAddressClient) {
        return new AddressZipcodeUseCase(getAddressClient);
    }

}
