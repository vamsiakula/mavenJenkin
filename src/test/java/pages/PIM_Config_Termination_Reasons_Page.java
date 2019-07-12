package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.SafeActions;

public class PIM_Config_Termination_Reasons_Page extends SafeActions {
    public PIM_Config_Termination_Reasons_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void addTerminationReasons(String reason) throws InterruptedException {
        WebElement add = driver.findElement(By.id("btnAdd"));
        safeClick(add, 10);
        WebElement select = driver.findElement(By.xpath("//*[@name='terminationReason[name]']"));
        select.sendKeys(reason);
        WebElement save = driver.findElement(By.id("btnSave"));
        safeClick(save, 10);
    }
    public void deleteReason() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.xpath("(//*[@name='chkListRecord[]'])[2]"));
        safeClick(checkbox, 10);
        WebElement delete = driver.findElement(By.id("btnSave"));
        safeClick(delete, 10L);
    }
    public void deleteMultiple(String no_of_checkboxes) throws InterruptedException {
        String checkboxes="(//*[@name='chkListRecord[]'])["+no_of_checkboxes+"]";
        WebElement checkbox = driver.findElement(By.xpath(checkboxes));
        safeClick(checkbox, 10);
        WebElement delete = driver.findElement(By.id("btnDel"));
        safeClick(delete, 10);
    }
    public void deleteAllReasons() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.id("checkAll"));
        safeClick(checkbox, 10);
        WebElement delete = driver.findElement(By.id("btnSave"));
        safeClick(delete, 10L);
    }
}
