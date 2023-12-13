package Dashboard;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        WebElement Success = driver.findElement(By.cssSelector(".fl-success"));
        Assert.assertTrue(Success.isDisplayed());
    }
    @Test(priority = 2)
    public void deleteCategory() throws InterruptedException {
        driver.navigate().to("http://stars.neop.co/admin/categories");
        Thread.sleep(1000);
        WebElement deleteBtn = driver.findElement(By.cssSelector("tbody:nth-child(2) tr:nth-child(8) td.text-sm.font-weight-normal:nth-child(5) div:nth-child(2) > button.btn.btn-icon.btn-2.btn-danger .btn-inner--text"));
        Thread.sleep(500);
        Actions actions = new Actions(driver);
        // Move the mouse to the target element
        actions.moveToElement(deleteBtn).click().build().perform();
        Thread.sleep(500);
        driver.switchTo().activeElement();
        Thread.sleep(3000);
        WebElement sureBtn= driver.findElement(By.cssSelector("body.g-sidenav-show.bg-gray-100.modal-open:nth-child(2) main.main-content.position-relative.max-height-vh-100.h-100.border-radius-lg.overflow-x-hidden.ps.ps--active-y:nth-child(2) div.container-fluid.py-4 div.container-fluid.py-4 div.row.mt-4 div.col-12 div.card div.table-responsive div.dataTable-wrapper.dataTable-loading.no-footer.sortable.searchable.fixed-height.fixed-columns div.dataTable-container table.table.table-flush.dataTable-table td.text-sm.font-weight-normal:nth-child(5) div.modal.fade.show div.modal-dialog div.modal-content div.modal-footer > form:nth-child(2)"));
        actions.moveToElement(sureBtn).click().build().perform();
        driver.switchTo().defaultContent();
        Thread.sleep(1500);
        WebElement Success = driver.findElement(By.cssSelector("div.fl-success"));
        Assert.assertTrue(Success.isDisplayed());
    }
    @Test(priority = 3)
    public void RestoreCategory() throws InterruptedException {
        driver.navigate().to("http://stars.neop.co/admin/categories");
        Thread.sleep(1000);
        WebElement deleteBtn = driver.findElement(By.cssSelector("body.g-sidenav-show.bg-gray-100:nth-child(2) main.main-content.position-relative.max-height-vh-100.h-100.border-radius-lg.overflow-x-hidden.ps.ps--active-y:nth-child(2) div.container-fluid.py-4 div.container-fluid.py-4 div.row.mt-4 div.col-12 div.card div.table-responsive div.dataTable-wrapper.dataTable-loading.no-footer.sortable.searchable.fixed-height.fixed-columns div.dataTable-container table.table.table-flush.dataTable-table tr:nth-child(8) td.text-sm.font-weight-normal:nth-child(5) div:nth-child(2) button.btn.btn-icon.btn-2.btn-primary > span.btn-inner--text"));
        Thread.sleep(500);
        Actions actions = new Actions(driver);
        // Move the mouse to the target element
        actions.moveToElement(deleteBtn).click().build().perform();
        Thread.sleep(500);
        driver.switchTo().activeElement();
        Thread.sleep(3000);
        WebElement sureBtn= driver.findElement(By.cssSelector("body.g-sidenav-show.bg-gray-100.modal-open:nth-child(2) main.main-content.position-relative.max-height-vh-100.h-100.border-radius-lg.overflow-x-hidden.ps.ps--active-y:nth-child(2) div.container-fluid.py-4 div.container-fluid.py-4 div.row.mt-4 div.col-12 div.card div.table-responsive div.dataTable-wrapper.dataTable-loading.no-footer.sortable.searchable.fixed-height.fixed-columns div.dataTable-container table.table.table-flush.dataTable-table td.text-sm.font-weight-normal:nth-child(5) div.modal.fade.show div.modal-dialog div.modal-content div.modal-footer > form:nth-child(2)"));
        actions.moveToElement(sureBtn).click().build().perform();
        driver.switchTo().defaultContent();
        Thread.sleep(1500);
        WebElement Success = driver.findElement(By.cssSelector("div.fl-success"));
        Assert.assertTrue(Success.isDisplayed());
    }
    @Test(priority = 4)
    public void editCategory() throws InterruptedException {
        driver.navigate().to("http://stars.neop.co/admin/categories");
        Thread.sleep(1000);
        WebElement editBtn = driver.findElement(By.xpath("//a[@href='http://stars.neop.co/admin/categories/1/edit']"));
        Thread.sleep(1000);
        editBtn.click();
        WebElement name_en = driver.findElement(By.id("name_en"));
        WebElement name_ar = driver.findElement(By.id("name_ar"));
        name_ar.clear();
        name_en.clear();
        Thread.sleep(100);
        WebElement saveBtn= driver.findElement(By.id("save"));
        Thread.sleep(100);
        name_en.sendKeys("TestCategory 100");
        Thread.sleep(100);
        name_ar.sendKeys("اختبار الفئات 100");
        WebElement selectElement = driver.findElement(By.tagName("select"));
        // Create a Select object by wrapping the WebElement
        Select select = new Select(selectElement);
        Thread.sleep(100);
        // You can now interact with the <select> element using methods provided by the Select class
        // Select by index (index starts from 0)
        select.selectByIndex(1);
        Thread.sleep(100);
        saveBtn.click();
        Thread.sleep(1500);
        WebElement Success = driver.findElement(By.cssSelector(".fl-success"));
        Assert.assertTrue(Success.isDisplayed());
    }

}
