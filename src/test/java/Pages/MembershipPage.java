package Pages;

import Utils.CommonMethods;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MembershipPage extends CommonMethods {
    @FindBy (id = "btnAdd")
    public WebElement AddButton;
    @FindBy (id = "membership_name")
    public WebElement NameTextBox;
   @FindBy (id = "btnSave")
    public WebElement SaveButton;

    public MembershipPage(){
        PageFactory.initElements(driver,this);
    }
}
