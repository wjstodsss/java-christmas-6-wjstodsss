package christmas.model.menu;

public enum MainDish {
    T_BONE_STEAK("티본스테이크", 55000, 0),
    BBQ_RIBS("바비큐립", 54000, 0),
    SEAFOOD_PASTA("해산물파스타", 35000, 0),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, 0);

    private final String itemName;
    private final int price;
    private final int quantity;

    MainDish(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}