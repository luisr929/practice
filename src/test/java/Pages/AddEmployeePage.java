package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {
    @FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
    public WebElement addEmployeeButton;

        @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameTextBox;

        @FindBy(xpath = "//input[@id='middleName']")
    public WebElement middleNameTextBox;

        @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameTextBox;


        @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement saveButton;

        @FindBy(id= "employeeId")
    public WebElement empIDField;

        @FindBy(xpath = "(//a[normalize-space()='46648316'])[1]")
    public WebElement actualId;

        @FindBy(id = "re_password")
    public WebElement passwordTextBox2;

        @FindBy(id = "photofile")
    public WebElement photoButton;

        @FindBy(id = "user_name")
    public WebElement userNameTextBox;
        @FindBy(id= "user_password")
    public WebElement passwordTextBox;

        @FindBy(id = "chkLogin")
    public WebElement createLoginDetails;

        @FindBy(xpath = "//a[text()='Dependents']")
        public WebElement dependantsTab;

        @FindBy(id = "dependent_name")
        public WebElement dependantName;

        @FindBy(id = "dependent_relationshipType")
        public WebElement relationshipDropDown;

        @FindBy(id = "btnSaveDependent")
        public WebElement dependantsSaveButton;

        @FindBy(id = "dependent_dateOfBirth")
        public WebElement dependantsCal;

        @FindBy(id = "btnAddDependent")
        public WebElement dependantAddButton;

        @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
        public WebElement dependantsCalDate;


        @FindBy(xpath = "//*[@id='sidenav']/li[10]/a")
        public WebElement qualificationsTab;

        @FindBy(id = "experience_employer")
        public WebElement companyField;

        @FindBy (id = "experience_jobtitle")
        public WebElement jobTitleField;

        @FindBy(id = "btnWorkExpSave")
        public WebElement experienceSaveButton;

        @FindBy(id = "addWorkExperience")
        public WebElement addWorkExperienceButton;




        public AddEmployeePage(){
            PageFactory.initElements(driver,this);
        }




}
