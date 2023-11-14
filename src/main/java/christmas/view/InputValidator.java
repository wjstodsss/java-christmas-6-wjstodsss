package christmas.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static christmas.view.MessageManager.*;

public class InputValidator {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 31;

    public static void validateDate(String inputDate) {
        validateNonInteger(inputDate);
        validateInputRange(inputDate);
    }

    public static void validateNonInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(getValidateNonIntegerMessage());
        }
    }

    public static void validateInputRange(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(getValidateInputRange());
        }
    }

    public static void validateInputMenuAndQuantity(String input) {
        if (!isInputMenuAndQuantityFormat(input)) {
            throw new IllegalArgumentException(getValidateInputMenuAndQuantity());
        }
    }
    public static boolean isInputMenuAndQuantityFormat(String input) {
        String pattern = "^[가-힣]+-\\d+(,[가-힣]+-\\d+)*$";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        return matcher.matches();
    }


}
