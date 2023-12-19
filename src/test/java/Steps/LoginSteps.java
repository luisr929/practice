package Steps;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.Constants;
import Utils.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginSteps extends CommonMethods {
    @Given("driver is made and navigates to the url")
    public void driver_is_made_and_navigates_to_the_url() {
       //openBrowserAndNavigateToUrl();

    }

    @Given("user enters credentials and presses enter")
    public void user_enters_credentials_and_presses_enter() {
        sendText(ConfigReader.getPropertyValue("username"),loginPage.usernameField);
        sendText(ConfigReader.getPropertyValue("password"),loginPage.passwordField);
       click(loginPage.loginButton);

    }
    @Then("User is naviagted to home page")
    public void user_is_naviagted_to_home_page() {
        String actual1= homePage.welcomeHomeDisplay.getText();
        String expectedMessage="Welcome Admin";

        Assert.assertEquals(actual1,expectedMessage);
        System.out.println(actual1);
        System.out.println(expectedMessage);

    }
    @Then("user must read excelfile")
    public void user_must_read_excelfile() {
        System.out.println(ExcelReader.read("EmployeeDataBatch16", Constants.EXCEL_READER_PATH));
    }

}
