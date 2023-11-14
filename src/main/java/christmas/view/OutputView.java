package christmas.view;

import static christmas.util.MessageManager.*;

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

    public void printTotalAmountAndFormat(int totalAmount) {
        printBoundaryEmptyLine();
        getPrintTotalOrderAmount();

        System.out.printf("%,d원\n", totalAmount);
    }

    public void printFreeAward() {
        printBoundaryEmptyLine();
        getPrintFreeAward();
    }

    public void printFreeAwardFormat(String item) {
        System.out.println(item + " 1개");
    }

    public void printNothing() {
        System.out.println("없음");
    }

}
