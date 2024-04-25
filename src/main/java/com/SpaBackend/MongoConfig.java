package com.SpaBackend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-secrets.properties")
public class MongoConfig {
    
    @Value("${mongoUri}")
    private String mongoUri;

    public String getMongoUri() {
        return mongoUri;
    }
}
