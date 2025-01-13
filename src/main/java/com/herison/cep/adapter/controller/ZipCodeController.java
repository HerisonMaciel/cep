package com.herison.cep.adapter.controller;

import com.herison.cep.adapter.inbound.response.EstablishmentsByZipcodeResponse;
import com.herison.cep.core.port.inbound.EstablishmentsByZipcodeContract;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
@RequestMapping("/search")
@AllArgsConstructor
public class ZipCodeController implements ZipCodeControllerContract{

    private final EstablishmentsByZipcodeContract establishmentsByZipcodeContract;

    @Override
    @GetMapping("/{zipcode}")
    public ResponseEntity<EstablishmentsByZipcodeResponse> searchEstablishment(@PathVariable String zipcode){
        log.info("Get request search zipcode: " + zipcode);
        return ResponseEntity.ok(establishmentsByZipcodeContract.execute(zipcode));
    }

}
