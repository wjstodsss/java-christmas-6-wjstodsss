package christmas;

import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        outputView.printDDayDiscount(10000);
        outputView.printAwardEvent(25000);
        outputView.printWeekdayDiscount(1000);
        outputView.printWeekendDiscount(1500);
        outputView.printSpecialDiscount(3000);
    }
}
