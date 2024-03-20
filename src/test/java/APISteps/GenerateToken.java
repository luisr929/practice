package APISteps;

import Utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateToken extends CommonMethods

{
     String baseURI = RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
     public static String token;





    @Given("generate API token")
    public void generate_api_token() {
        RequestSpecification request = given().header("Content-type","application/json").body("{\n" +
                "  \"email\": \"lu.band@gmail.com\",\n" +
                "  \"password\": \"BigMoney\"\n" +
                "}");

        Response response=request.when().post("/generateToken.php");
        response.prettyPrint();

        token="Bearer "+response.jsonPath().getString("token");
        System.out.println(token);
    }

}
