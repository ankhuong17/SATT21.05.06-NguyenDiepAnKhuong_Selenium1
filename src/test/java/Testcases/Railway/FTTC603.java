package Testcases.Railway;

import Common.JsonHelper;
import Common.Utilities;
import PageObjects.Railway.*;
import com.google.gson.JsonObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC603 extends TestBase {
    @Test(description = "FTTC603 - User can cancel all ticket", dataProvider = "data-provider")
    public void FTTC603(String email,String password,String departDate,String departFrom,String arriveAt,String seatType,int ticketAmount) {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        homePage.gotoRegisterPage();
        email = registerPage.registerNewAccount();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(email, password);

        System.out.println("3. Book more than 6 tickets");
        homePage.gotoBookTicketPage();
        bookTicketPage.bookTicketMultipleTimes(departDate, departFrom, arriveAt, seatType, ticketAmount, 7);

        System.out.println("4. Click on \"My ticket\" tab");
        homePage.gotoMyTicket();

        System.out.println("5. Cancel all existing tickets");
        myTicketPage.clickCancelAllTickets(departDate,departFrom,arriveAt,seatType,ticketAmount);


    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "\\DataObjects\\data.json";
        System.out.println(filePath);
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataFTTC603 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = "";
        String password = dataFTTC603.get("password").getAsString();
        String departDate = Utilities.getNextDays(7);
        String departStation = dataFTTC603.get("departFrom").getAsString();
        String arriveStation = dataFTTC603.get("arriveAt").getAsString();
        String seatType = dataFTTC603.get("seatType").getAsString();
        int amount = dataFTTC603.get("ticketAmount").getAsInt();

        Object[][] object = new Object[][]{
                {email, password, departDate, departStation, arriveStation, seatType, amount}
        };

        return object;
    }
}
