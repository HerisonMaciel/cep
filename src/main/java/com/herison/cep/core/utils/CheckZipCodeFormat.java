package com.herison.cep.core.utils;

import com.herison.cep.infrastructure.exception.ZipCodeIncorrectException;

public class CheckZipCodeFormat {

    public String check(String zipcode){
        if (zipcode == null || zipcode.isEmpty()) {throw new NullPointerException();}

        String zipCodeFormat = zipcode.replaceAll("[^\\d]", "");

        if (zipCodeFormat.length() != 8) {
            throw new ZipCodeIncorrectException(zipcode);
        }
        return zipCodeFormat;
    }
}
