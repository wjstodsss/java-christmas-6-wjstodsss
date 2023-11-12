package christmas.model.event;

import christmas.model.menu.MenuItem;
import christmas.util.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static christmas.util.Calculator.extractNumbers;

public class MenuDiscountEvent {
    private static final int DISCOUNT_AMOUNT_PER_UNIT = 2023;
    public static int calculateMenuDiscount(String inputOrder, Enum<? extends MenuItem> enumItem) {
        ArrayList<Integer> quantity = extractNumbers(inputOrder);
        List<String> itemNameList = Arrays.stream(enumItem.getDeclaringClass().getEnumConstants())
                .map(menuItem -> ((MenuItem) menuItem).getItemName())
                .toList();
        Set<String> orderMenu = Calculator.extractWords(inputOrder);
        int discountPrice = 0;
        int i = 0;

        for (String item : orderMenu) {
            if (itemNameList.contains(item)) {
                discountPrice += quantity.get(i) * DISCOUNT_AMOUNT_PER_UNIT;
            }
            i++;
        }
        return discountPrice;
    }

}
