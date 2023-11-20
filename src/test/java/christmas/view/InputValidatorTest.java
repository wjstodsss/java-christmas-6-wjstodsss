package christmas.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    public void 입력_검증_정수_변환_테스트(InputValidator inputValidator) {
        String input = "1a2b3c";
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateNonInteger(input);
        });
    }

    @Test
    void 입력_검증_범위내_숫자가_아닌_경우(InputValidator inputValidator) {
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateInputRange("0");
        });
    }

    @Test
    void 입력_검증_포멧이_다른_경우(InputValidator inputValidator) {
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateInputMenuAndQuantity("ABCDE-1");
        });
    }
}