package christmas.view;

import static christmas.util.MessageManager.*;

public class InputValidator {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 31;
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
}
