package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends TestBase{
    @Test
    public void TC03() {
        System.out.println("TC03- User cannot login with invalid password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME,Constant.PASSWORD+"111").getLoginErrorMsg();
        String expectedMsg= "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not display as expected");
    }
}
