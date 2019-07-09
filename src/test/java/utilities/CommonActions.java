package utilities;

import base.BrowserSetUp;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class CommonActions extends BrowserSetUp {
    public void commonActionsProduced(String url,String userName,String password) throws IOException, InterruptedException {
        //open application
        openApplication(url);
        //login to application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPage();
        loginPage.userLogin(userName, password);

        HomePage homePage=new HomePage(driver);
        homePage.verifyHomePage();

    }
}