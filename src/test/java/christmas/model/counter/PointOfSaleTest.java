package christmas.model.counter;

import christmas.model.counter.PointOfSale;
import org.junit.jupiter.api.Test;

import static christmas.model.counter.PointOfSale.calculateTotalOrderAmount;
import static org.junit.jupiter.api.Assertions.*;

class PointOfSaleTest {
    @Test
    void 총_주문_금액_확인() {

        String input = "티본스테이크-3,레드와인-2";

        assertEquals(285000, calculateTotalOrderAmount(input));
    }
}