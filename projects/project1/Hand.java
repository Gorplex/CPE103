import java.lang.*;
import java.util.*;

/*Hand of Cards
 *
 *@author John Thomsen
 *@version proj1
 */

public class Hand {
   private Deck deck;
   private ArrayList<Card> hand;
   
   public Hand(Deck deck, int handSize) {
      if (handSize <= 0) {throw new IllegalArgumentException();}//changed from not including 0
      if (deck == null) {throw new NullPointerException();}
      if (deck.size() < handSize) {throw new NoSuchElementException();}//changed after prob unnessary
      
      this.deck = deck;
      hand = new ArrayList<Card>(handSize);
      for (int i = 0; i < handSize; i++) {
         draw();
      }
   }
   public void draw() {
      hand.add(deck.draw());
   }
   public Card getCard(int cardNumber) {
      return hand.get(cardNumber);    
   }
   public Card play(int cardNumber) {
      return hand.remove(cardNumber);  
   }
   public int size() {
      return hand.size();
   }
}
