package Testcases.Railway;

import Common.Constant;
import Common.JSonHelper;
import Common.Utilities;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends TestBase{
    @Test(description = "TC08 - User can't login with an account hasn't been activated")
    public void TC08() throws Exception{
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Login\" tab");
        homePage.gotoLoginPage();

        System.out.println("3. Enter username and password of account hasn't been activated. \n4. Click on \"Login\" button");
        String filePath = Utilities.getProjectPath() + "\\Common\\data.json";
        JsonObject jsonObject = JSonHelper.getJsonObject(filePath);
        JsonObject dataTC08 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC08.get("email").getAsString();
        String password = dataTC08.get("password").getAsString();
        loginPage.login(email, password);

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }

}
