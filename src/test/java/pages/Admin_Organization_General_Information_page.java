package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Log;
import utilities.SafeActions;

public class Admin_Organization_General_Information_page extends SafeActions {
    public WebDriver driver;
    public Admin_Organization_General_Information_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void updateDetails(String New_Data,String Input_Data){
        WebElement update_data=driver.findElement(By.xpath("//label[text()='"+New_Data+"']/following-sibling::input[@type='text']"));
        Log.info(""+New_Data+" is updated with "+Input_Data+".");
        update_data.clear();
        safeSendKeys(update_data,Input_Data);
    }
    public void validateUpdatedInformation(String New_Data,String Input_Data){
        WebElement update_data=driver.findElement(By.xpath("//label[text()='"+New_Data+"']/following-sibling::input[@type='text']"));
        String Updated_Data=update_data.getAttribute("value");
        Assert.assertTrue(Input_Data.equals(Updated_Data));
        Log.info("General Information Updated Successfully.");
        System.out.println("Information Updated Successfully");
    }
    public int validateCountOfEmployees(){
        WebElement update_data=driver.findElement(By.cssSelector("[id='numOfEmployees']"));
        int Updated_Data=Integer.parseInt(update_data.getText());
        Log.info("Count of employees is "+Updated_Data+".");
        return Updated_Data;
    }
    public void validationError(){
        WebElement error=driver.findElement(By.cssSelector("span[class='validation-error']"));
        Log.info("Mandatory Fields Required.");
        error.isDisplayed();
        System.out.println("Mandatory Fields Required");
    }

}