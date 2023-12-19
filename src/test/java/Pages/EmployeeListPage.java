package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage extends CommonMethods {

    @FindBy(xpath = "//ul[@class='paging bottom']//a[@class='tiptip'][normalize-space()='Next']")
    public WebElement nextButton;
    @FindBy(xpath = "//td[normalize-space()='No Records Found']")
    public WebElement actualMessage;
    @FindBy(xpath = "//input[@id='dialogConfirm']")
    public WebElement submitButton;
    @FindBy(xpath = "//a[normalize-space()='26']")
    public WebElement calenderDay;
    @FindBy(xpath = "//form[@id='frmTerminateEmployement']//img[@class='ui-datepicker-trigger']")
    public WebElement calender;

    @FindBy(xpath = "//input[@id='empsearch_employee_name_empName']")
    public WebElement employeeNameSearchBox;

    @FindBy(xpath = "//input[@id='btnTerminateEmployement']")
    public WebElement terminateEmployeeButton;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[2]")
    public WebElement employeeTable;

    @FindBy(xpath = "//select[@id='terminate_reason']")
    public WebElement dropDown;

    @FindBy(xpath = "//ul[@id='sidenav']//a[contains(text(),'Job')]")
    public WebElement employeeJobTab;

    @FindBy(xpath = "//a[normalize-space()='Dan Ivan']")
    public WebElement employeeWeWant;

    @FindBy(xpath = "//input[@id='empsearch_id']")
    public WebElement employeeIdSearchBox;

    @FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']")
    public WebElement employeeListButton;
    @FindBy(xpath = "//input[@id='searchBtn']")
    public WebElement employeeSearchButton;


   // @FindBy(xpath = "(//table/tbody/tr/td[2]")
    //public WebElement realId;

    public EmployeeListPage(){
        PageFactory.initElements(driver,this);
    }
}
