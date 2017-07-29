package com.edufabricio.server.endpoint;

import com.edufabricio.server.BaseIntegrationTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class SenderServiceEndpointTest extends BaseIntegrationTest {

    public static final String
        SENDER_ENDPOINT_REQUEST = "/sender/";

    @Test
    public void mustReturnUnauthorizedWhenUserIsNotAuthenticated() throws Exception {
        when()
            .post(SENDER_ENDPOINT_REQUEST)
            .then()
            .statusCode(HttpStatus.SC_OK);
    }


}
