package Dashboard;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class Categories extends TestBase {
    @BeforeClass
    public void init() throws InterruptedException {
        initialization();
    }
    @AfterClass
    public void EndTest() throws InterruptedException {
        Teardown();
    }
    @Test(priority = 0)
    public void navigate_To_Categories(){
        WebElement categoriesLink = driver.findElement(By.xpath("//a[@href='http://stars.neop.co/admin/categories']"));
        categoriesLink.click();
        String expectedResult="http://stars.neop.co/admin/categories";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(priority = 1)
    public void create_Category() throws InterruptedException {
        WebElement addCategoriesLink = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]/a[1]/button[1]"));
        Thread.sleep(100);
        addCategoriesLink.click();
        Thread.sleep(100);
        WebElement name_en = driver.findElement(By.id("name_en"));
        WebElement name_ar = driver.findElement(By.id("name_ar"));
        Thread.sleep(100);
        WebElement saveBtn= driver.findElement(By.id("save"));
        Thread.sleep(100);
        name_en.sendKeys("TestCategory 4");
        Thread.sleep(100);
        name_ar.sendKeys("اختبار الفئات 4");
        WebElement selectElement = driver.findElement(By.tagName("select"));

        // Create a Select object by wrapping the WebElement
        Select select = new Select(selectElement);
        Thread.sleep(100);
        // You can now interact with the <select> element using methods provided by the Select class
        // Select by index (index starts from 0)
        select.selectByIndex(0);
        Thread.sleep(100);
        saveBtn.click();
        Thread.sleep(500);
        WebElement Success = driver.findElement(By.cssSelector("body.g-sidenav-show.bg-gray-100.fl-dark-mode:nth-child(2) div.fl-main-container:nth-child(10) div.fl-flasher.fl-success.fl-container.fl-show > div.fl-content"));
        Assert.assertTrue(Success.isDisplayed());
    }
    @Test(priority = 2)
    public void deleteCategory() throws InterruptedException {
        driver.navigate().to("http://stars.neop.co/admin/categories");
        Thread.sleep(1000);
        Thread.sleep(500);
        WebElement deleteBtn = driver.findElement(By.cssSelector("tbody:nth-child(2) tr:nth-child(8) td.text-sm.font-weight-normal:nth-child(5) div:nth-child(2) > button.btn.btn-icon.btn-2.btn-danger .btn-inner--text"));
        Thread.sleep(500);
        deleteBtn.click();
        WebElement sureBtn= driver.findElement(By.xpath("//tbody/tr[5]/td[5]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/button[1]"));
        Thread.sleep(500);
        sureBtn.click();
        Thread.sleep(500);
        WebElement Success = driver.findElement(By.cssSelector("body.g-sidenav-show.bg-gray-100.fl-dark-mode:nth-child(2) div.fl-main-container:nth-child(10) div.fl-flasher.fl-success.fl-container.fl-show > div.fl-content"));
        Assert.assertTrue(Success.isDisplayed());
    }
    @Test(priority = 3)
    public void editCategory() throws InterruptedException {
        driver.navigate().to("http://stars.neop.co/admin/categories");
        Thread.sleep(1000);
        Thread.sleep(500);
        WebElement editBtn = driver.findElement(By.xpath("//tbody/tr[7]/td[5]/a[1]/button[1]"));
        Thread.sleep(500);
        editBtn.click();
        WebElement name_en = driver.findElement(By.id("name_en"));
        WebElement name_ar = driver.findElement(By.id("name_ar"));
        Thread.sleep(100);
        WebElement saveBtn= driver.findElement(By.id("save"));
        Thread.sleep(100);
        name_en.sendKeys("TestCategory 4");
        Thread.sleep(100);
        name_ar.sendKeys("اختبار الفئات 4");
        WebElement selectElement = driver.findElement(By.tagName("select"));
        // Create a Select object by wrapping the WebElement
        Select select = new Select(selectElement);
        Thread.sleep(100);
        // You can now interact with the <select> element using methods provided by the Select class
        // Select by index (index starts from 0)
        select.selectByIndex(0);
        Thread.sleep(100);
        saveBtn.click();
        Thread.sleep(500);
        WebElement Success = driver.findElement(By.cssSelector("body.g-sidenav-show.bg-gray-100.fl-dark-mode:nth-child(2) div.fl-main-container:nth-child(10) div.fl-flasher.fl-success.fl-container.fl-show > div.fl-content"));
        Assert.assertTrue(Success.isDisplayed());
    }

}
