package org.flex.ems.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component

public class MongoDataSources {

    @Value("${spring.data.mongodb.database}")
    private String alias;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private String port;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Value("${spring.data.mongodb.authentication-database}")
    private String authSource;

    @Bean
    public MongoClient getMongoClient() {
        MongoCredential credential = MongoCredential.createCredential(username, authSource, password.toCharArray());
        return MongoClients.create(MongoClientSettings.builder()
                .applyToClusterSettings(builder -> builder
                        .hosts(parseHostToServerAddress(host)))
                .credential(credential).applicationName("default").build());
    }

    private List<ServerAddress> parseHostToServerAddress(String host) {

        List<ServerAddress> serverAddressList = new ArrayList<>();
        String[] hostList = host.split(",");

        for (String individualHost : hostList) {
            String[] dbPort = individualHost.split(":");
            serverAddressList.add(new ServerAddress(dbPort[0], Integer.parseInt(dbPort[1])));
        }

        return serverAddressList;
    }

}