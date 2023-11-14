package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.counter.OrderValidator;
import christmas.model.counter.PointOfSale;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import static christmas.view.MessageManager.getPrintOrderMenu;

public class AppIODataController {
    private String inputDate;
    private  String inputOrder;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private PointOfSale pointOfSale = new PointOfSale();
    private OrderValidator orderValidator = new OrderValidator();



    public AppIODataController() {
        this.inputDate = inputView.readDate();
        this.inputOrder = inputView.readMenuAndQuantity();
        inputOrder = validateInputOrderLoop(inputOrder);
        printOrderMenu(inputOrder);
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
        }
        return inputOrder;
    }


    private void printOrderMenu(String inputOrder) {
        outputView.printBoundaryEmptyLine();
        getPrintOrderMenu();

        Iterator<String> itemsIterator = pointOfSale.itemsSet(inputOrder).iterator();
        Iterator<Integer> quantitiesIterator = pointOfSale.quantitiesList(inputOrder).iterator();

        while (itemsIterator.hasNext() && quantitiesIterator.hasNext()) {
            String item = itemsIterator.next();
            int quantity = quantitiesIterator.next();

            outputView.printOrderMenuFormat(item, quantity);
        }
    }
}
