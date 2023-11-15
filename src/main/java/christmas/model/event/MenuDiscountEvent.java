package christmas.model.event;

import christmas.model.menu.Dessert;
import christmas.model.menu.MainDish;
import christmas.model.menu.MenuItem;
import christmas.util.Calculator;
import christmas.view.OutputView;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static christmas.util.Calculator.extractNumbers;
import static christmas.util.Date.getDayOfWeekFromDate;

public class MenuDiscountEvent {
    private static final int DISCOUNT_AMOUNT_PER_UNIT = 2023;
    private final OutputView outputView = new OutputView();

    public static int menuDiscount (String inputDate, String inputOrder) {
        if (weekDiscount(inputDate,inputOrder)==0) {
            return 0;
        }
        return weekDiscount(inputDate,inputOrder);
    }
    private static int weekDiscount(String inputDate, String inputOrder) {
        DayOfWeek dayOfWeek = getDayOfWeekFromDate(inputDate);
        if(dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            MainDish mainDish = MainDish.T_BONE_STEAK;
            return calculateMenuDiscount(inputOrder,mainDish);
        }
        Dessert dessert = Dessert.CHOCO_CAKE;
        return calculateMenuDiscount(inputOrder,dessert);
    }

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
