import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    @Test
    void checkCartEmptyListAndPayment(){
        //test case if list of items is null and there is some payment
        List<Item> allItems=null;
        RuntimeException ex;
        ex = Assertions.assertThrows(RuntimeException.class, ()-> SILab2.checkCart(allItems,100));
        Assertions.assertFalse(ex.getMessage().contains("allItems can not be null!"));
    }
    @Test
    void checkCartWithSomeNoNameItems(){
        //test case if there is some items in list allItems, but they do not have name
        List<Item> allItems = Arrays.asList(
                new Item("", "12345", 100, 0.1F),
                new Item(null, "14615", 100, 0.0F)
        );
        assertDoesNotThrow(()->SILab2.checkCart(allItems,100));
        assertFalse(()->SILab2.checkCart(allItems,100));
    }
    @Test
    void checkCartWithNoBarcodeItems(){
        // test case for checkCart function
        // if there are items that do not have barcode
        List<Item> allItems = Arrays.asList(
                new Item("", null, 100, 0.1F),
                new Item(null, "14615", 100, 0.2F)
        );
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class,()->SILab2.checkCart(allItems,100));
        assertTrue(ex.getMessage().contains("No barcode"));
    }
    @Test
    void testSpecialDiscount(){
        List<Item> allItems = Arrays.asList(
                new Item("Item A", "21234", 400, 0.1F),
                new Item("Item B", "23132", 500, 0.1F)
        );
        assertTrue(SILab2.checkCart(allItems,1000));
    }
    @Test
    void testInvalidBarCode(){
        List<Item> allItems = Arrays.asList(
                new Item("Item A", "21B34", 400, 0.15F),
                new Item("Item B", "2313A", 500, 0.1F),
                new Item("Item C", "214-1", 500, .25F)
        );
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class,()->SILab2.checkCart(allItems,100));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));
    }
    @Test
    void testMultipleConditions(){
        List<Item> allItems = Arrays.asList(
                new Item("Item A", "21234", 400, 0.15F),
                new Item("Item B", "23132", 300, 0.1F),
                new Item("Item C", "21231", 500, .25F)
        );
        float sumForTest = (400*0.15F)-30 + (200*0.1F) + (500*0.25F)-30;
        assertTrue(SILab2.checkCart(allItems,(int)sumForTest));
    }

}