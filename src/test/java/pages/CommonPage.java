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
        Log.info("The module "+Module1+" is found");
        Actions action = new Actions(driver);
        action.moveToElement(select_module).build().perform();
        WebElement select_sub_module = driver.findElement(By.xpath("//a[text()='" + SubModule + "']"));
        Log.info("The sub-module "+SubModule+" is found");
        action.moveToElement(select_sub_module).build().perform();
        WebElement general_information = driver.findElement(By.xpath("//a[text()='" + SectionName + "']"));
        Log.info("The section "+SectionName+" is clicked");
        safeClick(general_information, 10L);
    }

    public void selectSectionOfPIM(String Module2, String SubModule) throws InterruptedException {
        WebElement select_module = driver.findElement(By.xpath("//b[text()='" + Module2 + "']"));
        Log.info("The module "+Module2+" is found");
        Actions action = new Actions(driver);
        action.moveToElement(select_module).build().perform();
        WebElement select_sub_module = driver.findElement(By.xpath("//a[text()='" + SubModule + "']"));
        Log.info("The sub-module "+SubModule+" is clicked");
        action.moveToElement(select_sub_module).click().build().perform();

    }


}