package Testcases.Railway;

import Common.Common.Utilities;
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
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD).gotoBookTicketPage();
        System.out.println("3. Book a ticket");
        bookTicketPage.bookTicket(Constant.DEPART_DATE,Constant.DEPART_FROM, Constant.ARRIVE_AT,Constant.SEAT_TYPE,Constant.TICKET_AMOUNT);
        Thread.sleep(5000);
        System.out.println("4. Click on \"My ticket\" tab");
        homePage.gotoMyTicket();
        System.out.println("5. Click on \"Cancel\" button of ticket which user want to cancel.");
        myTicketPage.clickCancelButton();
        System.out.println("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        myTicketPage.clickOKAlert();
        Utilities.waitMultipleSeconds(2);

    }
}
