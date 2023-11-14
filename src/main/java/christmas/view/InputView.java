package christmas.view;

import static christmas.view.MessageManager.getDatePromptMessage;
import static christmas.view.MessageManager.getMenuAndQuantityPromptMessage;
import static christmas.view.InputValidator.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readDate() {
        getDatePromptMessage();
        return readDateloop();
    }

    private String readDateloop() {
        int attempts = 0;
        int maxAttempts = 3;
        String inputDate = Console.readLine();

        while (attempts < maxAttempts) {
            try {
                validateDate(inputDate);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputDate = Console.readLine();
                attempts++;
            }
        }
        return  inputDate;
    }

    public String readMenuAndQuantity() {
        getMenuAndQuantityPromptMessage();
        return readMenuAndQuantityLoop();
    }

    private String readMenuAndQuantityLoop() {
        int attempts = 0;
        int maxAttempts = 3;
        String inputMenuAndQuantity = Console.readLine();

        while (attempts < maxAttempts) {
            try {
                validateInputMenuAndQuantity(inputMenuAndQuantity);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputMenuAndQuantity = Console.readLine();
                attempts++;
            }
        }
        return inputMenuAndQuantity;
    }
}
