package com.edufabricio;

import org.apache.cxf.feature.LoggingFeature;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan({"com.edufabricio"})
@EnableAutoConfiguration(exclude = {
        JmxAutoConfiguration.class
})
@EnableJpaRepositories
public class CamelMongoDBQueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamelMongoDBQueueApplication.class, args);
    }

    @Bean
    public LoggingFeature loggingFeature() {
        return new LoggingFeature();
    }

    @Bean
    @Profile("!production")
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            Arrays.stream(ctx.getBeanDefinitionNames()).map(Object::toString)
                    .sorted().forEach(System.out::println);
        };
    }
}
