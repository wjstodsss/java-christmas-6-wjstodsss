package christmas.model.menu;

public enum Appetizer {
    MUSHROOM_SOUP("양송이수프", 6_000, 0),
    TAPAS("타파스", 5_500, 0),
    CAESAR_SALAD("시저샐러드", 8_000, 0);

    private final String itemName;
    private final int price;
    private final int quantity;

    Appetizer(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}