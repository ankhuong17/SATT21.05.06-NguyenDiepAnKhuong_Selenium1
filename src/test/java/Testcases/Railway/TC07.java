package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    @Test(description = "TC07 - User can create new account")
    public void TC07(){
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Register\" tab");
        homePage.gotoRegisterPage();

        System.out.println("3. Enter valid information into all fields & 4. Click on \"Register\" button");
        registerPage.register(Constant.RANDOM_EMAIL,Constant.REG_PASSWORD,Constant.REG_CONFIRM_PASSWORD,Constant.PID);

        String actualMsg = registerPage.getMessage();
        String expectedMsg = "Thank you for registering your account.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error that user cannot register an account.");
    }
}
