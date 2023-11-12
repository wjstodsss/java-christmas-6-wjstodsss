package christmas.model.event;

import org.junit.jupiter.api.Test;

import static christmas.model.event.SpecialStarEvent.getSpecialStarDiscount;
import static org.junit.jupiter.api.Assertions.*;
class SpecialStarEventTest {
    @Test
    void 특별_할인_금액_확인() {
        assertEquals(1000, getSpecialStarDiscount());
    }
}