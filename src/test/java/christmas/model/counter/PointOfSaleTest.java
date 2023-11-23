package christmas.model.counter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PointOfSaleTest {
    @Test
    void 총_주문_금액_확인() {
        PointOfSale pointOfSale = new PointOfSale();

        String input = "티본스테이크-3,레드와인-2";

        assertEquals(285000, pointOfSale.calculateTotalOrderAmount(input));
    }
}