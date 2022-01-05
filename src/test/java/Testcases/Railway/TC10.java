package Testcases.Railway;

import Common.Constant;
import Common.JSonHelper;
import Common.Utilities;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase{
    @Test(description = "TC10 - User can't create account with an already in-use email")
    public void TC10() throws Exception {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("1. Navigate to QA Railway Website\n");
        homePage.open();
        System.out.println("2. Click on \"Register\" tab\n");
        homePage.gotoRegisterPage();
        System.out.println("3. Enter information of the created account in Pre-condition & 4. Click on \"Register\" button\n");
        String filePath = Utilities.getProjectPath() + "\\Common\\data.json";
        JsonObject jsonObject = JSonHelper.getJsonObject(filePath);
        JsonObject dataTC10 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC10.get("email").getAsString();
        String password = dataTC10.get("password").getAsString();
        String confirm_password = dataTC10.get("confirm_password").getAsString();
        String pid = dataTC10.get("pid").getAsString();
        registerPage.register(email, password,confirm_password,pid);

        String actualMsg = registerPage.getMessageError();
        String expectedMsg = "This email address is already in use.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}
