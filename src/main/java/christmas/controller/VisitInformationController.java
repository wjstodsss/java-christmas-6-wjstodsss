package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.counter.OrderValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class VisitInformationController {
    private String inputDate;
    private String inputOrder;

    private InputView inputView = new InputView();
    private OrderValidator orderValidator = new OrderValidator();
    private OutputView outputView = new OutputView();

    public VisitInformationController() {
        outputView.printGreetingMessage();
        this.inputDate = inputView.readDate();
        this.inputOrder = inputView.readMenuAndQuantity();
        inputOrder = validateInputOrderLoop(inputOrder);
        outputView.printBenefitsPreview(inputDate);
    }

    private String validateInputOrderLoop(String inputOrder) {

        int attempts = 0;
        int maxAttempts = 3;

        while (attempts < maxAttempts) {
            try {
                orderValidator.orderValidatorBundle(inputOrder);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputOrder = Console.readLine();
                attempts++;
            }
            if (attempts == maxAttempts) {
                outputView.printProgramCloseMessage();
                break;
            }
        }
        return inputOrder;
    }

    public String getDateInput() {
        return this.inputDate;
    }

    public String getOrderInput() {
        return this.inputOrder;
    }
}
