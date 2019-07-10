package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.CommonActions;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class TC_Admin_Organization extends CommonActions {


    FileInputStream myFile;

    {
        try {
            myFile = new FileInputStream("InputData.properties");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public Properties propertiesFile = new Properties();

    {
        try {
            propertiesFile.load(myFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String url = propertiesFile.getProperty("url");
    String username = propertiesFile.getProperty("username");
    String password = propertiesFile.getProperty("password");
    String module_name1 = propertiesFile.getProperty("module_name1");
    String sub_module_name1_of_module_name1 = propertiesFile.getProperty("sub_module_name1_of_module_name1");
    String section1 = propertiesFile.getProperty("section1");
    String section2 = propertiesFile.getProperty("section2");
    String section3 = propertiesFile.getProperty("section3");
    String new_data1 = propertiesFile.getProperty("new_data1");
    String input_for_new_data1 = propertiesFile.getProperty("input_for_new_data1");
    String module_name2 = propertiesFile.getProperty("module_name2");
    String sub_module_name1_of_module_name2 = propertiesFile.getProperty("sub_module_name1_of_module_name2");
    String new_data2 = propertiesFile.getProperty("new_data2");
    String input_for_new_data2 = propertiesFile.getProperty("input_for_new_data2");
    String new_data3 = propertiesFile.getProperty("new_data3");
    String input_for_new_data3 = propertiesFile.getProperty("input_for_new_data3");
    String search_field1 = propertiesFile.getProperty("search_field1");
    String Location_name1 = propertiesFile.getProperty("Location_name1");
    String Location_name2 = propertiesFile.getProperty("Location_name2");
    String search_field2 = propertiesFile.getProperty("search_field2");
    String City_name1 = propertiesFile.getProperty("City_name1");
    String City_name2 = propertiesFile.getProperty("City_name2");
    String Country_name1 = propertiesFile.getProperty("Country_name1");
    String Country_name2 = propertiesFile.getProperty("Country_name2");


    @Test
    public void updatingGeneralInformation() throws IOException, InterruptedException {

        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);

        commonActionsProduced(url, username, password);

        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1, section1);
        verifySectionPage(section1,module_name1);

        clickButton(propertiesFile.getProperty("button"));
        //adminOrganization_general_information_page.clickEdit();
        adminOrganization_general_information_page.updateDetails(new_data1, input_for_new_data1);
        adminOrganization_general_information_page.clickSave();
        driver.navigate().refresh();
        adminOrganization_general_information_page.validateUpdatedInformation(new_data1, input_for_new_data1);
    }
//
  @Test
    public void validateCountOfEmployees() throws InterruptedException, IOException {

        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        PIM_EmployeeList_Page pim_employee_list_page=new PIM_EmployeeList_Page(driver);

        commonActionsProduced(url,username,password);

        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1, section1);
        adminOrganization_general_information_page.verifySectionPage(section1);
        int Before_Count= adminOrganization_general_information_page.validateCountOfEmployees();
        commonPage.selectSectionOfPIM(module_name2,sub_module_name1_of_module_name2);
        pim_employee_list_page.addingNewEmployee();
        commonPage.selectSectionOfAdmin(module_name1,sub_module_name1_of_module_name1,section1);
        int After_Count= adminOrganization_general_information_page.validateCountOfEmployees();
        Assert.assertTrue(Before_Count+1==After_Count);
        System.out.println("Count of Employees List Updated");
    }
  @Test
    public void validateMandatoryFields() throws IOException, InterruptedException {

        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);

        commonActionsProduced(url,username,password);

        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1, section1);
        adminOrganization_general_information_page.verifySectionPage(section1);
        adminOrganization_general_information_page.clickEdit();
        adminOrganization_general_information_page.updateDetails(new_data2,input_for_new_data2);
        adminOrganization_general_information_page.clickSave();
        adminOrganization_general_information_page.validationError();

    }
   @Test
    public void validateNonMandatoryFields() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);

        commonActionsProduced(url,username,password);

        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1, section1);
        adminOrganization_general_information_page.verifySectionPage(section1);
        adminOrganization_general_information_page.clickEdit();
        adminOrganization_general_information_page.updateDetails(new_data3,input_for_new_data3);
        adminOrganization_general_information_page.clickSave();
        driver.navigate().refresh();
        adminOrganization_general_information_page.validateUpdatedInformation(new_data3,input_for_new_data3);
    }
    @Test
    public void validateSearchByAvailableLocationName() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        adminOrganization_general_information_page.verifySectionPage(section2);
        organization_locations_page.searchByName(search_field1,Location_name1);
        organization_locations_page.clickSearch();
        organization_locations_page.resultsFound(Location_name1);

    }
    @Test
    public void validateSearchByUnavailableLocationName() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        adminOrganization_general_information_page.verifySectionPage(section2);
        organization_locations_page.searchByName(search_field1,Location_name2);
        organization_locations_page.clickSearch();
        organization_locations_page.resultsNotFound(Location_name2);

    }
    @Test
    public void validateSearchByAvailableCityName() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        adminOrganization_general_information_page.verifySectionPage(section2);
        organization_locations_page.searchByName(search_field2,City_name1);
        organization_locations_page.clickSearch();
        organization_locations_page.resultsFound(City_name1);

    }
    @Test
    public void validateSearchByUnavailableCityName() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        adminOrganization_general_information_page.verifySectionPage(section2);
        organization_locations_page.searchByName(search_field2,City_name2);
        organization_locations_page.clickSearch();
        organization_locations_page.resultsNotFound(City_name2);

    }
    @Test
    public void validateSearchByAvailableCountry() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        adminOrganization_general_information_page.verifySectionPage(section2);
        organization_locations_page.selectCountry(Country_name1);
        organization_locations_page.clickSearch();
        organization_locations_page.resultsFound(Country_name2);

    }
    @Test
    public void validateSearchByUnavailableCountry() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        adminOrganization_general_information_page.verifySectionPage(section2);
        organization_locations_page.selectCountry(Country_name2);
        organization_locations_page.clickSearch();
        organization_locations_page.resultsNotFound(Country_name2);

    }

}
