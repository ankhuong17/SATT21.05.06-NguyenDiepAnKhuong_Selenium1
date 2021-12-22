package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;

public class LoginTest {
    @BeforeMethod
    public void beforeMethod() throws IOException {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()+"\\src\\main\\java\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER= new ChromeDriver();
        Dimension size = new Dimension(1280, 1024);
        Constant.WEBDRIVER.manage().window().setSize(size);
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01(){
        System.out.println("TC01- User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME,Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg= "Welcome "+ Constant.USERNAME;

        Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not display as expected");
    }

}
