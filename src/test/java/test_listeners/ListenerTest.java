package test_listeners;

import base.BrowserSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.Log;

import java.io.IOException;


public class ListenerTest extends BrowserSetUp implements ITestListener{

    @Override
    public void onTestStart(ITestResult Result) {
        System.out.println(Result.getName()+" test case started");

    }

    @Override
    public void onTestSuccess(ITestResult Result) {
        System.out.println("The name of the testcase passed is :"+Result.getName());


    }


    @Override
    public void onTestFailure(ITestResult Result) {
        System.out.println("The name of the testcase failed is :"+Result.getName());
        driver=(WebDriver)Result.getAttribute("result");
        try {
            Log.warn("The name of the testcase failed is :"+Result.getName());
            takeScreenShot(Result.getMethod().getMethodName());
        } catch (IOException e) {
            Log.error("taking screenshot got failed");
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult Result) {
        System.out.println("The name of the testcase Skipped is :"+Result.getName());

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

    }

    public void onStart(ITestContext Context) {

    }

    public void onFinish(ITestContext Context) {

    }
}
