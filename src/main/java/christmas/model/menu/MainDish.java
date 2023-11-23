package christmas.model.menu;

public enum MainDish implements MenuItem {
    T_BONE_STEAK("티본스테이크", 55000),
    BBQ_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000);

    private final String itemName;
    private final int price;

    MainDish(String itemName, int price) {
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