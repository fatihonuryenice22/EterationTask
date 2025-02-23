package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;

public class APITestSteps {

    private String endpoint;
    private Response response;
    private String requestBody;

    @Given("The API endpoint is {string}")
    public void setApiEndpoint(String url) {
        this.endpoint = url;
    }

    @When("I send a GET request")
    public void sendGetRequest() {
        response = RestAssured.get(endpoint);
    }

    @Then("The response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("The response body should contain {string}")
    public void verifyResponseBody(String expectedText) {
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains(expectedText), "Response body does not contain expected text.");
    }

    @When("I send a POST request with the following body")
    public void ıSendAPOSTRequestWithTheFollowingBody(String body) {
        this.requestBody = body;
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(endpoint);

    }

    @When("I send a POST request with an invalid body")
    public void ıSendAPOSTRequestWithAnInvalidBody() {
        String invalidBody = "{ \"title\": \"Only Title\" }"; //Missing body this should fail
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(invalidBody)
                .post(endpoint);
    }
}
