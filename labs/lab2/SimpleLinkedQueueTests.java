import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

/*tests
 *@author John Thomsen
 *@version lab2
 */

public class SimpleLinkedQueueTests {
   @Test
   public void testSize() {
      SimpleLinkedQueue<Integer> q = new SimpleLinkedQueue<>();
      assertTrue(q.size() == 0);
   }

   @Test
   public void testSize2() {
      SimpleLinkedQueue<Integer> q = new SimpleLinkedQueue<>();
      q.enqueue(0);
      assertTrue(q.size() == 1);
   }

   @Test(expected=NoSuchElementException.class)
   public void testPeekError() {
      SimpleLinkedQueue<Integer> q = new SimpleLinkedQueue<>();
      q.peek();
   }

   @Test(expected=NoSuchElementException.class)
   public void testDequeueError() {
      SimpleLinkedQueue<Integer> q = new SimpleLinkedQueue<>();
      q.dequeue();
   }

   @Test
   public void testPeek2() {
      SimpleLinkedQueue<Integer> q = new SimpleLinkedQueue<>();
      q.enqueue(0);
      assertTrue(q.peek().equals(0));
      assertTrue(q.size() == 1);
   }

   @Test
   public void testDequeue2() {
      SimpleLinkedQueue<Integer> q = new SimpleLinkedQueue<>();
      q.enqueue(0);
      assertTrue(q.dequeue().equals(0));
      assertTrue(q.size() == 0);
   }

   @Test
   public void testEnqueue() {
      SimpleLinkedQueue<Integer> q = new SimpleLinkedQueue<>();
      q.enqueue(0);
      q.enqueue(5);
      q.enqueue(10);
      assertTrue(q.size() == 3);
      assertTrue(q.peek().equals(0));
      assertTrue(q.dequeue().equals(0));
      assertTrue(q.dequeue().equals(5));
      assertTrue(q.dequeue().equals(10)); 
   }

   @Test
   public void testEnqueue2() {
      SimpleLinkedQueue<Integer> q = new SimpleLinkedQueue<>();
      q.enqueue(2);
      assertTrue(q.dequeue().equals(2));
      assertTrue(q.size() == 0);
      q.enqueue(4);
      assertTrue(q.size() == 1);
      assertTrue(q.peek().equals(4));
      assertTrue(q.dequeue().equals(4));
      assertTrue(q.size() == 0);
   }
}
