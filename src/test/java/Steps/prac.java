package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class prac {
    public static void main(String[] args) {

    }
    public static String getLoadedData(WebDriver driver) {

        driver.findElement(By.id("load-button")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(1));
      wait.until(ExpectedConditions.elementToBeClickable(By.id("load-button")));
      boolean button=driver.findElement(By.id("load-button")).isEnabled();
      if (button){
         String response= driver.findElement(By.id("content")).getText();
         System.out.println(response);
      }




        return null;
}

}
