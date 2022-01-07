package Testcases.Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase{
    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11() throws Exception {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("1. Navigate to QA Railway Website\n");
        homePage.open();
        System.out.println("2. Click on \"Register\" tab\n");
        homePage.gotoRegisterPage();
        System.out.println("3. Enter valid email address and leave other fields empty & 4. Click on \"Register\" button\n");
        registerPage.register(Constant.RANDOM_EMAIL, "","","");

        String actualErrorMsg = registerPage.getMessageError();
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        String actualPasswordErrorMsg = registerPage.getMessageError();
        String expectedPasswordErrorMsg = "Invalid password length";
        String actualPIDErrorMsg = registerPage.getMessageError();
        String expectedPIDErrorMsg = "Invalid ID length.";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualPasswordErrorMsg, expectedPasswordErrorMsg, "Password error message is not displayed as expected.");
        Assert.assertEquals(actualPIDErrorMsg, expectedPIDErrorMsg, "PID error message is not displayed as expected.");
    }
}
