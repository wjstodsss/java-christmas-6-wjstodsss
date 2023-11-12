package christmas.model.discount;

import christmas.model.menu.Appetizer;
import christmas.model.menu.Beverage;
import christmas.model.menu.Dessert;
import christmas.model.menu.MainDish;
import org.junit.jupiter.api.Test;

import static christmas.model.discount.SpecialStarEvent.getSpecialStarDiscount;
import static org.junit.jupiter.api.Assertions.*;
class SpecialStarEventTest {
    @Test
    void 특별_할인_금액_확인() {
        assertEquals(1000, getSpecialStarDiscount());
    }
}