package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utilities {
    public static String getProjectPath() throws IOException {

        String currentDir = System.getProperty("user.dir");

        return currentDir;
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
        return saltStr +dateTime+ "@" + "abc.com";
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
    public static String getDateNow(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String dateNow = dtf.format(now);
        return dateNow;
    }

    public static String right(String value, int length) {
        return value.substring(value.length() - length);
    }

    public static void waitMultipleSeconds(int seconds) {
        try{
            Thread.sleep(seconds*1000);
        }catch(InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }
    }

}
