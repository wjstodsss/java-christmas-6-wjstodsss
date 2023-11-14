package christmas.util;

import java.util.ResourceBundle;

public class MessageManager {
    private static final ResourceBundle messages = ResourceBundle.getBundle("messages");
    private static final ResourceBundle exceptionMessages = ResourceBundle.getBundle("exception-messages");

    //General Messages
    public static void getDatePromptMessage() {
        System.out.println(messages.getString("datePrompt.message"));
    }

    public static void getProgramClosePromoptMessage() {
        System.out.println(messages.getString("programClosePromopt.message"));
    }

    public static void getMenuAndQuantityPromptMessage() {
        System.out.println(messages.getString("menuAndQuantityPrompt.message"));
    }

    public static void getPrintOrderMenu() {
        System.out.println(messages.getString("printOrderMenu.message"));
    }

    //Exception Messages
    public static String getValidateNonIntegerMessage() {
        return exceptionMessages.getString("validateNonInteger.message");
    }

    public static String getValidateInputRange() {
        return exceptionMessages.getString("validateInputRange.message");
    }
    public static String getValidateInputMenuAndQuantity() {return exceptionMessages.getString("validateInputMenuAndQuantity.message");}

}
