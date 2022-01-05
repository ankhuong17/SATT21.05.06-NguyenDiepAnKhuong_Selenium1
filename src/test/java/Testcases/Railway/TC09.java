package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase{
    @Test(description = "TC09 - User can't change password when \"New Password\" and \"Confirm Password\" are different.")
    public void TC09(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        System.out.println("1. Navigate to QA Railway Website\n");
        homePage.open();
        System.out.println("2. Login with a valid account & 3. Click on \"Change Password\" tab");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).gotoChangePasswordPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        System.out.println("");
        changePasswordPage.changePassword(Constant.PASSWORD,Constant.NEW_PASSWORD,Constant.INVALID_CONFIRM_PASSWORD);

        String actualMsg = changePasswordPage.getMessageError();
        String expectedMsg = "Password change failed. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}
