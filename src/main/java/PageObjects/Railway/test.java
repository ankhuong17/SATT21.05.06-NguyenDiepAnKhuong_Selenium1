package PageObjects.Railway;

import Common.Common.Utilities;

import java.text.ParseException;

public class test {
    public static void main(String[] args) throws ParseException {
        String dt= Utilities.getNextDays(7);
        System.out.println("date: " + dt);
    }
}
