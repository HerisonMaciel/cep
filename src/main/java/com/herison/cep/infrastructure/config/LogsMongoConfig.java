package com.herison.cep.infrastructure.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = "com.herison.cep.adapter.outbound.repository",
        mongoTemplateRef = "logsMongoTemplate"
)
public class LogsMongoConfig {

    @Bean(name = "logsMongoTemplate")
    public MongoTemplate logsMongoTemplate() {
        MongoClient mongoClient = MongoClients.create("mongodb://root:log123@localhost:27018/logs?authSource=admin");
        return new MongoTemplate(mongoClient, "logs");
    }
}
