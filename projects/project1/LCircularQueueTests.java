/**
 * JUnit tests for CircularQueue.
 *  
 * @version Project 1
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;


public class LCircularQueueTests {
   @Test
   public void testSize_empty() {
      CircularQueue<Integer> queue = new CircularQueue<Integer>();
      assertEquals(0, queue.size());
   }

   @Test
   public void testSize_enqueue() {
      CircularQueue<Integer> queue = new CircularQueue<Integer>(10);
      queue.enqueue(5);
      queue.enqueue(10);
      assertEquals(2, queue.size());
   }
   
   @Test
   public void testSize_dequeue() {
      CircularQueue<Integer> queue = new CircularQueue<Integer>();
      queue.enqueue(5);
      queue.enqueue(5);
      queue.enqueue(5);
      queue.dequeue();
      queue.dequeue();
      assertEquals(1, queue.size());
   }

   @Test
   public void testSize_4Elements() {
      CircularQueue<Integer> queue = new CircularQueue<Integer>();
      queue.enqueue(5);
      queue.enqueue(10);
      queue.enqueue(15);
      queue.enqueue(20);
      assertEquals(4, queue.size());
      assertEquals((Integer)5 , queue.dequeue());
      assertEquals((Integer)10, queue.dequeue());
      assertEquals(2, queue.size());
      assertEquals((Integer)15, queue.dequeue());
      
   }

   @Test
   public void testUnusual_4Elements() {
      CircularQueue<Integer> queue = new CircularQueue<Integer>();
      queue.enqueue(5);
      queue.enqueue(10);
      queue.enqueue(15);
      queue.enqueue(20);
      assertEquals(4, queue.size());
      assertTrue( ArrayEquals(new Integer[] {5, 10, 15, 20, null, null, null, null, null, null},
			       queue.unusualMethodForTestingPurposesOnly()));
      assertEquals((Integer)5 , queue.dequeue());
      assertEquals((Integer)10, queue.dequeue());
      assertEquals(2, queue.size());
      assertEquals((Integer)15, queue.dequeue());
      
   }
   
   @Test(expected=NoSuchElementException.class)
   public void testDequeue_atConstruction() {
      CircularQueue<Integer> queue = new CircularQueue<Integer>();
      queue.dequeue();
   }

   @Test
   public void testEnqueueSize() {
      CircularQueue<Integer> queue = new CircularQueue<Integer>();

      queue.enqueue(5);
      queue.enqueue(10);
      queue.enqueue(15);
      queue.enqueue(20);
      assertEquals(4, queue.size());
   }

   @Test
   public void testPeek() {
      CircularQueue<Integer> queue = new CircularQueue<Integer>();

      queue.enqueue(5);
      assertEquals((Integer)5,queue.peek());
      queue.enqueue(10);
      assertEquals((Integer)5,queue.peek());
      queue.dequeue();
      assertEquals((Integer)10,queue.peek());
      queue.enqueue(15);
      queue.enqueue(20);
      assertEquals((Integer)10,queue.peek());
      assertEquals(3, queue.size());
   }

   @Test(expected=CircularQueue.MyException.class)
   public void testConstruction_MyException0() {
      CircularQueue<Integer> queue = new CircularQueue<Integer>(0);
   }

   @Test(expected=CircularQueue.MyException.class)
   public void testConstruction_MyExceptionNeg() {
      CircularQueue<Integer> queue = new CircularQueue<Integer>(-1);
   }

   @Test(expected=CircularQueue.MyException.class)
   public void testConstruction_MyExceptionNeg2() {
      CircularQueue<Integer> queue = new CircularQueue<Integer>(-456);
   }
   @Test(expected=NoSuchElementException.class)
   public void testPeek_atConstruction() {
      CircularQueue<Integer> queue = new CircularQueue<Integer>();
      queue.peek();
   }
   
   @Test
   public void testIncreaseSizeEnqueue() {
      CircularQueue<Integer> queue = new CircularQueue<Integer>(2);
      queue.enqueue(5);
      queue.enqueue(10);
      queue.enqueue(15);
      queue.enqueue(20);
      assertEquals(4, queue.size());
      assertEquals((Integer)5, queue.dequeue());
      assertEquals((Integer)10, queue.dequeue());
      assertEquals((Integer)15, queue.dequeue());
      assertEquals((Integer)20, queue.dequeue());
      
   }


   private boolean ArrayEquals(Integer[] a, Object[] queue) {
      if (queue.length != a.length) {
         return false;
      }

      for (int i = 0; i < a.length; i++) {
	 if(queue[i] == null) {
	    if(a[i] != null) {
	       return false;
	    }
	 }
         else if (a[i].equals( (Integer)queue[i])) {
            //return false;
         }
	 else {
	    return false;
	 }
	    
      }

      return true;
   }   

}
