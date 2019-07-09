package basis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BrowserSetup {
    public WebDriver driver;

    @BeforeMethod
    @Parameters({"browserName","url"})
    public void openBrowser(@Optional("Chrome") String browserName,String url, ITestResult iTestResult) {
        if (browserName.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "resourses/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(url);
        } else if (browserName.equals("Chrome")) {
            // Disable notifications

            System.setProperty("webdriver.chrome.driver", "resourses/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
        } else {
            System.out.println("Give proper browser name");
        }
        iTestResult.setAttribute("result",driver);
    }
//    @BeforeMethod
//    @Parameters({"url"})
//    public void enterUrl(String url){
//        driver.get(url);
//    }
@AfterMethod
public void closeBrowser() throws InterruptedException{
        driver.close();
}

}
