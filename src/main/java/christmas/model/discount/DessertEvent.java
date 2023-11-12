package christmas.model.discount;

import christmas.model.menu.Beverage;
import christmas.model.menu.Dessert;
import christmas.model.menu.MenuItem;
import christmas.util.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static christmas.util.Calculator.extractNumbers;

public class DessertEvent {
    private static final int DISCOUNT_AMOUNT_PER_UNIT = 2023;
    public static int dessertDiscount(String inputOrder, Dessert dessert) {
        ArrayList<Integer> quantity = extractNumbers(inputOrder);
        List<String> dessertNameList = Arrays.stream(Dessert.values())
                .map(Dessert::getItemName)
                .toList();
        Set<String> orderMenu = Calculator.extractWords(inputOrder);

        int discountPrice = 0;
        int i = 0;

        for (String item : orderMenu) {
            if(dessertNameList.contains(item)) {
                discountPrice += quantity.get(i) * DISCOUNT_AMOUNT_PER_UNIT;
            };
            i++;
        }
        return discountPrice;
    }
}
