/* StringHash
 *
 * @version lab9
 */

public class StringHash implements Hashable<String> {
   public int hash(String input) {
      return input.hashCode();
   }
}
