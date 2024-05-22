package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage extends CommonMethods {

    @FindBy(xpath = "//b[text()='My Info']")
    public WebElement infoButton;
    @FindBy(xpath = "//input[@id='contact_street1']")
    public WebElement StreetAddressTextBox;
    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement EditButton;
    @FindBy(xpath = "//a[text()='Contact Details']")
    public WebElement ContactDetailsButton;

    @FindBy(xpath = "//input[@id='contact_city']")
    public WebElement cityTextBox;

    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement saveButton;







   public  EmployeePage(){
        PageFactory.initElements(driver,this);
    }
}
