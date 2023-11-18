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
        String inputDate = Console.readLine();

        while (attempts < maxAttempts) {
            try {
                inputvalidator.validateDate(inputDate);
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
        outputView.printMenuAndQuantityPromptMessage();
        return readMenuAndQuantityLoop();
    }

    private String readMenuAndQuantityLoop() {
        int attempts = 0;
        int maxAttempts = 3;
        String inputMenuAndQuantity = Console.readLine();

        while (attempts < maxAttempts) {
            try {
                inputvalidator.validateInputMenuAndQuantity(inputMenuAndQuantity);
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
