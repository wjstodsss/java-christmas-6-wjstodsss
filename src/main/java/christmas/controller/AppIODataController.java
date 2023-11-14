package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.counter.OrderValidator;
import christmas.model.counter.PointOfSale;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Iterator;

import static christmas.model.counter.PointOfSale.itemsSet;
import static christmas.model.counter.PointOfSale.quantitiesList;
import static christmas.model.event.FreeChampagneEvent.freeChampane;
import static christmas.model.event.FreeChampagneEvent.validateFreeChampagne;
import static christmas.view.MessageManager.*;


public class AppIODataController {
    private String inputDate;
    private  String inputOrder;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private OrderValidator orderValidator = new OrderValidator();
    private PointOfSale pointOfSale = new PointOfSale();



    public AppIODataController() {
        this.inputDate = inputView.readDate();
        this.inputOrder = inputView.readMenuAndQuantity();
        outputView.printBenefitsPreview(inputDate);
        printOrderMenu(inputOrder);
        inputOrder = validateInputOrderLoop(inputOrder);
        int totalAmount = pointOfSale.calculateTotalOrderAmount(inputOrder);
        totalAmountView(totalAmount);
        freeAwardView(totalAmount);
    }

    private void totalAmountView(int totalAmount) {
        outputView.printBoundaryEmptyLine();
        getPrintTotalOrderAmount();
        outputView.printTotalAmountFormat(totalAmount);
    }
    private void freeAwardView(int totalAmount){
        outputView.printBoundaryEmptyLine();
        getPrintFreeAward();
        outputView.printFreeAwardFormat(freeChampagneEvent(totalAmount));
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

        Iterator<String> itemsIterator = itemsSet(inputOrder).iterator();
        Iterator<Integer> quantitiesIterator = quantitiesList(inputOrder).iterator();

        while (itemsIterator.hasNext() && quantitiesIterator.hasNext()) {
            String item = itemsIterator.next();
            int quantity = quantitiesIterator.next();

            outputView.printOrderMenuFormat(item, quantity);
        }
    }

    private String freeChampagneEvent(int totalAmount) {
        if (validateFreeChampagne(totalAmount)) {
           return freeChampane() + " 1개";
        }
       return "없음";
    }
}
