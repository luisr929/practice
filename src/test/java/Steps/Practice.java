package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Practice {
    public class PetWiki {
        public static String getLoadedData(WebDriver driver) throws InterruptedException {

            driver.findElement(By.id("load-button")).click();

                //WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(1))
                     //   wait.until(ExpectedConditions.elementToBeClickable())

           boolean button= driver.findElement(By.id("load-button")).isEnabled();
            if (button==true){

                String content= driver.findElement(By.id("content")).getText();
                System.out.println(content);
            }




            return null;
        }
    }
}
