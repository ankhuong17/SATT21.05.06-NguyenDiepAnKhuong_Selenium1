package PageObjects.Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage {
    //dynamic locator
    String linkCheckPrice = "//td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a";

    public WebElement getLinkCheckPrice(String depart, String arrive){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(linkCheckPrice, depart, arrive)));
    }
    //methods
    public void clickLinkCheckPrice(String depart, String arrive){

        Utilities.scrollDownToElement(getLinkCheckPrice(depart,arrive));
        this.getLinkCheckPrice(depart, arrive).click();
    }
}
