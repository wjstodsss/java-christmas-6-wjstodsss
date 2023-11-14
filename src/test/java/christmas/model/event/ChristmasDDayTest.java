package christmas.model.event;

import christmas.model.counter.PointOfSale;
import org.junit.jupiter.api.Test;
import static christmas.model.event.ChristmasDDay.dDayDiscount;
import static org.junit.jupiter.api.Assertions.*;

class ChristmasDDayTest {
    @Test
    void 총_주문_금액_디데이_할인_확인() {
        PointOfSale pointOfSale = new PointOfSale();
        String inputOrder = "티본스테이크-3,레드와인-2";
        String inputDay = "19";

        int totalPayment = pointOfSale.calculateTotalOrderAmount(inputOrder) - dDayDiscount(inputDay);

        assertEquals(282200, totalPayment);
    }
}