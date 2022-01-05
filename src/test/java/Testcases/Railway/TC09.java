package Testcases.Railway;

import Common.Constant;
import Common.JSonHelper;
import Common.Utilities;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase {
    @Test(description = "TC09 - User can't change password when \"New Password\" and \"Confirm Password\" are different.")
    public void TC09() throws Exception {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        System.out.println("1. Navigate to QA Railway Website\n");
        homePage.open();
        System.out.println("2. Login with a valid account & 3. Click on \"Change Password\" tab");
        homePage.gotoLoginPage();
        String filePath = Utilities.getProjectPath() + "\\Common\\data.json";
        JsonObject jsonObject = JSonHelper.getJsonObject(filePath);
        JsonObject dataTC09 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC09.get("email").getAsString();
        String password = dataTC09.get("password").getAsString();
        String newPassword = dataTC09.get("new_password").getAsString();
        String confirmPassword = dataTC09.get("confirm_password").getAsString();
        loginPage.login(email, password).gotoChangePasswordPage();

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.changePassword(password, newPassword, confirmPassword);

        String actualMsg = changePasswordPage.getMessageError();
        String expectedMsg = "Password change failed. Please correct the errors and try again.";
        String actualConfirmPasswordErrorMsg = changePasswordPage.getMessageError();
        String expectedConfirmPasswordErrorMsg = "The password confirmation does not match the new password.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualConfirmPasswordErrorMsg, expectedConfirmPasswordErrorMsg, "Confirm error message is not displayed as expected.");
    }
}
