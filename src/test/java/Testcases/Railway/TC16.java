package Testcases.Railway;

import Common.JsonHelper;
import Common.Utilities;
import Common.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC16 extends TestBase {
    @Test(description = "TC16 - User can cancel a ticket", dataProvider = "data-provider")
    public void TC16(String email, String password, String departDate, String departFrom, String arriveAt, String seatType, int ticketAmount) {
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        loginPage.login(email, password);

        System.out.println("3. Book a ticket");
        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);

        System.out.println("4. Click on \"My ticket\" tab");
        homePage.gotoMyTicket();

        System.out.println("5. Click on \"Cancel\" button of ticket which user want to cancel.");
        myTicketPage.clickCancelButton(departDate, departFrom, arriveAt, seatType, ticketAmount);
        System.out.println("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        myTicketPage.clickOKAlert();
        myTicketPage.gotoMyTicket();//reload MyTicket Page
        System.out.println("toi day roi");
        Assert.assertFalse(myTicketPage.isCancelButtonDisplayed(departDate, departFrom,arriveAt,seatType,ticketAmount), "User cannot cancel their ticket.");

    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "\\DataObjects\\data.json";
        System.out.println(filePath);
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC16 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC16.get("email").getAsString();
        String password = dataTC16.get("password").getAsString();
        String departDate = Constant.DEPART_DATE;
        String departStation = dataTC16.get("departFrom").getAsString();
        String arriveStation = dataTC16.get("arriveAt").getAsString();
        String seatType = dataTC16.get("seatType").getAsString();
        int amount = dataTC16.get("ticketAmount").getAsInt();

        Object[][] object = new Object[][]{
                {email,password,departDate, departStation, arriveStation, seatType , amount}
        };

        return object;
    }
}
