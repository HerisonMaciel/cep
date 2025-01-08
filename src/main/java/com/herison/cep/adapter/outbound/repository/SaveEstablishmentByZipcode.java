package com.herison.cep.adapter.outbound.repository;

import com.herison.cep.core.domain.EstablishmentsByZipcode;
import com.herison.cep.core.port.outbound.SaveEstablishmentsByZipcodePort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SaveEstablishmentByZipcode implements SaveEstablishmentsByZipcodePort {

    private final MongoTemplate zipcodeMongoTemplate;
    private final MongoTemplate logsMongoTemplate;

    public SaveEstablishmentByZipcode(@Qualifier("zipcodeMongoTemplate")  MongoTemplate zipcodeMongoTemplate,
                                      @Qualifier("logsMongoTemplate")  MongoTemplate logsMongoTemplate) {
        this.zipcodeMongoTemplate = zipcodeMongoTemplate;
        this.logsMongoTemplate = logsMongoTemplate;
    }


    @Override
    @Transactional
    public EstablishmentsByZipcode save(EstablishmentsByZipcode establishmentsByZipcode) {
        try {

            var establishmentByZipcodeEntity = createEstablishmentByZipcodeEntity(establishmentsByZipcode);

            saveLog(zipcodeMongoTemplate.save(establishmentByZipcodeEntity));

            establishmentsByZipcode.setCreatedAt(establishmentByZipcodeEntity.getCreatedAt());
            establishmentsByZipcode.setUpdatedAt(establishmentByZipcodeEntity.getUpdatedAt());

        } catch (Exception e) {
            throw new RuntimeException("Error saving EstablishmentByZipcode", e);
        }

        return establishmentsByZipcode;
    }

    private EstablishmentByZipcodeEntity createEstablishmentByZipcodeEntity(
            EstablishmentsByZipcode establishmentsByZipcode){

        EstablishmentByZipcodeEntity establishmentByZipcodeEntity = new EstablishmentByZipcodeEntity();
        establishmentByZipcodeEntity.setZipcode(establishmentsByZipcode.getZipcode());
        establishmentByZipcodeEntity.setAddressZipCode(establishmentsByZipcode.getAddressZipCode());
        establishmentByZipcodeEntity.setEstablishmentList(establishmentsByZipcode.getEstablishmentList());

        return establishmentByZipcodeEntity;
    }

    private void saveLog(EstablishmentByZipcodeEntity establishmentByZipcodeEntity){
        LogEntity log = new LogEntity();
        log.setEstablishmentByZipcodeEntity(establishmentByZipcodeEntity);
        log.setCreatedAt(establishmentByZipcodeEntity.getCreatedAt());

        logsMongoTemplate.save(log);
    }

}
