package Testcases.Railway;

import Common.Constant;
import Common.JSonHelper;
import Common.Utilities;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends TestBase {

    @Test(description = "TC01- User can log into Railway with valid username and password")
    public void TC01()throws Exception {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Login\" tab");
        homePage.gotoLoginPage();

        System.out.println("3. Enter valid Email and Password & 4. Click on \"Login\" button");
        String filePath = Utilities.getProjectPath() + "\\Common\\data.json";
        JsonObject jsonObject = JSonHelper.getJsonObject(filePath);
        JsonObject dataTC01 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC01.get("email").getAsString();
        String password = dataTC01.get("password").getAsString();
        String actualMsg = loginPage.login(email, password).getWelcomeMessage();
        String expectedMsg = "Welcome " + email;

        System.out.println("Result: ");
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not display as expected");
    }
}
