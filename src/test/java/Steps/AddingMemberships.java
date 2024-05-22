package Steps;

import Utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddingMemberships extends CommonMethods {
    @When("Admin navigares to qualifications")
    public void admin_navigares_to_qualifications() {
        click(homePage.adminButton);
        click(homePage.QualificationButton);



    }
    @When("selects membership")
    public void selects_membership() {
        click(homePage.MembershipsButton);
        click(membershipPage.AddButton);
        sendText("money3", membershipPage.NameTextBox);
        click(membershipPage.SaveButton);
    }
    @Then("Admin should be able to add memnerships")
    public void admin_should_be_able_to_add_memnerships() {
        String expected="money3";
        List<WebElement> tables=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
        for (WebElement table : tables) {
            String actual= table.getText();
            if (actual.equals("money3")){
                System.out.println("actual is "+actual);
                break;



            }

        }
        System.out.println("expected is "+expected);


    }

}
