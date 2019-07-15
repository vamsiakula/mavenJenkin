package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Log;
import utilities.SafeActions;

public class HomePage extends SafeActions {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }
    public void verifyHomePage(){
        WebElement welcomeNote=driver.findElement(By.cssSelector("[id='branding']"));
        Log.info("Home Page of Orange HRM is displayed");
        welcomeNote.isDisplayed();
        System.out.println("Home Page of Orange HRM is displayed");
    }


}