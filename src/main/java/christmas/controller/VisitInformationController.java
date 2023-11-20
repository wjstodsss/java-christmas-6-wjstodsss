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
        validateInputOrder(inputOrder);
        outputView.printBenefitsPreview(inputDate);
    }

    private void validateInputOrder(String inputOrder) {
            try {
                orderValidator.orderValidatorBundle(inputOrder);
                this.inputOrder = inputOrder;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                validateInputOrderLoop(inputOrder);
            }
    }

    private void validateInputOrderLoop(String inputOrder) {
        int attempts = 0;
        int maxAttempts = 2;

        while (attempts < maxAttempts) {
            try {
                inputOrder = Console.readLine();
                orderValidator.orderValidatorBundle(inputOrder);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                attempts++;
            }
        }
        if (attempts == maxAttempts) {
            String errorMessage = outputView.printMaxAttemptsOverMessage();
            System.out.println(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        this.inputOrder = inputOrder;
    }

    public String getDateInput() {
        return this.inputDate;
    }

    public String getOrderInput() {
        return this.inputOrder;
    }
}
