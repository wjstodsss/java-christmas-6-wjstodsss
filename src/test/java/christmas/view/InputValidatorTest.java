package christmas.view;

import static christmas.view.InputValidator.validateNonInteger;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    public void 입력_검증_정수_변환_테스트() {
        String input = "1a2b3c";
        assertThrows(IllegalArgumentException.class, () -> {
            validateNonInteger(input);
        });
    }

    @Test
    void 입력_검증_범위내_숫자가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateInputRange("0");
        });
    }
}