package Testcases.Railway;

import Common.Constant;
import Common.JSonHelper;
import Common.Utilities;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase {

    @Test(description = "TC04 - User is redirected to Book ticket page after logging in")
    public void TC04() throws Exception {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();
        String actualLoginTitle = homePage.getPageTitle();
        String expectedLoginTitle = Constant.LOGIN_PAGE_TITLE;

        System.out.println("3. Login with valid account");
        String filePath = Utilities.getProjectPath() + "\\Common\\data.json";
        JsonObject jsonObject = JSonHelper.getJsonObject(filePath);
        JsonObject dataTC04 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC04.get("email").getAsString();
        String password = dataTC04.get("password").getAsString();
        loginPage.login(email, password);

        String actualTitle = homePage.getPageTitle();
        String expectedTitle = Constant.BOOK_TICKET_PAGE_TITLE;

        Assert.assertEquals(actualLoginTitle,expectedLoginTitle, "Error that User is not directed to Login page.");
        Assert.assertEquals(actualTitle,expectedTitle, "Error that User is not directed to Book Ticket page.");
    }
}
