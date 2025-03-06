package org.testing.core;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RestAssuredClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestAssuredClient.class);

    public static Response doGet(String url, Map<String, String> headers) {
        LOGGER.info("Executing GET on URL doGet: {}", url);

        if (headers != null && !headers.isEmpty()) {
            LOGGER.info("GET request headers: {}", headers);
            return RestAssured.given().headers(headers).get(url).andReturn();
        } else {
            return RestAssured.given().get(url).andReturn();
        }
    }

    public static Response doPost(String url, Map<String, String> headers, String requestBody) {
        LOGGER.info("Executing POST on URL: {}", url);
        LOGGER.debug("Request Body doPost:\n{}", requestBody);

        if (headers != null && !headers.isEmpty()) {
            LOGGER.info("POST request headers: {}", headers);
            return RestAssured
                    .given()
                    .headers(headers)
                    .body(requestBody)
                    .post(url)
                    .andReturn();
        } else {
            return RestAssured
                    .given()
                    .body(requestBody)
                    .post(url)
                    .andReturn();
        }
    }

    public static Response doPut(String url, Map<String, String> headers, String requestBody) {
        if (headers != null && !headers.isEmpty()) {
            LOGGER.info("PUT request headers: {}", headers);
            return RestAssured.given().headers(headers).body(requestBody).put(url).andReturn();
        } else {
            return RestAssured.given().body(requestBody).put(url).andReturn();
        }
    }

    public static Response doPatch(String url, Map<String, String> headers, String requestBody) {
        LOGGER.info("Executing PATCH on URL: {}", url);
        LOGGER.debug("Request Body doPatch:\n{}", requestBody);

        if (headers != null && !headers.isEmpty()) {
            LOGGER.info("PATCH request headers: {}", headers);
            return RestAssured.given().headers(headers).body(requestBody).patch(url).andReturn();
        } else {
            return RestAssured.given().body(requestBody).patch(url).andReturn();
        }
    }

    public static Response doDelete(String url, Map<String, String> headers) {
        LOGGER.info("Executing DELETE on URL: {}", url);

        if (headers != null && !headers.isEmpty()) {
            LOGGER.info("DELETE request headers: {}", headers);
            return RestAssured.given().headers(headers).delete(url).andReturn();
        } else {
            return RestAssured.given().delete(url).andReturn();
        }
    }
}

