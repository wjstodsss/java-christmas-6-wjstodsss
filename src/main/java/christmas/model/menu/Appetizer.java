package christmas.model.menu;

public enum Appetizer implements MenuItem {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000);

    private final String itemName;
    private final int price;

    Appetizer(String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public int getPrice() {
        return price;
    }
}