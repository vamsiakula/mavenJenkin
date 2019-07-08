package BaseClass;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BrowsersetUp {
    public WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void openBrowser(@Optional("chrome") String browserName,ITestResult Result) {

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }
        Result.setAttribute("result",driver);
    }

    public void openApplication(String url) {
        driver.get(url);
    }

    public void closeApplication() {
        driver.close();
    }

    public void takeScreenshot(WebDriver driver) {

        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File("screenshots/error.jpg"));
        }

        catch (IOException e)
        {
            System.out.println(e.getMessage());

        }
    }
}