package utilities;

import BaseClass.BrowsersetUp;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerClass implements ITestListener {
   WebDriver driver;
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("get started"+iTestResult.getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("successful"+iTestResult.getName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("test is failed"+iTestResult.getName());
        BrowsersetUp browserSetup = new BrowsersetUp();
        driver=(WebDriver)iTestResult.getAttribute("screenshot");
        browserSetup.takeScreenshot(driver);
    }
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("ontestSkipped"+iTestResult.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("failedButSuccess"+iTestResult.getName());
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("started"+iTestContext.getName());

    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("finished"+iTestContext.getName());
    }
}
