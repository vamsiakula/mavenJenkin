package testSuite;

<<<<<<< HEAD
import pages.PIM_EmployeeList_Page;
=======

>>>>>>> 7c6377fda910e2da6fa5303fafd858c33dec41f9
import Pages_HRM.Search;
import base.BrowserSetUp;
import org.testng.annotations.Test;
<<<<<<< HEAD
import utilities.CommonActions;
=======
import pages.LoginPage;
import pages.PIM_EmployeeList;
>>>>>>> 7c6377fda910e2da6fa5303fafd858c33dec41f9

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

<<<<<<< HEAD
public class TC_OrangeHRM extends CommonActions {
=======
public class TC_OrangeHRM extends BrowserSetUp {
>>>>>>> 7c6377fda910e2da6fa5303fafd858c33dec41f9
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
<<<<<<< HEAD
        public void tc_001_search() throws IOException, InterruptedException {

           commonActionsProduced(url,username,password);

            PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
            pim_employeeListPage.click_ON_PIM();
            verifySectionPage("Employee List","PIM");
=======
        public void tc_001_search() throws InterruptedException {
            openApplication(url);
            LoginPage login = new LoginPage(driver);
            login.userLogin(username, password);
            PIM_EmployeeList pim_employeeList = new PIM_EmployeeList(driver);
            pim_employeeList.click_ON_PIM();
>>>>>>> 7c6377fda910e2da6fa5303fafd858c33dec41f9
            Search search = new Search(driver);
            search.searchEmployee(empName, "None", "None");
            search.resultsfound(empId);

<<<<<<< HEAD

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
=======
        }
//   @Test
//    public void tc_003_search()  {
//            openApplication(url);
//            Login login = new Login(driver);
//            login.loginApplication1(username, password);
//            PIM_EmployeeList pim_employeeList = new PIM_EmployeeList(driver);
//            pim_employeeList.click_ON_PIM();
//            Search search = new Search(driver);
//            search.searchEmployee("None",empId,"None");
//            search.resultsfound(empId);
//            closeApplication();
//    }
//    @Test
//    public void tc_004_search()  {
//            openApplication(url);
//            Login login = new Login(driver);
//            login.loginApplication1(username, password);
//            PIM_EmployeeList pim_employeeList = new PIM_EmployeeList(driver);
//            pim_employeeList.click_ON_PIM();
//            Search search = new Search(driver);
//            search.searchEmployee("None",empId2,"None");
//            search.validate();
//            closeApplication();
//   }
//    @Test
//    public void tc_002_search () {
//        openApplication(url);
//        Login login = new Login(driver);
//        login.loginApplication1(username, password);
//        PIM_EmployeeList pim_employeeList = new PIM_EmployeeList(driver);
//        pim_employeeList.click_ON_PIM();
//        Search search = new Search(driver);
//        search.searchEmployee(empName1, "none", "None");
//        search.validate();
//        closeApplication();
//    }
//    @Test
//    public void tc_005_search(){
//            openApplication(url);
//            Login login = new Login(driver);
//            login.loginApplication1(username, password);
//            PIM_EmployeeList pim_employeeList = new PIM_EmployeeList(driver);
//            pim_employeeList.click_ON_PIM();
//            Search search = new Search(driver);
//            search.searchDropDown_Status(status);
//            search.resultsfound(empId);
//            closeApplication();
//    }
//    @Test
//    public void tc_006_search(){
//            openApplication(url);
//            Login login = new Login(driver);
//            login.loginApplication1(username, password);
//            PIM_EmployeeList pim_employeeList = new PIM_EmployeeList(driver);
//            pim_employeeList.click_ON_PIM();
//            Search search = new Search(driver);
//            search.searchDropDown_JobTitle(jobTitle);
//            search.resultsfound(empId);
//            closeApplication();
//    }
//   @Test
//    public void tc_007_search(){
//            openApplication(url);
//            Login login = new Login(driver);
//            login.loginApplication1(username, password);
//            PIM_EmployeeList pim_employeeList = new PIM_EmployeeList(driver);
//            pim_employeeList.click_ON_PIM();
//            Search search = new Search(driver);
//            search.searchDropDown_SubUnit(subUnit);
//            search.resultsfound(empId);
//            closeApplication();
//    }
//
//    @Test
//    public void tc_008_search() {
//        openApplication(url);
//        Login login = new Login(driver);
//        login.loginApplication1(username, password);
//        PIM_EmployeeList pim_employeeList = new PIM_EmployeeList(driver);
//        pim_employeeList.click_ON_PIM();
//        Search search = new Search(driver);
//        search.searchEmployee(empName,empId, "None");
//        search.resultsfound(empId);
//        closeApplication();
//    }
//    @Test
//    public void tc_009_search() {
//        openApplication(url);
//        Login login = new Login(driver);
//        login.loginApplication1(username, password);
//        PIM_EmployeeList pim_employeeList = new PIM_EmployeeList(driver);
//        pim_employeeList.click_ON_PIM();
//        Search search = new Search(driver);
//        search.searchEmployee(empName,empId2,"None");
//        search.resultsfound(empId);
//        closeApplication();
//
//    }
//   @Test
//    public void tc_010_search() {
//        openApplication(url);
//        Login login = new Login(driver);
//        login.loginApplication1(username, password);
//        PIM_EmployeeList pim_employeeList = new PIM_EmployeeList(driver);
//        pim_employeeList.click_ON_PIM();
//        Search search = new Search(driver);
//        search.searchEmployee(empName1,empId, "None");
//        search.resultsfound(empId);
//        closeApplication();
//    }
//    @Test
//    public void tc_011_search() {
//        openApplication(url);
//        Login login = new Login(driver);
//        login.loginApplication1(username, password);
//        PIM_EmployeeList pim_employeeList = new PIM_EmployeeList(driver);
//        pim_employeeList.click_ON_PIM();
//        Search search = new Search(driver);
//        search.searchEmployee(empName1,empId2, "None");
//        search.resultsfound(empId);
//        closeApplication();
//    }
//    @Test
//    public void tc_012_search() {
//        openApplication(url);
//        Login login = new Login(driver);
//        login.loginApplication1(username, password);
//        PIM_EmployeeList pim_employeeList = new PIM_EmployeeList(driver);
//        pim_employeeList.click_ON_PIM();
//        Search search = new Search(driver);
//        search.searchEmployee("None", "None",empSupervisor);
//        search.validate();
//        closeApplication();
//    }
//    @Test
//    public void tc_013_search () {
//        openApplication(url);
//        Login login = new Login(driver);
//        login.loginApplication1(username, password);
//        PIM_EmployeeList pim_employeeList = new PIM_EmployeeList(driver);
//        pim_employeeList.click_ON_PIM();
//        Search search = new Search(driver);
//        search.searchEmployee("None", "none",empSupervisor2);
//        search.validate();
//        closeApplication();
//    }
>>>>>>> 7c6377fda910e2da6fa5303fafd858c33dec41f9

}

