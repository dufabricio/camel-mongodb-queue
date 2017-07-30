package com.edufabricio.config;

import com.edufabricio.server.endpoint.SenderServiceEndpoint;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

@Configuration
public class RestEndpointConfig {

    private final Bus bus;
    private final ObjectMapper objectMapper;
    private final JacksonJsonProvider jacksonProvider;

    private final List<Object> DEFAULT_PROVIDERS;

    public RestEndpointConfig(
        Bus bus,
        ObjectMapper objectMapper,
        JacksonJsonProvider jacksonProvider) {

        this.bus = bus;
        this.objectMapper = objectMapper;
        this.jacksonProvider = jacksonProvider;

        DEFAULT_PROVIDERS = Arrays.asList(jacksonProvider);
    }

    @Bean
    public JAXRSServerFactoryBean sender(SenderServiceEndpoint senderServiceEndpoint) {
        return buildServer("/sender", senderServiceEndpoint, DEFAULT_PROVIDERS);
    }


    private JAXRSServerFactoryBean buildServer(String address, Object serviceRest, List<Object> providers) {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();

        endpoint.setBus(bus);
        endpoint.setAddress(address);
        endpoint.setServiceBean(singletonList(serviceRest));
        endpoint.setProviders(providers);

        return endpoint;
    }
}
