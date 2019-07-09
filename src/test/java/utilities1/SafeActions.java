package utilities;

import basis.BrowserSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SafeActions   {
    public WebDriver driver;
    public SafeActions(WebDriver driver){
        this.driver=driver;
    }
    public void safeClick(WebElement element, int waitTime) throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }
}
