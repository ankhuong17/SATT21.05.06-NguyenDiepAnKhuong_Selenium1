package Common.Constant;


import org.openqa.selenium.WebDriver;

import java.security.SecureRandom;
import java.util.Random;

public class Constant {

    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.railway.somee.com/";
    public static final String USERNAME = "khuong.nguyendiepan@gmail.com";
    public static final String PASSWORD = "ankhuong3107";
    public static final String USERNAME_BLANK = "";
    public static final String PID = "1234567891";
    public static final String NEW_PASSWORD = "123456789";
    public static final String INVALID_CONFIRM_PASSWORD = "123a456a789";
    public static final String EMPTY_PID = "";
    public static final String RANDOM_EMAIL = getRandomEmail();
    public static final String BLANK_PASSWORD = "";

    private static String getRandomPassword(int len) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

    private static String getRandomEmail() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}


