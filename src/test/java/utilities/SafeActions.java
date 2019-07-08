package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SafeActions {
    public WebDriver driver;
    public SafeActions(WebDriver driver){
        this.driver=driver;
    }
    public void safeClick(WebElement element, double waiting) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, (long) waiting);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(300);
        element.click();
    }
    public void safeSendKeys(WebElement element,String s)
    {
        element.sendKeys(s);
    }

}
