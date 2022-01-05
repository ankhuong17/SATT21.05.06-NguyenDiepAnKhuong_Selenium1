package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    //locators
    private final By btnCancelTicket = By.xpath("//input[@value='Cancel']");
    private final By lblNumberOfTicketBooked = By.xpath("//li[text()]");

    //elements
    protected WebElement getBtnCancelTicket() {
        return Constant.WEBDRIVER.findElement(btnCancelTicket);
    }

    //methods
    public void clickCancelButton() {
        try {
            WebElement btnCancel = this.getBtnCancelTicket();
            ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", btnCancel);
            btnCancel.click();
        } catch (Exception e) {
            System.out.println("Cannot locate 'Cancel' button because it not exits in form");
        }
    }

    public String getLblTicketInfor() {
        return Constant.WEBDRIVER.findElement(lblNumberOfTicketBooked).getText();
    }

    public void clickOKAlert() {
        try {
            Alert alert = Constant.WEBDRIVER.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("Cannot locate 'OK' button in alert notification");
        }
    }
}
