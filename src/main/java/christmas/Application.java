package christmas;

import christmas.controller.AppFlowController;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        try {
            AppFlowController loader = new AppFlowController();
        } catch (IllegalArgumentException e) {
            String message = outputView.printProgramCloseMessage();
            System.out.println(message);
        }

    }
}
