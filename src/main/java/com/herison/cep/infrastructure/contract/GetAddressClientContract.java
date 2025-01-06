package com.herison.cep.infrastructure.contract;


import com.herison.cep.core.dtos.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "get-address",
url = "${get.address-url}")
public interface GetAddressClientContract {

    @GetMapping("/zipcode/{zipcode}/json")
    AddressResponse searchZipCode(@PathVariable("zipcode") String zipcode);
}
