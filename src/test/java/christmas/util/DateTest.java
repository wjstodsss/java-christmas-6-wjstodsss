package christmas.util;

import christmas.model.menu.MainDish;
import com.sun.security.jgss.InquireType;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    @Test
    void testGetDayOfWeekFromDate() {
        Date date = new Date();
        String input = "3";

        DayOfWeek expectedDayOfWeek = DayOfWeek.SUNDAY;
        assertEquals(expectedDayOfWeek, date.getDayOfWeekFromDate(input));
    }
}