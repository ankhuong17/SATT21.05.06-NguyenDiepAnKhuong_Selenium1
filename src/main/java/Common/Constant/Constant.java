package Common.Constant;


import Common.Common.Utilities;
import org.openqa.selenium.WebDriver;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.Random;

public class Constant {

    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.raillog.somee.com/";
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


