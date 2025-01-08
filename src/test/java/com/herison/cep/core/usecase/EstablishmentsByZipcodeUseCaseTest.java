package com.herison.cep.core.usecase;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.herison.cep.adapter.inbound.response.EstablishmentsByZipcodeResponse;
import com.herison.cep.core.domain.AddressZipCode;
import com.herison.cep.core.domain.Establishment;
import com.herison.cep.core.domain.EstablishmentsByZipcode;
import com.herison.cep.core.dtos.AddressResponse;
import com.herison.cep.core.dtos.EstablishmentResponse;
import com.herison.cep.core.port.inbound.AddressZipcodeContract;
import com.herison.cep.core.port.inbound.EstablishmentContract;
import com.herison.cep.core.port.outbound.GetEstablishmentsByZipcodePort;
import com.herison.cep.core.port.outbound.SaveEstablishmentsByZipcodePort;
import com.herison.cep.infrastructure.exception.ZipCodeIncorrectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;


public class EstablishmentsByZipcodeUseCaseTest {

    @Mock
    private AddressZipcodeContract addressZipcodeContract;
    @Mock
    private EstablishmentContract establishmentContract;
    @Mock
    private SaveEstablishmentsByZipcodePort saveEstablishmentsByZipcodePort;
    @Mock
    private GetEstablishmentsByZipcodePort getEstablishmentsByZipcodePort;

    private EstablishmentsByZipcodeUseCase establishmentsByZipcodeUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializa os mocks
        establishmentsByZipcodeUseCase = new EstablishmentsByZipcodeUseCase(
                addressZipcodeContract,
                establishmentContract,
                saveEstablishmentsByZipcodePort,
                getEstablishmentsByZipcodePort
        );
    }

    @Test
    void testExecute_ShouldReturnExistingDataWhenZipcodeExists() {
        String validZipcode = "60861124";

        AddressZipCode addressZipCode = new AddressZipCode(
                "60861124", "Rua Exemplo", "Complemento Exemplo", "Apt 101", "Bairro Exemplo",
                "Cidade Exemplo", "UF", "Estado Exemplo", "Região Exemplo", "IBGE", "GIA", "DDD", "SIAFI"
        );
        List<Establishment> establishmentList = List.of(
                new Establishment("Estabelecimento 1", "123", "Contato 1", "www.example1.com")
        );
        EstablishmentsByZipcode existingEntity = new EstablishmentsByZipcode(
                validZipcode, addressZipCode, establishmentList);

        when(getEstablishmentsByZipcodePort.get(validZipcode)).thenReturn(existingEntity);

        AddressResponse expectedAddressResponse = new AddressResponse(
                "60861124", "Rua Exemplo", "Complemento Exemplo", "Apt 101", "Bairro Exemplo",
                "Cidade Exemplo", "UF", "Estado Exemplo", "Região Exemplo", "IBGE", "GIA", "DDD", "SIAFI"
        );

        EstablishmentsByZipcodeResponse response = establishmentsByZipcodeUseCase.execute(validZipcode);

        assertNotNull(response);
        assertEquals(validZipcode, response.getZipcode());

        assertEquals(expectedAddressResponse, response.getAddressResponse());

        assertEquals("Estabelecimento 1", response.getEstablishmentResponseList().get(0).name());

        // Verificando se o método foi chamado corretamente
        verify(getEstablishmentsByZipcodePort, times(1)).get(validZipcode);
        verifyNoInteractions(addressZipcodeContract, establishmentContract, saveEstablishmentsByZipcodePort);
    }

    @Test
    void testExecute_ShouldCreateAndReturnNewDataWhenZipcodeNotFound() {
        String validZipcode = "60861124";

        when(getEstablishmentsByZipcodePort.get(validZipcode)).thenReturn(null);

        AddressResponse addressResponse = new AddressResponse(
                "60861124", "Rua Exemplo", "Complemento Exemplo", "Apt 101", "Bairro Exemplo",
                "Cidade Exemplo", "UF", "Estado Exemplo", "Região Exemplo", "IBGE", "GIA", "DDD", "SIAFI"
        );
        List<EstablishmentResponse> establishmentResponses = List.of(
                new EstablishmentResponse("Estabelecimento 1", "123", "Contato 1", "www.example1.com")
        );
        when(addressZipcodeContract.execute(validZipcode)).thenReturn(addressResponse);
        when(establishmentContract.execute(validZipcode)).thenReturn(establishmentResponses);

        EstablishmentsByZipcode newEntity = new EstablishmentsByZipcode(
                validZipcode, new AddressZipCode(addressResponse.cep(), addressResponse.logradouro(), addressResponse.logradouro(),
                addressResponse.unidade(), addressResponse.bairro(), addressResponse.localidade(), addressResponse.uf(),
                addressResponse.estado(), addressResponse.regiao(), addressResponse.ibge(), addressResponse.gia(), addressResponse.ddd(),
                addressResponse.siafi()),
                List.of(new Establishment("Estabelecimento 1", "123", "Contato 1", "www.example1.com"))
        );
        when(saveEstablishmentsByZipcodePort.save(any())).thenReturn(newEntity);

        EstablishmentsByZipcodeResponse response = establishmentsByZipcodeUseCase.execute(validZipcode);

        assertNotNull(response);
        assertEquals(validZipcode, response.getZipcode());
        assertEquals("Rua Exemplo", response.getAddressResponse().logradouro());
        assertEquals("Estabelecimento 1", response.getEstablishmentResponseList().get(0).name());

        verify(getEstablishmentsByZipcodePort, times(1)).get(validZipcode);
        verify(addressZipcodeContract, times(1)).execute(validZipcode);
        verify(establishmentContract, times(1)).execute(validZipcode);
        verify(saveEstablishmentsByZipcodePort, times(1)).save(any());
    }

    @Test
    void testExecute_ShouldThrowExceptionWhenZipcodeFormatIsInvalid() {
        String invalidZipcode = "6086";

        assertThrows(ZipCodeIncorrectException.class, () -> {
            establishmentsByZipcodeUseCase.execute(invalidZipcode);
        });

        verifyNoInteractions(addressZipcodeContract, establishmentContract, saveEstablishmentsByZipcodePort, getEstablishmentsByZipcodePort);
    }

    @Test
    void testExecute_ShouldThrowExceptionWhenZipcodeIsNull() {
        assertThrows(NullPointerException.class, () -> {
            establishmentsByZipcodeUseCase.execute(null);
        });

        verifyNoInteractions(addressZipcodeContract, establishmentContract, saveEstablishmentsByZipcodePort, getEstablishmentsByZipcodePort);
    }

    @Test
    void testExecute_ShouldThrowExceptionWhenZipcodeIsEmpty() {
        assertThrows(NullPointerException.class, () -> {
            establishmentsByZipcodeUseCase.execute("");
        });

        verifyNoInteractions(addressZipcodeContract, establishmentContract, saveEstablishmentsByZipcodePort, getEstablishmentsByZipcodePort);
    }
}


