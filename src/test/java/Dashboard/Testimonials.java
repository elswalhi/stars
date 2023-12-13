package Dashboard;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class Testimonials extends TestBase {

    @BeforeClass
    public void init() throws InterruptedException {
        initialization();
    }
    @AfterClass
    public void EndTest() throws InterruptedException {
        Teardown();
    }
    @Test(priority = 0)
    public void navigate_To_Testimonials(){
//        href="http://stars.neop.co/admin/projects/1/edit"
        WebElement categoriesLink = driver.findElement(By.xpath("//a[@href='http://stars.neop.co/admin/testimonials']"));
        categoriesLink.click();
        String expectedResult="http://stars.neop.co/admin/testimonials";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(priority = 1)
    public void create_Testimonials() throws InterruptedException {
        WebElement addProjectsLink = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]/a[1]/button[1]"));
        Thread.sleep(100);
        addProjectsLink.click();
        Thread.sleep(100);
        WebElement name_en = driver.findElement(By.id("name_en"));
        WebElement name_ar = driver.findElement(By.id("name_ar"));
        WebElement description_ar = driver.findElement(By.id("description_ar"));
        WebElement description_en = driver.findElement(By.id("description_en"));
        WebElement rate = driver.findElement(By.id("rate"));
        File uploadFile = new File("src/test/java/Dashboard/test.jpg");
        WebElement image = driver.findElement(By.id("image"));
        Thread.sleep(100);
        name_en.sendKeys("Testtestimonials 4");
        Thread.sleep(100);
        name_ar.sendKeys("اختبار  4");
        Thread.sleep(100);
        rate.sendKeys("4");
        Thread.sleep(100);
        description_ar.sendKeys("اختبار");
        description_en.sendKeys("test");
        image.sendKeys(uploadFile.getAbsolutePath());
        Thread.sleep(500);
        WebElement saveBtn= driver.findElement(By.id("save"));
        Thread.sleep(100);
        Actions actions = new Actions(driver);
        actions.moveToElement(saveBtn).click().build().perform();
        Thread.sleep(500);
        WebElement Success = driver.findElement(By.cssSelector(".fl-success"));
        Assert.assertTrue(Success.isDisplayed());
    }
    @Test(priority = 2)
    public void deleteTestimonials() throws InterruptedException {
        driver.navigate().to("http://stars.neop.co/admin/testimonials");
        Thread.sleep(1000);
        WebElement deleteBtn = driver.findElement(By.cssSelector("tr:nth-child(1) td.text-sm.font-weight-normal:nth-child(5) div:nth-child(2) button.btn.btn-icon.btn-2.btn-danger > span.btn-inner--text"));
        Thread.sleep(500);
        Actions actions = new Actions(driver);
        // Move the mouse to the target element
        actions.moveToElement(deleteBtn).click().build().perform();
        Thread.sleep(500);
        WebElement modal=  driver.findElement(By.cssSelector(".modal-content"));
        driver.switchTo().activeElement();
        Thread.sleep(3000);
        WebElement sureBtn= driver.findElement(By.cssSelector("body.g-sidenav-show.bg-gray-100:nth-child(2) main.main-content.position-relative.max-height-vh-100.h-100.border-radius-lg.overflow-x-hidden.ps:nth-child(2) div.container-fluid.py-4 div.container-fluid.py-4 div.row.mt-4 div.col-12 div.card div.table-responsive div.dataTable-wrapper.dataTable-loading.no-footer.sortable.searchable.fixed-height.fixed-columns div.dataTable-container table.table.table-flush.dataTable-table td.text-sm.font-weight-normal:nth-child(5) div.modal.fade div.modal-dialog div.modal-content div.modal-footer form:nth-child(2) > button.btn.btn-danger:nth-child(3)"));
        actions.moveToElement(sureBtn).click().build().perform();
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        WebElement Success = driver.findElement(By.cssSelector("div.fl-success"));
        Assert.assertTrue(Success.isDisplayed());
    }
    @Test(priority = 3)
    public void RestoreTestimonials() throws InterruptedException {
        driver.navigate().to("http://stars.neop.co/admin/testimonials");
        Thread.sleep(1000);
        WebElement RestoreBtn = driver.findElement(By.cssSelector("button.btn.btn-icon.btn-2.btn-primary > span.btn-inner--text"));
        Thread.sleep(500);
        Actions actions = new Actions(driver);
        // Move the mouse to the target element
        actions.moveToElement(RestoreBtn).click().build().perform();
        Thread.sleep(500);
        driver.switchTo().activeElement();
        Thread.sleep(3000);
        WebElement sureBtn= driver.findElement(By.cssSelector("div.modal-dialog div.modal-content div.modal-footer form:nth-child(2) > button.btn.btn-primary:nth-child(3)"));
        actions.moveToElement(sureBtn).click().build().perform();
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        WebElement Success = driver.findElement(By.cssSelector("div.fl-success"));
        Assert.assertTrue(Success.isDisplayed());
    }
    @Test(priority = 4)
    public void editTestimonials() throws InterruptedException {
        driver.navigate().to("http://stars.neop.co/admin/testimonials");
        Thread.sleep(1000);
        WebElement editBtn = driver.findElement(By.xpath("//a[@href='http://stars.neop.co/admin/testimonials/1/edit']"));
        Thread.sleep(1000);
        editBtn.click();

        WebElement name_en = driver.findElement(By.id("name_en"));
        WebElement name_ar = driver.findElement(By.id("name_ar"));
        WebElement description_ar = driver.findElement(By.id("description_ar"));
        WebElement description_en = driver.findElement(By.id("description_en"));
        WebElement rate = driver.findElement(By.id("rate"));
        name_ar.clear();
        name_en.clear();
        description_en.clear();
        description_ar.clear();
        rate.clear();
        File uploadFile = new File("src/test/java/Dashboard/test.jpg");
        WebElement image = driver.findElement(By.id("image"));
        Thread.sleep(100);
        name_en.sendKeys("Testtestimonials 4");
        Thread.sleep(100);
        name_ar.sendKeys("اختبار  4");
        Thread.sleep(100);
        rate.sendKeys("4");
        Thread.sleep(100);
        description_ar.sendKeys("اختبار");
        description_en.sendKeys("test");
        image.sendKeys(uploadFile.getAbsolutePath());
        Thread.sleep(500);
        WebElement saveBtn= driver.findElement(By.id("save"));
        Thread.sleep(100);
        Actions actions = new Actions(driver);
        actions.moveToElement(saveBtn).click().build().perform();
        Thread.sleep(500);
        WebElement Success = driver.findElement(By.cssSelector(".fl-success"));
        Assert.assertTrue(Success.isDisplayed());
    }

}