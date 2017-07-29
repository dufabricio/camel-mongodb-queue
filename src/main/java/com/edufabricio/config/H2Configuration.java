package com.edufabricio.config;

import com.edufabricio.server.repository.MessageReceivedRepository;
import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("!production")
public class H2Configuration {

    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/h2console/*");
        return registrationBean;
    }

    @Autowired
    MessageReceivedRepository itemRepository;


    @PostConstruct
    @Profile("!production")
    public void seedDataBase(){



    }

}
