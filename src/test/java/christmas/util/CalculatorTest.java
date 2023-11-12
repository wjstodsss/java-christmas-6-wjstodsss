package christmas.util;

import christmas.model.menu.MainDish;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void 주문_메뉴의_총_개수1(){
        String orderMenu = "티본스테이크-3,양송이수프-1,아이스크림-5";
        assertEquals(9, Calculator.calculateSum(orderMenu));
    }
}