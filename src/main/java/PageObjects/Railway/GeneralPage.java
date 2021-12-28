package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");

    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");

    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");

    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    private final By lblTitle = By.xpath("//h1");

    private final By lblLoginErrorMsg = By.xpath("//p[@class ='message error LoginForm']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");

    public WebElement getLblLoginErrorMsg() { return Constant.WEBDRIVER.findElement(lblLoginErrorMsg); }

    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getlblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTitle() {
        return Constant.WEBDRIVER.findElement(lblTitle);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabChangePassword() { return Constant.WEBDRIVER.findElement(tabChangePassword); }

    public String getWelcomeMessage() {
        return this.getlblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public BookTicketPage gotoBookTicketPage() {
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }

    public String getPageTitle() {
        return this.getTitle().getText();
    }

    public String getLoginErrorMsg() {
        return this.getLblLoginErrorMsg().getText();
    }

    public void gotoChangePasswordPage() {
        this.getTabChangePassword().click();
    }
}
