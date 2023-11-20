package christmas.view;

import java.util.ResourceBundle;

public class OutputView {
    private final ResourceBundle messages;
    private final ResourceBundle exceptionMessages;

    public OutputView() {
        this.messages = ResourceBundle.getBundle("messages");
        this.exceptionMessages = ResourceBundle.getBundle("exception-messages");
    }

    public void printOrderMenuFormat(String item, int quantity) {
        System.out.printf(messages.getString("printOrderMenuFormat.message"), item, quantity);
    }

    public void printTotalAmountFormat(int totalAmount) {
        System.out.printf(messages.getString("printTotalAmountFormat.message"), totalAmount);
    }

    public void printFreeAwardFormat(String item) {
        System.out.printf(messages.getString("printFreeAwardFormat.message"), item);
    }

    public void printBenefitsPreview(String input) {
        System.out.printf(messages.getString("printBenefitsPreviewFormat.message"), input);
    }

    public void printDDayDiscount(int discountAmount) {
        System.out.printf(messages.getString("printDDayDiscountFormat.message"), discountAmount);
    }

    public void printWeekdayDiscount(int discountAmount) {
        System.out.printf(messages.getString("printWeekdayDiscountFormat.message"), discountAmount);
    }

    public void printWeekendDiscount(int discountAmount) {
        System.out.printf(messages.getString("printWeekendDiscountFormat.message"), discountAmount);
    }

    public void printSpecialDiscount(int discountAmount) {
        System.out.printf(messages.getString("printSpecialDiscountFormat.message"), discountAmount);
    }

    public void printAwardEvent(int itemPrice) {
        System.out.printf(messages.getString("printAwardEventFormat.message"), itemPrice);
    }

    public void printTotalDiscountAmountFormat(int totalAmount) {
        System.out.printf(messages.getString("printTotalDiscountAmountFormat.message"), totalAmount);
    }

    public void printTotalDiscountAmountZeroFormat() {
        System.out.printf(messages.getString("printTotalDiscountAmountZeroFormat.message"));
    }

    public void printDecemberBadgeAward(String badge) {
        System.out.printf(messages.getString("printDecemberBadgeAwardFormat.message"), badge);
    }

    //General Messages
    public void printBoundaryEmptyLine() {
        System.out.println(messages.getString("printBoundaryEmptyLine.message"));
    }

    public void printGreetingMessage() {
        System.out.println(messages.getString("printGreetingMessage.message"));
    }

    public void printDatePromptMessage() {
        System.out.println(messages.getString("datePrompt.message"));
    }

    public void printMenuAndQuantityPromptMessage() {
        System.out.println(messages.getString("menuAndQuantityPrompt.message"));
    }

    public void printOrderMenu() {
        System.out.println(messages.getString("printOrderMenu.message"));
    }

    public void printTotalOrderAmount() {
        System.out.println(messages.getString("printTotalOrderAmount.message"));
    }

    public void printFreeAward() {
        System.out.println(messages.getString("printFreeAward.message"));
    }

    public void printBenefitsDetails() {
        System.out.println(messages.getString("printBenefitsDetails.message"));
    }

    public void printTotalBenefitsAmount() {
        System.out.println(messages.getString("printTotalBenefitsAmount.message"));
    }

    public void printExpectedDiscountedPaymentAmount() {
        System.out.println(messages.getString("printExpectedDiscountedPaymentAmount.message"));
    }

    public void printDecemberBadgeAward() {
        System.out.println(messages.getString("printDecemberBadgeAward.message"));
    }

    //Exception Messages
    public String printProgramCloseMessage() {
        return exceptionMessages.getString("programClose.message");
    }

    public String printMaxAttemptsOverMessage() {
        return exceptionMessages.getString("maxAttemptsOver.message");
    }

    public String printValidateNonIntegerMessage() {
        return exceptionMessages.getString("validateNonInteger.message");
    }

    public String printValidateInputRange() {
        return exceptionMessages.getString("validateInputRange.message");
    }

    public String printValidateInputMenuAndQuantity() {
        return exceptionMessages.getString("validateInputMenuAndQuantity.message");
    }

    public String printValidateContainsItem() {
        return exceptionMessages.getString("validateContainsItem.message");
    }

    public String printValidateOrderQuantityMinimum() {
        return exceptionMessages.getString("validateOrderQuantityMinimum.message");
    }

    public String printValidateDuplicateMenu() {
        return exceptionMessages.getString("validateDuplicateMenu.message");
    }


    public String printNotOnlyBeveragesOrdered() {
        return exceptionMessages.getString("notOnlyBeveragesOrdered.message");
    }

    public String printExceededMaxOrderQuantity() {
        return exceptionMessages.getString("exceededMaxOrderQuantity.message");
    }

}