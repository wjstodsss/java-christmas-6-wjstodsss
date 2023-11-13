package christmas.view;

import static christmas.util.MessageManager.*;
import static christmas.view.InputValidator.validateDate;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void readDate() {
        int maxAttempts = 3;
        int attempts = 0;

        getDatePromptMessage();
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
    }
}
