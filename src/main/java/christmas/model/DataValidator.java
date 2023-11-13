package christmas.model;

import static christmas.model.menu.MenuPriceMap.menuPrices;
import static christmas.util.Calculator.extractNumbers;

import java.util.ArrayList;

public class DataValidator {
    public static boolean validateContainsItem(String itemName) {
        return menuPrices.containsKey(itemName);
    }

    public static boolean validateOrderQuantityMinimum(String input) {
        return extractNumbers(input).contains(0);
    }
}
