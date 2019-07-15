package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.Log;
import utilities.SafeActions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class BrowserSetUp  {
    public  WebDriver driver;


    @BeforeMethod
    @Parameters({"browser"})
    public void openBrowser(String browserName, ITestResult Result) throws IOException {

        if (browserName.equals("chrome")) {
            Log.info("Launched Chrome Browser");
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if (browserName.equals("firefox")){
            Log.info("Launched Chrome FireFox");
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else System.out.println("provide proper browserName");
        Result.setAttribute("result",driver);
    }

    public  void openApplication(String url)  {
        Log.info("he URL of Orange HRM is loaded");
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser(){
        Log.info("Closed the Browser");
        driver.close();
    }
    public void takeScreenShot(String screenshot) throws IOException {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String Path = "screenshots\\";


        File screenshotName = new File(Path +"failed_"+screenshot+".jpg");

        FileHandler.copy(scrFile, screenshotName);

        Reporter.log("<br>  <img src='"+screenshotName+"' height='100' width='100' /><br>");
        Reporter.log("<a href='"+screenshotName+"'>screenshot</a>");

    }
}