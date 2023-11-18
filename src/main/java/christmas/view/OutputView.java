package christmas.view;

public class OutputView {
    public void printBoundaryEmptyLine() {
        System.out.println();
    }

    public void printGreetingMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printOrderMenuFormat(String item, int quantity) {
        System.out.println(item + " " + quantity + "개");
    }

    public void printTotalAmountFormat(int totalAmount) {
        System.out.printf("%,d원\n", totalAmount);
    }

    public void printFreeAwardFormat(String item) {
        System.out.println(item);
    }

    public void printBenefitsPreview(String input) {
        System.out.printf("12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n",input);
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

    public void printTotalDiscountAmountFormat(int totalAmount) {
        System.out.printf("-%,d원\n", totalAmount);
    }
    public void printTotalDiscountAmountZeroFormat() {
        System.out.printf("0원\n");
    }
    public void printDecemberBadgeAward(String badge) {
        System.out.printf("%s\n", badge);
    }

}
