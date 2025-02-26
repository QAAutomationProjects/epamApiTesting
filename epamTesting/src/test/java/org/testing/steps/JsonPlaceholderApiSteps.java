package org.testing.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testing.core.RestAssuredClient;
import org.testing.constants.ApiUrlConstants;
import org.testing.utils.FileUtils;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JsonPlaceholderApiSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonPlaceholderApiSteps.class);
    private Response response;

    @Given("I send a request GET {string} to {string}")
    public void sendRequestTo(String apiType, String endpoint) {
        if ("DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE".equals(apiType)) {
            apiType = ApiUrlConstants.getDefaultApiJsonPlaceholderTypeCode();
        }
        String fullUrl = apiType + endpoint;

        response = RestAssuredClient.doGet(fullUrl, null);

        Assertions.assertNotNull(response, "Response should not be null");
    }

    @Then("the response status should be {int}")
    public void verifyResponseStatus(int expectedStatusCode) {
        if (response == null) {
            throw new IllegalStateException(
                    "Response object is null. Ensure the request was executed before verifying the status.");
        }
        int actualStatusCode = response.getStatusCode();
        assertEquals(
                expectedStatusCode,
                actualStatusCode,
                "Unexpected response status code"
        );
    }

    @Then("the response should match {string}")
    public void theResponseShouldMatch(String schemaPath) {
        String filePath = ApiUrlConstants.getDefaultJsonResourcePath() + schemaPath;
        String schemaContent = FileUtils.readFileToString(filePath);

        response.then()
                .log().ifValidationFails()
                .body(JsonSchemaValidator.matchesJsonSchema(schemaContent));
    }

    @Given("I send a request DELETE {string} to {string}")
    public void sendDeleteRequestTo(String apiType, String endpoint) {
        if ("DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE".equals(apiType)) {
            apiType = ApiUrlConstants.getDefaultApiJsonPlaceholderTypeCode();
        }
        String fullUrl = apiType + endpoint;

        response = RestAssuredClient.doDelete(fullUrl, null);

        Assertions.assertNotNull(response, "Response should not be null");
    }

    @Then("the DELETE response status should be {int}")
    public void verifyDeleteResponseStatus(int expectedStatusCode) {
        if (response == null) {
            throw new IllegalStateException(
                    "Response object is null. Ensure the request was executed before verifying the status."
            );
        }

        int actualStatusCode = response.getStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode, "Unexpected response status code");
    }

    @Then("the DELETE response body should be empty")
    public void verifyDeleteResponseBodyIsEmpty() {
        String responseBody = response.getBody().asString().trim();
        boolean isEmpty = responseBody.isEmpty()
                || "{}".equals(responseBody)
                || "[]".equals(responseBody);

        assertTrue(isEmpty, "Response body should be empty or contain an empty JSON object.");
    }

    @Given("I send a request POST {string} to {string} with the following body:")
    public void sendPostRequest(String apiType, String endpoint, String requestBody) {
        if ("DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE".equals(apiType)) {
            apiType = ApiUrlConstants.getDefaultApiJsonPlaceholderTypeCode();
        }

        String fullUrl = apiType + endpoint;

        response = RestAssuredClient.doPost(fullUrl, null, requestBody);

        Assertions.assertNotNull(response, "Response should not be null");
    }

    @Then("the response GET body should contain:")
    public void verifyResponseBody(io.cucumber.datatable.DataTable expectedData) {
        Map<String, String> expectedMap = expectedData.asMaps().get(0);
        Map<String, Object> actualResponse = response.jsonPath().getMap("$");

        expectedMap.forEach((expectedKey, expectedValue) -> {
            Object actualValue = actualResponse.get(expectedKey);
            Assertions.assertNotNull(
                    actualValue,
                    String.format("Response key '%s' should not be null", expectedKey)
            );
            assertEquals(
                    expectedValue,
                    actualValue.toString(),
                    String.format("Unexpected value for key '%s'", expectedKey)
            );
        });
    }

    @Then("the response PUT body should contain:")
    public void verifyResponsePutBody(io.cucumber.datatable.DataTable expectedData) {
        int actualId = response.jsonPath().getInt("id");

        String expectedIdStr = expectedData.asMaps(String.class, String.class)
                .get(0)
                .get("id");
        int expectedId = Integer.parseInt(expectedIdStr);

        Assertions.assertEquals(expectedId, actualId, "El ID no coincide");
    }

    @Given("I send a PATCH request to {string} at {string} with the following body:")
    public void sendPatchRequest(String apiType, String endpoint, String requestBody) {
        if ("DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE".equals(apiType)) {
            apiType = ApiUrlConstants.getDefaultApiJsonPlaceholderTypeCode();
        }
        String fullUrl = apiType + endpoint;

        response = RestAssuredClient.doPatch(fullUrl,null, requestBody);

        Assertions.assertNotNull(response, "Response should not be null");
    }

    @Given("I send a PUT request to {string} at {string} with the following body:")
    public void sendPutRequest(String apiType, String endpoint, String requestBody) {
        if ("DEFAULT_API_JSON_PLACEHOLDER_TYPE_CODE".equals(apiType)) {
            apiType = ApiUrlConstants.getDefaultApiJsonPlaceholderTypeCode();
        }
        String fullUrl = apiType + endpoint;

        response = RestAssuredClient.doPut(fullUrl, null, requestBody);

        Assertions.assertNotNull(response, "Response should not be null");
    }

    @Then("the response by POST body should contain:")
    public void theResponseByPOSTBodyShouldContain(DataTable dataTable) {
        if (response == null) {
            throw new IllegalStateException("Response is null! Did you call iSendARequestPOST first?");
        }
    }

}
