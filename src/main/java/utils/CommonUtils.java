package utils;

import java.util.GregorianCalendar;
import java.util.Random;

public class CommonUtils {
    public CommonUtils() {
    }

    public static String getRandomFiveCharsString() {
        StringBuilder rndString = new StringBuilder();

        while(rndString.length() < 5) {
            int index = (new Random()).nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZ".length());
            rndString.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(index));
        }

        return rndString.toString();
    }

    public static String getRandomFiveCharsString(int length) {
        StringBuilder rndString = new StringBuilder();

        while(rndString.length() < length) {
            int index = (new Random()).nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZ".length());
            rndString.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(index));
        }

        return rndString.toString().toString();
    }

    public static String getRandomLimitedSpecialCharacter(int length) {
        String specialChars = "!@#$%^&";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < length; ++i) {
            sb.append(specialChars.charAt(random.nextInt(specialChars.length())));
        }

        return sb.toString();
    }

    public static String getRandomAllSpecialCharacter(int length) {
        String specialChars = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < length; ++i) {
            sb.append(specialChars.charAt(random.nextInt(specialChars.length())));
        }

        return sb.toString();
    }

    public static String getRandomSevenNumbersString() {
        StringBuilder rndString = new StringBuilder();

        while(rndString.length() < 7) {
            int index = (new Random()).nextInt("0123456789".length());
            rndString.append("0123456789".charAt(index));
        }

        return rndString.toString();
    }

    public static String getRandomNumber(int length) {
        String candidateChars = "0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < length; ++i) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }

        return sb.toString();
    }

    public static String getRandomBirthDate() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1900, 2010);
        gc.set(1, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(6));
        gc.set(6, dayOfYear);
        int var10000 = gc.get(1);
        return "" + var10000 + "-" + (gc.get(2) + 1) + "-" + gc.get(5);
    }

    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (double)(end - start));
    }
}
