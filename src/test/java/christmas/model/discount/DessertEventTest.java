package christmas.model.discount;

import christmas.model.menu.Dessert;
import org.junit.jupiter.api.RepeatedTest;

import static christmas.model.discount.DessertEvent.dessertDiscount;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DessertEventTest {

    @RepeatedTest(10000)
    void 디저트_할인_확인() {
        Dessert dessert = Dessert.CHOCO_CAKE;
        String inputOrder = "티본스테이크-3,양송이수프-1,아이스크림-5,초코케이크-3";

        assertEquals(16184, dessertDiscount(inputOrder, dessert));

    }
    
}