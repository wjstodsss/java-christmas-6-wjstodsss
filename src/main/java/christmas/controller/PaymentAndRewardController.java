package christmas.controller;

import static christmas.model.event.BadgeAwardEvent.awardBadge;

import christmas.view.OutputView;

public class PaymentAndRewardController {
    private final OutputView outputView = new OutputView();

    public PaymentAndRewardController(int totalAmount, int totalDiscountAmount) {
        expectedDiscountedPaymentAmount(totalAmount, totalDiscountAmount);
        decemberBadgeAward(totalDiscountAmount);
    }

    private void expectedDiscountedPaymentAmount(int totalAmount, int totalDiscountAmount) {
        outputView.printBoundaryEmptyLine();
        outputView.printExpectedDiscountedPaymentAmount();
        outputView.printTotalAmountFormat(totalAmount - totalDiscountAmount);
    }

    private void decemberBadgeAward(int totalDiscountAmount) {
        outputView.printBoundaryEmptyLine();
        outputView.printDecemberBadgeAward();
        String badge = awardBadge(totalDiscountAmount);
        outputView.printDecemberBadgeAward(badge);
    }
}
