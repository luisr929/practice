package Utils;

import Steps.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void openBrowserAndNavigateToUrl() {
        ConfigReader.readProperties(Constants.CONFIG_READER_PATH);

        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        initializePageObjects();

    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();


    }

    public static void sendText(String text, WebElement element) {
        element.clear();
        element.sendKeys(text);
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait;
    }

    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static byte[] takeScreenshot(String filename) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,
                    new File(Constants.SCREENSHOT_FILEPATH + filename + " " +
                            getTimeStamp("yyyy-MM-dd-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }


    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void selectFromDropDown(WebElement dropdown, String visibleText) {
        Select sel = new Select(dropdown);
        sel.selectByVisibleText(visibleText);
    }
}