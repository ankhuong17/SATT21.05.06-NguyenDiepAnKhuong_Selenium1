package Testcases.Railway;

import Common.Constant;
import Common.JSonHelper;
import Common.Utilities;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;

public class TC17 extends TestBase {
    @Test(description = "TC17 - User can't book more than 10 tickets")
    public void TC17() throws Exception {
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        String filePath = Utilities.getProjectPath() + "\\Common\\data.json";
        JsonObject jsonObject = JSonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC17.get("email").getAsString();
        String password = dataTC17.get("password").getAsString();
        loginPage.login(email, password).gotoBookTicketPage();
        System.out.println("3. Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();
        System.out.println("4. Book 10 tickets");
        String departDate = Constant.DEPART_DATE;
        String departFrom = dataTC17.get("departFrom").getAsString();
        String arriveAt = dataTC17.get("arriveAt").getAsString();
        String seatType = dataTC17.get("seatType").getAsString();
        String ticketAmount = String.valueOf(dataTC17.get("ticketAmount").getAsInt());
        bookTicketPage.bookTicketMultipleTimes(departDate,departFrom, arriveAt,seatType,ticketAmount,11);
        System.out.println("5. Click on \"Book ticket\" tab again");
        System.out.println("6. Book one more ticket");


        String actualErrorMsg = bookTicketPage.getErrorMessage();
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        String actualValidationErrorMsg = bookTicketPage.getTicketAmountValidationErrorMessage();
        String expectedValidationErrorMsg = "You have booked 10 tickets. You can book no more.";


        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualValidationErrorMsg, expectedValidationErrorMsg, "Validation error message is not displayed as expected.");
    }
}
