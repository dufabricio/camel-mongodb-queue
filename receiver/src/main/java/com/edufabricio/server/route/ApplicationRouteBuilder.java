package com.edufabricio.server.route;

import com.edufabricio.server.exception.BadRequestException;
import com.edufabricio.server.exception.ResourceNotFoundException;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.Date;

@Component
@Slf4j
public class ApplicationRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        onException(BadRequestException.class).handled(true).process(exchange -> {
            Throwable caused = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
            Response response = Response.status(400).entity("{\"error\":\"" + caused.getMessage() + "\"}").build();
            exchange.getOut().setBody(response);
            exchange.setProperty(Exchange.ROUTE_STOP, Boolean.TRUE);
        });

        onException(ResourceNotFoundException.class).handled(true).process(exchange -> {
            Throwable caused = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
            Response r = Response.status(404).entity("{\"error\":\"" + caused.getMessage() + "\"}").build();
            exchange.getOut().setBody(r);
            exchange.setProperty(Exchange.ROUTE_STOP, Boolean.TRUE);
        });

        configureReceiver();

    }

    private void configureReceiver() {

       from("mongodb3:mongoClientBean?database=eventBus&collection=messages" +
                "&tailTrackIncreasingField=dispatchedAt" +
                "&persistentId=messagesTracker" +
                "&persistentTailTracking=true")
                .id("tailableCursorConsumer1")
                .autoStartup(true)
                .to("bean:receiverService?method=receive");

    }

}
