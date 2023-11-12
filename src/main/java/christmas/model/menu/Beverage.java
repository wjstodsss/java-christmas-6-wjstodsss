package christmas.model.menu;

public enum Beverage implements MenuItem {
    ZERO_COLA("제로콜라", 3000, 0),
    RED_WINE("레드와인", 60000, 0),
    CHAMPAGNE("샴페인", 25000, 0);

    private final String itemName;
    private final int price;
    private final int quantity;

    Beverage(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public int orderAmount() {
        return price*quantity;
    }

}