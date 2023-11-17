package Steps;

import Pages.EmployeeListPage;
import Utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Random;

public class AddAnEmployeeSteps extends CommonMethods {

    String employeeId;


    @When("user clicks on add an employee button")
    public void user_clicks_on_add_an_employee_button() {
    click(addEmployeePage.addEmployeeButton);

    }
    @When("user enters employees information and clicks save button")
    public void user_enters_employees_information_and_clicks_save_button() {
        sendText("moneyman"+ Math.random(), addEmployeePage.firstNameTextBox);
        sendText("coder"+ Math.random(), addEmployeePage.middleNameTextBox);
        sendText("king"+ Math.random(), addEmployeePage.lastNameTextBox);
        employeeId=addEmployeePage.empIDField.getAttribute("value");
        click(addEmployeePage.saveButton);
        System.out.println(employeeId);

    }
    @Then("new user will be created")
    public void new_user_will_be_created() {
        click(homePage.pimButton);
       click(employeeListPage.employeeListButton);
       click(employeeListPage.employeeIdSearchBox);
       sendText(employeeId, employeeListPage.employeeIdSearchBox);
        System.out.println(employeeId);
        String actual =employeeListPage.employeeIdSearchBox.getText();


        Assert.assertEquals(employeeId,actual);

    }
}
