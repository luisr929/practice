package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {
    @FindBy(id = "txtUsername")
    public WebElement usernameField;
    @FindBy(id = "txtPassword")
    public WebElement passwordField;
    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

}
