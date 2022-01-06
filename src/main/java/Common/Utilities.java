package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

public class Utilities {
    public static String getProjectPath() {
        String currentDir = System.getProperty("user.dir");

        return currentDir+"\\src\\main\\java";

    }

    public static String getRandomEmail() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        String dateTime = generateTimeStampString(14);
        return saltStr + dateTime + "@" + "abc.com";
    }

    public static String generateTimeStampString(int length) {
        String timestampStr = null;
        if (length <= 14 && length > 0) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime now = LocalDateTime.now();
            timestampStr = dtf.format(now);
        }
        return Utilities.right(timestampStr, length);
    }

    public static String getDateNow() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String dateNow = dtf.format(now);
        return dateNow;
    }

    public static String getNextDays(int Date) {
        String dt = getDateNow();  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, Date);  // number of days to add
        dt = sdf.format(c.getTime());  // dt is now the new date
        return dt;
    }

    public static String right(String value, int length) {
        return value.substring(value.length() - length);
    }

    public static void waitMultipleSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public static void scrollDownToElement(WebElement element){
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
