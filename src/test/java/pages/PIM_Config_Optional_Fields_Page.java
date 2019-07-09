package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.SafeActions;

import java.sql.SQLOutput;

public class PIM_Config_Optional_Fields_Page extends CommonPageActions {
//    public WebDriver driver;
    public PIM_Config_Optional_Fields_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void addMultipleOptionalFields() throws InterruptedException {
        WebElement edit =driver.findElement(By.cssSelector("input[value='Edit']"));
        safeClick(edit,10);
       // WebElement checkbox =driver.findElement(By.cssSelector("input[id='configPim_chkDeprecateFields']"));
        //safeClick(checkbox,10);
        WebElement checkbox1 =driver.findElement(By.cssSelector("input[id='configPim_chkShowSSN']"));
        safeClick(checkbox1,10);
        WebElement save =driver.findElement(By.cssSelector("input[value='Save']"));
        safeClick(save,10);
        System.out.println("--- Multiple fields are added successfully---");

    }
    public void addOptionalField() throws InterruptedException {
        WebElement edit =driver.findElement(By.cssSelector("input[value='Edit']"));
        safeClick(edit,10);
        WebElement checkbox =driver.findElement(By.cssSelector("input[id='configPim_chkDeprecateFields']"));
        safeClick(checkbox,10);
        WebElement save =driver.findElement(By.cssSelector("input[value='Save']"));
        safeClick(save,10);
        System.out.println(" Optional fields are added successfully");

    }
    public void directAdd() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement edit =driver.findElement(By.cssSelector("input[value='Edit']"));
        safeClick(edit,10);
        WebElement checkbox1 =driver.findElement(By.cssSelector("input[id='configPim_chkShowSSN']"));
        safeClick(checkbox1,10);
        WebElement save1 =driver.findElement(By.cssSelector("input[value='Save']"));
        safeClick(save1,10);
        System.out.println("---Admin cannot add fields without selecting them--");
    }
    public String beforeAdd() throws InterruptedException {
        WebElement text=driver.findElement(By.cssSelector("label[for='configPim_chkDeprecateFields']"));
        String s= text.getText();
        String sub=s.substring(5,14);
        System.out.println(""+sub);
        return sub;
    }
    public String afterAdd() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement text=driver.findElement(By.id("menu_pim_viewEmployeeList"));
        safeClick(text,10);
        WebElement id=driver.findElement(By.xpath("(//*[@class='left'])[1]"));
        safeClick(id,10);;
        WebElement text1=driver.findElement(By.xpath("//label[contains(text(),'Nick Name')]"));
    String name=text1.getText();
        System.out.println(""+name);
        return name;
    }
}
