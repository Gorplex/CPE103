import java.util.*;

/*Deck of Cards
 *
 *@author John Thomsen
 *@version proj1
 */

public class Deck extends CircularQueue<Card> {

   public Deck(boolean shuffle) {
      super(53);
      for (int i = 0; i < 52; i++) {
         enqueue(new Card(i%13+1,i/13+1));
      }
      if (shuffle) {
         shuffle();
         shuffle();
         shuffle();
      }
   }
   public Card draw() {
      return dequeue();
   }
   public void shuffle() {
      //stack 1 from i = 0 to n/2-1
      //stack 2 from i = n/2 to n-1
      Card[] a1 = new Card[size()];
      Card[] a2 = new Card[size()];
      int i1 = 0;
      int i2 = 0;
      Random rand = new Random();
      while (size() > 0) {
         if (rand.nextBoolean()) {
            a1[i1] = dequeue();
            i1++;
         }else{
            a2[i2] = dequeue();
            i2++;
         }
      }
      //System.out.println("i1: " +i1);
      //System.out.println("i2: " +i2);

      int i = 0;
      while(i1 > 0 || i2 > 0) {
         //System.out.println(size());
         if (rand.nextFloat() <= i1/(i1+i2)) {
            enqueue(a1[i1-1]);
            i1--;
         }else{
            enqueue(a2[i2-1]);
            i2--;
         }
      }
   }
}
