
/* CharacterOrder
 *
 * @author John Thomsen
 * @version project4
 */

public class CharacterOrder extends MorseCode implements Comparable<CharacterOrder> {
   public CharacterOrder(Character character, String string) {
      super(character, string);
   }
   public CharacterOrder(MorseCode code) {
      super(code);
   }
   public int compareTo(CharacterOrder other) {
      return getCharacter().compareTo(other.getCharacter());
   }
}
