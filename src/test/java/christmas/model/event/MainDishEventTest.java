package christmas.model.event;

import christmas.model.menu.MainDish;
import org.junit.jupiter.api.RepeatedTest;

import static christmas.model.event.MenuDiscountEvent.calculateMenuDiscount;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainDishEventTest {

    @RepeatedTest(100)
    void 메인음식_할인_확인() {
        MainDish mainDish = MainDish.SEAFOOD_PASTA;
        String inputOrder = "티본스테이크-3,양송이수프-1,아이스크림-5,초코케이크-3";

        assertEquals(6069, calculateMenuDiscount(inputOrder, mainDish));

    }
}
