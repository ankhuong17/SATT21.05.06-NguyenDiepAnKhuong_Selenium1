package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC17 extends TestBase {
    @Test(description = "TC17 - User can't book more than 10 tickets")
    public void TC17() {
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        System.out.println("3. Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();
        System.out.println("4. Book 10 tickets");
        bookTicketPage.bookTicketMultipleTimes(10);
        System.out.println("5. Click on \"Book ticket\" tab again");
        homePage.gotoBookTicketPage();
        System.out.println("6. Book one more ticket");
        bookTicketPage.bookTicket(Constant.DEPART_DATE, Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE, "1");

        String actualErrorMsg = bookTicketPage.getErrorMessage();
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        String actualValidationErrorMsg = bookTicketPage.getTicketAmountValidationErrorMessage();
        String expectedValidationErrorMsg = "You have booked 10 tickets. You can book no more.";


        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualValidationErrorMsg, expectedValidationErrorMsg, "Validation error message is not displayed as expected.");
    }
}
