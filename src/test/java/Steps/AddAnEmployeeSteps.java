package Steps;

import Pages.AddEmployeePage;
import Pages.EmployeeListPage;
import Utils.CommonMethods;
import Utils.Constants;
import Utils.DBUtils;
import Utils.ExcelReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.opentelemetry.api.internal.Utils;
import org.apache.commons.collections4.functors.WhileClosure;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class AddAnEmployeeSteps extends CommonMethods {

    String employeeId;
    String firstName;
    String middleName;
    String lastName;


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
        System.out.println(employeeId);
        click(addEmployeePage.saveButton);


    }
    @Then("new user will be created")
    public void new_user_will_be_created() throws InterruptedException {
        click(homePage.pimButton);
       click(employeeListPage.employeeListButton);
       click(employeeListPage.employeeIdSearchBox);
       sendText(employeeId, employeeListPage.employeeIdSearchBox);
       click(employeeListPage.employeeSearchButton);
        System.out.println(employeeId);
        String actual = employeeListPage.employeeTable.getText();
        Thread.sleep(5000);



       Assert.assertEquals(employeeId,actual);

        System.out.println(employeeId);

    }

    @When("user enters {string} and {string} and {string} in the data driven format")
    public void user_enters_and_and_in_the_data_driven_format(String firstname, String middlename, String lastname) {
        sendText(firstname, addEmployeePage.firstNameTextBox);
        sendText(middlename, addEmployeePage.middleNameTextBox);
        sendText(lastname, addEmployeePage.lastNameTextBox);
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
      click(addEmployeePage.saveButton);
    }
    @Then("user is saved successfully")
    public void user_is_saved_successfully() {
        System.out.println("test passed successful");
    }

    @When("user enters firstname and middlename and lastname and verify employee has been added")
    public void user_enters_firstname_middlename_and_lastname_and_verify_employee_has_been_added(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        List<Map<String,String>> employeeNames=dataTable.asMaps();
        for (Map<String, String> employee : employeeNames) {

            String firstNameValue=employee.get("firstname");
            String middleNameValue=employee.get("middlename");
            String lastNameValue=employee.get("lastname");

            sendText(firstNameValue, addEmployeePage.firstNameTextBox);
            sendText(middleNameValue, addEmployeePage.middleNameTextBox);
            sendText(lastNameValue, addEmployeePage.lastNameTextBox);

            click(addEmployeePage.saveButton);
            //click(addEmployeePage.addEmployeeButton);





            click(addEmployeePage.addEmployeeButton);



        }
    }
    @When("user adds employee using excel {string} and verify it")
    public void user_adds_employee_using_excel_and_verify_it(String sheetName) {
        List<Map<String,String>> newEmployees= ExcelReader.read(sheetName, Constants.EXCEL_READER_PATH);
        Iterator<Map<String,String >> itr=newEmployees.iterator();

        while (itr.hasNext()){

            Map<String,String> mapNewEmp=itr.next();

            sendText(mapNewEmp.get("firstName"),addEmployeePage.firstNameTextBox);
            sendText(mapNewEmp.get("middleName"),addEmployeePage.middleNameTextBox);
            sendText(mapNewEmp.get("lastName"),addEmployeePage.lastNameTextBox);
            sendText(mapNewEmp.get("photograph"),addEmployeePage.photoButton);

            if (!addEmployeePage.createLoginDetails.isSelected()) {
                click(addEmployeePage.createLoginDetails);

                sendText(mapNewEmp.get("userName"),addEmployeePage.userNameTextBox);
                sendText(mapNewEmp.get("password"),addEmployeePage.passwordTextBox);
                sendText(mapNewEmp.get("confirmPassword"),addEmployeePage.passwordTextBox2);
            }

            String empIdValue= addEmployeePage.empIDField.getAttribute("value");
            click(addEmployeePage.saveButton);



        }

    }
    @When("use adds {string} and {string} and {string}")
    public void use_adds_and_and(String firstName, String middleName, String lastName) {
        this.firstName=firstName;
        this.middleName=middleName;
        this.lastName=lastName;

        sendText(firstName, addEmployeePage.firstNameTextBox);
        sendText(middleName, addEmployeePage.middleNameTextBox);
        sendText(lastName, addEmployeePage.lastNameTextBox);
        employeeId=addEmployeePage.empIDField.getAttribute("value");
        click(addEmployeePage.saveButton);


    }
    @When("employee is added successfully")
    public void employee_is_added_successfully() {
        System.out.println("user has been added!");
    }
    @Then("user verfy in the database")
    public void user_verfy_in_the_database() {
        String query="select emp_firstName,emp_middle_name,emp_lastname from hs_hr_employees where employee_id="+employeeId+";";
        System.out.println(query);

        List<Map<String,String>>mapList=DBUtils.fetch(query);
        Map<String, String> firstRow = mapList.get(0);
        String dbFirstname = firstRow.get("emp_firstName");
        String dbMiddleName = firstRow.get("emp_middle_name");
        String dbLastName = firstRow.get("emp_lastname");
        System.out.println("test passed");
       Assert.assertEquals("Firstname from front end does not match firstname from database", firstName, dbFirstname);
        Assert.assertEquals("middlename from front end does not match middlename from database", middleName, dbMiddleName);
        Assert.assertEquals("lastname from front end does not match lastname from database", lastName, dbLastName);
        System.out.println(firstName+lastName+middleName);
    }
    @When("user clicks dependants tab")
    public void user_clicks_dependants_tab() {
        click(addEmployeePage.dependantsTab);
    }
    @When("user presses add button and provides the enters the information needed and clicks save")
    public void user_presses_add_button_and_provides_the_enters_the_information_needed_and_clicks_save() {
        click(addEmployeePage.dependantAddButton);
        sendText("babyLu",addEmployeePage.dependantName);
        selectFromDropDown(addEmployeePage.relationshipDropDown,"Child");
        click(addEmployeePage.dependantsCal);
        boolean isFound=false;
        while (!isFound){
            List<WebElement>calDate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
            for (WebElement date : calDate) {
                String getDate=date.getText();
                if (getDate.equalsIgnoreCase("15")){
                    System.out.println(getDate);
                    click(date);
                    isFound=true;
                    break;
                }
            }
        }

        click(addEmployeePage.dependantsSaveButton);

    }
    @Then("employees dependants are save successfully")
    public void employees_dependants_are_save_successfully() {

    }


}
