package christmas.view;

import static christmas.util.MessageManager.*;
import static christmas.view.InputValidator.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void readDate() {
        getDatePromptMessage();
        String inputDate = Console.readLine();
        readDateloop(inputDate);
    }

    private void readDateloop(String inputDate) {
        int attempts = 0;
        int maxAttempts = 3;

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
    }

    public void readMenuAndQuantity() {
        getMenuAndQuantityPromptMessage();
        String inputMenuAndQuantity = Console.readLine();
        readMenuAndQuantityLoop(inputMenuAndQuantity);
    }

    private void readMenuAndQuantityLoop(String inputMenuAndQuantity) {
        int attempts = 0;
        int maxAttempts = 3;

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
    }
}
