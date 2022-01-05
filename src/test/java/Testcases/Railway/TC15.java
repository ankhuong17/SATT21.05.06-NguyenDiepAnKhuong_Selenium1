package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.TicketPricePage;
import PageObjects.Railway.TimeTablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 extends TestBase{
    @Test(description = "TC15 - \"Ticket price\" page displays with ticket details after clicking on \"check price\" link in \"Train timetable\" page")
    public void TC15(){
        System.out.println("Pre-condition: Create and activate a new account");
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimeTablePage timeTablePage = new TimeTablePage();
        TicketPricePage ticketPricePage = new TicketPricePage();

        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoTimeTable();
        timeTablePage.gotoTicketPrice();

        String actualTitle = ticketPricePage.getPageTitle();
        String expectedTitle = "Ticket Price";
        String actualMsg = ticketPricePage.getTextLblTicketInfo();
        String expectedMsg = "Ticket price from Đà Nẵng to Sài Gòn";
        String actualHSPrice = ticketPricePage.getHSPrice();
        String expectedHSPrice = "310000";
        String actualSSPrice = ticketPricePage.getSSPrice();
        String expectedSSPrice = "335000";
        String actualSSCPrice = ticketPricePage.getSSCPrice();
        String expectedSSCPrice = "360000";
        String actualHBPrice = ticketPricePage.getHBPrice();
        String expectedHBPrice = "410000";
        String actualSBPrice = ticketPricePage.getSBPrice();
        String expectedSBPrice = "460000";
        String actualSBCPrice = ticketPricePage.getSBCPrice();
        String expectedSBCPrice = "510000";

        Assert.assertEquals(actualTitle, expectedTitle, "Page title is not displayed as expected.");
        Assert.assertEquals(actualMsg, expectedMsg, "Ticket table is not displayed as expected.");
        Assert.assertEquals(actualHSPrice, expectedHSPrice, "HS price is not displayed as expected.");
        Assert.assertEquals(actualSSPrice, expectedSSPrice, "SS price is not displayed as expected.");
        Assert.assertEquals(actualSSCPrice, expectedSSCPrice, "SSC price is not displayed as expected.");
        Assert.assertEquals(actualHBPrice, expectedHBPrice, "HB price is not displayed as expected.");
        Assert.assertEquals(actualSBPrice, expectedSBPrice, "SB price is not displayed as expected.");
        Assert.assertEquals(actualSBCPrice, expectedSBCPrice, "SBC price is not displayed as expected.");
    }
}
