
/* MorseOrder
 *
 * @author John Thomsen
 * @version project4
 */

public class MorseOrder extends MorseCode implements Comparable<MorseOrder> {
   public MorseOrder(Character character, String string) {
      super(character, string);
   }
   public MorseOrder(MorseCode code) {
      super(code);
   }
   
   public int compareTo(MorseOrder other) {
      return getCode().compareTo(other.getCode());
   }
}
