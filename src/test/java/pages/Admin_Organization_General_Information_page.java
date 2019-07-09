package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.SafeActions;

public class Admin_Organization_General_Information_page extends SafeActions {
    public WebDriver driver;
    public Admin_Organization_General_Information_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void verifySectionPage(String Title){
        WebElement welcomeNote=driver.findElement(By.xpath("//h1[text()='"+Title+"']"));
        welcomeNote.isDisplayed();
        System.out.println(""+Title+" Page of Organization module of Orange HRM is displayed");
    }

    public void clickEdit() throws InterruptedException {
        WebElement click_edit=driver.findElement(By.cssSelector("input[value='Edit']"));
        safeClick(click_edit,10);
    }
    public void updateDetails(String New_Data,String Input_Data){
        WebElement update_data=driver.findElement(By.xpath("//label[text()='"+New_Data+"']/following-sibling::input[@type='text']"));
        update_data.clear();
        safeSendKeys(update_data,Input_Data);
    }
    public void clickSave() throws InterruptedException {
        WebElement click_save=driver.findElement(By.cssSelector("input[value='Save']"));
        safeClick(click_save,10);
//        driver.navigate().refresh();
    }
    public void validateUpdatedInformation(String New_Data,String Input_Data){
        WebElement update_data=driver.findElement(By.xpath("//label[text()='"+New_Data+"']/following-sibling::input[@type='text']"));
        String Updated_Data=update_data.getAttribute("value");
        Assert.assertTrue(Input_Data.equals(Updated_Data));
        System.out.println("Information Updated Successfully");
    }
    public int validateCountOfEmployees(){
        WebElement update_data=driver.findElement(By.cssSelector("[id='numOfEmployees']"));
        int Updated_Data=Integer.parseInt(update_data.getText());
        return Updated_Data;
    }
    public void validationError(){
        WebElement error=driver.findElement(By.cssSelector("span[class='validation-error']"));
        error.isDisplayed();
        System.out.println("Mandatory Fields Required ");
    }

}