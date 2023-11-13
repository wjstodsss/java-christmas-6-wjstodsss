package christmas.model;

import static christmas.model.menu.MenuPriceMap.menuPrices;

import christmas.model.menu.MenuPriceMap;

public class DataValidator {
    public static boolean containsItem(String itemName) {
        return menuPrices.containsKey(itemName);
    }
}
