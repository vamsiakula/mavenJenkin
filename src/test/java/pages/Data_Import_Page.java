package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Data_Import_Page extends CommonPageActions {
//    public WebDriver driver;

    public Data_Import_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void importWithoutSelectFile() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement upload = driver.findElement(By.xpath("//*[@id='btnSave']"));
        upload.click();
    }
    public void importWithInvalidFile(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement chooseFile = driver.findElement(By.cssSelector("input[type='file']"));
        chooseFile.click();
        chooseFile.sendKeys("D:\\pratyusha.nulu\\Desktop\\Open cart");
        WebElement upload = driver.findElement(By.xpath("input[id='btnSave']"));
        upload.click();

    }
}
