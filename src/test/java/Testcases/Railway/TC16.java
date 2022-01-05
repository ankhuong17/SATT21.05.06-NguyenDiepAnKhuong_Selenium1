package Testcases.Railway;

import Common.JSonHelper;
import Common.Utilities;
import Common.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16 extends TestBase{
    @Test(description = "TC16 - User can cancel a ticket")
    public void TC16 () throws Exception {
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        String filePath = Utilities.getProjectPath() + "\\Common\\data.json";
        JsonObject jsonObject = JSonHelper.getJsonObject(filePath);
        JsonObject dataTC16 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC16.get("email").getAsString();
        String password = dataTC16.get("password").getAsString();
        loginPage.login(email, password).gotoBookTicketPage();
        System.out.println("3. Book a ticket");
        String departDate = Constant.DEPART_DATE;
        String departFrom = dataTC16.get("departFrom").getAsString();
        String arriveAt = dataTC16.get("arriveAt").getAsString();
        String seatType = dataTC16.get("seatType").getAsString();
        String ticketAmount = String.valueOf(dataTC16.get("ticketAmount").getAsInt());
        bookTicketPage.bookTicket(departDate,departFrom, arriveAt,seatType,ticketAmount);

        System.out.println("4. Click on \"My ticket\" tab");
        homePage.gotoMyTicket();
        System.out.println("5. Click on \"Cancel\" button of ticket which user want to cancel.");
        myTicketPage.clickCancelButton();
        System.out.println("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        myTicketPage.clickOKAlert();
        String actualMsg = myTicketPage.getLblTicketInfor();
        String expectedMsg = "You currently book 0 ticket, you can book 10 more.";

        Assert.assertEquals(actualMsg, expectedMsg, "User cannot cancel their ticket.");

    }
}
