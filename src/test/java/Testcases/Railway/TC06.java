package Testcases.Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.Railway.ContactPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {
    @Test(description = "TC03 - User is redirected to Home page after logging our")
    public void TC06() throws Exception {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ContactPage contactPage = new ContactPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with valid Email and Password");
        homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);

        System.out.println("3. Click on \"Contact\" tab");
        loginPage.gotoContactPage();

        Assert.assertTrue(contactPage.isContactPageDisplayed(), "Contact Title is displayed failed.");
        System.out.println("4. Click on \"Log out\" tab");
        loginPage.logout();

        Assert.assertTrue(homePage.isHomePageDisplayed(), "Homepage Title is displayed failed.");

    }
}
