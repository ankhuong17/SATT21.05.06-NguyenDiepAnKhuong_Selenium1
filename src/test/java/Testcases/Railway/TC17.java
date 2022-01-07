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

public class TC17 extends TestBase {
    @Test(description = "TC17 - User can't book more than 10 tickets",dataProvider = "data-provider")
    public void TC17(String email,String password,String departDate,String departFrom,String arriveAt,String seatType,int ticketAmount) {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        RegisterPage registerPage = new RegisterPage();
        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        homePage.gotoRegisterPage();
        email=registerPage.registerNewAccount();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        homePage.gotoLoginPage();
        System.out.println("2. Login with a valid account ");
        loginPage.login(email, password);
        loginPage.gotoBookTicketPage();
        System.out.println("3. Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();
        System.out.println("4. Book 10 tickets");
        System.out.println("5. Click on \"Book ticket\" tab again");
        System.out.println("6. Book one more ticket");
        bookTicketPage.bookTicketMultipleTimes(departDate, departFrom, arriveAt, seatType, ticketAmount, 11);



        String actualErrorMsg = bookTicketPage.getErrorMessage();
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        String actualValidationErrorMsg = bookTicketPage.getTicketAmountValidationErrorMessage();
        String expectedValidationErrorMsg = "You have booked 10 tickets. You can book no more.";


        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualValidationErrorMsg, expectedValidationErrorMsg, "Validation error message is not displayed as expected.");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPath() + "\\DataObjects\\data.json";
        System.out.println(filePath);
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = "";
        String password = dataTC17.get("password").getAsString();
        String departDate = Constant.DEPART_DATE;
        String departStation = dataTC17.get("departFrom").getAsString();
        String arriveStation = dataTC17.get("arriveAt").getAsString();
        String seatType = dataTC17.get("seatType").getAsString();
        int amount = dataTC17.get("ticketAmount").getAsInt();

        Object[][] object = new Object[][]{
                {email, password, departDate, departStation, arriveStation, seatType, amount}
        };

        return object;
    }
}
