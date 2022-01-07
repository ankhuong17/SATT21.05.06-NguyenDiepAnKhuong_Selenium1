package Testcases.Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase {
    @Test(description = "TC09 - User can't change password when \"New Password\" and \"Confirm Password\" are different.")
    public void TC09() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage=new RegisterPage();
        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        homePage.gotoRegisterPage();
        String email = registerPage.registerNewAccount();
        System.out.println("1. Navigate to QA Railway Website\n");
        homePage.open();
        System.out.println("2. Login with a valid account & 3. Click on \"Change Password\" tab");
        homePage.gotoLoginPage();
        loginPage.login(email, Constant.REG_PASSWORD);
        loginPage.gotoChangePasswordPage();

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.changePassword(Constant.REG_PASSWORD, Constant.NEW_PASSWORD, Constant.CONFIRM_PASSWORD);

        String actualMsg = changePasswordPage.getMessageError();
        String expectedMsg = "Password change failed. Please correct the errors and try again.";
        String actualConfirmPasswordErrorMsg = changePasswordPage.getMessageError();
        String expectedConfirmPasswordErrorMsg = "The password confirmation does not match the new password.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualConfirmPasswordErrorMsg, expectedConfirmPasswordErrorMsg, "Confirm error message is not displayed as expected.");
    }
}
