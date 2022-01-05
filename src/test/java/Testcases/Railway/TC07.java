package Testcases.Railway;

import Common.Constant;
import Common.JSonHelper;
import Common.Utilities;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    @Test(description = "TC07 - User can create new account")
    public void TC07() throws Exception {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Register\" tab");
        homePage.gotoRegisterPage();

        System.out.println("3. Enter valid information into all fields & 4. Click on \"Register\" button");
        String filePath = Utilities.getProjectPath() + "\\Common\\data.json";
        JsonObject jsonObject = JSonHelper.getJsonObject(filePath);
        JsonObject dataTC07 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String password = dataTC07.get("password").getAsString();
        String reEnterPassword = dataTC07.get("re_enter_password").getAsString();
        String pid = dataTC07.get("pid").getAsString();
        registerPage.register(Utilities.getRandomEmail(),password,reEnterPassword,pid);

        String actualMsg = registerPage.getMessage();
        String expectedMsg = "Thank you for registering your account.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error that user cannot register an account.");
    }
}
