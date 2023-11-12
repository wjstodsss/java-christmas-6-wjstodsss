package christmas.model.menu;

public enum Dessert implements MenuItem{
    CHOCO_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private final String itemName;
    private final int price;

    Dessert(String itemName, int price) {
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