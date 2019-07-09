package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.SafeActions;

public class PIM_Config_Custom_Fields_Page extends CommonPageActions {
//    public WebDriver driver;
    public PIM_Config_Custom_Fields_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public String clickOnCustomField(String field_name, String ScreenType ) throws InterruptedException {
        WebElement add = driver.findElement(By.cssSelector("input[value='Add']"));
        if (add.isDisplayed()) {
            safeClick(add, 10);
        } else {
            System.out.println("");
        }
        WebElement fieldName = driver.findElement(By.cssSelector("input[id='customField_name']"));
        fieldName.sendKeys(field_name);
        String FieldName = fieldName.getText();
        WebElement screen = driver.findElement(By.cssSelector("select[id='customField_screen']"));
        safeClick(screen, 10);
        String typeOfScreen = "//option[contains(text(),'" + ScreenType + "')]";
        WebElement optional = driver.findElement(By.xpath(typeOfScreen));
        safeClick(optional, 10);
        return FieldName;
    }
        public String clickOnType (String type, String selectOption ) throws InterruptedException {
            if (type.equals("Text or Number")) {
                String type1 = "//option[contains(text(),'" + type + "')]";
                WebElement textNum = driver.findElement(By.xpath(type1));
                safeClick(textNum, 10);
            } else {
                String type1 = "//option[contains(text(),'" + type + "')]";
                WebElement textNum = driver.findElement(By.xpath(type1));
                safeClick(textNum, 10);
                WebElement select = driver.findElement(By.cssSelector("input[id='customField_extra_data']"));
                select.sendKeys(selectOption);
            }
            WebElement save = driver.findElement(By.cssSelector("input[id='btnSave']"));
            safeClick(save, 10);
            System.out.println(" --custom fields added Successfully--- ");
            // Verification
            WebElement Name = driver.findElement(By.xpath("(//*[@class='fieldName'])[1]"));
            String afterAdd = Name.getText();
            return afterAdd;
        }

        public void directSave() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver,10);
            WebElement save = driver.findElement(By.cssSelector("input[id='btnSave']"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='btnSave']")));
            safeClick(save, 10);
            System.out.println("--please enter required fields--");

        }
        public void deleteSingleField() throws InterruptedException {
            WebElement checkbox = driver.findElement(By.xpath("(//*[@class='check'])[1]"));
            safeClick(checkbox, 10);
            WebElement delete = driver.findElement(By.cssSelector("input[id='buttonRemove']"));
            safeClick(delete, 10);
            WebElement delete1 = driver.findElement(By.cssSelector("input[id='dialogDeleteBtn']"));
            safeClick(delete1, 10);
            System.out.println("--single field is deleted successfully--");
        }
        public void deleteAllFields() throws InterruptedException {
            WebElement checkbox = driver.findElement(By.cssSelector("input[id='checkAll']"));
            safeClick(checkbox, 10);
            WebElement delete = driver.findElement(By.cssSelector("input[id='buttonRemove']"));
            safeClick(delete, 10);
            WebElement delete1 = driver.findElement(By.cssSelector("input[id='dialogDeleteBtn']"));
            safeClick(delete1, 10);
            System.out.println("---all fields are deleted successfully---");

        }
    }