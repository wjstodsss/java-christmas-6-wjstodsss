package christmas.model.event;

import christmas.model.menu.Dessert;
import org.junit.jupiter.api.Test;

import static christmas.model.event.BadgeAwardEvent.awardBadge;
import static christmas.model.event.ChristmasDDay.dDayDiscount;
import static christmas.model.event.MenuDiscountEvent.calculateMenuDiscount;
import static christmas.model.event.SpecialStarEvent.getSpecialStarDiscount;
import static org.junit.jupiter.api.Assertions.*;

class BadgeAwardEventTest {
    @Test
    void 특별_할인_금액_확인() {
        Dessert dessert = Dessert.CHOCO_CAKE;
        String inputOrder = "티본스테이크-3,양송이수프-1,아이스크림-5,초코케이크-3";
        String inputDay = "19";
        int totalBenefitAmount = dDayDiscount(inputDay) + getSpecialStarDiscount() + calculateMenuDiscount(inputOrder, dessert);
        assertEquals("트리", awardBadge(totalBenefitAmount));
    }

}