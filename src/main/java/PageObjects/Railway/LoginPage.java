package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class ='message error LoginForm']");

    public WebElement getTxtUsername()
    {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }
    public WebElement getTxtPassword()
    {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }
    public WebElement getBtnLogin() { return Constant.WEBDRIVER.findElement(btnLogin); }
    public WebElement getLblLoginErrorMsg()
    {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }

    public void login(String username, String password){
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }
    public void logout(){
        this.getTabLogout().click();
    }

    public void loginMultipleTimes(String username, String password, int times){
        for (int i = 0; i < times; i++) {
            System.out.println("count: "+(i+1)+" times");
            this.getTxtUsername().sendKeys(username);
            this.getTxtPassword().sendKeys(password);
            this.getBtnLogin().click();
        }
    }

}
