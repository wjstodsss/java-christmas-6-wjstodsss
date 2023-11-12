package christmas.model.menu;

public enum Dessert implements MenuItem {
    CHOCO_CAKE("초코케이크", 15000, 0),
    ICE_CREAM("아이스크림", 5000, 0);

    private final String itemName;
    private final int price;
    private final int quantity;

    Dessert(String itemName, int price, int quantity) {
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