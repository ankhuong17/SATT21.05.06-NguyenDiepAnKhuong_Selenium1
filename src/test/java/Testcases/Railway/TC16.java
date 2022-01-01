package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16 extends TestBase{
    @Test(description = "TC16 - User can cancel a ticket")
    public void TC16 () throws InterruptedException {
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD).gotoBookTicketPage();
        bookTicketPage.bookTicket(Constant.DEPART_DATE,Constant.DEPART_FROM, Constant.ARRIVE_AT,Constant.SEAT_TYPE,Constant.TICKET_AMOUNT);
        Thread.sleep(5000);
        homePage.gotoMyTicket();
        myTicketPage.clickCancelButton();
        myTicketPage.clickOKAlert();

        String actualMsg = "";
        String expectedMsg = "i don't know what to write here :((";

        Assert.assertEquals(actualMsg, expectedMsg, "The canceled ticket is not disappeared.");
    }
}
