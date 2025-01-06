package com.herison.cep.infrastructure.contract;

import com.herison.cep.core.dtos.EstablishmentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "get-establishment",
        url = "${get.establishment-url}")
public interface GetEstablishmentClientContract {

    @GetMapping("/establishment/{zipcode}/json")
    EstablishmentResponse searchEstablishment(@PathVariable("zipcode") String zipcode);
}
