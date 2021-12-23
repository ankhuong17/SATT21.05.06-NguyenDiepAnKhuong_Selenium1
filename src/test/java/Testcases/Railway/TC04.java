package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase{

    @Test
    public void TC04(){
        System.out.println("TC04 - User is redirected to Book ticket page after logging in");
        HomePage homePage = new HomePage();
        homePage.open();

        homePage.gotoBookTicketPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
         String actualMsg = loginPage.getPageTitle();
         String expectedMsg= "Book ticket";

        Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not display as expected");
    }
}
