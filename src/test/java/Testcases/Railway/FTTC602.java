package Testcases.Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.Railway.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC602 extends TestBase{
    @Test(description = "FTTC602 - User can filter \"Manage ticket\" table with both Depart station and Depart date",dataProvider = "data-provider")
    public void  FTTC602(String email,String password,String departDate,String departFrom,String arriveAt,String seatType,int ticketAmount){
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        System.out.println("Pre-condition: Create and activate a new account.");
        homePage.open();
        homePage.gotoRegisterPage();
        email = registerPage.registerNewAccount();
        System.out.println(email);
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(email,password);
        System.out.println("3. Book more than 6 tickets with different Depart Dates");
        homePage.gotoBookTicketPage();
        bookTicketPage.bookMultipleTicketsWithDifferentDepartDate(departDate,departFrom,arriveAt,seatType,ticketAmount,7);
        System.out.println("4. Click on\"My ticket\" tab");
        bookTicketPage.gotoMyTicket();
        System.out.println("5. Input one of booked Depart Date in \"Depart Station\" and \"Depart date\" textboxes");
        myTicketPage.fillTicketInfoWithFilter(departFrom,"Ignore",Utilities.getNextDays(5),"Ignore");
        Utilities.waitMultipleSeconds(2);

        Assert.assertEquals(myTicketPage.getTicketDepartStation(),departFrom,"The Depart Station is incorrect");
        Assert.assertEquals(myTicketPage.getTicketDepartDate(),Utilities.getNextDays(5),"The Depart Date is incorrect");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "\\DataObjects\\data.json";
        System.out.println(filePath);
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataFTTC602 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email ="" ;
        String password = dataFTTC602.get("password").getAsString();
        String departDate = "";
        String departStation = dataFTTC602.get("departFrom").getAsString();
        String arriveStation = dataFTTC602.get("arriveAt").getAsString();
        String seatType = dataFTTC602.get("seatType").getAsString();
        int amount = dataFTTC602.get("ticketAmount").getAsInt();

        Object[][] object = new Object[][]{
                {email,password,departDate, departStation, arriveStation, seatType , amount}
        };

        return object;
    }
}
