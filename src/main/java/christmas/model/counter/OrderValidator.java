package christmas.model.counter;

import christmas.model.menu.Beverage;

import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.Set;

import static christmas.model.counter.PointOfSale.*;
import static christmas.model.menu.MenuPriceMap.menuPrices;

public class OrderValidator {
    private final int MAX_ORDER_NUMBER = 20;
    private final OutputView outputView = new OutputView();

    public void orderValidatorBundle(String input) {
        isNotOnlyBeveragesOrdered(input);
        isExceededMaxOrderQuantity(input);
        validateContainsItem(input);
        validateOrderQuantityMinimum(input);
        validateDuplicateMenu(input);
    }
    private void isNotOnlyBeveragesOrdered(String input) {
        Beverage myBeverage = Beverage.RED_WINE;
        ArrayList<String> beverageNames = new ArrayList<>();

        for (Beverage beverage : myBeverage.values()) {
            beverageNames.add(beverage.getItemName());
        }

        Set<String> itemsSet= itemsSet(input);

        itemsSet.addAll(beverageNames);
        int additemsSetSize = itemsSet.size();

        if(beverageNames.size() >= additemsSetSize) {
            throw new IllegalArgumentException(outputView.printNotOnlyBeveragesOrdered());
        }
    }

    private void isExceededMaxOrderQuantity(String input){
        if (totalQuantities(input) > MAX_ORDER_NUMBER) {
            throw new IllegalArgumentException(outputView.printExceededMaxOrderQuantity());
        }
    }

    private void validateContainsItem(String input) {
        Set<String> itemsSet = itemsSet(input);
        for (String itemName : itemsSet) {
            if (!isContainsItem(itemName)) {
                throw new IllegalArgumentException(outputView.printValidateContainsItem());
            }
        }
    }

    private void validateOrderQuantityMinimum(String input) {
        ArrayList<Integer> quantity = quantitiesList(input);
        if (isOrderQuantityMinimum(quantity)) {
            throw new IllegalArgumentException(outputView.printValidateOrderQuantityMinimum());
        }
    }

    private void validateDuplicateMenu(String input) {
        Set<String> itemsSet = itemsSet(input);
        ArrayList<Integer> quantity = quantitiesList(input);
        if (!isDuplicateMenu(itemsSet, quantity)) {
            throw new IllegalArgumentException(outputView.printValidateDuplicateMenu());
        }
    }

    private boolean isContainsItem(String itemName) {
        return menuPrices.containsKey(itemName);
    }

    private boolean isOrderQuantityMinimum(ArrayList<Integer> quantity) {
        return quantity.contains(0);
    }

    private boolean isDuplicateMenu(Set<String> inputOrder, ArrayList<Integer> quantity) {
        return inputOrder.size() == quantity.size();
    }
}