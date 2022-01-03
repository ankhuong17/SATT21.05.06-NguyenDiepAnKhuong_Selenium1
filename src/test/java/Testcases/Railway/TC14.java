package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase{
    @Test(description = "TC14 - User can book many tickets at a time")
    public void TC14(){

        HomePage homePage= new HomePage();
        LoginPage loginPage=new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        System.out.println("Pre-condition: Create and activate a new account");
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        System.out.println("3. Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();
        System.out.println("4. Select a \"Depart date\" from the list");
        System.out.println("5. Select \"Nha Trang\" for \"Depart from\" and \"Sài Gòn\" for \"Arrive at\".");
        System.out.println("6. Select \"Soft seat with air conditioner\" for \"Seat type\"");
        System.out.println("7. Select \"5\" for \"Ticket amount\"");
        System.out.println("8. Click on \"Book ticket\" button");
        bookTicketPage.bookTicket(Constant.DEPART_DATE,Constant.DEPART_FROM,Constant.ARRIVE_AT,Constant.SEAT_TYPE,Constant.TICKET_AMOUNT);
        //Utilities.waitMultipleSeconds(3);
        String actualMsg = bookTicketPage.getSuccessMessage();
        String expectedMsg = "Ticket booked successfully!";
        String actualDepartDate = bookTicketPage.getTicketDepartDate();
        String expectedDepartDate = Constant.DEPART_DATE;
        String actualDepartStation = bookTicketPage.getTicketDepartStation();
        String expectedDepartStation = Constant.DEPART_FROM;
        String actualArriveStation = bookTicketPage.getTicketArriveStation();
        String expectedArriveStation = Constant.ARRIVE_AT;
        String actualSeatType = bookTicketPage.getTicketSeatType();
        String expectedSeatType = Constant.SEAT_TYPE;
        String actualTicketAmount = bookTicketPage.getTicketAmount();
        String expectedTicketAmount = Constant.TICKET_AMOUNT;
        //Utilities.waitMultipleSeconds(3);

        Assert.assertEquals(actualMsg,expectedMsg,"Message is not displayed as expected.");
        Assert.assertEquals(actualDepartDate, expectedDepartDate, "Depart date is not displayed as expected.");
        Assert.assertEquals(actualDepartStation, expectedDepartStation, "Depart Station is not displayed as expected.");
        Assert.assertEquals(actualArriveStation, expectedArriveStation, "Arrive Station is not displayed as expected.");
        Assert.assertEquals(actualSeatType, expectedSeatType, "Seat type is not displayed as expected.");
        Assert.assertEquals(actualTicketAmount, expectedTicketAmount, "Ticket amount is not displayed as expected.");
    }
}
