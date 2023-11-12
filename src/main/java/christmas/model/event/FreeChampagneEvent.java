package christmas.model.event;

import christmas.model.counter.PointOfSale;
import christmas.model.menu.Beverage;

import static christmas.model.counter.PointOfSale.calculateTotalOrderAmount;

public class FreeChampagneEvent {
    private static final int REWARD_THRESHOLD_AMOUNT = 120000;
    public static String freeChampane(int input) {
        return Beverage.CHAMPAGNE.getItemName();
    }
    private static boolean validateFreeChampagne(int input) {
        return input >= REWARD_THRESHOLD_AMOUNT;
    }
}
