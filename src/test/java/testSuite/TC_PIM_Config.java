package testSuite;

import base.BrowserSetUp;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utilities.CommonActions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
@Listeners({test_listeners.ListenerTest.class})

public class TC_PIM_Config extends CommonActions {
    FileReader reader = null;

    {
        try {
            reader = new FileReader("TestData.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Properties properties = new Properties();
    {
        try
        {
            properties.load(reader);
        }   catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    String url=properties.getProperty("url");
    String username=properties.getProperty("username");
    String password=properties.getProperty("password");
    String module_name1=properties.getProperty("module_name1");
    String sub_module_name1_of_module_name1=properties.getProperty("sub_module_name1_of_module_name1");
    String section1=properties.getProperty("section1");


    @Test
    public void pim_config_optionalfield_001() throws IOException, InterruptedException {



        commonActionsProduced(url,username,password);

        CommonPageActions commonPageActions=new CommonPageActions(driver);
        commonPageActions.clickModule();
        commonPageActions.selectOptionFromConfig(properties.getProperty("option1_from_dropdown"));


        PIM_Config_Optional_Fields_Page optional = new PIM_Config_Optional_Fields_Page(driver);
        optional.addOptionalField();
        String beforeName = optional.beforeAdd();
        String aftreName = optional.afterAdd();
        //Verification
        Assert.assertEquals(beforeName, aftreName);
        System.out.println("---optional field verification is done--");
    }

  @Test
    public void pim_config_optionalfield_002() throws IOException, InterruptedException {
      commonActionsProduced(url,username,password);

      CommonPageActions commonPageActions=new CommonPageActions(driver);
      commonPageActions.clickModule();
      commonPageActions.selectOptionFromConfig(properties.getProperty("option1_from_dropdown"));

      // add more than one optional fields
        PIM_Config_Optional_Fields_Page optional = new PIM_Config_Optional_Fields_Page(driver);
        optional.addMultipleOptionalFields();
    }

    @Test
    public void pim_config_optionalfield_003() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        CommonPageActions commonPageActions=new CommonPageActions(driver);
        commonPageActions.clickModule();
        commonPageActions.selectOptionFromConfig(properties.getProperty("option1_from_dropdown"));

        PIM_Config_Optional_Fields_Page optional = new PIM_Config_Optional_Fields_Page(driver);
        optional.directAdd();
    }
@Test
    public void pim_custom_fields_004() throws IOException ,InterruptedException{
    commonActionsProduced(url,username,password);

    CommonPageActions commonPageActions=new CommonPageActions(driver);
    commonPageActions.clickModule();


    commonPageActions.selectOptionFromConfig(properties.getProperty("option2_from_dropdown"));
    PIM_Config_Custom_Fields_Page custom =new PIM_Config_Custom_Fields_Page(driver);
    custom.clickOnCustomField(properties.getProperty("field_name"),properties.getProperty("screenType"));
    custom.clickOnType(properties.getProperty("type1"),properties.getProperty("select_option"));
}
@Test
    public void pim_custom_fields_005() throws IOException, InterruptedException {
    commonActionsProduced(url,username,password);

    CommonPageActions commonPageActions=new CommonPageActions(driver);
    commonPageActions.clickModule();
    commonPageActions.selectOptionFromConfig(properties.getProperty("option2_from_dropdown"));
    PIM_Config_Custom_Fields_Page custom =new PIM_Config_Custom_Fields_Page(driver);
    custom.clickOnCustomField(properties.getProperty("field_name"),properties.getProperty("screenType"));
    custom.clickOnType(properties.getProperty("type2"),properties.getProperty("select_option"));
   }
   @Test
    public void pim_custom_fields_006() throws IOException, InterruptedException {
       commonActionsProduced(url,username,password);

       CommonPageActions commonPageActions=new CommonPageActions(driver);
       commonPageActions.clickModule();
       commonPageActions.selectOptionFromConfig(properties.getProperty("option2_from_dropdown"));
       PIM_Config_Custom_Fields_Page custom =new PIM_Config_Custom_Fields_Page(driver);
       custom.clickOnCustomField(properties.getProperty("field_name1"),properties.getProperty("screenType1"));
       custom.clickOnType(properties.getProperty("type1"),properties.getProperty("select_option"));
       custom.clickOnCustomField(properties.getProperty("field_name2"),properties.getProperty("screenType2"));
       custom.clickOnType(properties.getProperty("type2"),properties.getProperty("select_option"));
   }
   @Test
    public void pim_custom_fields_007() throws IOException, InterruptedException {
       commonActionsProduced(url,username,password);

       CommonPageActions commonPageActions=new CommonPageActions(driver);
       commonPageActions.clickModule();
       commonPageActions.selectOptionFromConfig(properties.getProperty("option2_from_dropdown"));
       PIM_Config_Custom_Fields_Page custom =new PIM_Config_Custom_Fields_Page(driver);
       custom.directSave();
   }
   @Test
    public void pim_custom_fields_008() throws IOException, InterruptedException {
       commonActionsProduced(url,username,password);

       CommonPageActions commonPageActions=new CommonPageActions(driver);
       commonPageActions.clickModule();
       commonPageActions.selectOptionFromConfig(properties.getProperty("option2_from_dropdown"));
       PIM_Config_Custom_Fields_Page custom =new PIM_Config_Custom_Fields_Page(driver);
       custom.deleteSingleField();
   }
   @Test
   public void pim_custom_fields_009() throws IOException, InterruptedException {
       commonActionsProduced(url,username,password);

       CommonPageActions commonPageActions=new CommonPageActions(driver);
       commonPageActions.clickModule();
       commonPageActions.selectOptionFromConfig(properties.getProperty("option2_from_dropdown"));
       PIM_Config_Custom_Fields_Page custom =new PIM_Config_Custom_Fields_Page(driver);
       custom.deleteAllFields();
   }
    @Test
    public void pim_data_import_011() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        CommonPageActions commonPageActions=new CommonPageActions(driver);
        commonPageActions.clickModule();
        commonPageActions.selectOptionFromConfig(properties.getProperty("option3_from_dropdown"));
        PIM_Config_Data_Import_Page dataimport = new PIM_Config_Data_Import_Page(driver);
        dataimport.importWithInvalidFile();
    }

    @Test
    public void pim_data_import_012() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        CommonPageActions commonPageActions=new CommonPageActions(driver);
        commonPageActions.clickModule();
       commonPageActions.selectOptionFromConfig(properties.getProperty("option3_from_dropdown"));
       PIM_Config_Data_Import_Page dataimport = new PIM_Config_Data_Import_Page(driver);
       dataimport.importWithoutSelectFile();

   }

    @Test
    public void pim_reporting_methods_013() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        CommonPageActions commonPageActions=new CommonPageActions(driver);
        commonPageActions.clickModule();
        commonPageActions.selectOptionFromConfig(properties.getProperty("option4_from_dropdown"));
       PIM_Config_Reporting_Methods_Page reports=new PIM_Config_Reporting_Methods_Page(driver);
       String before=reports.addReportMethods(properties.getProperty("methodName"));
       String after =reports.afterAdd();
       Assert.assertEquals(before,after);

    }
    @Test
    public void pim_reporting_methods_014() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        CommonPageActions commonPageActions=new CommonPageActions(driver);
        commonPageActions.clickModule();
        commonPageActions.selectOptionFromConfig(properties.getProperty("option4_from_dropdown"));
        PIM_Config_Reporting_Methods_Page reports=new PIM_Config_Reporting_Methods_Page(driver);
        reports.addReportMethods(properties.getProperty("methodName1"));
        reports.addReportMethods(properties.getProperty("methodName2"));
   }

    @Test
    public void pim_reporting_methods_015() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        CommonPageActions commonPageActions=new CommonPageActions(driver);
        commonPageActions.clickModule();
        commonPageActions.selectOptionFromConfig(properties.getProperty("option4_from_dropdown"));
        PIM_Config_Reporting_Methods_Page reports = new PIM_Config_Reporting_Methods_Page(driver);
        reports.deleteMethod();
        reports.delete();
    }
    @Test
    public void pim_reporting_methods_016() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        CommonPageActions commonPageActions=new CommonPageActions(driver);
        commonPageActions.clickModule();
        commonPageActions.selectOptionFromConfig(properties.getProperty("option4_from_dropdown"));
        PIM_Config_Reporting_Methods_Page reports = new PIM_Config_Reporting_Methods_Page(driver);
        reports.deleteMultiple(properties.getProperty("no_of_checkbox1"));
        reports.deleteMultiple(properties.getProperty("no_of_checkbox2"));
        reports.delete();

    }
    @Test
    public void pim_reporting_methods_017() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        CommonPageActions commonPageActions=new CommonPageActions(driver);
        commonPageActions.clickModule();
        commonPageActions.selectOptionFromConfig(properties.getProperty("option4_from_dropdown"));
        PIM_Config_Reporting_Methods_Page reports = new PIM_Config_Reporting_Methods_Page(driver);
        reports.deleteAllMethods();
        reports.delete();
    }
    @Test
    public void pim_terminating_reasons_018() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        CommonPageActions commonPageActions=new CommonPageActions(driver);
        commonPageActions.clickModule();
        commonPageActions.selectOptionFromConfig(properties.getProperty("option5_from_dropdown"));
        PIM_Config_Termination_Reasons_Page reasons=new PIM_Config_Termination_Reasons_Page(driver);
        reasons.addTerminationReasons(properties.getProperty("reason"));
    }
    @Test
    public void pim_terminating_reasons_019() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        CommonPageActions commonPageActions=new CommonPageActions(driver);
        commonPageActions.clickModule();
        commonPageActions.selectOptionFromConfig(properties.getProperty("option5_from_dropdown"));
        PIM_Config_Termination_Reasons_Page reasons=new PIM_Config_Termination_Reasons_Page(driver);
        reasons.addTerminationReasons(properties.getProperty("reason2"));
        reasons.addTerminationReasons(properties.getProperty("reason1"));

    }
    @Test
    public void pim_terminating_reasons_020() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        CommonPageActions commonPageActions=new CommonPageActions(driver);
        commonPageActions.clickModule();
        commonPageActions.selectOptionFromConfig(properties.getProperty("option5_from_dropdown"));
        PIM_Config_Termination_Reasons_Page reasons=new PIM_Config_Termination_Reasons_Page(driver);
        reasons.deleteReason();
   }
    @Test
    public void pim_terminating_reasons_022() throws IOException, InterruptedException {
        commonActionsProduced(url,username,password);

        CommonPageActions commonPageActions=new CommonPageActions(driver);
        commonPageActions.clickModule();
        commonPageActions.selectOptionFromConfig(properties.getProperty("option5_from_dropdown"));
        PIM_Config_Termination_Reasons_Page reasons=new PIM_Config_Termination_Reasons_Page(driver);
        reasons.deleteAllReasons();
    }
}
