package constants;

import utils.CommonUtils;

import static utils.CommonUtils.getRandomFiveCharsString;
import static utils.CommonUtils.getRandomNumber;

public class RegisterConstants {
    public static final String PHONE_NUMBER = "58" + CommonUtils.getRandomSevenNumbersString();
    public static final String PHONE_NUMBER_REGISTER = "58123123";
    public static final String PASSWORD_REGISTER = "Binh741456";
    public static final String FIRST_NAME = "Cody";
    public static final String LAST_NAME = "Testing";
    public static final String PASSWORD = "Cody741456";
    public static final String PIN_NUMBER = "999999";
    public static final String EMAIL_REGISTERED = getRandomFiveCharsString() + getRandomNumber(2) + "@gmail.com";
    public static final String BRANCH_SEARCH = "Riyadh";
    public static final String CARD_NO = "456" + getRandomNumber(10);
    public static final String EXPIRY_DATE = "1229";
}
