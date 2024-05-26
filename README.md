<h3>Лабораториска вежба бр.2 Софтверско Инженерство</h3>
<h3> Иван Ивановски 212093</h3>
<h4>Одговор на прашања од вежба се подолу</h4>
<h3>Control Flow Graph</h3>
<img src="./SI_2024_lab2_resenie_CFG.PNG" alt="Slika na control flow graph na funckijata checkCart"/>
<h3>Цикломатска комплексност</h3>
<p>За да пресметаме цикломатската комплексност на дадената функција, треба прво да идентификуваме јазлите и ребрата во контролниот токовен граф (CFG) на функцијата.
Потоа можеме да го примениме следниот израз за пресметување на цикломатската комплексност:
V(G)=E−N+2. Каде што:</p>
<ul>
<li>V(G) е цикломатската комплексност,</li>
<li>E е бројот на ребра (линии на кодот)</li>
<li>N е бројот на темиња (основни блокови или точки на одлука).</li> 
</ul>
<p>Па според горе прикажаниот граф имаме 24 темиња, 32 ребра па од тука цикломатската комплексност ќе биде: V(G)=32-24+2=34-24=10.</p> 
<p>Значи графот има цикломатска комплексност 10.</p>
<h3>Тестирање според every branch критериум</h3>
<p>Следнава слика се однесува за тест случаи.Со секој тест случај се тестирање парче од код, линија по линија притао истиот тест да биде задоволен.</p>
<img src="SI_2024_lab2_every_branch_testiranje.PNG" alt="Mesto od slika so test slucai po every branch kriterium"/>
<h3>Тестирање случаи по Multiple Condition критериум</h3>
<p>За напишување на тест случаи според Multiple Condition критериумот, треба да ги разгледаме сите можни комбинации на условите. Во конкретниот услов:</p>
<code>(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')</code>
<p>Треба да се обрне внимание на позитивни но и на негативни случаи.</p>
<p>Кај позитивните тест случаи, секој услов не зависно треба да биде исполнет, т.е да бидат исполнети:</p>
<ul>
    <li>item.getPrice() > 300</li>
    <li>item.getDiscount() > 0</li>
    <li>item.getBarcode().charAt(0) == '0'</li>
</ul>
<p>Соодветно кај негативните тест случаи мора еден од дадени услови да не биде исполенет, т.е  </p>
<ul>
    <li>item.getPrice() <= 300</li>
    <li>item.getDiscount() < 0</li>
    <li>item.getBarcode().charAt(0) != '0'</li>
</ul>
<h3>Објаснување за unit тестови</h3>
<p>Пред да почнеме со пишување на било кој тест, треба добро да се разгледат тест случаи од Every Statement критериум. </p>
<p>За дел од тестови проверуваме дали во одреден момент се фрла некој исклучок. Доколку е фрлен соодветен исклучок за истиот 
проверуваме дали ја содржи истата порука како во главниот код.</p>
<p>Тестови кои што се искористени за тестирање на самиот код.</p>
<pre>
<code>
    
    Java
    
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
</code>
</pre>
