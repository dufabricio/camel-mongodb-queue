package com.edufabricio.server.service;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    public String send(Exchange exchange) {
       return (String)exchange.getIn().getBody();
    }
}
