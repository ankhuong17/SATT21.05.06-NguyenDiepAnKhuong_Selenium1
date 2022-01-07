package Testcases.Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import com.google.gson.JsonObject;
import com.sun.org.apache.bcel.internal.Const;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.ConsoleHandler;

public class TC10 extends TestBase{
    @Test(description = "TC10 - User can't create account with an already in-use email")
    public void TC10(){
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        homePage.gotoRegisterPage();
        String email = registerPage.registerNewAccount();

        System.out.println("1. Navigate to QA Railway Website\n");
        homePage.open();
        System.out.println("2. Click on \"Register\" tab\n");
        homePage.gotoRegisterPage();
        System.out.println("3. Enter information of the created account in Pre-condition & 4. Click on \"Register\" button\n");

        registerPage.register(email, Constant.REG_PASSWORD,Constant.REG_CONFIRM_PASSWORD,Constant.PID);

        String actualMsg = registerPage.getMessageError();
        String expectedMsg = "This email address is already in use.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}
