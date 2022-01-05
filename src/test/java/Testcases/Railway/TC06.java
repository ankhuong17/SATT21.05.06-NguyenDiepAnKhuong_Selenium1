package Testcases.Railway;

import Common.Constant;
import Common.JSonHelper;
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
        String filePath = Utilities.getProjectPath() + "\\Common\\data.json";
        JsonObject jsonObject = JSonHelper.getJsonObject(filePath);
        JsonObject dataTC01 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC01.get("email").getAsString();
        String password = dataTC01.get("password").getAsString();
        loginPage.login(email, password);
        System.out.println("3. Click on \"Contact\" tab");
        loginPage.gotoContactPage();
        boolean isContactTitleDisplayed = contactPage.isContactPageDisplayed();
        Assert.assertTrue(isContactTitleDisplayed, "Contact Title is displayed failed.");
        System.out.println("4. Click on \"Log out\" tab");
        loginPage.logout();
//        String actualMsg = loginPage.getPageTitle();
//        String expectedMsg = "Welcome to Safe Railway";

//        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not display as expected");

        boolean isHomeTitleDisplayed = homePage.isHomePageDisplayed();
        Assert.assertTrue(isHomeTitleDisplayed, "Homepage Title is displayed failed.");

    }
}
