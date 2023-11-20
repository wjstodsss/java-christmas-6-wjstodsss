package christmas.model.counter;

import christmas.model.counter.OrderValidator;
import christmas.model.menu.Beverage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderValidatorTest {

    @Test
    public void 음료만_주문한_경우() {
        String input = "제로콜라-1";

        OrderValidator orderValidator = new OrderValidator();

        assertThrows(IllegalArgumentException.class, () -> {
            orderValidator.orderValidatorBundle(input);
        });

    }

    @Test
    public void 주문한_메뉴의_수가_20을_초과하는_경우() {
        String input = "제로콜라-21";

        OrderValidator orderValidator = new OrderValidator();

        assertThrows(IllegalArgumentException.class, () -> {
            orderValidator.orderValidatorBundle(input);
        });
    }
}