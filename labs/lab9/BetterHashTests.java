import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
/* BetterHashTest
 *
 * @author John Thomsen
 * @version lab9
 */

public class BetterHashTests {
   @Test
   public void testHash() {
      BetterHash h = new BetterHash();
      assertEquals(89461066, h.hash("abcd"));
   }
   @Test
   public void testHash2() {
      BetterHash h = new BetterHash();
      assertEquals(1049138540, h.hash("1234567890qwer"));
   }
   @Test
   public void testHashMatch() {
      BetterHash h = new BetterHash();
      for (int i = 0; i < 1000; i++) {
         assertEquals(h.hash(""+i*255+124),h.hash(""+i*255+124));
      }
   }
}
