package christmas.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static Set<String> extractWords(String input) {
        return processMatches(input, "[가-힣]+");
    }

    public static int calculateSumOfMatches(String input) {
        Matcher numberMatcher = createMatcher(input, "\\d+");
        return sumOfMatches(numberMatcher);
    }

    private static Matcher createMatcher(String input, String regex) {
        return Pattern.compile(regex).matcher(input);
    }

    private static Set<String> processMatches(String input, String regex) {
        Matcher matcher = createMatcher(input, regex);
        Set<String> matches = new LinkedHashSet<>();
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }

    private static int sumOfMatches(Matcher matcher) {
        int sum = 0;
        while (matcher.find()) {
            sum += parseToInt(matcher.group());
        }
        return sum;
    }

    private static int parseToInt(String str) {
        return Integer.parseInt(str);
    }

    public static ArrayList<Integer> extractNumbers(String input) {
        Matcher numberMatcher = createMatcher(input, "\\d+");
        return getNumbers(numberMatcher);
    }

    private static ArrayList<Integer> getNumbers(Matcher matcher) {
        ArrayList<Integer> numbers = new ArrayList<>();
        while (matcher.find()) {
            numbers.add(parseToInt(matcher.group()));
        }
        return numbers;
    }
}
