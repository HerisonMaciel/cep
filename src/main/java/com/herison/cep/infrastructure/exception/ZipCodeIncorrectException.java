package com.herison.cep.infrastructure.exception;

public class ZipCodeIncorrectException extends RuntimeException {

    public ZipCodeIncorrectException(String zipcode) {
        super(String.format("incorrect zip code %s.", zipcode));
    }


}
