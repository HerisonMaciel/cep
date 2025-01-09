package com.herison.cep.core.usecase;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.herison.cep.core.dtos.AddressResponse;
import com.herison.cep.infrastructure.contract.GetAddressClientContract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddressZipcodeUseCaseTest {

    @Mock
    private GetAddressClientContract getAddressClientContract;

    private AddressZipcodeUseCase addressZipcodeUseCase;

    @BeforeEach
    void setUp() {
        addressZipcodeUseCase = new AddressZipcodeUseCase(getAddressClientContract);
    }

    @Test
    void testExecute_ShouldReturnAddressResponse_WhenZipcodeIsValid() {
        String validZipcode = "60861124";
        AddressResponse expectedResponse = new AddressResponse(
                "60861-124",
                "Rua Corumbá",
                "",
                "", //
                "Boa Vista-Castelão",
                "Fortaleza",
                "CE",
                "Ceará",
                "Nordeste",
                "2304400",
                "",
                "85",
                "1389"
        );

        when(getAddressClientContract.searchZipCode(validZipcode)).thenReturn(expectedResponse);

        AddressResponse result = addressZipcodeUseCase.execute(validZipcode);

        assertNotNull(result);
        assertEquals(expectedResponse.cep(), result.cep());
        assertEquals(expectedResponse.logradouro(), result.logradouro());
        assertEquals(expectedResponse.bairro(), result.bairro());
        assertEquals(expectedResponse.localidade(), result.localidade());
        assertEquals(expectedResponse.uf(), result.uf());
        assertEquals(expectedResponse.estado(), result.estado());
        assertEquals(expectedResponse.regiao(), result.regiao());
        assertEquals(expectedResponse.ibge(), result.ibge());
        assertEquals(expectedResponse.gia(), result.gia());
        assertEquals(expectedResponse.ddd(), result.ddd());
        assertEquals(expectedResponse.siafi(), result.siafi());

        verify(getAddressClientContract).searchZipCode(validZipcode);
    }

    @Test
    void testExecute_ShouldReturnNull_WhenZipcodeNotFound() {
        String invalidZipcode = "00000000";

        when(getAddressClientContract.searchZipCode(invalidZipcode)).thenReturn(null);

        AddressResponse result = addressZipcodeUseCase.execute(invalidZipcode);

        assertNull(result);

        verify(getAddressClientContract).searchZipCode(invalidZipcode);
    }

    @Test
    void testExecute_ShouldHandleException_WhenSearchZipCodeThrowsException() {
        String errorZipcode = "60861999999";

        when(getAddressClientContract.searchZipCode(errorZipcode)).thenThrow(new RuntimeException("API error"));

        RuntimeException thrownException = assertThrows(RuntimeException.class, () -> {
            addressZipcodeUseCase.execute(errorZipcode);
        });

        assertEquals("API error", thrownException.getMessage());

        verify(getAddressClientContract).searchZipCode(errorZipcode);
    }

}


