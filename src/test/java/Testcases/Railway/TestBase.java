package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;

public class TestBase {
    @BeforeMethod
    public void beforeMethod() throws IOException {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\src\\main\\java\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Dimension size = new Dimension(1920, 1080);
        Constant.WEBDRIVER.manage().window().setSize(size);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }


}
