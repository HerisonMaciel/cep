package com.herison.cep.core.usecase;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.herison.cep.core.dtos.EstablishmentResponse;
import com.herison.cep.infrastructure.contract.GetEstablishmentClientContract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EstablishmentUseCaseTest {

    @Mock
    private GetEstablishmentClientContract getEstablishmentClientContract;

    private EstablishmentUseCase establishmentUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        establishmentUseCase = new EstablishmentUseCase(getEstablishmentClientContract);
    }

    @Test
    void testExecute_ShouldReturnEstablishmentList() {
        String zipcode = "60861125";

        EstablishmentResponse establishmentResponse1 = new EstablishmentResponse("Ze do Lanche", "443", "85988201399", "www.zedolanche.com.br");
        EstablishmentResponse establishmentResponse2 = new EstablishmentResponse("Lanchonete X", "500", "85999331122", "www.lanchoneteX.com.br");
        List<EstablishmentResponse> expectedList = List.of(establishmentResponse1, establishmentResponse2);

        when(getEstablishmentClientContract.searchEstablishment(zipcode)).thenReturn(expectedList);

        List<EstablishmentResponse> result = establishmentUseCase.execute(zipcode);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Ze do Lanche", result.get(0).name());
        assertEquals("Lanchonete X", result.get(1).name());

        verify(getEstablishmentClientContract, times(1)).searchEstablishment(zipcode);
    }

    @Test
    void testExecute_ShouldReturnEmptyListWhenNoEstablishments() {
        String zipcode = "00000000";

        when(getEstablishmentClientContract.searchEstablishment(zipcode)).thenReturn(List.of());

        List<EstablishmentResponse> result = establishmentUseCase.execute(zipcode);

        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(getEstablishmentClientContract, times(1)).searchEstablishment(zipcode);
    }

}

