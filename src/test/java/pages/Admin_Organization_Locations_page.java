package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.SafeActions;

public class Admin_Organization_Locations_page extends SafeActions {
    public WebDriver driver;
    public Admin_Organization_Locations_page(WebDriver driver){
        super(driver);
        this.driver=driver;
}
    public void searchByName(String New_Data,String Name){
        WebElement location=driver.findElement(By.xpath("//label[contains(text(),'"+New_Data+"')]/following-sibling::input[@type='text']"));
        safeSendKeys(location,Name);
    }
    public void selectCountry(String New_Data) throws InterruptedException {
        WebElement country=driver.findElement(By.xpath("//*[text()='"+New_Data+"']"));
        safeClick(country,10);
    }

    public void resultsFound(String Name) {
        WebElement found = driver.findElement(By.xpath("//*[text()='" + Name + "']"));
        found.isDisplayed();
        System.out.println("The results for " + Name + " were shown below");
    }
    public void resultsNotFound(String Name) {
        WebElement not_found = driver.findElement(By.xpath("//*[text()='No Records Found']"));
        not_found.isDisplayed();
        System.out.println("No Records Found for "+Name+"");
    }

    public void validateHidingOptionsBar() throws InterruptedException {
        WebElement expand = driver.findElement(By.cssSelector("a[class='toggle tiptip']"));
        safeClick(expand,10);
        WebElement hide = driver.findElement(By.cssSelector("a[class='toggle tiptip activated']"));
        Assert.assertFalse((expand.getClass())!=(hide.getClass()));
        System.out.println("Options Bar hiden and expanded successfully");
    }
    public void clickCity(String New_Data) throws InterruptedException {
        WebElement country=driver.findElement(By.xpath("//a[text()='"+New_Data+"']"));
        safeClick(country,10);
    }
    public void updateDetails(String New_Data,String Input_Data){
        WebElement update_data=driver.findElement(By.xpath("//label[text()='"+New_Data+"']/following-sibling::input[@type='text']"));
        update_data.clear();
        safeSendKeys(update_data,Input_Data);
    }
    public void validateUpdatedInformation(String New_Data,String Input_Data){
        WebElement update_data=driver.findElement(By.xpath("//label[text()='"+New_Data+"']/following-sibling::input[@type='text']"));
        String Updated_Data=update_data.getAttribute("value");
        Assert.assertTrue(Input_Data.equals(Updated_Data));
        System.out.println("Information Updated Successfully");
    }
}
