package com.herison.cep.infrastructure;

import com.herison.cep.core.port.inbound.AddressZipcodeContract;
import com.herison.cep.core.port.inbound.EstablishmentContract;
import com.herison.cep.core.port.inbound.EstablishmentsByZipcodeContract;
import com.herison.cep.core.port.outbound.GetEstablishmentsByZipcodePort;
import com.herison.cep.core.port.outbound.SaveEstablishmentsByZipcodePort;
import com.herison.cep.core.usecase.AddressZipcodeUseCase;
import com.herison.cep.core.usecase.EstablishmentUseCase;
import com.herison.cep.core.usecase.EstablishmentsByZipcodeUseCase;
import com.herison.cep.infrastructure.contract.GetAddressClientContract;
import com.herison.cep.infrastructure.contract.GetEstablishmentClientContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public AddressZipcodeContract createAddressUseCasePort(GetAddressClientContract getAddressClientContract) {
        return new AddressZipcodeUseCase(getAddressClientContract);
    }

    @Bean
    public EstablishmentContract createEstablishmentUseCasePort(GetEstablishmentClientContract getEstablishmentClientContract) {
        return new EstablishmentUseCase(getEstablishmentClientContract);
    }

    @Bean
    public EstablishmentsByZipcodeContract createEstablishmentbyZipCodePort(
            AddressZipcodeContract addressZipcodeContract,
            EstablishmentContract establishmentContract,
            SaveEstablishmentsByZipcodePort saveEstablishmentsByZipcodePort,
            GetEstablishmentsByZipcodePort getEstablishmentsByZipcodePort) {
        return new EstablishmentsByZipcodeUseCase(
                addressZipcodeContract,
                establishmentContract,
                saveEstablishmentsByZipcodePort,
                getEstablishmentsByZipcodePort);
    }

}
