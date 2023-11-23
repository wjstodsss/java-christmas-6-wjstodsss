package christmas.controller;

import christmas.view.OutputView;


public class AppFlowController {
    private String inputDate;
    private String inputOrder;
    private int totalAmount = 0;
    private int totalDiscountAmount = 0;

    public AppFlowController() {
        visitInformationController();
        orderInformationController();
        discountInformationController();
        paymentAndRewardController();
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

    private void discountInformationController() {
        DiscountInformationController discountController = new DiscountInformationController(totalAmount, inputDate, inputOrder);
        this.totalDiscountAmount = discountController.totalDiscountAmount();
    }

    private void paymentAndRewardController() {
        PaymentAndRewardController paymentAndRewardController = new PaymentAndRewardController(totalAmount, totalDiscountAmount);
    }
}


