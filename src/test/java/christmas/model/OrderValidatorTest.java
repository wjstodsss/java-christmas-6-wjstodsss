package christmas.model;

import christmas.model.menu.Appetizer;
import christmas.model.menu.Beverage;
import christmas.model.menu.Dessert;
import christmas.model.menu.MainDish;
import christmas.util.Calculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static christmas.util.Calculator.extractNumbers;
import static org.junit.jupiter.api.Assertions.*;

class OrderValidatorTest {

    @Test
    public void 음료만_주문한_경우() {
        String input = "제로콜라-1";

        OrderValidator orderValidator = new OrderValidator();
        Beverage beverages = Beverage.RED_WINE;

        assertThrows(IllegalArgumentException.class, () -> {
            orderValidator.isNotOnlyBeveragesOrdered(input, beverages);
        });

    }

    @Test
    public void 주문한_메뉴의_수가_20을_초과하는_경우() {
        String input = "제로콜라-21";

        OrderValidator orderValidator = new OrderValidator();

        assertThrows(IllegalArgumentException.class, () -> {
            orderValidator.isExceededMaxOrderQuantity(input);
        });
    }
}