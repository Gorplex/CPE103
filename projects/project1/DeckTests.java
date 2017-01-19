import org.junit.*;
import static org.junit.Assert.*;

/*Deck Tests
 *
 *@author John Thomsen
 *@version proj1
 */

public class DeckTests {
   @Test
   public void testInit() {
      Deck d = new Deck(false);
      //printArr(d.unusualMethodForTestingPurposesOnly());
      assertEquals(52, d.size());
      Card c = d.draw();
      //System.out.println(c);
      assertEquals(51, d.size());
   }

   @Test
   public void testShuffle() {
      Deck d = new Deck(false);
      d.shuffle();
      //printArr(d.unusualMethodForTestingPurposesOnly());
      assertEquals(52, d.size());
      Card c = d.draw();
      //System.out.println(c);
      assertEquals(51, d.size());
   }

   @Test
   public void testInit2() {
      Deck d = new Deck(true);
      printArr(d.unusualMethodForTestingPurposesOnly());
      assertEquals(52, d.size());
      Card c = d.draw();
      System.out.println(c);
      assertEquals(51, d.size());
   }

   private void printArr(Object[] arr) {
      System.out.println("---START-ARR-PRINT---");
      for (int i = 0; i < arr.length; i++) {
         System.out.println(i + ": " + arr[i]);
      }
      System.out.println("-----END-ARR-PRINT---");
   }
}
