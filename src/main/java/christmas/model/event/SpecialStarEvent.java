package christmas.model.event;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialStarEvent {
    private static final int SPECIAL_STAR_DISCOUNT = 1000;
    private static final ArrayList<String> specialDays = new ArrayList<>(Arrays.asList("3", "10", "17", "24", "25", "31"));

    public static int getSpecialStarDiscount() {
        return SPECIAL_STAR_DISCOUNT;
    }

    public static int specialDiscount(String inputDate) {
        for (String specialDay : specialDays) {
            if(inputDate.equals(specialDay)) {
                return SPECIAL_STAR_DISCOUNT;
            }
        }
        return 0;
    }
}
