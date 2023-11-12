package christmas.model.menu;

public enum Dessert {
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

}