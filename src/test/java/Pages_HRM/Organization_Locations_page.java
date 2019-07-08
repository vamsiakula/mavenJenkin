package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.SafeActions;

public class Organization_Locations_page extends SafeActions {
    public WebDriver driver;
    public Organization_Locations_page(WebDriver driver){
        super(driver);
        this.driver=driver;
}
    public void searchByName(String New_Data,String Name){
        WebElement location=driver.findElement(By.xpath("//label[text()='"+New_Data+"']/following-sibling::input[@type='text']"));
        safeSendKeys(location,Name);
    }
    public void selectCountry(String New_Data) throws InterruptedException {
        WebElement country=driver.findElement(By.xpath("//select[@id='searchLocation_country']/*[text()='"+New_Data+"']"));
        safeClick(country,10);
    }
    public void clickSearch() throws InterruptedException {
        WebElement click_edit=driver.findElement(By.cssSelector("input[value='Search']"));
        safeClick(click_edit,10);
    }
    public void resultsFound(String Name) {
        WebElement found = driver.findElement(By.xpath("//*[text()='" + Name + "']"));
        found.isDisplayed();
        System.out.println("The results for " + Name + " were shown below");
    }
    public void resultsNotFound(String Name) {
        WebElement not_found = driver.findElement(By.xpath("//*[text()='No Records Found']"));
        not_found.isDisplayed();
        System.out.println("The results for "+Name+" were shown below");
    }
}
