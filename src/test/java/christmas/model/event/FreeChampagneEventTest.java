//package christmas.model.event;
//
//import christmas.model.counter.PointOfSale;
//import christmas.model.menu.Appetizer;
//import org.junit.jupiter.api.Test;
//
//import static christmas.model.event.FreeChampagneEvent.freeChampane;
//import static org.junit.jupiter.api.Assertions.*;
//
//class FreeChampagneEventTest {
//    @Test
//    void 샴페인_증정_확인() {
//        PointOfSale pointOfSale = new PointOfSale();
//        String inputOrder = "티본스테이크-3,레드와인-2";
//
//        int input = pointOfSale.calculateTotalOrderAmount(inputOrder);
//        assertEquals("샴페인", freeChampane(input));
//    }
//}