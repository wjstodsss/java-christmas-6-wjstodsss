package christmas.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 31;

    private OutputView outputView = new OutputView();

    public void validateDate(String inputDate) {
        validateNonInteger(inputDate);
        validateInputRange(inputDate);
    }

    public void validateNonInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(outputView.getValidateNonIntegerMessage());
        }
    }

    public void validateInputRange(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(outputView.getValidateInputRange());
        }
    }

    public void validateInputMenuAndQuantity(String input) {
        if (!isInputMenuAndQuantityFormat(input)) {
            throw new IllegalArgumentException(outputView.getValidateInputMenuAndQuantity());
        }
    }
    public boolean isInputMenuAndQuantityFormat(String input) {
        String pattern = "^[가-힣]+-\\d+(,[가-힣]+-\\d+)*$";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        return matcher.matches();
    }


}
