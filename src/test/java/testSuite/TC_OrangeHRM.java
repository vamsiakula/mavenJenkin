package testSuite;

import pages.PIM_EmployeeList_Page;
import Pages_HRM.Search;
import org.testng.annotations.Test;
import utilities.CommonActions;

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
        empId2= p.getProperty("empId2");
        empSupervisor=p.getProperty("empSupervisor");
        empSupervisor2=p.getProperty("empSupervisor");
        status = p.getProperty("status");
        jobTitle = p.getProperty("jobTitle");
        subUnit = p.getProperty("subUnit");
    }
       @Test
        public void tc_001_search() throws IOException, InterruptedException {

           commonActionsProduced(url,username,password);

            PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
            pim_employeeListPage.click_ON_PIM();
            verifySectionPage("Employee List","PIM");
            Search search = new Search(driver);
            search.searchEmployee(empName, "None", "None");
            search.resultsfound(empId);


        }
        /*@Test
       public void tc_002_search () throws IOException, InterruptedException {
            commonActionsProduced(url,username,password);

            PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
            pim_employeeListPage.click_ON_PIM();
            Search search = new Search(driver);
            search.searchEmployee(empName1, "none", "None");
            search.validate();
   }
   @Test
    public void tc_003_search() throws IOException, InterruptedException {
       commonActionsProduced(url,username,password);

       PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
            pim_employeeListPage.click_ON_PIM();
            Search search = new Search(driver);
            search.searchEmployee("None",empId,"None");
            search.resultsfound(empId);

    }
   @Test
    public void tc_004_search() throws IOException, InterruptedException {
       commonActionsProduced(url,username,password);

       PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
            pim_employeeListPage.click_ON_PIM();
            Search search = new Search(driver);
            search.searchEmployee("None",empId2,"None");
            search.validate();

   }
   @Test
    public void tc_005_search() throws IOException, InterruptedException {
       commonActionsProduced(url,username,password);

       PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
            pim_employeeListPage.click_ON_PIM();
            Search search = new Search(driver);
            search.searchDropDown_Status(status);
            search.resultsfound(empId);

    }
    @Test
    public void tc_006_search() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
            pim_employeeListPage.click_ON_PIM();
            Search search = new Search(driver);
            search.searchDropDown_JobTitle(jobTitle);
            search.resultsfound(empId);

    }
   @Test
    public void tc_007_search() throws IOException, InterruptedException {
       commonActionsProduced(url,username,password);

       PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
            pim_employeeListPage.click_ON_PIM();
            Search search = new Search(driver);
            search.searchDropDown_SubUnit(subUnit);
            search.resultsfound(empId);

    }

    @Test
    public void tc_008_search() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        Search search = new Search(driver);
        search.searchEmployee(empName,empId, "None");
        search.resultsfound(empId);

    }
    @Test
    public void tc_009_search() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        Search search = new Search(driver);
        search.searchEmployee(empName,empId2,"None");
        search.validate();


    }
   @Test
    public void tc_010_search() throws IOException, InterruptedException {
       commonActionsProduced(url,username,password);

       PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        Search search = new Search(driver);
        search.searchEmployee(empName1,empId, "None");
       search.validate();

    }
    @Test
    public void tc_011_search() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        Search search = new Search(driver);
        search.searchEmployee(empName1,empId2, "None");
        search.validate();

    }
    @Test
    public void tc_012_search() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        Search search = new Search(driver);
        search.searchEmployee("None", "None",empSupervisor);
        search.validate();

    }
    @Test
    public void tc_013_search () throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        pim_employeeListPage.click_ON_PIM();
        Search search = new Search(driver);
        search.searchEmployee("None", "none",empSupervisor2);
        search.validate();

    }*/

}

