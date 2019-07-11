package pages;

import org.openqa.selenium.*;
import utilities.SafeActions;

import java.io.IOException;

public class Admin_Organization_Structure_page extends SafeActions {
    public WebDriver driver;
    public Admin_Organization_Structure_page(WebDriver driver){
        super(driver);
        this.driver=driver;
	}
	public void editUnit(String UnitName,String Action) throws InterruptedException {
		WebElement edit=driver.findElement(By.xpath("//span[text()='"+UnitName+"']/following-sibling::a[text()=' "+Action+"']"));
		safeClick(edit,10);

	}
	public void clickOk() throws InterruptedException {
		WebElement click_ok=driver.findElement(By.xpath("(//input[@value='Ok'])[2]"));
		safeClick(click_ok,10);
	}
	public void validateEditedUnit(String UnitName) throws InterruptedException {

    	try {
				WebElement unit = driver.findElement(By.xpath("//span[text()='" + UnitName + "']"));
				unit.isDisplayed();
				System.out.println(""+UnitName+" added");
			} catch (NoSuchElementException ignored) {
				System.out.println(""+UnitName+" removed");

			}
    }
	public void clickUnit(String UnitName) throws InterruptedException {
		WebElement unit = driver.findElement(By.xpath("//a[text()='" + UnitName + "']"));
		safeClick(unit,20);
	}
    public void editDetails(String NewUnitName){
    	WebElement edit=driver.findElement(By.cssSelector("[name='txtName']"));
    	edit.clear();
    	safeSendKeys(edit,NewUnitName);

	}


}

