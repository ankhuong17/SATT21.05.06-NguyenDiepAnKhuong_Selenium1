package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblHomePageTitle = By.xpath("//h1[text()='Welcome to Safe Railway']");
    private final By lblContactPageTitle = By.xpath("//h1[text()='Contact Information']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class ='message error LoginForm']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");
    private final By tabTimeTable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By lblpageTitle = By.xpath("//div[@id='content']/h1");

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }

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

    protected WebElement getLblHomePageTitle() {
        return Constant.WEBDRIVER.findElement(lblHomePageTitle);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    public String getWelcomeMessage() {
        return this.getlblWelcomeMessage().getText();
    }

    public WebElement getLblContactTitle() {
        return Constant.WEBDRIVER.findElement(lblContactPageTitle);
    }

    protected WebElement getTitle() {
        return Constant.WEBDRIVER.findElement(lblpageTitle);
    }

    protected WebElement getTabTimeTable() {
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }

    public String getLoginErrorMsg() {
        try {
            return this.getLblLoginErrorMsg().getText();
        } catch (NoSuchElementException noSuchElementException) {
            noSuchElementException.printStackTrace();
            return "Error message is not displayed.";
        }
    }

    public boolean isLoginErrorMsg() {
        boolean isDisplayed = Constant.WEBDRIVER.findElement(lblLoginErrorMsg).isDisplayed();
        return isDisplayed;
    }

    public void gotoChangePasswordPage() {
        this.getTabChangePassword().click();
    }

    public void gotoContactPage() {
        this.getTabContact().click();
    }

    public boolean isContactPageDisplayed() {
        boolean isDisplayed = this.getLblContactTitle().isDisplayed();
        return isDisplayed;
    }

    public boolean isHomePageDisplayed() {
        boolean isDisplayed = this.getLblHomePageTitle().isDisplayed();
        return isDisplayed;
    }

    public String getPageTitle() {
        return this.getTitle().getText();
    }

    public void gotoTimeTable() {
        this.getTabTimeTable().click();
    }

    public void gotoMyTicket() {
        this.getTabMyTicket().click();
    }
}
