package christmas.view;



import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final OutputView outputView = new OutputView();
    private InputValidator inputvalidator  = new InputValidator();

    public String readDate() {
        outputView.printDatePromptMessage();
        return readDateloop();
    }

    private String readDateloop() {
        int attempts = 0;
        int maxAttempts = 3;
        String inputDate = null;

        while (attempts < maxAttempts) {
            try {
                inputDate = Console.readLine();
                inputvalidator.validateDate(inputDate);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                attempts++;
            }
        }
        if (attempts == maxAttempts) {
            String errorMessage = outputView.printMaxAttemptsOverMessage();
            System.out.println(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        return  inputDate;
    }

    public String readMenuAndQuantity() {
        outputView.printMenuAndQuantityPromptMessage();
        return readMenuAndQuantityLoop();
    }

    private String readMenuAndQuantityLoop() {
        int attempts = 0;
        int maxAttempts = 3;
        String inputMenuAndQuantity = null;

        while (attempts < maxAttempts) {
            try {
                inputMenuAndQuantity = Console.readLine();
                inputvalidator.validateInputMenuAndQuantity(inputMenuAndQuantity);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                attempts++;
            }
        }
        if (attempts == maxAttempts) {
            String errorMessage = outputView.printMaxAttemptsOverMessage();
            System.out.println(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        return inputMenuAndQuantity;
    }
}
