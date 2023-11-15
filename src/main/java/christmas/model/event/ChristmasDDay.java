package christmas.model.event;

public class ChristmasDDay {
    private static final int DEFAULT_DISCOUNT = 1000;
    private static final int ONE_DAY_ADD_SIZE = 100;
    private static final int FIRST_DAY = 1;
    private static final int FINAL_DAY = 25;

    public static int dDayDiscount(String input) {
        int day = Integer.parseInt(input);
        if (day>FINAL_DAY) {
            return 0;
        }
        return DEFAULT_DISCOUNT + (day - FIRST_DAY) * ONE_DAY_ADD_SIZE;
    }
}
