package com.herison.cep.infrastructure;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(
        basePackages = "com.herison.cep.adapter.outbound.repository",
        mongoTemplateRef = "zipcodeMongoTemplate"
)
public class ZipCodeMongoConfig {

    @Primary
    @Bean(name = "zipcodeMongoTemplate")
    public MongoTemplate mongoTemplate() {
        MongoClient mongoClient = MongoClients.create("mongodb://root:cep123@localhost:27017/cep?authSource=admin");
        return new MongoTemplate(mongoClient, "cep");
    }

}
