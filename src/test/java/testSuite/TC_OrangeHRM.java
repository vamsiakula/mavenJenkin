package testSuite;

import org.testng.Assert;
import pages.CommonPage;
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
    String input_name;
    String input_id;
    String input_supervisor;
    String search;
    String module_pim;
    String module_employeeList;
    String input_status;
    String input_jobtitle;
    String input_subunit;
    String add;

    {
        try {
            reader = new FileReader("OrangeHRMData.properties");
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
        input_name = p.getProperty("input_name");
        input_id = p.getProperty("input_id");
        input_supervisor = p.getProperty("input_supervisor");
        search = p.getProperty("search_btn");
        module_pim = p.getProperty("module_name2");
        module_employeeList = p.getProperty("sub_module_name1_of_module_name2");
        input_status = p.getProperty("input_status");
        input_jobtitle = p.getProperty("input_jobtitle");
        input_subunit = p.getProperty("input_subunit");
        add=p.getProperty("add_btn");
    }

    @Test
    public void tc_001_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName, "None", "None",input_name,input_name,input_supervisor);
        clickButton(search);
        pim_employeeListPage.resultsfound(empId);
    }

    @Test
    public void tc_002_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName1, "None", "None",input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();
    }

    @Test
    public void tc_003_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("None", empId, "None",input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.resultsfound(empId);

    }

    @Test
    public void tc_004_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("None", empId2, "None",input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();

    }

    @Test
    public void tc_005_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.dropDown_Search(input_status,input_jobtitle,input_subunit,status,"None","None");
        clickButton(search);
        pim_employeeListPage.resultsfound(empId);

    }

    @Test
    public void tc_006_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.dropDown_Search(input_name,input_jobtitle,input_subunit,"None",jobTitle,"None");
        clickButton(search);
        pim_employeeListPage.resultsfound(empId);

    }

    @Test
    public void tc_007_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.dropDown_Search(input_status,input_jobtitle,input_subunit,"None","None",subUnit);
        clickButton(search);
        pim_employeeListPage.resultsfound(empId);

    }

    @Test
    public void tc_008_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName,empId,"None",input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.resultsfound(empId);

    }

    @Test
    public void tc_009_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName, empId2, "None",input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();


    }

    @Test
    public void tc_010_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName1, empId, "None",input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();

    }

    @Test
    public void tc_011_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName1, empId2, "None",input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();

    }

    @Test
    public void tc_012_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("None", "None",empSupervisor,input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();

    }

    @Test
    public void tc_013_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee("None", "None",empSupervisor2,input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_014_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);

        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName,empId,empSupervisor2,input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();
    }
    @Test
    public void tc_015_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName,empId,empSupervisor,input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_016_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName1,empId,empSupervisor,input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_017_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName1,empId2,empSupervisor,input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_018_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName,empId2,empSupervisor2,input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_019_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName1,empId,empSupervisor2,input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_020_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName1,empId2,empSupervisor2,input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_021_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        pim_employeeListPage.searchEmployee(empName1,empId2,empSupervisor,input_name,input_id,input_supervisor);
        clickButton(search);
        pim_employeeListPage.validate();

    }
    @Test
    public void tc_022_search() throws IOException, InterruptedException {
        CommonPage commonPage = new CommonPage(driver);
        commonActionsProduced(url, username, password);
        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
        verifySectionPage("Employee List", "PIM");
        clickButton(search);
        pim_employeeListPage.noInput();
    }
//    @Test
//    public void tc_0023_addEmployee() throws IOException, InterruptedException {
//        CommonPage commonPage = new CommonPage(driver);
//        commonActionsProduced(url, username, password);
//        PIM_EmployeeList_Page pim_employeeListPage = new PIM_EmployeeList_Page(driver);
//        commonPage.selectSectionOfPIM(module_pim,module_employeeList);
//        verifySectionPage("Employee List", "PIM");
//        clickButton(add);
//    }

}