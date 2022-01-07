package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage {
    //locators
    private final By lblTicketInfo = By.xpath("//tr[@class='TableSmallHeader']//th[@colspan='7']");
    private final By txtHSPrice = By.xpath("//div[@class='DivTable']//th[contains(text(),'Price')]//following-sibling::td[count(//div[@class='DivTable']//th[contains(text(),'Seat type')]//following-sibling::td[text()='HS']//preceding-sibling::td)+1]");
    private final By txtSSPrice = By.xpath("//div[@class='DivTable']//th[contains(text(),'Price')]//following-sibling::td[count(//div[@class='DivTable']//th[contains(text(),'Seat type')]//following-sibling::td[text()='SS']//preceding-sibling::td)+1]");
    private final By txtSSCPrice = By.xpath("//div[@class='DivTable']//th[contains(text(),'Price')]//following-sibling::td[count(//div[@class='DivTable']//th[contains(text(),'Seat type')]//following-sibling::td[text()='SSC']//preceding-sibling::td)+1]");
    private final By txtHBPrice = By.xpath("//div[@class='DivTable']//th[contains(text(),'Price')]//following-sibling::td[count(//div[@class='DivTable']//th[contains(text(),'Seat type')]//following-sibling::td[text()='HB']//preceding-sibling::td)+1]");
    private final By txtSBPrice = By.xpath("//div[@class='DivTable']//th[contains(text(),'Price')]//following-sibling::td[count(//div[@class='DivTable']//th[contains(text(),'Seat type')]//following-sibling::td[text()='SB']//preceding-sibling::td)+1]");
    private final By txtSBCPrice = By.xpath("//div[@class='DivTable']//th[contains(text(),'Price')]//following-sibling::td[count(//div[@class='DivTable']//th[contains(text(),'Seat type')]//following-sibling::td[text()='SBC']//preceding-sibling::td)+1]");

    //elements
    protected WebElement getLblTicketInfo() {
        return Constant.WEBDRIVER.findElement(lblTicketInfo);
    }

    protected WebElement getTxtHSPrice() {
        return Constant.WEBDRIVER.findElement(txtHSPrice);
    }

    protected WebElement getTxtSSPrice() {
        return Constant.WEBDRIVER.findElement(txtSSPrice);
    }

    protected WebElement getTxtSSCPrice() {
        return Constant.WEBDRIVER.findElement(txtSSCPrice);
    }

    protected WebElement getTxtHBPrice() {
        return Constant.WEBDRIVER.findElement(txtHBPrice);
    }

    protected WebElement getTxtSBPrice() {
        return Constant.WEBDRIVER.findElement(txtSBPrice);
    }

    protected WebElement getTxtSBCPrice() {
        return Constant.WEBDRIVER.findElement(txtSBCPrice);
    }

    //methods
    public String getTextLblTicketInfo() {
        return this.getLblTicketInfo().getText();
    }

    public String getHSPrice() {
        return this.getTxtHSPrice().getText();
    }

    public String getSSPrice() {
        return this.getTxtSSPrice().getText();
    }

    public String getSSCPrice() {
        return this.getTxtSSCPrice().getText();
    }

    public String getHBPrice() {
        return this.getTxtHBPrice().getText();
    }

    public String getSBPrice() {
        return this.getTxtSBPrice().getText();
    }

    public String getSBCPrice() {
        return this.getTxtSBCPrice().getText();
    }
}
