package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage{
    //locators
    private final By lnkCheckPrice = By.xpath("//table[@class='MyTable WideTable']//tr//td[text()='Đà Nẵng']//following-sibling::td[text()='Sài Gòn']//following-sibling::td//a[text()='check price']");

    //elements
    protected WebElement getLnkCheckPrice(){
        return Constant.WEBDRIVER.findElement(lnkCheckPrice);
    }

    //methods
    public void gotoTicketPrice(){
        try {
            WebElement link = this.getLnkCheckPrice();
            ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", link);
            link.click();
        }catch (Exception e){
            System.out.println("Cannot navigate to Ticket Price page");
            e.printStackTrace();
        }
    }
}
