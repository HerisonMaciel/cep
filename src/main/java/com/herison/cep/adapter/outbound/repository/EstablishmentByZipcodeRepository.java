package com.herison.cep.adapter.outbound.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentByZipcodeRepository extends MongoRepository<EstablishmentByZipcodeEntity, String> {

    EstablishmentByZipcodeEntity findByZipcode(String zipcode);

}
