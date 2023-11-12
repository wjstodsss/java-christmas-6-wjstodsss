package christmas.model;

import christmas.model.menu.Appetizer;
import christmas.model.menu.Beverage;
import christmas.model.menu.Dessert;
import christmas.model.menu.MainDish;
import christmas.util.Calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OrderValidator {
    public void isNotOnlyBeveragesOrdered(String input, Beverage beverages) {
        ArrayList<String> beverageNames = new ArrayList<>();

        for (Beverage beverage : beverages.values()) {
            beverageNames.add(beverage.getItemName());
        }

        Set<String> koreanWords = Calculator.extractWords(input);

        koreanWords.addAll(beverageNames);
        int addKoreanWordsSize = koreanWords.size();
        System.out.println(addKoreanWordsSize);
        if(beverageNames.size() >= addKoreanWordsSize) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
