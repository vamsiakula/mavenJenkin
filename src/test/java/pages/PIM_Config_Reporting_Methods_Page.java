package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.SafeActions;

public class PIM_Config_Reporting_Methods_Page extends SafeActions {
    public PIM_Config_Reporting_Methods_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public String addReportMethods(String Method) throws InterruptedException {
        WebElement add = driver.findElement(By.id("btnAdd"));
        safeClick(add, 10);
        WebElement select = driver.findElement(By.id("reportingMethod_name"));
        select.sendKeys(Method);
        WebElement save = driver.findElement(By.id("btnSave"));
        safeClick(save, 10);
        String beforeMethod=select.getText();
        System.out.println(""+beforeMethod);
        return beforeMethod;
    }
    public String afterAdd() throws InterruptedException {

        WebElement after=driver.findElement(By.xpath("//*[@class='tdName tdValue']"));
        String afterMethod=after.getText();
        System.out.println(""+afterMethod);
        return afterMethod;
    }
    public void delete() throws InterruptedException {
        WebElement delete = driver.findElement(By.id("btnDel"));
        safeClick(delete, 10);
    }
    public void deleteMethod() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.cssSelector("input[name='chkListRecord[]']"));
        safeClick(checkbox, 10);

    }
    public void deleteMultiple(String no_of_checkboxes) throws InterruptedException {
        String checkboxes="(//*[@name='chkListRecord[]'])["+no_of_checkboxes+"]";
        WebElement checkbox = driver.findElement(By.xpath(checkboxes));
        safeClick(checkbox, 10);

    }
    public void deleteAllMethods() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.id("checkAll"));
        safeClick(checkbox, 10);

    }


}
