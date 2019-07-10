package testSuite;

import org.testng.Assert;
import pages.PIM_EmployeeList_Page;

import base.BrowserSetUp;
import org.testng.annotations.Test;
import utilities.CommonActions;
import pages.LoginPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class TC_OrangeHRM extends CommonActions {

    String url;
    String username;
    String password;
    String empName;
    String empId;
    String empName1;
    String empId2;
    String empSupervisor;
    String empSupervisor2;
    String status;
    String jobTitle;
    String subUnit;
    FileReader reader;

    {
        try {
            reader = new FileReader("D:\\orange\\OrangeHrm\\OrangeHRMData.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties p = new Properties();
        try {
            p.load(reader);
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        url = p.getProperty("url");
        username = p.getProperty("username");
        password = p.getProperty("password");
        empName = p.getProperty("empName");
        empId = p.getProperty("empId");
        empName1 = p.getProperty("empName1");
        empId2 = p.getProperty("empId2");
        empSupervisor = p.getProperty("empSupervisor");
        empSupervisor2 = p.getProperty("empSupervisor");
        status = p.getProperty("status");
        jobTitle = p.getProperty("jobTitle");
        subUnit = p.getProperty("subUnit");
    }

  @Test
    public void tc_001_search() throws IOException, InterruptedException {

        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        pim_employeeListPage.searchEmployee(empName, "none", "None");
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.validate();
    }

    @Test
    public void tc_002_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName1, "none", "None");
        pim_employeeListPage.validate();
    }

    @Test
    public void tc_003_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("None", empId, "None");
        pim_employeeListPage.resultsfound(empId);

    }

    @Test
    public void tc_004_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("None", empId2, "None");
        pim_employeeListPage.validate();

    }

    @Test
    public void tc_005_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchDropDown_Status(status);
        pim_employeeListPage.resultsfound(empId);

    }

    @Test
    public void tc_006_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchDropDown_JobTitle(jobTitle);
        pim_employeeListPage.resultsfound(empId);

    }

    @Test
    public void tc_007_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchDropDown_SubUnit(subUnit);
        pim_employeeListPage.resultsfound(empId);

    }

    @Test
    public void tc_008_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName, empId, "None");
        pim_employeeListPage.resultsfound(empId);

    }

    @Test
    public void tc_009_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName, empId2, "None");
        pim_employeeListPage.validate();


    }

    @Test
    public void tc_010_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName1, empId, "None");
        pim_employeeListPage.validate();

    }

    @Test
    public void tc_011_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName1, empId2, "None");
        pim_employeeListPage.validate();

    }

    @Test
    public void tc_012_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("None", "None", empSupervisor);
        pim_employeeListPage.validate();

    }

    @Test
    public void tc_013_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("None", "none", empSupervisor2);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_014_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("empName", "empId", empSupervisor2);
        pim_employeeListPage.validate();
    }
    @Test
    public void tc_015_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("empName", "empId", empSupervisor);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_016_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("empName1", "empId", empSupervisor);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_017_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("empName", "empId2", empSupervisor);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_018_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("empName", "empId2", empSupervisor2);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_019_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("empName1", "empId", empSupervisor2);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_020_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("empName1", "empId2", empSupervisor2);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_021_search() throws IOException, InterruptedException {
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("empName1", "empId2", empSupervisor);
        pim_employeeListPage.validate();

    }
//    @Test
//    public void tc_022_search() throws IOException, InterruptedException {
//        commonActionsProduced(url, username, password);
//        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
//        pim_employeeListPage.click_ON_PIM();
//        verifySectionPage("Employee List", "PIM");
//        pim_employeeListPage.searchEmployee("None", "None","None");
//
//    }
}

