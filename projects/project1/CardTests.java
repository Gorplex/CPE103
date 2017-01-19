import org.junit.*;
import static org.junit.Assert.*;

/*
 *JUnit tests
 *@author John Thomsen
 *@version proj1
 */

public class CardTests {
   private static final String[] RANK = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
   private static final String[] SUIT = {"Spades", "Hearts", "Diamonds", "Clubs"};

   @Test(expected=IllegalArgumentException.class)
   public void testInit1() {
      Card c = new Card(0, 1);
   }
   @Test(expected=IllegalArgumentException.class)
   public void testInit2() {
      Card c = new Card(1, 0);
   }
   @Test(expected=IllegalArgumentException.class)
   public void testInit3() {
      Card c = new Card(14, 1);
   }
   @Test(expected=IllegalArgumentException.class)
   public void testInit4() {
      Card c = new Card(1, 5);
   }

   //toString() method uses the getRank() and getSuit() methods (efectivly testing them)
   @Test
   public void testToString1() {
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 13; j++) { 
            assertEquals(RANK[j]+" of "+SUIT[i], (new Card(j+1,i+1)).toString());
         }
      }
   }
}
