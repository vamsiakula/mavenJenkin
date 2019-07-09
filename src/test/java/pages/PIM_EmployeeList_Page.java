package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.SafeActions;

public class PIM_EmployeeList_Page extends SafeActions {
    public WebDriver driver;

    public PIM_EmployeeList_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void click_ON_PIM() {
        WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
        pim.click();
        String pimPage_verify;
        pimPage_verify = driver.getTitle();}
}