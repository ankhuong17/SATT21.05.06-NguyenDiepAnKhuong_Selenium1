package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {
    @Test(description = "TC03 - User is redirected to Home page after logging our")
    public void TC06() {
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.logout();
        String actualMsg = loginPage.getPageTitle();
        String expectedMsg = "Welcome to Safe Railway";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not display as expected");
    }
}
