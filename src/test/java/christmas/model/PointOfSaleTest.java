package christmas.model;

import christmas.model.menu.Appetizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointOfSaleTest {
    @Test
    void 메뉴_이름_호출() {

        String input = "티본스테이크-3,레드와인-2";

        PointOfSale pointOfSale = new PointOfSale();

        pointOfSale.calculateTotalOrderAmount(input);

        assertEquals(285000, pointOfSale.calculateTotalOrderAmount(input));
    }
}