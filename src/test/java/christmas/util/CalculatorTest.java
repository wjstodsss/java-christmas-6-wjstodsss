package christmas.util;

import christmas.model.menu.MainDish;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void 주문_메뉴의_총_개수1(){
        String orderMenu = "티본스테이크-3,양송이수프-1,아이스크림-5";
        assertEquals(9, Calculator.calculateSumOfMatches(orderMenu));
    }

    @Test
    public void 주문_메뉴_이름을_SET에_담기() {
        String input = "티본스테이크-3,양송이수프-1,아이스크림-5";
        Set<String> expectedKoreanWords = new HashSet<>();
        expectedKoreanWords.add("티본스테이크");
        expectedKoreanWords.add("양송이수프");
        expectedKoreanWords.add("아이스크림");

        Set<String> koreanWords = Calculator.extractWords(input);
        assertEquals(expectedKoreanWords, koreanWords);
    }
}