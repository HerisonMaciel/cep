package com.herison.cep.adapter.controller;

import com.herison.cep.adapter.inbound.response.EstablishmentsByZipcodeResponse;
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

    @Override
    @GetMapping("/{zipcode}")
    public ResponseEntity<EstablishmentsByZipcodeResponse> searchEstablishment(@PathVariable String zipcode){
        return null;
    }

}
