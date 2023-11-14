package christmas.view;

import static christmas.view.MessageManager.*;

public class OutputView {
    public void printBoundaryEmptyLine() {
        System.out.println();
    }

    public void printOrderMenuFormat(String item, int quantity) {
        System.out.println(item + " " + quantity + "개");
    }

    public void printTotalAmountFormat(int totalAmount) {
        System.out.printf("%,d원\n", totalAmount);
    }

    public void printFreeAwardFormat(String item) {
        System.out.println(item + " 1개");
    }

    public void printNothing() {
        System.out.println("없음");
    }

    public void printDDayDiscount(int discountAmount) {
        System.out.printf("크리스마스 디데이 할인: -%,d원\n", discountAmount);
    }

    public void printWeekdayDiscount(int discountAmount) {
        System.out.printf("평일 할인: -%,d원\n", discountAmount);
    }

    public void printWeekendDiscount(int discountAmount) {
        System.out.printf("주말 할인: -%,d원\n", discountAmount);
    }

    public void printSpecialDiscount(int discountAmount) {
        System.out.printf("특별 할인: -%,d원\n", discountAmount);
    }

    public void printAwardEvent(int itemPrice) {
        System.out.printf("증정 이벤트: -%,d원\n", itemPrice);
    }

}
