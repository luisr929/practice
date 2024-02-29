package Steps;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.formula.functions.Code;
import org.junit.Assert;

public class EmployeeSteps extends CommonMethods {
    @Given("User navigates to the login page")
    public void user_navigates_to_the_login_page() {
        System.out.println("user is navigated to the application");
    }
    @When("user enters valid credentials pressed login button then is navigated to homepage")
    public void user_enters_valid_credentials_pressed_login_button_then_is_navigated_to_homepage() {
       sendText(ConfigReader.getPropertyValue("empUsername"),loginPage.usernameField);
       sendText(ConfigReader.getPropertyValue("empPassword"),loginPage.passwordField);
       click(loginPage.loginButton);
    }
    @When("user clicks MY INFO tab and clicks on Contact Details")
    public void user_clicks_my_info_tab_and_clicks_on_contact_details() {
       click(employeePage.infoButton);
       click(employeePage.ContactDetailsButton);

    }
    @When("user pressed the Edit button and adds contact details")
    public void user_pressed_the_edit_button_and_adds_contact_details() {
       click(employeePage.EditButton);
       sendText("970 madison Ave",employeePage.StreetAddressTextBox);
       sendText("chitown",employeePage.cityTextBox);

    }
    @When("hits the save button")
    public void hits_the_save_button() {
      click(employeePage.saveButton);
    }
    @Then("users contacts details have been saved")
    public void users_contacts_details_have_been_saved() {
        click(employeePage.EditButton);
        String actual=employeePage.StreetAddressTextBox.getAttribute("value");
        String expected="970 madison Ave";
        System.out.println("actual "+actual);
        System.out.println("expected "+expected);
        Assert.assertEquals(expected,actual);
    }
}
