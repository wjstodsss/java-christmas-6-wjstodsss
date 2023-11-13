package christmas.model.menu;

import java.util.HashMap;
import java.util.Map;

public class MenuPriceMap {
    public static final Map<String, Integer> menuPrices = new HashMap<>();

    static {

        for (Appetizer appetizer : Appetizer.values()) {
            menuPrices.put(appetizer.getItemName(), appetizer.getPrice());
        }

        for (Beverage beverage : Beverage.values()) {
            menuPrices.put(beverage.getItemName(), beverage.getPrice());
        }

        for (Dessert dessert : Dessert.values()) {
            menuPrices.put(dessert.getItemName(), dessert.getPrice());
        }

        for (MainDish mainDish : MainDish.values()) {
            menuPrices.put(mainDish.getItemName(), mainDish.getPrice());
        }
    }

    public static int getPriceByName(String itemName) {
        return menuPrices.getOrDefault(itemName, 0);
    }
}
