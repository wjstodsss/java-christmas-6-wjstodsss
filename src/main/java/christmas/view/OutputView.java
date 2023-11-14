package christmas.view;

import static christmas.util.MessageManager.getPrintOrderMenu;

public class OutputView {
    public void printBoundaryEmptyLine() {
        System.out.println();
    }

    public void printOrderMenu() {
        printBoundaryEmptyLine();
        getPrintOrderMenu();
    }

    public void printOrderMenuFormat(String item, int quantity) {
        System.out.println(item + " " + quantity + "개");
    }

}
