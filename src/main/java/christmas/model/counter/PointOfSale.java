package christmas.model.counter;

import christmas.model.menu.*;
import christmas.util.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static christmas.util.Calculator.extractNumbers;

public class PointOfSale {

    public int calculateTotalOrderAmount(String input) {
        ArrayList<Integer> orderMenuPrice = orderMenuPriceFinder(input);
        ArrayList<Integer> quantity = quantitiesList(input);

        int totalAmount = 0;
        for (int i = 0; i < orderMenuPrice.size(); i++) {
            totalAmount += orderMenuPrice.get(i) * quantity.get(i);
        }
        return totalAmount;
    }
    public ArrayList<Integer> orderMenuPriceFinder(String input) {
        Set<String> koreanWords = itemsSet(input);
        ArrayList<Integer> orderMenuPrice = new ArrayList<>();
        for (String koreanWord : koreanWords) {
            orderMenuPrice.add(MenuPriceMap.getPriceByName(koreanWord));
        }
        return orderMenuPrice;
    }

    public static Set<String> itemsSet(String inputOrder) {
        return Calculator.extractWords(inputOrder);
    }

    public  static ArrayList<Integer> quantitiesList(String inputOrder) {
        return Calculator.extractNumbers(inputOrder);
    }

    public  static int totalQuantities(String inputOrder) {
        return Calculator.calculateSumOfMatches(inputOrder);
    }
}
