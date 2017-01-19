import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

/*tests
 *@author John Thomsen
 *@version lab3
 */

public class SimpleLinkedStackTests {
   @Test
   public void testSize() {
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<>();
      assertEquals(0, s.size());   
      s.push(1);
      assertEquals(1, s.size());
   }

   @Test(expected=NoSuchElementException.class)
   public void testPeek1() {
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<>();
      s.peek();
   }

   @Test
   public void testPeek2() {
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<>();
      s.push(1);
      assertEquals(1, (int)s.peek());
      assertEquals(1, s.size());
   }

   @Test(expected=NoSuchElementException.class)
   public void testPop1() {
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<>();
      s.pop();
   }
   
   @Test
   public void testPop2() {
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<>();
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
