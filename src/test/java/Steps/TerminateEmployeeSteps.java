package Steps;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TerminateEmployeeSteps extends CommonMethods {
    @When("user clicks on pim button")
    public void user_clicks_on_pim_button() {
      click(homePage.pimButton);
    }
    @When("user accesses the list of employees in the system.")
    public void user_accesses_the_list_of_employees_in_the_system() {
        click(employeeListPage.employeeListButton);
    }
    @When("select a specified employee from the list.")
    public void select_a_specified_employee_from_the_list() {
        boolean isFound = false;
        while (!isFound) {
            List<WebElement> cells = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
            for (WebElement value : cells) {
                String valueTxt = value.getText();

                if (valueTxt.equals(ConfigReader.getPropertyValue("terminatedEmployeeId"))) {
                    System.out.println(valueTxt);
                    click(value);
                    isFound=true;
                    break;


                } //else{
                   // click(employeeListPage.nextButton);
                }

            }

        }

    @When("navigate to the employee's job page.")
    public void navigate_to_the_employee_s_job_page() {
      click(employeeListPage.employeeJobTab);
    }
    @When("select the option to terminate the employment of the specified employee.")
    public void select_the_option_to_terminate_the_employment_of_the_specified_employee() {
       click(employeeListPage.terminateEmployeeButton);
    }
    @Then("specified employee is terminated")
    public void specified_employee_is_terminated() {
      selectFromDropDown(employeeListPage.dropDown,"Deceased");
      click(employeeListPage.calender);
      click(employeeListPage.calenderDay);
      click(employeeListPage.submitButton);
      click(homePage.pimButton);
      click(employeeListPage.employeeListButton);
      //click(employeeListPage.employeeIdSearchBox);
      sendText(ConfigReader.getPropertyValue("terminatedEmployeeId"),employeeListPage.employeeIdSearchBox);
      click(employeeListPage.employeeSearchButton);
      String expected="No Records Found";
      String actual=employeeListPage.actualMessage.getText();
        System.out.println(actual);
        System.out.println(expected);
        Assert.assertEquals(actual,expected);
    }
}
