package APISteps;

import Utils.APIConstants;
import Utils.APIPayloadConstants;
import Utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class APIWorkflow extends CommonMethods {
    RequestSpecification request;
    Response response;


    @Given("request is prepped to create an employee")
    public void request_is_prepped_to_create_an_employee() {
        request=given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .header(APIConstants.HEADER_AUTHORIZATION_KEY,GenerateToken.token)
                .body(APIPayloadConstants.createEmployeePayload());
    }
    @When("A post call is made")
    public void a_post_call_is_made() {
        response=request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
        response.prettyPrint();


    }
    @Then("the status code for creation of employee is {int}")
    public void the_status_code_for_creation_of_employee_is(Integer statusCode) {
        response.then().statusCode(statusCode);

    }
}
