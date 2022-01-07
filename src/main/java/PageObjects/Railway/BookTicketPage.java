package PageObjects.Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    //Locators
    private final By ddlDepartDate = By.xpath("//select[@name='Date']");
    private final By ddlDepartStation = By.xpath("//select[@name='DepartStation']");
    private final By ddlArriveStation = By.xpath("//select[@name='ArriveStation']");
    private final By ddlSeatType = By.xpath("//select[@name='SeatType']");
    private final By ddlTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By lblBookSuccessfully = By.xpath("//div[@id='content']/h1");
    private final By tdDepartDate = By.xpath("//div[@class='DivTable']//tr[@class='OddRow']//td[count(//div[@class='DivTable']//tr[@class='TableSmallHeader']//th[text()='Depart Date']/preceding-sibling::th)+1]");
    private final By tdDepartStation = By.xpath("//div[@class='DivTable']//tr[@class='OddRow']//td[count(//div[@class='DivTable']//tr[@class='TableSmallHeader']//th[text()='Depart Station']/preceding-sibling::th)+1]");
    private final By tdArriveStation = By.xpath("//div[@class='DivTable']//tr[@class='OddRow']//td[count(//div[@class='DivTable']//tr[@class='TableSmallHeader']//th[text()='Arrive Station']/preceding-sibling::th)+1]");
    private final By tdSeatType = By.xpath("//div[@class='DivTable']//tr[@class='OddRow']//td[count(//div[@class='DivTable']//tr[@class='TableSmallHeader']//th[text()='Seat Type']/preceding-sibling::th)+1]");
    private final By tdTicketAmount = By.xpath("//div[@class='DivTable']//tr[@class='OddRow']//td[count(//div[@class='DivTable']//tr[@class='TableSmallHeader']//th[text()='Amount']/preceding-sibling::th)+1]");
    private final By lblTicketAmountValidationError = By.xpath("//li/label[text()='Ticket amount:']/following-sibling::label[@class='validation-error']");
    private final By lblMessageError = By.xpath("//div/p[@class='message error']");

    //Elements
    protected Select getDdlDepartDate() {
        return new Select(Constant.WEBDRIVER.findElement(ddlDepartDate));
    }

    protected Select getDdlDepartStation() {
        return new Select(Constant.WEBDRIVER.findElement(ddlDepartStation));
    }

    protected Select getDdlArriveStation() {
        return new Select(Constant.WEBDRIVER.findElement(ddlArriveStation));
    }

    protected Select getDdlSeatType() {
        return new Select(Constant.WEBDRIVER.findElement(ddlSeatType));
    }

    protected Select getDdlTicketAmount() {
        return new Select(Constant.WEBDRIVER.findElement(ddlTicketAmount));
    }

    protected WebElement getTdDepartDate() {
        return Constant.WEBDRIVER.findElement(tdDepartDate);
    }

    protected WebElement getTdDepartStation() {
        return Constant.WEBDRIVER.findElement(tdDepartStation);
    }

    protected WebElement getTdArriveStation() {
        return Constant.WEBDRIVER.findElement(tdArriveStation);
    }

    protected WebElement getTdSeatType() {
        return Constant.WEBDRIVER.findElement(tdSeatType);
    }

    protected WebElement getTdTicketAmount() {
        return Constant.WEBDRIVER.findElement(tdTicketAmount);
    }

    protected WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    protected WebElement getLblBookSuccessfully() {
        return Constant.WEBDRIVER.findElement(lblBookSuccessfully);
    }

    protected WebElement getLblTicketAmountValidationError() {
        return Constant.WEBDRIVER.findElement(lblTicketAmountValidationError);
    }

    protected WebElement getLblErrorMessage() {
        return Constant.WEBDRIVER.findElement(lblMessageError);
    }

    //Methods
    public void open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, int ticketAmount) {
        try {

            Select ddlDepartDate = this.getDdlDepartDate();
            ddlDepartDate.selectByVisibleText(departDate);
            Utilities.waitMultipleSeconds(1);

            Select ddlDepartStation = this.getDdlDepartStation();
            ddlDepartStation.selectByVisibleText(departStation);
            Utilities.waitMultipleSeconds(1);

            Select ddlArriveStation = this.getDdlArriveStation();
            ddlArriveStation.selectByVisibleText(arriveStation);

            Select ddlSeatType = this.getDdlSeatType();
            ddlSeatType.selectByVisibleText(seatType);

            Select ddlTicketAmount = this.getDdlTicketAmount();
            ddlTicketAmount.selectByVisibleText(String.valueOf(ticketAmount));
            Utilities.waitMultipleSeconds(1);

            Utilities.scrollDownToElement(getBtnBookTicket());
            getBtnBookTicket().click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot chose an option in book ticket form!");
        }
    }

    public String getSuccessMessage() {
        return this.getLblBookSuccessfully().getText();
    }

    public String getTicketDepartDate() {
        return this.getTdDepartDate().getText();
    }

    public String getTicketDepartStation() {
        return this.getTdDepartStation().getText();

    }

    public String getTicketArriveStation() {
        return this.getTdArriveStation().getText();
    }

    public String getTicketSeatType() {
        return this.getTdSeatType().getText();
    }

    public int getTicketAmount() {
        return Integer.parseInt(getTdTicketAmount().getText());
    }

    public void bookTicketMultipleTimes(String departDate, String departStation, String arriveStation, String
            seatType, int ticketAmount, int times) {
        for (int i = 0; i < times; i++) {
            HomePage homePage = new HomePage();
            homePage.gotoBookTicketPage();
            this.bookTicket(departDate, departStation, arriveStation, seatType, ticketAmount);
        }
    }

    public String getTicketAmountValidationErrorMessage() {
            return this.getLblTicketAmountValidationError().getText();
    }

    public String getErrorMessage() {
            return this.getLblErrorMessage().getText();
    }

    public void bookMultipleTicketsWithDifferentDepartDate(String departDate, String departStation, String arriveStation, String
            seatType, int ticketAmount, int times){
        for (int i = 0; i < times; i++) {
            HomePage homePage = new HomePage();
            homePage.gotoBookTicketPage();
            departDate = Utilities.getNextDays(i+5);
            this.bookTicket(departDate, departStation, arriveStation, seatType, ticketAmount);
        }
    }
}
