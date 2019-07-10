package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.SafeActions;

public class PIM_EmployeeList_Page extends SafeActions {
    public WebDriver driver;

    public PIM_EmployeeList_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void searchEmployee(String empName,String empId,String empSupervisor,String input_name,String input_id,String input_superviosr) throws InterruptedException {

        String name_string = "empsearch_"+input_name;
        String id_string="empsearch_"+input_id;
        String supervisor_string ="empsearch_"+input_superviosr;
        if(empName!="None"){ WebElement employeeName = driver.findElement(By.id(name_string));
            employeeName.sendKeys(empName);}
        if(empId!="None"){
            WebElement employeeId = driver.findElement(By.id(id_string));
            employeeId.sendKeys(empId);}
        if(empSupervisor!="None"){ WebElement employeeSupervisor = driver.findElement(By.id(supervisor_string));
            employeeSupervisor.sendKeys(empSupervisor);}
    }
    public void dropDown_Search(String input_status,String input_jobtitle,String input_subunit,String status,String jobtitle,String subUnit){
        String status_string="empsearch_"+input_status;
        String jobtitle_string="empsearch_"+input_jobtitle;
        String subunit_string="empsearch_"+input_subunit;
        if(status!="None"){
        WebElement employeeStatus = driver.findElement(By.id(status_string));
            Select dropdown = new Select(employeeStatus);
            dropdown.selectByVisibleText(status);}
        else if(jobtitle!="None") {
            WebElement employeeJobTitle = driver.findElement(By.id(jobtitle_string));
            Select dropdown = new Select(employeeJobTitle);
            dropdown.selectByVisibleText(jobtitle);
        }
        else{
            WebElement employeeSubUnit = driver.findElement(By.id(subunit_string));
            Select dropdown = new Select(employeeSubUnit);
            dropdown.selectByVisibleText(subUnit);
        }
    }
    public void reset() throws InterruptedException {
        WebElement resetButton = driver.findElement(By.id("resetBtn"));
        safeClick(resetButton,10);
    }
    public void validate(){
        WebElement validation = driver.findElement(By.xpath("//td[text()=\"No Records Found\"]"));
        Assert.assertTrue(validation.getText().equals("No Records Found"));
        System.out.println("No Records Found");
    }
    public void resultsfound(String empId) throws InterruptedException {
        WebElement validateElement1 = driver.findElement(By.xpath("//a[text()='0001']"));
        safeClick(validateElement1,10L);
        WebElement validateElement2 = driver.findElement(By.cssSelector("input[id='personal_txtEmployeeId']"));
        Assert.assertTrue(validateElement2.getAttribute("value").equals(empId));
        System.out.println("search results found");


    }
    public void noInput(){
        WebElement emptySearch = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        String a=emptySearch.getText();
        Assert.assertEquals(a,"Employee List");
        //Assert.assertEquals(emptySearch.getAttribute("value").equals("Employee List"));
        System.out.println("page reloaded");
    }
    public void addingNewEmployee() throws InterruptedException {
        WebElement enter_first_name=driver.findElement(By.cssSelector("input[name='firstName']"));
        safeSendKeys(enter_first_name,"vamsith");
        WebElement enter_last_name=driver.findElement(By.cssSelector("input[name='lastName']"));
        safeSendKeys(enter_last_name,"varma");
    }
}