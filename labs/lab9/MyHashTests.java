import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
/* MyHashTest
 *
 * @author John Thomsen
 * @version lab9
 */

public class MyHashTests {
   @Test
   public void testHash() {
      MyHash h = new MyHash();
      assertEquals(3158403,h.hash("abcd"));
   }
   @Test
   public void testHash2() {
      MyHash h = new MyHash();
      assertEquals(1460419657,h.hash("1234567890qwer"));
   }
   @Test
   public void testHashMatch() {
      MyHash h = new MyHash();
      for (int i = 0; i < 1000; i++) {
         assertEquals(h.hash(""+i*255+124),h.hash(""+i*255+124));
      }
   }
}
