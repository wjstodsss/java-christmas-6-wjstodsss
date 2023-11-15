package christmas.model.event;

import christmas.model.menu.Beverage;

public class FreeChampagneEvent {
    private static final int REWARD_THRESHOLD_AMOUNT = 120000;
    public static String freeChampane() {
            return Beverage.CHAMPAGNE.getItemName();
    }
    public static int freeChampanePrice() {
        return Beverage.CHAMPAGNE.getPrice();
    }
    public static boolean validateFreeChampagne(int input) {
        return input >= REWARD_THRESHOLD_AMOUNT;
    }

    public static int freeChampagneDiscount(int totalAmount) {
        if (validateFreeChampagne(totalAmount)) {
            return freeChampanePrice();
        }
        return 0;
    }
}
