package PageObjects.Railway;

import Common.Constant;
import Common.Utilities;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage extends GeneralPage {
    // Dynamic Locators
    String btnCancel = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/../td/input[@value='Cancel']";
    private final By ddlDepartStation = By.xpath("//select[@name='FilterDpStation']");
    private final By ddlArriveStation = By.xpath("//select[@name='FilterArStation']");
    private final By txtDepartDate = By.xpath("//input[@name='FilterDpDate']");
    private final By ddlStatus = By.xpath("//select[@name='FilterStatus']");
    private final By btnApplyFilter = By.xpath("//input[@type='submit']");
    private final By tdDepartDate = By.xpath("//div[@class='DivTable']//tr[@class='OddRow']//td[count(//div[@class='DivTable']//tr[@class='TableSmallHeader']//th[text()='Depart Date']/preceding-sibling::th)+1]");
    private final By tdDepartStation = By.xpath("//div[@class='DivTable']//tr[@class='OddRow']//td[count(//div[@class='DivTable']//tr[@class='TableSmallHeader']//th[text()='Depart Station']/preceding-sibling::th)+1]");
    private final By btnCancelTicket = By.xpath("//input[@value='Cancel']");
    private final By lblNumberOfBookedTickets = By.xpath("//li[text()='You currently book 0 ticket, you can book 10 more.']");
    private final By lblErrorMsg = By.xpath("//div[@class='error message']");


    //elements
    protected WebElement getButtonCancel(String departDate, String departStation, String arriveStation, String seatType, int ticketAmount) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancel, departStation, arriveStation, seatType, departDate, ticketAmount)));
    }

    protected Select getDdlDepartStation() {
        return new Select(Constant.WEBDRIVER.findElement(ddlDepartStation));
    }

    protected Select getDdlArriveStation() {
        return new Select(Constant.WEBDRIVER.findElement(ddlArriveStation));
    }

    protected Select getDdlStatus() {
        return new Select(Constant.WEBDRIVER.findElement(ddlStatus));
    }

    protected WebElement getTxtDepartDate() {
        return Constant.WEBDRIVER.findElement(txtDepartDate);
    }

    protected WebElement getBtnApplyFilter() {
        return Constant.WEBDRIVER.findElement(btnApplyFilter);
    }

    protected WebElement getTdDepartDate() {
        return Constant.WEBDRIVER.findElement(tdDepartDate);
    }

    protected WebElement getBtnCancelTicket() {
        return Constant.WEBDRIVER.findElement(btnCancelTicket);
    }
    protected WebElement getLblErrorMsg(){
        return Constant.WEBDRIVER.findElement(lblErrorMsg);
    }
    protected  WebElement getLblNumberOfBookedTickets() {
        return Constant.WEBDRIVER.findElement(lblNumberOfBookedTickets);
    }

    protected WebElement getTdDepartStation() {
        return Constant.WEBDRIVER.findElement(tdDepartStation);
    }

    //methods
    public void clickCancelButton(String departDate, String departStation, String arriveStation, String seatType, int ticketAmount) {
        try {
            WebElement btnCancel = this.getButtonCancel(departDate, departStation, arriveStation, seatType, ticketAmount);
            Utilities.scrollDownToElement(btnCancel);
            btnCancel.click();
        } catch (Exception e) {
            System.out.println("Cannot locate 'Cancel' button because it not exits in form");
        }
    }

    public void clickOKAlert() {
        try {
            Alert alert = Constant.WEBDRIVER.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("Cannot locate 'OK' button in alert notification");
        }
    }

    public boolean isCancelButtonDisplayed(String departDate, String departStation, String arriveStation, String seatType, int ticketAmount) {
        try {
            boolean isDisplayed = getButtonCancel(departDate, departStation, arriveStation, seatType, ticketAmount).isDisplayed();
            return isDisplayed;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void fillTicketInfoWithFilter(String departStation, String arriveStation, String departDate, String status) {
        Select ddlDepartStation = this.getDdlDepartStation();
        ddlDepartStation.selectByVisibleText(departStation);
        Utilities.waitMultipleSeconds(1);

        Select ddlArriveStation = this.getDdlArriveStation();
        ddlArriveStation.selectByVisibleText(arriveStation);
        Utilities.waitMultipleSeconds(1);

        getTxtDepartDate().sendKeys(departDate);

        Select ddlStatus = this.getDdlStatus();
        ddlStatus.selectByVisibleText(status);
        Utilities.waitMultipleSeconds(1);

        getBtnApplyFilter().click();

    }

    public String getTicketDepartDate() {
        return this.getTdDepartDate().getText();
    }

    public String getTicketDepartStation() {
        return this.getTdDepartStation().getText();
    }

    public void clickCancelAllTickets(String departDate, String departStation, String arriveStation, String seatType, int ticketAmount) {
      int times = Constant.WEBDRIVER.findElements(By.xpath("//tr[@class='TableSmallHeader']/following-sibling::tr")).size();
        for(int i=1;i<= times;i++){
           clickCancelButton(departDate,departStation,arriveStation,seatType,ticketAmount);
       }
    }


}
