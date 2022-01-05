package Common;


import org.openqa.selenium.WebDriver;

public class Constant {

    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.raillog.somee.com/";
    public static final String BOOK_TICKET_PAGE_TITLE = "Book ticket";
    public static final String LOGIN_PAGE_TITLE = "Login Page";
    public static final String HOME_PAGE_TITLE = "Welcome to Safe Railway";
    //USERNAME/EMAIL
    public static final String USERNAME = "khuong.nguyendiepan@gmail.com";
    public static final String USERNAME_BLANK = "";
    public static final String RANDOM_EMAIL = Utilities.getRandomEmail();
    //PASSWORD
    public static final String PASSWORD = "ankhuong3107";
    public static final String NEW_PASSWORD = "123456789";
    public static final String INVALID_CONFIRM_PASSWORD = "123a456a789";
    public static final String BLANK_PASSWORD = "";
    //PASSPORT/PID
    public static final String PID = "1234567891";
    public static final String EMPTY_PID = "";
    //BOOKTICKET
    public static final String DEPART_FROM = "Nha Trang";
    public static final String ARRIVE_AT = "Sài Gòn";
    public static final String SEAT_TYPE = "Soft seat with air conditioner";
    public static final String TICKET_AMOUNT = "5";
    public static final String DEPART_DATE = Utilities.getNextDays(7);


}


