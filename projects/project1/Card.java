
/*Card class
 *
 *@author John Thomsen
 *@version proj1
 */

public class Card {
   private static final String[] RANK = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
   private static final String[] SUIT = {"Spades", "Hearts", "Diamonds", "Clubs"};

   private int rank;
   private int suit;
   
   public Card(int rank, int suit) {
      if (rank < 1 || rank > 13 || suit < 1 || suit > 4){ throw new IllegalArgumentException();}
      this.rank = rank;
      this.suit = suit;
   }
   public String getRank() {
      return RANK[rank-1];
   }
   public String getSuit() {
      return SUIT[suit-1];
   }
   @Override
   public String toString() {
      return getRank() + " of " + getSuit();
   }
}
