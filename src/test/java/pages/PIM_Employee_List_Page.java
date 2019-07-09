package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.SafeActions;

public class PIM_Employee_List_Page extends SafeActions {
    public WebDriver driver;
    public PIM_Employee_List_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void addingNewEmployee() throws InterruptedException {
        WebElement click_add=driver.findElement(By.cssSelector("input[value='Add']"));
        safeClick(click_add,10);
        WebElement enter_first_name=driver.findElement(By.cssSelector("input[name='firstName']"));
        safeSendKeys(enter_first_name,"vamsith");
        WebElement enter_last_name=driver.findElement(By.cssSelector("input[name='lastName']"));
        safeSendKeys(enter_last_name,"varma");
        WebElement click_save=driver.findElement(By.cssSelector("input[value='Save']"));
        safeClick(click_save,10);
    }
}
