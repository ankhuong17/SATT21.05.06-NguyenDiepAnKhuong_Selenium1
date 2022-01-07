package PageObjects.Railway;

import Common.Utilities;
import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    private final By txtEmail = By.xpath("//input[@id='email']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By txtPID = By.xpath("//input[@id='pid']");
    private final By btnRegister = By.xpath("//input[@value='Register']");
    private final By lblRegisterErrorMsg = By.xpath("//p[@class ='message error']");
    private final By lblRegisterMsg = By.xpath("//div[@id='content']");

    protected WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    protected WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    protected WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(txtPID);
    }

    protected WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    protected WebElement getLblRegisterErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblRegisterErrorMsg);
    }

    protected WebElement getLblRegisterMsg() {
        return Constant.WEBDRIVER.findElement(lblRegisterMsg);
    }

    public void register(String email, String password, String confirmPassword, String PID) {
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtPID().sendKeys(PID);
        WebElement btnRegister = this.getBtnRegister();
        Utilities.scrollDownToElement(btnRegister);
        btnRegister.click();
    }

    public String getMessage() {
            return this.getLblRegisterMsg().getText();
    }

    public String getMessageError() {
            return this.getLblRegisterErrorMsg().getText();
    }

    public String registerNewAccount() {
        String email = Constant.RANDOM_EMAIL;
        String password = Constant.REG_PASSWORD;
        String confirmPassword = Constant.REG_CONFIRM_PASSWORD;
        String PID =Constant.PID;
        this.register(email, password, confirmPassword, PID);
        return email;
    }
}

