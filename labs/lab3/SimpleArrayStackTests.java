import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

/*tests
 *@author John Thomsen
 *@version lab3
 */

public class SimpleArrayStackTests {
   @Test
   public void testCapacity() {
      SimpleArrayStack<Integer> s = new SimpleArrayStack<>();
      assertEquals(10, s.capacity());
   }
 
   @Test
   public void testCapacity2() {
      SimpleArrayStack<Integer> s = new SimpleArrayStack<>();
      assertEquals(10, s.capacity());
      for (int i = 0; i < 11; i++) { s.push(i); }
      assertEquals(20, s.capacity());
   }

   @Test
   public void testSize() {
      SimpleArrayStack<Integer> s = new SimpleArrayStack<>();
      assertEquals(0, s.size());   
      s.push(1);
      assertEquals(1, s.size());
   }

   @Test(expected=NoSuchElementException.class)
   public void testPeek1() {
      SimpleArrayStack<Integer> s = new SimpleArrayStack<>();
      s.peek();
   }

   @Test
   public void testPeek2() {
      SimpleArrayStack<Integer> s = new SimpleArrayStack<>();
      s.push(1);
      assertEquals(1, (int)s.peek());
      assertEquals(1, s.size());
   }

   @Test(expected=NoSuchElementException.class)
   public void testPop1() {
      SimpleArrayStack<Integer> s = new SimpleArrayStack<>();
      s.pop();
   }
   
   @Test
   public void testPop2() {
      SimpleArrayStack<Integer> s = new SimpleArrayStack<>();
      s.push(0);
      s.push(1);
      s.push(4);
      assertEquals(4, (int)s.pop());
      s.push(10);
      assertEquals(10, (int)s.pop());
      assertEquals(1, (int)s.pop());
      assertEquals(1, s.size());
      assertEquals(0, (int)s.pop());
      assertEquals(0, s.size());
   }

}
