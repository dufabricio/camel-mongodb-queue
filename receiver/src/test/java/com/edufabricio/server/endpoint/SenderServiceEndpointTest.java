package com.edufabricio.server.endpoint;

import com.edufabricio.server.BaseIntegrationTest;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.when;

public class SenderServiceEndpointTest extends BaseIntegrationTest {

    public static final String
        SENDER_ENDPOINT_REQUEST = "/sender/";

    @Test
    public void mustReturnUnauthorizedWhenUserIsNotAuthenticated() throws Exception {
        when()
            .post(SENDER_ENDPOINT_REQUEST, "{message:hello}")
            .then()
            .statusCode(HttpStatus.SC_OK);
    }


}
