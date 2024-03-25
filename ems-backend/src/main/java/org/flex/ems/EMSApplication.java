package org.flex.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableMongoRepositories(basePackages = "org.flex.ems.*")
public class EMSApplication {
    public static void main(String[] args) {
        SpringApplication.run(EMSApplication.class, args);
    }
}