package Testcases.Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Locale;

public class FTTC601 extends TestBase{
    @Test(description = "FTTC601 - User can book 1 ticket at time",dataProvider = "data-provider")
    public void  FTTC601(String email,String password,String departDate,String departFrom,String arriveAt,String seatType,int ticketAmount){
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("Pre-condition: Create and activate a new account.");
        homePage.open();
        homePage.gotoRegisterPage();
        email = registerPage.registerNewAccount();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        System.out.println("3. Click on \"Book ticket\" tab");
        System.out.println("4. Select a \"Depart date\" from the list");
        System.out.println("5. Select \"Nha Trang\" for \"Depart from\" and \"Huế\" for \"Arrive at\".");
        System.out.println("6. Select \"Soft seat\" for \"Seat type\"");
        System.out.println("7. Select \"2\" for \"Ticket amount\"");
        System.out.println("8. Click on \"Book ticket\" button");
        loginPage.login(email, password);
        loginPage.gotoBookTicketPage();
        homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket(departDate,departFrom, arriveAt,seatType,ticketAmount);

        String actualDepartDate = bookTicketPage.getTicketDepartDate();
        String expectedDepartDate = departDate;
        String actualDepartStation = bookTicketPage.getTicketDepartStation();
        String expectedDepartStation = departFrom;
        String actualArriveStation = bookTicketPage.getTicketArriveStation();
        String expectedArriveStation = arriveAt;
        String actualSeatType = bookTicketPage.getTicketSeatType();
        String expectedSeatType = seatType;
        int actualTicketAmount = bookTicketPage.getTicketAmount();
        int expectedTicketAmount = ticketAmount;
        String actualMsg = bookTicketPage.getSuccessMessage();
        String expectedMsg = "Ticket booked successfully!";

        Assert.assertEquals(actualDepartDate, expectedDepartDate, "Depart date is not displayed as expected.");
        Assert.assertEquals(actualDepartStation, expectedDepartStation, "Depart Station is not displayed as expected.");
        Assert.assertEquals(actualArriveStation, expectedArriveStation, "Arrive Station is not displayed as expected.");
        Assert.assertEquals(actualSeatType, expectedSeatType, "Seat type is not displayed as expected.");
        Assert.assertEquals(actualTicketAmount, expectedTicketAmount, "Ticket amount is not displayed as expected.");
        Assert.assertEquals(actualMsg.toLowerCase(), expectedMsg.toLowerCase(), "Error message is not displayed as expected.");

    }


    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "\\DataObjects\\data.json";
        System.out.println(filePath);
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataFTTC601 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email ="" ;
        String password = dataFTTC601.get("password").getAsString();
        String departDate = Constant.DEPART_DATE;
        String departStation = dataFTTC601.get("departFrom").getAsString();
        String arriveStation = dataFTTC601.get("arriveAt").getAsString();
        String seatType = dataFTTC601.get("seatType").getAsString();
        int amount = dataFTTC601.get("ticketAmount").getAsInt();

        Object[][] object = new Object[][]{
                {email,password,departDate, departStation, arriveStation, seatType , amount}
        };

        return object;
    }
}