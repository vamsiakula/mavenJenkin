package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Log;
import utilities.SafeActions;

public class CommonPage extends SafeActions {
    public WebDriver driver;

    public CommonPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public void selectSectionOfAdmin(String Module1, String SubModule, String SectionName) throws InterruptedException {
        WebElement select_module = driver.findElement(By.xpath("//b[text()='" + Module1 + "']"));
        Actions action = new Actions(driver);
        action.moveToElement(select_module).build().perform();
        WebElement select_sub_module = driver.findElement(By.xpath("//a[text()='" + SubModule + "']"));
        action.moveToElement(select_sub_module).build().perform();
        WebElement general_information = driver.findElement(By.xpath("//a[text()='" + SectionName + "']"));
        safeClick(general_information, 10L);
    }

    public void selectSectionOfPIM(String Module2, String SubModule) throws InterruptedException {
        WebElement select_module = driver.findElement(By.xpath("//b[text()='" + Module2 + "']"));
        Actions action = new Actions(driver);
        action.moveToElement(select_module).build().perform();
        WebElement select_sub_module = driver.findElement(By.xpath("//a[text()='" + SubModule + "']"));
        action.moveToElement(select_sub_module).click().build().perform();
        Log.info(SubModule+" "+"Module is opened");
    }


}