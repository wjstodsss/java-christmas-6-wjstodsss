package christmas.model;

import static christmas.model.menu.MenuPriceMap.menuPrices;
import static christmas.util.Calculator.extractNumbers;
import static christmas.util.Calculator.extractWords;

import java.util.ArrayList;

public class DataValidator {
    public static boolean validateContainsItem(String itemName) {
        return menuPrices.containsKey(itemName);
    }

    public static boolean validateOrderQuantityMinimum(String input) {
        return extractNumbers(input).contains(0);
    }

    public static boolean validateDuplicateMenu(String input) {
        return extractWords(input).size() == extractNumbers(input).size();
    }
}
