package com.herison.cep.adapter.controller;

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
    public ResponseEntity<Void> searchEstablishment(@PathVariable String zipcode){
        System.out.println("ZipCode: " + zipcode);
        return null;
    }

}
