package pages;

import com.sun.javafx.binding.StringFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import sun.invoke.empty.Empty;
import utilities.Log;
import utilities.SafeActions;

public class Admin_Organization_Locations_page extends SafeActions {
    public WebDriver driver;
    public Admin_Organization_Locations_page(WebDriver driver){
        super(driver);
        this.driver=driver;
}
    public void searchByName(String New_Data,String Name){
        WebElement location=driver.findElement(By.xpath("//label[contains(text(),'"+New_Data+"')]/following-sibling::input[@type='text']"));
        Log.info("The locations of "+Name+" is searched.");
        safeSendKeys(location,Name);
    }
    public void validateReset(String New_Data){
        WebElement location=driver.findElement(By.xpath("//label[contains(text(),'"+New_Data+"')]/following-sibling::input[@type='text']"));
        String text=location.getAttribute("value");
        Assert.assertTrue(text.isEmpty());
        Log.info("Reset button is verified.");
        System.out.println("Reset button is verified");
    }
    public void selectCountry(String New_Data) throws InterruptedException {
        WebElement country=driver.findElement(By.xpath("//*[text()='"+New_Data+"']"));
        Log.info("The locations in the country "+New_Data+" is searched.");
        safeClick(country,10);
    }

    public void resultsFound(String Name) {
        WebElement found = driver.findElement(By.xpath("//*[text()='" + Name + "']"));
        found.isDisplayed();
        Log.info("The results for " + Name + " were shown below.");
        System.out.println("The results for " + Name + " were shown below");
    }
    public void resultsNotFound(String Name) {
        WebElement not_found = driver.findElement(By.xpath("//*[text()='No Records Found']"));
        not_found.isDisplayed();
        Log.info("No Records Found for "+Name+".");
        System.out.println("No Records Found for "+Name+"");
    }

    public void validateHidingOptionsBar() throws InterruptedException {
        WebElement expand = driver.findElement(By.cssSelector("a[class='toggle tiptip']"));
        safeClick(expand,10);
        Log.info("Options bar is clicked to hide.");
        WebElement hide = driver.findElement(By.cssSelector("a[class='toggle tiptip activated']"));
        Assert.assertFalse((expand.getClass())!=(hide.getClass()));
        Log.info("Options Bar hidden and expanded successfully.");
        System.out.println("Options Bar hidden and expanded successfully.");
    }
    public void clickCity(String New_Data) throws InterruptedException {
        WebElement country=driver.findElement(By.xpath("//a[text()='"+New_Data+"']"));
        Log.info("The city "+New_Data+" is clicked to get its respective details.");
        safeClick(country,10);
    }
    public void updateDetails(String New_Data,String Input_Data){
//      WebElement update_data=driver.findElement(By.xpath("//label[text()='"+New_Data+"']/following-sibling::input[@type='text']"));
        WebElement update_data=driver.findElement(By.cssSelector("#location_"+New_Data+""));
        update_data.clear();
        safeSendKeys(update_data,Input_Data);
        Log.info("The information of "+New_Data+" is updated with "+Input_Data+".");
    }
    public void validateUpdatedInformation(String New_Data,String Input_Data){
        WebElement update_data=driver.findElement(By.cssSelector("#location_"+New_Data+""));
        String Updated_Data=update_data.getAttribute("value");
        Assert.assertTrue(Input_Data.equals(Updated_Data));
        Log.info("Information Updated Successfully.");
        System.out.println("Information Updated Successfully");
    }

    public void deletedExistedLocation(String locationName) throws InterruptedException {
        String string;
        String value;
        WebElement index=driver.findElement(By.xpath("//*[text()='"+locationName+"']"));
        string=index.getAttribute("href");
        StringBuffer num = new StringBuffer();
        {

            for (int i = string.length()-1; i >0; i--)
            {
                if (Character.isDigit(string.charAt(i)))
                    num.append(string.charAt(i));
                else break;

            }
            value= String.valueOf((num.reverse()));
        }
        WebElement checkbox=driver.findElement(By.cssSelector("[type='checkbox'][value='"+value+"']"));
        Log.info("The checkbox of "+locationName+" is enabled.");
        safeClick(checkbox,10);
    }
    public void clickOk() throws InterruptedException {
        WebElement click_ok=driver.findElement(By.xpath("(//input[@value='Ok'])[2]"));
        Log.info("OK button is clicked.");
        safeClick(click_ok,10);
    }
}
