package utils;

import java.time.LocalDate;

public class DateUtils {
    public static LocalDate getValidExpiryDate() {
        return LocalDate.now().plusMonths(6);
    }

    public static String[] getFormattedExpiryDate() {
        LocalDate expiryDate = getValidExpiryDate();
        return new String[]{
                String.format("%02d", expiryDate.getDayOfMonth()),
                String.format("%02d", expiryDate.getMonthValue()),
                String.valueOf(expiryDate.getYear())
        };
    }
}
