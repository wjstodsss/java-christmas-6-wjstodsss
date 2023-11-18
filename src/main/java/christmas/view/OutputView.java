package christmas.view;

import java.util.ResourceBundle;

public class OutputView {
    private final ResourceBundle messages;
    private final ResourceBundle exceptionMessages;

    public OutputView() {
        this.messages = ResourceBundle.getBundle("messages");
        this.exceptionMessages = ResourceBundle.getBundle("exception-messages");
    }

    public void getPrintOrderMenuFormat(String item, int quantity) {
        System.out.printf(messages.getString("printOrderMenuFormat.message"), item, quantity);
    }

    public void getPrintTotalAmountFormat(int totalAmount) {
        System.out.printf(messages.getString("printTotalAmountFormat.message"), totalAmount);
    }

    public void getPrintFreeAwardFormat(String item) {
        System.out.printf(messages.getString("printFreeAwardFormat.message"), item);
    }

    public void getPrintBenefitsPreview(String input) {
        System.out.printf(messages.getString("printBenefitsPreviewFormat.message"), input);
    }

    public void getPrintDDayDiscount(int discountAmount) {
        System.out.printf(messages.getString("printDDayDiscountFormat.message"), discountAmount);
    }

    public void getPrintWeekdayDiscount(int discountAmount) {
        System.out.printf(messages.getString("printWeekdayDiscountFormat.message"), discountAmount);
    }

    public void getPrintWeekendDiscount(int discountAmount) {
        System.out.printf(messages.getString("printWeekendDiscountFormat.message"), discountAmount);
    }

    public void getPrintSpecialDiscount(int discountAmount) {
        System.out.printf(messages.getString("printSpecialDiscountFormat.message"), discountAmount);
    }

    public void getPrintAwardEvent(int itemPrice) {
        System.out.printf(messages.getString("printAwardEventFormat.message"), itemPrice);
    }

    public void getPrintTotalDiscountAmountFormat(int totalAmount) {
        System.out.printf(messages.getString("printTotalDiscountAmountFormat.message"), totalAmount);
    }

    public void getPrintTotalDiscountAmountZeroFormat() {
        System.out.printf(messages.getString("printTotalDiscountAmountZeroFormat.message"));
    }

    public void getPrintDecemberBadgeAward(String badge) {
        System.out.printf(messages.getString("printDecemberBadgeAwardFormat.message"), badge);
    }

    //General Messages
    public void getPrintBoundaryEmptyLine() {
        System.out.println(messages.getString("printBoundaryEmptyLine.message"));
    }

    public void getPrintGreetingMessage() {
        System.out.println(messages.getString("printGreetingMessage.message"));
    }

    public void getDatePromptMessage() {
        System.out.println(messages.getString("datePrompt.message"));
    }

    public void getProgramClosePromptMessage() {
        System.out.println(messages.getString("programClosePrompt.message"));
    }

    public void getMenuAndQuantityPromptMessage() {
        System.out.println(messages.getString("menuAndQuantityPrompt.message"));
    }

    public void getPrintOrderMenu() {
        System.out.println(messages.getString("printOrderMenu.message"));
    }

    public void getPrintTotalOrderAmount() {
        System.out.println(messages.getString("printTotalOrderAmount.message"));
    }

    public void getPrintFreeAward() {
        System.out.println(messages.getString("printFreeAward.message"));
    }

    public void getPrintBenefitsDetails() {
        System.out.println(messages.getString("printBenefitsDetails.message"));
    }

    public void getPrintTotalBenefitsAmount() {
        System.out.println(messages.getString("printTotalBenefitsAmount.message"));
    }

    public void getPrintExpectedDiscountedPaymentAmount() {
        System.out.println(messages.getString("printExpectedDiscountedPaymentAmount.message"));
    }

    public void getPrintDecemberBadgeAward() {
        System.out.println(messages.getString("printDecemberBadgeAward.message"));
    }

    //Exception Messages
    public String getValidateNonIntegerMessage() {
        return exceptionMessages.getString("validateNonInteger.message");
    }

    public String getValidateInputRange() {
        return exceptionMessages.getString("validateInputRange.message");
    }

    public String getValidateInputMenuAndQuantity() {
        return exceptionMessages.getString("validateInputMenuAndQuantity.message");
    }

    public String getValidateContainsItem() {
        return exceptionMessages.getString("validateContainsItem.message");
    }

    public String getValidateOrderQuantityMinimum() {
        return exceptionMessages.getString("validateOrderQuantityMinimum.message");
    }

    public String getValidateDuplicateMenu() {
        return exceptionMessages.getString("validateDuplicateMenu.message");
    }


    public String getNotOnlyBeveragesOrdered() {
        return exceptionMessages.getString("notOnlyBeveragesOrdered.message");
    }

    public String getExceededMaxOrderQuantity() {
        return exceptionMessages.getString("exceededMaxOrderQuantity.message");
    }

}