package com.herison.cep.adapter.outbound.repository;

import com.herison.cep.core.domain.EstablishmentsByZipcode;
import com.herison.cep.core.port.outbound.GetEstablishmentsByZipcodePort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.transaction.annotation.Transactional;


@Component
public class GetEstablishmentByZipcode implements GetEstablishmentsByZipcodePort {

    private final MongoTemplate zipcodeMongoTemplate;
    private final MongoTemplate logsMongoTemplate;

    public GetEstablishmentByZipcode(@Qualifier("zipcodeMongoTemplate")  MongoTemplate zipcodeMongoTemplate,
                                      @Qualifier("logsMongoTemplate")  MongoTemplate logsMongoTemplate) {
        this.zipcodeMongoTemplate = zipcodeMongoTemplate;
        this.logsMongoTemplate = logsMongoTemplate;
    }

    @Override
    @Transactional
    public EstablishmentsByZipcode get(String zipcode) {

        Query query = new Query();
        query.addCriteria(Criteria.where("zipcode").is(zipcode));

        EstablishmentByZipcodeEntity response = zipcodeMongoTemplate.findOne(query, EstablishmentByZipcodeEntity.class);

        if (response != null) {

            var establishmentByZipcode = createEstablishmentsByZipcode(response);
            saveLog(response);

            return establishmentByZipcode;
        }

        return null;
    }

    private EstablishmentsByZipcode createEstablishmentsByZipcode(
            EstablishmentByZipcodeEntity establishmentByZipcodeEntity){

        EstablishmentsByZipcode establishmentByZipcode = new EstablishmentsByZipcode();
        establishmentByZipcode.setZipcode(establishmentByZipcodeEntity.getZipcode());
        establishmentByZipcode.setAddressZipCode(establishmentByZipcodeEntity.getAddressZipCode());
        establishmentByZipcode.setEstablishmentList(establishmentByZipcodeEntity.getEstablishmentList());
        establishmentByZipcode.setCreatedAt(establishmentByZipcodeEntity.getCreatedAt());
        establishmentByZipcode.setUpdatedAt(establishmentByZipcodeEntity.getUpdatedAt());

        return establishmentByZipcode;
    }

    private void saveLog(EstablishmentByZipcodeEntity establishmentByZipcodeEntity){
        LogEntity log = new LogEntity();
        log.setEstablishmentByZipcodeEntity(establishmentByZipcodeEntity);
        log.setCreatedAt(establishmentByZipcodeEntity.getCreatedAt());

        logsMongoTemplate.save(log);
    }

}
