package christmas.model.counter;

import christmas.model.menu.Appetizer;
import christmas.model.menu.Beverage;
import christmas.model.menu.Dessert;
import christmas.model.menu.MainDish;
import christmas.util.Calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OrderValidator {
    private final int MAX_ORDER_NUMBER = 20;
    public void isNotOnlyBeveragesOrdered(String input) {
        Beverage myBeverage = Beverage.RED_WINE;
        ArrayList<String> beverageNames = new ArrayList<>();

        for (Beverage beverage : myBeverage.values()) {
            beverageNames.add(beverage.getItemName());
        }

        Set<String> koreanWords = Calculator.extractWords(input);

        koreanWords.addAll(beverageNames);
        int addKoreanWordsSize = koreanWords.size();
        System.out.println(addKoreanWordsSize);
        if(beverageNames.size() >= addKoreanWordsSize) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void isExceededMaxOrderQuantity(String input){
        int totalOrderCount = Calculator.calculateSumOfMatches(input);

        if (totalOrderCount > MAX_ORDER_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
