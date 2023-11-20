package christmas.model.menu;

public enum Beverage implements MenuItem{
    ZERO_COLA("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);

    private final String itemName;
    private final int price;

    Beverage(String itemName, int price) {
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