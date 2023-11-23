package christmas.model.menu;


import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuTest {
    @Test
    void 메뉴_이름_호출() {
        assertEquals("양송이수프", Appetizer.MUSHROOM_SOUP.getItemName());
        assertEquals("제로콜라", Beverage.ZERO_COLA.getItemName());
        assertEquals("초코케이크", Dessert.CHOCO_CAKE.getItemName());
        assertEquals("티본스테이크", MainDish.T_BONE_STEAK.getItemName());
    }

}