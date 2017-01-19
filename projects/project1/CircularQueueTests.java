import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

/*
 *JUnit tests
 *@author John Thomsen
 *@version proj1
 */

public class CircularQueueTests {
   @Test
   public void testConst() {
      assertEquals(CircularQueue.INITIAL_LENGTH, 10);
   }

   @Test
   public void testInit1() {
      CircularQueue<Integer> q = new CircularQueue<>();
      assertEquals(0, q.size());
   }
   
   @Test
   public void testInitParam1() {
      CircularQueue<Integer> q = new CircularQueue<>(5);
      assertEquals(0, q.size());
   }

   @Test(expected=CircularQueue.MyException.class)
   public void testInitParam2() {
      CircularQueue<Integer> q = new CircularQueue<>(-1);
   }

   @Test
   public void testEnqueue1() {
      CircularQueue<Integer> q = new CircularQueue<>();
      assertEquals(0, q.size());
      q.enqueue(1);
      assertEquals(1, q.size());
      assertTrue(queueEquals(new Integer[] {1, null, null, null, null, null, null, null, null, null}, q));
   }
   
   @Test
   public void testEnqueue2() {
      CircularQueue<Integer> q = new CircularQueue<>(1);
      //printQueue(q);
      assertTrue(queueEquals(new Integer[] {null}, q));
      q.enqueue(1);
      assertEquals(1, q.size());
      //printQueue(q);
      assertTrue(queueEquals(new Integer[] {1, null}, q));
   }
   
   @Test
   public void testEnqueue3() {
      CircularQueue<Integer> q = new CircularQueue<>(1);
      for (int i = 0; i < 52; i++) {
         q.enqueue(i);
      }
      assertEquals(52, q.size());
      //printQueue(q);
      Object[] arr = q.unusualMethodForTestingPurposesOnly();
      assertEquals((int)64, arr.length);
   }
   
   @Test(expected=NoSuchElementException.class)
   public void testPeek1() {
      CircularQueue<Integer> q = new CircularQueue<>();
      q.peek();
   }

   @Test
   public void testPeek2() {
      CircularQueue<Integer> q = new CircularQueue<>();
      assertEquals(0, q.size());
      q.enqueue(1);
      assertEquals(1, q.size());
      assertEquals(new Integer(1), q.peek());
      assertEquals(1, q.size());
   }
   
   @Test(expected=NoSuchElementException.class)
   public void testDequeue1() {
      CircularQueue<Integer> q = new CircularQueue<>();
      q.dequeue();
   }


   @Test
   public void testDequeue2() {
      CircularQueue<Integer> q = new CircularQueue<>();
      assertEquals(0, q.size());
      q.enqueue(1);
      assertEquals(new Integer(1), q.dequeue());
      assertEquals(0, q.size());
   }


   private boolean queueEquals(Integer[] a, CircularQueue<Integer> q) {
      Object[] arr = q.unusualMethodForTestingPurposesOnly();
      
      if (a.length != arr.length) {
         return false;
      }

      for (int i = 0; i < a.length; i++) {
         if (a[i] != null) {
            if (!a[i].equals(arr[i])) {
               return false;
            }
         } else if (arr[i] != null) {
            return false;
         }
      }
      return true;
   }

   private void printQueue( CircularQueue<Integer> q) {
      Object[] a = q.unusualMethodForTestingPurposesOnly();      
      System.out.println("\n---START-QUEUE-PRINT---");
      for (int i = 0; i < a.length; i++) {
         System.out.println(a[i]);
      }
      System.out.println("---END-QUEUE-PRINT-----");
   }
}
