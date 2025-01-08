package com.herison.cep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ZipCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipCodeApplication.class, args);
	}

}
