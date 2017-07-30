package com.edufabricio.server.endpoint;

import com.mongodb.client.result.UpdateResult;
import org.springframework.stereotype.Service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service("senderServiceEndpoint")
@Path("/")
public class SenderServiceEndpoint {

    @POST
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public UpdateResult send(String message) {
        return null;
    }
}
