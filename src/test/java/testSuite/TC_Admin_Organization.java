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
	String OK = propertiesFile.getProperty("ok_btn");

	String add_action = propertiesFile.getProperty("add_action");
	String remove_action = propertiesFile.getProperty("remove_action");


	String FirstName = propertiesFile.getProperty("FirstName");
	String SecondName = propertiesFile.getProperty("SecondName");
	String empId = propertiesFile.getProperty("empId");


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
	String Name_of_the_location_to_be_added = propertiesFile.getProperty("Name_of_the_location_to_be_added");
	String City_name1 = propertiesFile.getProperty("Name_of_the_city_to_be_added");
	String City_name2 = propertiesFile.getProperty("City_name2");
	String Name_of_the_city_to_be_added = propertiesFile.getProperty("Name_of_the_city_to_be_added");
	String Country_name1 = propertiesFile.getProperty("Country_name1");
	String Country_name2 = propertiesFile.getProperty("Country_name2");
	String Name_of_the_country_to_be_added = propertiesFile.getProperty("Name_of_the_country_to_be_added");

	String base_unit = propertiesFile.getProperty("base_unit");
	String remove_unit = propertiesFile.getProperty("remove_unit");
	String add_unit = propertiesFile.getProperty("add_unit");

	@Test
	public void TC_001_updatingGeneralInformation() throws IOException, InterruptedException {

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
    public void TC_002_validateCountOfEmployees() throws InterruptedException, IOException {

        CommonPage commonPage = new CommonPage(driver);
        Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
        AddEmployee_page addEmployee_page =new AddEmployee_page(driver);

        commonActionsProduced(url,username,password);

        commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1, section1);
        verifySectionPage(section1, module_name1);
        int Before_Count= adminOrganization_general_information_page.validateCountOfEmployees();
        commonPage.selectSectionOfPIM(module_name2,sub_module_name1_of_module_name2);
        verifySectionPage(sub_module_name1_of_module_name2, module_name2);
        clickButton(Add);
        addEmployee_page.addingNewEmployee(FirstName,SecondName,empId);
        clickButton(Save);
        commonPage.selectSectionOfAdmin(module_name1,sub_module_name1_of_module_name1,section1);
        int After_Count= adminOrganization_general_information_page.validateCountOfEmployees();
        Assert.assertTrue(Before_Count+1==After_Count);
        System.out.println("Count of Employees List Updated");
    }
    @Test
    public void TC_003_validateMandatoryFields() throws IOException, InterruptedException {

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
    public void TC_004_validateNonMandatoryFields() throws InterruptedException, IOException {
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

    public void TC_005_verifyAddingNewCity() throws InterruptedException, IOException {
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
    public void TC_006_validateSearchByAvailableLocationName() throws InterruptedException, IOException {
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
    public void TC_007_validateSearchByUnavailableLocationName() throws InterruptedException, IOException {
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
    public void TC_008_validateSearchByAvailableCityName() throws InterruptedException, IOException {
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
    public void TC_009_validateSearchByUnavailableCityName() throws InterruptedException, IOException {
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
    public void TC_010_validateSearchByAvailableCountry() throws InterruptedException, IOException {
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
    public void TC_011_validateSearchByUnavailableCountry() throws InterruptedException, IOException {
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
   public void TC_012_validateOptionsBar() throws InterruptedException, IOException {
       CommonPage commonPage = new CommonPage(driver);
       Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
       Admin_Organization_Locations_page organization_locations_page = new Admin_Organization_Locations_page(driver);

       commonActionsProduced(url, username, password);
       commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1, section2);
       verifySectionPage(section2, module_name1);
       organization_locations_page.validateHidingOptionsBar();

   }


    @Test
    public void TC_013_validateUpdatedCityInfo() throws InterruptedException, IOException {
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
  @Test
    public void TC_014_deletingExistedLocation() throws IOException, InterruptedException {
      CommonPage commonPage = new CommonPage(driver);
      Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
      Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

      commonActionsProduced(url, username, password);
      commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
      verifySectionPage(section2, module_name1);
      organization_locations_page.deletedExistedLocation(Name_of_the_location_to_be_added);
      clickButton(Delete);
      organization_locations_page.clickOk();
      driver.navigate().refresh();
      organization_locations_page.searchByName(search_field1,Name_of_the_location_to_be_added);
      clickButton(Search);
      organization_locations_page.resultsNotFound(Name_of_the_location_to_be_added);
  }
	@Test
	public void TC_015_validateReset() throws IOException, InterruptedException {
		CommonPage commonPage = new CommonPage(driver);
		Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
		Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);

		commonActionsProduced(url, username, password);
		commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section2 );
		verifySectionPage(section2, module_name1);
		organization_locations_page.searchByName(search_field1,Location_name1);
		clickButton(Search);
		organization_locations_page.resultsFound(Location_name1);
		clickButton(Reset);
		organization_locations_page.validateReset(search_field1);

	}

  @Test
  public void TC_016_removeUnitOfStructure() throws IOException, InterruptedException {
	  CommonPage commonPage = new CommonPage(driver);
	  Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
	  Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);
	  Admin_Organization_Structure_page structurePage=new Admin_Organization_Structure_page(driver);

	  commonActionsProduced(url, username, password);
	  commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section3 );
	  verifySectionPage(section3, module_name1);
	  clickButton(Edit);
	  structurePage.editUnit(remove_unit,remove_action);
	  structurePage.clickOk();
	  driver.navigate().refresh();
	  structurePage.validateEditedUnit(remove_unit);
  }
	@Test
	public void TC_017_addUnitOfStructure() throws IOException, InterruptedException {
		CommonPage commonPage = new CommonPage(driver);
		Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
		Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);
		Admin_Organization_Structure_page structurePage=new Admin_Organization_Structure_page(driver);

		commonActionsProduced(url, username, password);
		commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section3 );
		verifySectionPage(section3, module_name1);
		clickButton(Edit);
		structurePage.editUnit(base_unit,add_action);
		structurePage.editDetails(add_unit);
		clickButton(Save);
		driver.navigate().refresh();
		structurePage.validateEditedUnit(add_unit);
	}
	@Test
	public void TC_018_updateUnitOfStructure() throws IOException, InterruptedException {
		CommonPage commonPage = new CommonPage(driver);
		Admin_Organization_General_Information_page adminOrganization_general_information_page = new Admin_Organization_General_Information_page(driver);
		Admin_Organization_Locations_page organization_locations_page=new Admin_Organization_Locations_page(driver);
		Admin_Organization_Structure_page structurePage=new Admin_Organization_Structure_page(driver);

		commonActionsProduced(url, username, password);
		commonPage.selectSectionOfAdmin(module_name1, sub_module_name1_of_module_name1,section3 );
		verifySectionPage(section3, module_name1);
		clickButton(Edit);
		structurePage.clickUnit(add_unit);
		structurePage.editDetails(remove_unit);
		clickButton(Save);
		driver.navigate().refresh();
		structurePage.validateEditedUnit(remove_unit);
	}


}
