package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase{
    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11(){
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("1. Navigate to QA Railway Website\n");
        homePage.open();
        System.out.println("2. Click on \"Register\" tab\n");
        homePage.gotoRegisterPage();
        System.out.println("3. Enter valid email address and leave other fields empty & 4. Click on \"Register\" button\n");
        registerPage.register(Constant.RANDOM_EMAIL, Constant.BLANK_PASSWORD,Constant.BLANK_PASSWORD,Constant.EMPTY_PID);

        String actualMsg = registerPage.getMessageError();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error that user cannot register an account with an already in-use email.");
    }
}
