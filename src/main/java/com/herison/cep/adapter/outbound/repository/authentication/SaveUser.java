package com.herison.cep.adapter.outbound.repository.authentication;

import com.herison.cep.adapter.authentication.User;
import com.herison.cep.adapter.outbound.repository.log.LogUserEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SaveUser {

    private final MongoTemplate zipcodeMongoTemplate;
    private final MongoTemplate logsMongoTemplate;

    public SaveUser(@Qualifier("zipcodeMongoTemplate")  MongoTemplate zipcodeMongoTemplate,
                                      @Qualifier("logsMongoTemplate")  MongoTemplate logsMongoTemplate) {
        this.zipcodeMongoTemplate = zipcodeMongoTemplate;
        this.logsMongoTemplate = logsMongoTemplate;
    }

    @Transactional
    public void save(User user) {
        try {
            saveLog(zipcodeMongoTemplate.save(user));
        } catch (Exception e) {
            throw new RuntimeException("Error saving User", e);
        }

    }

    private void saveLog(User user){
        LogUserEntity log = new LogUserEntity();
        log.setUserDetails(user);
        logsMongoTemplate.save(log);
    }
}
