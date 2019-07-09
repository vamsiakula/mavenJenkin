package utilities;

import base.BrowserSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class CommonActions extends BrowserSetUp {


    public void commonActionsProduced(String url, String userName, String password) throws IOException, InterruptedException {
        //open application
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
        welcomeNote.isDisplayed();
        System.out.println("" + Title + " Page of " + Module + " module of Orange HRM is displayed");
    }

    public void clickButton(String Button) throws InterruptedException {
        WebElement click_button = driver.findElement(By.cssSelector("input[value='"+Button+"']"));
        click_button.click();
    }
}