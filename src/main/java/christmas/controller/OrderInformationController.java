package christmas.controller;

import static christmas.model.counter.PointOfSale.itemsSet;
import static christmas.model.counter.PointOfSale.quantitiesList;
import christmas.view.OutputView;
import java.util.Iterator;
import christmas.model.counter.PointOfSale;

public class OrderInformationController {
    private String inputOrder;
    private final OutputView outputView = new OutputView();
    private final PointOfSale pointOfSale = new PointOfSale();
    public OrderInformationController(String inputOrder) {
        printOrder(inputOrder);
    }

    private void printOrder(String inputOrder) {
        this.inputOrder = inputOrder;
        orderChecker();
        totalAmountView(calculateTotalAmount());
    }

    public int calculateTotalAmount(){
        return pointOfSale.calculateTotalOrderAmount(inputOrder);
    }

    private void totalAmountView(int totalAmount) {
        calculateTotalAmount();
        outputView.printBoundaryEmptyLine();
        outputView.printTotalOrderAmount();
        outputView.printTotalAmountFormat(totalAmount);
    }

    private void orderChecker(){
        outputView.printBoundaryEmptyLine();
        outputView.printOrderMenu();

        Iterator<String> itemsIterator = itemsSet(inputOrder).iterator();
        Iterator<Integer> quantitiesIterator = quantitiesList(inputOrder).iterator();

        while (itemsIterator.hasNext() && quantitiesIterator.hasNext()) {
            String item = itemsIterator.next();
            int quantity = quantitiesIterator.next();

            outputView.printOrderMenuFormat(item, quantity);
        }
    }
}
