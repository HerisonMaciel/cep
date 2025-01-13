package com.herison.cep.adapter.outbound.repository.authentication;

import com.herison.cep.adapter.authentication.User;
import com.herison.cep.adapter.outbound.repository.log.LogUserEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GetUser {

    private final MongoTemplate zipcodeMongoTemplate;
    private final MongoTemplate logsMongoTemplate;

    public GetUser(@Qualifier("zipcodeMongoTemplate")  MongoTemplate zipcodeMongoTemplate,
                                     @Qualifier("logsMongoTemplate")  MongoTemplate logsMongoTemplate) {
        this.zipcodeMongoTemplate = zipcodeMongoTemplate;
        this.logsMongoTemplate = logsMongoTemplate;
    }

    @Transactional
    public UserDetails findByLogin(String login){

        Query query = new Query();
        query.addCriteria(Criteria.where("login").is(login));

        User response = zipcodeMongoTemplate.findOne(query, User.class);

        if (response != null) {
            saveLog(response);
            return response;
        }

        return null;
    }

    private void saveLog(UserDetails userDetails){

        LogUserEntity log = new LogUserEntity();
        log.setUserDetails(userDetails);

        logsMongoTemplate.save(log);
    }

    private void findAll(){
        zipcodeMongoTemplate.findAll(GetUser.class);

    }

}
