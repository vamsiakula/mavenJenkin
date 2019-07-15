package utilities;

import base.BrowserSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class CommonActions extends BrowserSetUp {


    public void commonActionsProduced(String url, String userName, String password) throws IOException, InterruptedException {
        //open application
        Log.info("OrangeHrm application is opened");
        openApplication(url);
        //login to application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPage();
        loginPage.userLogin(userName, password);

        HomePage homePage=new HomePage(driver);
        homePage.verifyHomePage();

    }
    public void verifySectionPage(String Title, String Module) {
        WebElement welcomeNote = driver.findElement(By.xpath("//*[text()='" + Title + "']"));
        Log.info("" + Title + " Page of " + Module + " module of Orange HRM is displayed.");
        welcomeNote.isDisplayed();
        System.out.println("" + Title + " Page of " + Module + " module of Orange HRM is displayed");
    }

    public void clickButton(String Button) throws InterruptedException {
        WebElement click_button = driver.findElement(By.cssSelector("input[value='"+Button+"']"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='"+Button+"']")));
        Log.info(""+Button+" button is clicked.");
        click_button.click();
        Log.info(Button+" "+"Button is clicked");
    }
}