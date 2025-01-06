package com.herison.cep.core.mapper;

import com.herison.cep.adapter.inbound.response.EstablishmentsByZipcodeResponse;
import com.herison.cep.core.domain.AddressZipCode;
import com.herison.cep.core.domain.Establishment;
import com.herison.cep.core.domain.EstablishmentsByZipcode;
import com.herison.cep.core.dtos.AddressResponse;
import com.herison.cep.core.dtos.EstablishmentByZipcodeDto;
import com.herison.cep.core.dtos.EstablishmentResponse;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EstablishmentsByZipcodeMapper {

    public static EstablishmentsByZipcode toEntity(EstablishmentByZipcodeDto dto) {
        if (dto == null) {
            return null;
        }

        AddressZipCode addressZipCode = mapAddressResponse(dto.addressResponse());
        List<Establishment> establishments = mapEstablishmentResponse(dto.establishmentResponse());

        return new EstablishmentsByZipcode(addressZipCode, establishments);
    }

    public static EstablishmentsByZipcodeResponse toDto(EstablishmentsByZipcode entity) {
        if (entity == null) {
            return null;
        }

        AddressResponse addressResponse = mapAddressZipCode(entity.getAddressZipCode());
        List<EstablishmentResponse> establishmentResponse = mapEstablishmentList(entity.getEstablishmentList());

        return new EstablishmentsByZipcodeResponse(addressResponse, establishmentResponse);
    }

    private static AddressZipCode mapAddressResponse(AddressResponse addressResponse) {
        if (addressResponse == null) {
            return null;
        }

        return new AddressZipCode(
                addressResponse.cep(),
                addressResponse.logradouro(),
                addressResponse.complemento(),
                addressResponse.unidade(),
                addressResponse.bairro(),
                addressResponse.localidade(),
                addressResponse.uf(),
                addressResponse.estado(),
                addressResponse.regiao(),
                addressResponse.ibge(),
                addressResponse.gia(),
                addressResponse.ddd(),
                addressResponse.siafi()
        );
    }

    private static List<Establishment> mapEstablishmentResponse(EstablishmentResponse establishmentResponse) {
        if (establishmentResponse == null) {
            return Collections.emptyList();
        }

        Establishment establishment = new Establishment(
                establishmentResponse.name(),
                establishmentResponse.number(),
                establishmentResponse.contact(),
                establishmentResponse.site()
        );

        return List.of(establishment);
    }

    private static AddressResponse mapAddressZipCode(AddressZipCode addressZipCode) {
        if (addressZipCode == null) {
            return null;
        }

        return new AddressResponse(
                addressZipCode.getCep(),
                addressZipCode.getLogradouro(),
                addressZipCode.getComplemento(),
                addressZipCode.getUnidade(),
                addressZipCode.getBairro(),
                addressZipCode.getLocalidade(),
                addressZipCode.getUf(),
                addressZipCode.getEstado(),
                addressZipCode.getRegiao(),
                addressZipCode.getIbge(),
                addressZipCode.getGia(),
                addressZipCode.getDdd(),
                addressZipCode.getSiafi()
        );
    }

    private static List<EstablishmentResponse> mapEstablishmentList(List<Establishment> establishmentList) {
        if (establishmentList == null || establishmentList.isEmpty()) {
            return Collections.emptyList();
        }

        return establishmentList.stream()
                .map(establishment -> new EstablishmentResponse(
                        establishment.getName(),
                        establishment.getNumber(),
                        establishment.getContact(),
                        establishment.getSite()))
                .collect(Collectors.toList());
    }
}


