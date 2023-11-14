package christmas.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Date {
    private static final int EVENT_YEAR = 2023;
    private static final int EVENT_MONTH = 12;
    public static DayOfWeek getDayOfWeekFromDate(String input) {
        int day = Integer.parseInt(input);
        int year = EVENT_YEAR;
        int month = EVENT_MONTH;

        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek;
    }
}
