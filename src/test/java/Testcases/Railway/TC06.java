package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.ContactPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {
    @Test(description = "TC03 - User is redirected to Home page after logging our")
    public void TC06() {
        HomePage homePage = new HomePage();
        ContactPage contactPage = new ContactPage();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        System.out.println("2. Login with valid Email and Password");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
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
