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

    public void click_ON_PIM() {
        WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
        pim.click();
        String pimPage_verify;
        pimPage_verify = driver.getTitle();}
    public void searchEmployee(String empName,String empId,String empSupervisor) throws InterruptedException {


        if(empName!="None"){ WebElement employeeName = driver.findElement(By.id("empsearch_employee_name_empName"));
            employeeName.sendKeys(empName);}
        if(empId!="None"){
            WebElement employeeId = driver.findElement(By.id("empsearch_id"));
            employeeId.sendKeys(empId);}
        if(empSupervisor!="None"){ WebElement employeeSupervisor = driver.findElement(By.id("empsearch_supervisor_name"));
            employeeSupervisor.sendKeys(empSupervisor);}
        WebElement searchButton  = driver.findElement(By.id("searchBtn"));
        safeClick(searchButton,10);

    }
    public void searchDropDown_Status(String status){
        WebElement employeeStatus = driver.findElement(By.id("empsearch_employee_status"));
        Select dropdown = new Select(employeeStatus);
        dropdown.selectByVisibleText(status);
        //dropdown.selectByIndex(1);
    }
    public void searchDropDown_JobTitle(String jobtitle){
        WebElement employeeJobTitle = driver.findElement(By.id("empsearch_job_title"));
        Select dropdown = new Select(employeeJobTitle);
        dropdown.selectByVisibleText(jobtitle);
    }
    public void searchDropDown_SubUnit(String subUnit){
        WebElement employeeSubUnit = driver.findElement(By.id("empsearch_sub_unit"));
        Select dropdown = new Select(employeeSubUnit);
        dropdown.selectByVisibleText(subUnit);
    }
    public void reset(){
        WebElement resetButton = driver.findElement(By.id("resetBtn"));
        resetButton.click();
    }
    public void validate(){
        WebElement validation = driver.findElement(By.xpath("//td[text()=\"No Records Found\"]"));
        Assert.assertTrue(validation.getText().equals("No Records Found"));
        System.out.println("No Records Found");
    }
    public void resultsfound(String empId){
        WebElement validateElement1 = driver.findElement(By.xpath("//a[contains(text(),'0001')]"));
        validateElement1.click();
        WebElement validateElement2 = driver.findElement(By.id("personal_txtEmployeeId"));
        Assert.assertTrue(validateElement2.getAttribute("value").equals(empId));
        System.out.println("search results found");


    }
}