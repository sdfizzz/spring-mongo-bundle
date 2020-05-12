package org.home.configs;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.util.StringUtils;

@Configuration
@EnableMongoRepositories(basePackages = "org.home.repositories")
public class MongoDBConfig {

    @Value("${db.name}")
    private String dbName;

    @Value("${db.host}")
    private String dbHost;

    @Value("${db.port}")
    private int dbPort;

    @Value("${db.user}")
    private String dbUser;

    @Value("${db.password}")
    private char[] dbPassword;

    @Bean
    public MongoClient mongoClient() {
        if (!StringUtils.isEmpty(dbUser) && !StringUtils.isEmpty(dbPassword)) {
            ServerAddress address = new ServerAddress(dbHost, dbPort);
            MongoCredential credential = MongoCredential.createCredential(dbUser, dbName, dbPassword);
            MongoClientOptions options = new MongoClientOptions.Builder().build();
            return new MongoClient(address, credential, options);
        }

        return new MongoClient(dbHost, dbPort);
    }

    @Bean
    public MongoDbFactory mongoDbFactory() {
        MongoDbFactory factory = new SimpleMongoClientDbFactory(MongoClients.create(), dbName);
        return factory;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }

}
