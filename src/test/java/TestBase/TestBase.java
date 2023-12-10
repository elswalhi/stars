package TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.ByteArrayInputStream;

public class TestBase {

    public static WebDriver driver;

    public static String email= "admin@email.com";
    public static String password= "123123";
    public static String  dUrl="http://stars.neop.co/admin/login";
    public void initialization() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(dUrl);
        WebElement emailInput = driver.findElement(By.name("email"));
        Thread.sleep(500);
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.tagName("button"));
        Thread.sleep(1000);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitBtn.click();
        String expectedResult = "http://stars.neop.co/admin/dashboard";
        String actualResult=driver.getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult);
    }
    public void Teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    public void captureScreenshot() {
        try {
            // Convert WebDriver object to TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Capture screenshot as Bytes
            byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);

            // Attach the screenshot to Allure report
            Allure.addAttachment("Screenshot on Failure", new ByteArrayInputStream(screenshotBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
