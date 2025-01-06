package com.herison.cep.infrastructure;


import com.herison.cep.core.dtos.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "get-address",
url = "${get.address-url}")
public interface GetAddressClient {

    @GetMapping("/zipcode/{zipcode}/json")
    AddressResponse buscarCep(@PathVariable("zipcode") String zipcode);
}
