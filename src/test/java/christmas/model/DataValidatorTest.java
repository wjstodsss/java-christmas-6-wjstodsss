package christmas.model;

import static christmas.model.DataValidator.validateContainsItem;
import static christmas.model.DataValidator.validateOrderQuantityMinimum;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataValidatorTest {

    @Test
    public void 메뉴판에_없는_메뉴를_확인() {

        String existingItem = "티본스테이크";
        assertTrue(validateContainsItem(existingItem));
    }

    @Test
    public void 주문한_메뉴_개수가_1이상임을_확인() {
        String input = "티본스테이크-3,초코우유-0,샴페인-5";
        assertTrue(validateOrderQuantityMinimum(input));
    }
}