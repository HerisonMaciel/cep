package com.herison.cep.adapter.inbound.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EstablishmentResponse {

    private String name;
    private String number;
    private String contact;
    private String site;

}
