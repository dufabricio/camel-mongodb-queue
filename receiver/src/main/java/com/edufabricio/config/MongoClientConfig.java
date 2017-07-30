package com.edufabricio.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoClientConfig {

    @Bean
    public MongoClient mongoClientBean(){
        MongoClient mongoClient
                = new MongoClient("localhost",27017);
        return mongoClient;

    }
}
