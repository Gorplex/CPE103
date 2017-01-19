import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class PriorityQueueTests {
   //construtor tests
   @Test
   public void testArrToQueue() {
      Integer[] arr = new Integer[1000];
      for (int i = 999; i >= 0; i--) {
         arr[i] = i;
      }
      PriorityQueue<Integer> q = new PriorityQueue<>(arr, 1000);
      assertEquals(1000, q.size());
      assertEquals(0, (int)q.peek());
      for (int i = 0; i < 1000;i++) {
         assertEquals(i, (int)q.dequeue());
      }
      assertEquals(0, q.size());
   }
   @Test
   public void testArrToQueueMax() {
      Integer[] arr = new Integer[1000];
      for (int i = 0; i < 1000; i++) {
         arr[i] = i;
      }
      PriorityQueue<Integer> q = new PriorityQueue<>(arr, 1000, true);
      assertEquals(1000, q.size());
      assertEquals(999, (int)q.peek());
      for (int i = 999; i >= 0;i--) {
         assertEquals(i, (int)q.dequeue());
      }
      assertEquals(0, q.size());
   }
   
   //complex tests
   @Test
   public void testLong() {
      PriorityQueue<Integer> q = new PriorityQueue<>();
      int SIZE = 100;
      for (int i = 0; i < SIZE; i++) {
         q.enqueue(2*i);
      }
      assertEquals(SIZE,q.size());
      assertEquals(0,(int)q.peek());
      assertEquals(SIZE, q.size());
      for (int i = SIZE; i > 0; i--) {
         q.enqueue(2*i-1);
      }
      assertEquals(2*SIZE, q.size());
      assertEquals(0, (int)q.peek());
      assertEquals(2*SIZE, q.size());
      for (int i = 0; i < SIZE*2;i++) {
         assertEquals(i,(int)q.dequeue());  
      }
      assertEquals(0, q.size());
   }
   
   @Test
   public void testLong1() {
      PriorityQueue<Integer> q = new PriorityQueue<>(true);
      int SIZE = 100;
      for (int i = 0; i < SIZE; i++) {
         q.enqueue(2*i);
      }
      assertEquals(SIZE,q.size());
      assertEquals(198,(int)q.peek());
      assertEquals(SIZE, q.size());
      for (int i = SIZE; i > 0; i--) {
         q.enqueue(2*i-1);
      }
      assertEquals(2*SIZE, q.size());
      assertEquals(199, (int)q.peek());
      assertEquals(2*SIZE, q.size());
      for (int i = SIZE*2-1; i >= 0;i--) {
         assertEquals(i,(int)q.dequeue());  
      }
      assertEquals(0, q.size());
   }  
   
   //heap tests
   @Test(expected=NoSuchElementException.class)
   public void testHeap0() {
      PriorityQueue<Integer> q = new PriorityQueue<>();
      q.dequeue();
   }
   @Test(expected=NoSuchElementException.class)
   public void testHeap1() {
      PriorityQueue<Integer> q = new PriorityQueue<>();
      q.peek();
   }
   @Test
   public void testHeap2() {
      PriorityQueue<Integer> q = new PriorityQueue<>();
      assertEquals(0, q.size());
   }
   @Test
   public void testHeap3() {
      PriorityQueue<Integer> q = new PriorityQueue<>();
      for (int i = 99; i >= 0; i--) {
         assertEquals(99-i, q.size());
         q.enqueue(i);
         assertEquals(i,(int)q.peek());
      }
      assertEquals(100, q.size());
      for (int i = 0; i < 100; i++) {
         assertEquals(i,(int)q.dequeue());
         assertEquals(99-i, q.size());
      }
   }
   @Test
   public void testHeap4() {
      PriorityQueue<Integer> q = new PriorityQueue<>(true);
      for (int i = 0; i < 100; i++) {
         assertEquals(i, q.size());
         q.enqueue(i);
         assertEquals(i,(int)q.peek());
      }
      assertEquals(100, q.size());
      for (int i = 99; i >= 0; i--) {
         assertEquals(i,(int)q.dequeue());
         assertEquals(i, q.size());
      }
   }

   
   //sort tests
   @Test
   public void testSort() {
      Integer[] arr1 = new Integer[1000];
      Integer[] arr2 = new Integer[1000];
      for (int i = 0; i < 1000; i++) {
         arr1[i] = i;
         arr2[i] = 999-i;
      }

      PriorityQueue.sort(arr2, 1000);

      for (int i = 0; i < 1000; i++) {
         assertEquals(arr1[i], arr2[i]);
      }
   }
   //extra length array
   @Test
   public void testSortExtra() {
      Integer[] arr1 = new Integer[1000];
      Integer[] arr2 = new Integer[1000];
      for (int i = 0; i < 1000; i++) {
         if(i<100) {
            arr1[i] = 900+i;
         }else{
            arr1[i] = 999-i;
         }
         arr2[i] = 999-i;
      }

      PriorityQueue.sort(arr2, 100);

      for (int i = 0; i < 1000; i++) {
         assertEquals(arr1[i], arr2[i]);
      }
   }

   //kth test
   @Test
   public void testKth() {
      Integer[] arr1 = new Integer[1000];
      for (int i = 0; i < 1000; i++) {
         arr1[i] = i;
      }
      for (int i = 0; i < 1000; i++) {
         assertEquals(i, (int)PriorityQueue.kth(arr1, 1000, 1000-i));  
      }
   }
   //extra size test
   @Test
   public void testKthExtra() {
      Integer[] arr1 = new Integer[1000];
      for (int i = 0; i < 1000; i++) {
         arr1[i] = i;
      }
      for (int i = 0; i < 100; i++) {
         assertEquals(i, (int)PriorityQueue.kth(arr1, 100, 100-i));  
      }
   }
}
