package Listeners;

import TestBase.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener extends TestBase implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Executed when a test method starts
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Executed when a test method is successful
        System.out.println(result + "The test was success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Executed when a test method fails
        System.out.println(result + "The test was Fail");
        captureScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Executed when a test method is skipped
        System.out.println(result + "The test was skipped");
        captureScreenshot();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Executed when a test method fails within success percentage
    }

    @Override
    public void onStart(ITestContext context) {
        // Executed before <test> tag of the XML file
    }

    @Override
    public void onFinish(ITestContext context) {
        // Executed after <test> tag of the XML file
    }

}
