package christmas.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int calculateSum(String input) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        int sum = 0;
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }

        return sum;
    }
}
