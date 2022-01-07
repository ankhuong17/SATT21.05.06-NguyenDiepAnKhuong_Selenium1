package Testcases.Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends TestBase{
    @Test(description = "TC08 - User can't login with an account hasn't been activated")
    public void TC08(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage=new RegisterPage();

        System.out.println("Pre-condition: Create a new account but do not activate it");
        homePage.open();
        homePage.gotoRegisterPage();
        String email = registerPage.registerNewAccount();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Login\" tab");
        homePage.gotoLoginPage();

        System.out.println("3. Enter username and password of account hasn't been activated. \n 4. Click on \"Login\" button");
        loginPage.login(email, Constant.REG_PASSWORD);
       // Assert.assertFalse(loginPage.isLoginErrorMsg(),"User can login with an inactivated account");
        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }

}
