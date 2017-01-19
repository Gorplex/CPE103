/* MyHash
 * @author John Thomsen
 * @version lab9
 */

public class MyHash implements Hashable<String> {
   public int hash(String s) {
      int hash = 1;
      for (int i = 0; i < s.length(); i++) {
         hash *= 29;//23;//7919;
         hash += (int)s.charAt(i);
      }
      return hash;
   }
}
