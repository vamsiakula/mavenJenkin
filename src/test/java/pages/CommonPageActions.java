package pages;

import basis.BrowserSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.SafeActions;

public class CommonPageActions extends SafeActions {
//    public WebDriver driver;
    public CommonPageActions(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void loginToApplication(String username, String password) throws InterruptedException {
        WebElement usernamefield;
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.cssSelector("input[id='txtUsername']")).sendKeys(username);
        //click on login button
        WebElement pwd = driver.findElement(By.cssSelector("input[id='txtPassword']"));
        pwd.sendKeys(password);
        WebElement loginButton = driver.findElement(By.cssSelector("input[id='btnLogin']"));
        safeClick(loginButton, 100);
        String title = driver.getTitle();
        //Assertions
        Assert.assertEquals("OrangeHRM", driver.getTitle());
        System.out.println(" login is successful");
        WebElement pim =driver.findElement(By.id("menu_pim_viewPimModule"));
        pim.click();
        WebElement config =driver.findElement(By.id("menu_pim_Configuration"));
         config.click();
    }
    // clicking PIM
    public void selectOptionFromConfig(String SelectOPtion) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        String typeOfElement = SelectOPtion;
        WebElement optional = driver.findElement(By.id(typeOfElement));
        optional.click();    }

}
