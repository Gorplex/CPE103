import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
/* StringHashTest
 *
 * @author John Thomsen
 * @version lab9
 */

public class StringHashTests {
   @Test
   public void testHash() {
      StringHash h = new StringHash();
      assertEquals(2987074,h.hash("abcd"));
   }
   @Test
   public void testHash2() {
      StringHash h = new StringHash();
      assertEquals(-1184736658,h.hash("1234567890qwer"));
   }
   @Test
   public void testHashMatch() {
      StringHash h = new StringHash();
      for (int i = 0; i < 1000; i++) {
         assertEquals(h.hash(""+i*255+124),h.hash(""+i*255+124));
      }
   }
}
