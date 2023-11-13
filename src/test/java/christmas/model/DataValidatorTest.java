package christmas.model;

import static christmas.model.DataValidator.containsItem;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataValidatorTest {

    @Test
    public void testContainsExistingItem() {

        String existingItem = "티본스테이크";
        assertTrue(containsItem(existingItem));
    }
}