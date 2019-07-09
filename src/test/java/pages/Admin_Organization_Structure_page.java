package pages;

import org.openqa.selenium.WebDriver;
import utilities.SafeActions;

public class Admin_Organization_Structure_page extends SafeActions {
    public WebDriver driver;
    public Admin_Organization_Structure_page(WebDriver driver){
        super(driver);
        this.driver=driver;
}
}

