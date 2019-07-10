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

    String Edit = propertiesFile.getProperty("edit_btn");
    String Save = propertiesFile.getProperty("save_btn");
    String Add = propertiesFile.getProperty("add_btn");
    String Delete = propertiesFile.getProperty("del_button");
    String Search = propertiesFile.getProperty("search_btn");
    String Reset = propertiesFile.getProperty("reset_btn");

    String module_name1 = propertiesFile.getProperty("module_name1");
    String sub_module_name1_of_module_name1 = propertiesFile.getProperty("sub_module_name1_of_module_name1");
    String section1 = propertiesFile.getProperty("section1");
    String section2 = propertiesFile.getProperty("section2");
    String section3 = propertiesFile.getProperty("section3");
    String module_name2 = propertiesFile.getProperty("module_name2");
    String sub_module_name1_of_module_name2 = propertiesFile.getProperty("sub_module_name1_of_module_name2");

    String data_to_be_updated1 = propertiesFile.getProperty("data_to_be_updated1");
    String input_for_data_to_be_updated1 = propertiesFile.getProperty("input_for_data_to_be_updated1");
    String data_to_be_updated2 = propertiesFile.getProperty("data_to_be_updated2");
    String input_for_data_to_be_updated2 = propertiesFile.getProperty("blank_data");
    String data_to_be_updated3 = propertiesFile.getProperty("data_to_be_updated3");
    String input_for_data_to_be_updated3 = propertiesFile.getProperty("blank_data");
    String data_to_be_updated4 = propertiesFile.getProperty("data_to_be_updated4");
    String input_for_data_to_be_updated4 = propertiesFile.getProperty("input_for_data_to_be_updated4");

    String search_field1 = propertiesFile.getProperty("search_field1");
    String search_field2 = propertiesFile.getProperty("search_field2");
    String Location_name1 = propertiesFile.getProperty("Location_name1");
    String Location_name2 = propertiesFile.getProperty("Location_name2");
    String Name_of_the_location_to_be_added=propertiesFile.getProperty("Name_of_the_location_to_be_added");
    String City_name1 = propertiesFile.getProperty("City_name1");
    String City_name2 = propertiesFile.getProperty("City_name2");
    String Name_of_the_city_to_be_added=propertiesFile.getProperty("Name_of_the_city_to_be_added");
    String Country_name1 = propertiesFile.getProperty("Country_name1");
    String Country_name2 = propertiesFile.getProperty("Country_name2");
    String Name_of_the_country_to_be_added=propertiesFile.getProperty("Name_of_the_country_to_be_added");


   @Test
    public void updatingGeneralInformation() throws IOException, InterruptedException {

        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);

        commonActionsProduced(url, username, password);

        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1, section1);
        verifySectionPage(section1, module_name1);
        clickButton(Edit);
        adminOrganization_general_information_page.updateDetails(data_to_be_updated1, input_for_data_to_be_updated1);
        clickButton(Save);
        driver.navigate().refresh();
        adminOrganization_general_information_page.validateUpdatedInformation(data_to_be_updated1, input_for_data_to_be_updated1);
    }

    @Test
    public void validateCountOfEmployees() throws InterruptedException, IOException {

        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        PIM_EmployeeList_Page pim_employee_list_page=new PIM_EmployeeList_Page(driver);

        commonActionsProduced(url,username,password);

        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1, section1);
        verifySectionPage(section1, module_name1);
        int Before_Count= adminOrganization_general_information_page.validateCountOfEmployees();
        commonPage.selectSectionOfPIM(module_name2,sub_module_name1_of_module_name2);
        verifySectionPage(sub_module_name1_of_module_name2, module_name2);
        clickButton(Add);
        pim_employee_list_page.addingNewEmployee();
        clickButton(Save);
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
        verifySectionPage(section1, module_name1);
        clickButton(Edit);
        adminOrganization_general_information_page.updateDetails(data_to_be_updated2,input_for_data_to_be_updated2);
        clickButton(Save);
        adminOrganization_general_information_page.validationError();

    }
    @Test
    public void validateNonMandatoryFields() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);

        commonActionsProduced(url,username,password);

        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1, section1);
        verifySectionPage(section1, module_name1);
        clickButton(Edit);
        adminOrganization_general_information_page.updateDetails(data_to_be_updated3,input_for_data_to_be_updated3);
        clickButton(Save);
        driver.navigate().refresh();
        adminOrganization_general_information_page.validateUpdatedInformation(data_to_be_updated3,input_for_data_to_be_updated3);
    }
    @Test
    public void validateSearchByAvailableLocationName() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        verifySectionPage(section2, module_name1);
        organization_locations_page.searchByName(search_field1,Location_name1);
        clickButton(Search);
        organization_locations_page.resultsFound(Location_name1);

    }
    @Test
    public void validateSearchByUnavailableLocationName() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        verifySectionPage(section2, module_name1);
        organization_locations_page.searchByName(search_field1,Location_name2);
        clickButton(Search);
        organization_locations_page.resultsNotFound(Location_name2);

    }
    @Test
    public void validateSearchByAvailableCityName() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        verifySectionPage(section2, module_name1);
        organization_locations_page.searchByName(search_field2,City_name1);
        clickButton(Search);
        organization_locations_page.resultsFound(City_name1);

    }
    @Test
    public void validateSearchByUnavailableCityName() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        verifySectionPage(section2, module_name1);
        organization_locations_page.searchByName(search_field2,City_name2);
        clickButton(Search);
        organization_locations_page.resultsNotFound(City_name2);

    }
    @Test
    public void validateSearchByAvailableCountry() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        verifySectionPage(section2, module_name1);
        organization_locations_page.selectCountry(Country_name1);
        clickButton(Search);
        organization_locations_page.resultsFound(Country_name2);

    }
    @Test
    public void validateSearchByUnavailableCountry() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        verifySectionPage(section2, module_name1);
        organization_locations_page.selectCountry(Country_name2);
        clickButton(Search);
        organization_locations_page.resultsNotFound(Country_name2);

    }
   @Test
   public void validateOptionsBar() throws InterruptedException, IOException {
       CommonPage commonPage = new CommonPage(driver);
       Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
       Admin_Organization_Locations_page organization_locations_page = new Admin_Organization_Locations_page(driver);

       commonActionsProduced(url, username, password);
       commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1, section2);
       verifySectionPage(section2, module_name1);
       organization_locations_page.validateHidingOptionsBar();

   }
    @Test
    public void verifyAddingNewCity() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        verifySectionPage(section2, module_name1);
        clickButton(Add);
        organization_locations_page.searchByName(search_field1,Name_of_the_location_to_be_added);
        organization_locations_page.searchByName(search_field2,Name_of_the_city_to_be_added);
        organization_locations_page.selectCountry(Name_of_the_country_to_be_added);
        clickButton(Save);
    }
    @Test
    public void validateUpdatedCityInfo() throws InterruptedException, IOException {
        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

        commonActionsProduced(url, username, password);
        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
        verifySectionPage(section2, module_name1);
        organization_locations_page.clickCity(Name_of_the_location_to_be_added);
        clickButton(Edit);
        organization_locations_page.updateDetails(data_to_be_updated4,input_for_data_to_be_updated4);
        clickButton(Save);
        driver.navigate().refresh();
        organization_locations_page.clickCity(Name_of_the_location_to_be_added);
        organization_locations_page.validateUpdatedInformation(data_to_be_updated4, input_for_data_to_be_updated4);
    }

}
