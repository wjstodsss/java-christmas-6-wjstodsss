package christmas;

import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        outputView.printOrderMenu();
        outputView.printOrderMenuFormat("초코케이크", 3);
        outputView.printTotalAmountAndFormat(10000);
    }
}
