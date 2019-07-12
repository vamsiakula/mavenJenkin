package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.SafeActions;

public class AddEmployee_page extends SafeActions {
    public WebDriver driver;
    public AddEmployee_page(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    public void addingNewEmployee(String FirstName, String SecondName,String Id) throws InterruptedException {
        WebElement enter_first_name = driver.findElement(By.cssSelector("input[name='firstName']"));
        safeSendKeys(enter_first_name, FirstName);
        WebElement enter_last_name = driver.findElement(By.cssSelector("input[name='lastName']"));
        safeSendKeys(enter_last_name, SecondName);
        WebElement enter_Id = driver.findElement(By.cssSelector("input[id=\"employeeId\"]"));
        safeSendKeys(enter_Id,Id);
    }
    public void verify_page(String string1, String string2) {
        String verify_string = "//h1[text()=\"" + string1 + "\"]";
        WebElement verifyElement = driver.findElement(By.xpath(verify_string));
        Assert.assertEquals(verifyElement.getText(), string2);
        System.out.println(string2 + " page is opened");
    }
    public void loginButton() throws InterruptedException {
        WebElement login_botton = driver.findElement(By.id("chkLogin"));
        safeClick(login_botton,10);
    }
    public void loginCredentials(String login_username,String credential) {
        String loginString = "#"+login_username;
        WebElement element = driver.findElement(By.cssSelector(loginString));
        safeSendKeys(element,credential);
    }
    public String requiredMessage(String messages){
        String s1="(//span[text()='"+messages+"'])[1]";
        WebElement message = driver.findElement(By.xpath(s1));
        return message.getText();

}}
