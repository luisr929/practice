package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonMethods {
    @FindBy(xpath = "//b[normalize-space()='Admin']")
    public WebElement adminButton;

    @FindBy(xpath = "//a[@id='welcome']")
    public WebElement welcomeHomeDisplay;

    @FindBy(xpath = "//b[normalize-space()='PIM']")
    public WebElement pimButton;

    @FindBy(xpath = "//a[text()='Qualifications']")
    public WebElement QualificationButton;
    @FindBy(xpath = "//a[text()='Memberships']")
    public WebElement MembershipsButton;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }



}
