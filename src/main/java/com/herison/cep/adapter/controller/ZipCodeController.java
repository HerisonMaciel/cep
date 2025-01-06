package com.herison.cep.adapter.controller;

import com.herison.cep.adapter.inbound.response.EstablishmentsByZipcodeResponse;
import com.herison.cep.core.port.inbound.AddressZipcodeContract;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/search")
public class ZipCodeController implements ZipCodeControllerContract{

    private final AddressZipcodeContract addressZipcodeContract;

    public ZipCodeController(AddressZipcodeContract addressZipcodeContract) {
        this.addressZipcodeContract = addressZipcodeContract;
    }

    @Override
    @GetMapping("/{zipcode}")
    public ResponseEntity<EstablishmentsByZipcodeResponse> searchEstablishment(@PathVariable String zipcode){
        System.out.println("Controller: " + addressZipcodeContract.execute(zipcode));
        //return ResponseEntity.ok(EstablishmentsByZipcodeResponse.fromDomain(getUserByIdUseCasePort.execute(userId)));
        return null;
    }

}
