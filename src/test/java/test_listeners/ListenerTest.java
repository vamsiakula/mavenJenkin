package test_listeners;

import basis.BrowserSetup;
import org.apache.commons.io.FileUtils;
import org.influxdb.dto.Point;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.Utils;
import testsuite.Metrics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ListenerTest extends BrowserSetup implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + " test case started");

    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("The name of the testcase passed is :" + iTestResult.getName());

    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("The name of testcase failed is : " + iTestResult.getName());
        driver = (WebDriver) iTestResult.getAttribute("result");
        File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrfile, new File("Screenshots/failedscreenshot"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("The name of the testcase skipped is :" + iTestResult.getName());

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        System.out.println(iTestContext.getName() + " is started");

    }

    public void onFinish(ITestContext iTestContext) {

    }
    private void sendTestMethodStatus(ITestResult iTestResult, String status) {
        Point point = Point.measurement("testmethod")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("testclass", iTestResult.getTestClass().getName())
                .tag("name", iTestResult.getName())
                .tag("description", iTestResult.getMethod().getDescription())
                .tag("result", status)
                .addField("duration", (iTestResult.getEndMillis() - iTestResult.getStartMillis()))
                .build();
        Metrics.send(point);
    }

    private void sendTestClassStatus(ITestContext iTestContext) {
        Point point = Point.measurement("testclass")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("name", iTestContext.getAllTestMethods()[0].getTestClass().getName())
                .addField("duration", (iTestContext.getEndDate().getTime() - iTestContext.getStartDate().getTime()))
                .build();
        Metrics.send(point);
    }

}
