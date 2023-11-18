//package christmas.view;
//
//import java.util.ResourceBundle;
//
//public class MessageManager {
//    private static final ResourceBundle messages = ResourceBundle.getBundle("messages");
//    private static final ResourceBundle exceptionMessages = ResourceBundle.getBundle("exception-messages");
//
//    //General Messages
//    public static void getDatePromptMessage() {
//        System.out.println(messages.getString("datePrompt.message"));
//    }
//
//    public static void getProgramClosePromoptMessage() {
//        System.out.println(messages.getString("programClosePromopt.message"));
//    }
//
//    public static void getMenuAndQuantityPromptMessage() {
//        System.out.println(messages.getString("menuAndQuantityPrompt.message"));
//    }
//
//    public static void getPrintOrderMenu() {
//        System.out.println(messages.getString("printOrderMenu.message"));
//    }
//
//    public static void getPrintTotalOrderAmount() {
//        System.out.println(messages.getString("printTotalOrderAmount.message"));
//    }
//
//    public static void getPrintFreeAward() {
//        System.out.println(messages.getString("printFreeAward.message"));
//    }
//
//    public static void getPrintBenefitsDetails() {
//        System.out.println(messages.getString("printBenefitsDetails.message"));
//    }
//
//    public static void getPrintTotalBenefitsAmount() {
//        System.out.println(messages.getString("printTotalBenefitsAmount.message"));
//    }
//
//    public static void getPrintExpectedDiscountedPaymentAmount() {
//        System.out.println(messages.getString("printExpectedDiscountedPaymentAmount.message"));
//    }
//
//    public static void getPrintDecemberBadgeAward() {
//        System.out.println(messages.getString("printDecemberBadgeAward.message"));
//    }
//
//    //Exception Messages
//    public static String getValidateNonIntegerMessage() {
//        return exceptionMessages.getString("validateNonInteger.message");
//    }
//
//    public static String getValidateInputRange() {
//        return exceptionMessages.getString("validateInputRange.message");
//    }
//
//    public static String getValidateInputMenuAndQuantity() {return exceptionMessages.getString("validateInputMenuAndQuantity.message");}
//
//    public static String getValidateContainsItem() {
//        return exceptionMessages.getString("validateContainsItem.message");
//    }
//
//    public static String getValidateOrderQuantityMinimum() {
//        return exceptionMessages.getString("validateOrderQuantityMinimum.message");
//    }
//
//    public static String getValidateDuplicateMenu() {
//        return exceptionMessages.getString("validateDuplicateMenu.message");
//    }
//
//
//    public static String getNotOnlyBeveragesOrdered() {
//        return exceptionMessages.getString("notOnlyBeveragesOrdered.message");
//    }
//
//    public static String getExceededMaxOrderQuantity() {
//        return exceptionMessages.getString("exceededMaxOrderQuantity.message");
//    }
//}
