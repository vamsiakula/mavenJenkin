package Pages_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends SafeActions {
    public WebDriver driver;
    public Login(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }
    public void loginApplication1(String username,String password)  {
        String loginVerify;
        WebElement field1 = driver.findElement(By.id("txtUsername"));
        field1.sendKeys(username);
        WebElement field2 = driver.findElement(By.id("txtPassword"));
        field2.sendKeys(password);
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='Submit']"));
        loginButton.click();
        loginVerify=driver.getTitle();
        System.out.println(loginVerify);
    }

}

