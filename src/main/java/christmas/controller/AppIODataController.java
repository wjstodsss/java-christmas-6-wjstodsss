package christmas.controller;

import christmas.view.OutputView;
import static christmas.model.event.BadgeAwardEvent.awardBadge;


public class AppIODataController {
    private String inputDate;
    private String inputOrder;
    private int totalAmount = 0;
    private final OutputView outputView = new OutputView();

    private int totalDiscountAmount = 0;

    public AppIODataController() {
        visitInformationController();
        orderInformationController();
        discountController();

        expectedDiscountedPaymentAmount();
        decemberBadgeAward();
    }

    private void visitInformationController() {
        VisitInformationController visitInformationController = new VisitInformationController();
        this.inputDate = visitInformationController.getDateInput();
        this.inputOrder = visitInformationController.getOrderInput();
    }

    private void orderInformationController() {
        OrderInformationController orderInformationController = new OrderInformationController(inputOrder);
        this.totalAmount = orderInformationController.calculateTotalAmount();
    }

    private void discountController() {
        DiscountController discountController = new DiscountController(totalAmount, inputDate, inputOrder);
        this.totalDiscountAmount = discountController.totalDiscountAmount();

    }

    private void expectedDiscountedPaymentAmount() {
        outputView.printBoundaryEmptyLine();
        outputView.printExpectedDiscountedPaymentAmount();
        outputView.printTotalAmountFormat(totalAmount - totalDiscountAmount);
    }

    private void decemberBadgeAward() {
        outputView.printBoundaryEmptyLine();
        outputView.printDecemberBadgeAward();
        String badge = awardBadge(totalDiscountAmount);
        outputView.printDecemberBadgeAward(badge);
    }
}


