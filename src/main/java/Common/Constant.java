package Common;


import org.openqa.selenium.WebDriver;

public class Constant {

    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.raillog.somee.com/";
    public static final String BOOK_TICKET_PAGE_TITLE = "Book ticket";
    public static final String LOGIN_PAGE_TITLE = "Login Page";
    public static final String HOME_PAGE_TITLE = "Welcome to Safe Railway";

    public static final String EMAIL = "khuong.nguyendiepan@gmail.com";
    public static final String RANDOM_EMAIL=Utilities.getRandomEmail();
    public static final String PASSWORD = "ankhuong3107";
    public static final String INVALID_PASSWORD = "ankhuong3107@#$#@$";
    public static final String PID = "01234567890";
    public static final String NEW_PASSWORD= "a123:\"/{}!@$\\";
    public static final String CONFIRM_PASSWORD="b456:\"/{}!@$\\";
    public static final String REG_PASSWORD = "123456789";
    public static final String REG_CONFIRM_PASSWORD = "123456789";

    public static final String DEPART_DATE = Utilities.getNextDays(7);


}


