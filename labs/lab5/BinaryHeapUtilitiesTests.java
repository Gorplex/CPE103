/*
 * @author John Thomsen
 * @version lab5
 *
 */


import org.junit.*;
import static org.junit.Assert.*;
import java.lang.*;
import java.util.*;

public class BinaryHeapUtilitiesTests {
   //Height
   @Test(expected=IllegalArgumentException.class)
   public void testHeight1() {
      BinaryHeapUtilities.height(0);
   }
   @Test
   public void testHeight2() {
      assertEquals(1,BinaryHeapUtilities.height(2));
   }
   @Test
   public void testHeight3() {
      assertEquals(1,BinaryHeapUtilities.height(3));
   }
   @Test
   public void testHeight4() {
      assertEquals(2,BinaryHeapUtilities.height(4));
   }
   @Test
   public void testHeight5() {
      assertEquals(2,BinaryHeapUtilities.height(6));
   }
   @Test
   public void testHeight6() {
      assertEquals(6,BinaryHeapUtilities.height(70));
   }


   //isHeap
   @Test
   public void testIsHeap0() {
      Integer[] heap = new Integer[10];
      assertFalse(BinaryHeapUtilities.isHeap(heap, 15));
   }
   @Test
   public void testIsHeap1() {
      Integer[] heap = new Integer[10];
      heap[1] = 12;
      heap[2] = 20;
      assertTrue(BinaryHeapUtilities.isHeap(heap, 2));
   }
   @Test
   public void testIsHeap2() {
      Integer[] heap = new Integer[10];
      heap[1] = 12;
      heap[2] = 20;
      heap[3] = 3;
      assertTrue(BinaryHeapUtilities.isHeap(heap, 2));
   }
   @Test
   public void testIsHeap3() {
      Integer[] heap = new Integer[10];
      heap[1] = 12;
      heap[2] = 20;
      heap[3] = 3;
      assertFalse(BinaryHeapUtilities.isHeap(heap, 3));
   }
   @Test
   public void testIsHeap4() {
      Integer[] heap = new Integer[10];
      heap[1] = 12;
      heap[2] = 20;
      heap[3] = 15;
      assertTrue(BinaryHeapUtilities.isHeap(heap, 3));
   }
   @Test
   public void testIsHeap5() {
      Integer[] heap = new Integer[10];
      heap[1] = 12;
      heap[2] = 20;
      heap[3] = 12;

      heap[4] = 50;
      heap[5] = 67;

      heap[6] = 12;
      heap[7] = 12;
      assertTrue(BinaryHeapUtilities.isHeap(heap, 7));
   }
   @Test
   public void testIsHeap6() {
      Integer[] heap = new Integer[10];
      heap[1] = 12;
      heap[2] = 20;
      heap[3] = 12;

      heap[4] = 12;
      heap[5] = 67;

      heap[6] = 12;
      heap[7] = 12;
      assertFalse(BinaryHeapUtilities.isHeap(heap, 7));
   }







   //parentOf
   @Test(expected=IndexOutOfBoundsException.class)
   public void testParentOf1() {
      Integer[] heap = new Integer[10];
      BinaryHeapUtilities.parentOf(-1, heap, 9);
   }
   @Test(expected=NoSuchElementException.class)
   public void testParentOf2() {
      Integer[] heap = new Integer[10];
      BinaryHeapUtilities.parentOf(1, heap, 9);
   } 
   @Test(expected=IllegalArgumentException.class)
   public void testParentOf3() {
      Integer[] heap = new Integer[10];
      BinaryHeapUtilities.parentOf(2, heap, 10);
   }
   @Test
   public void testParentOf4() {
      Integer[] heap = new Integer[10];
      heap[1] = 12;
      heap[2] = 20;
      assertEquals(12, (int)BinaryHeapUtilities.parentOf(2, heap, 2));
   }
   @Test
   public void testParentOf5() {
      Integer[] heap = new Integer[10];
      heap[1] = 10;
      heap[2] = 20;
      heap[3] = 11;

      heap[4] = 50;
      heap[5] = 67;

      heap[6] = 12;
      heap[7] = 12;
      assertEquals(11, (int)BinaryHeapUtilities.parentOf(7, heap, 7));
   }



   //leftChildOf
   @Test(expected=IndexOutOfBoundsException.class)
   public void testLeftChildOf0() {
      Integer[] heap = new Integer[10];
      BinaryHeapUtilities.leftChildOf(-1, heap, 9);
   }
   @Test(expected=IndexOutOfBoundsException.class)
   public void testLeftChildOf1() {
      Integer[] heap = new Integer[10];
      BinaryHeapUtilities.leftChildOf(10, heap, 9);
   }
   @Test(expected=NoSuchElementException.class)
   public void testLeftChildOf2() {
      Integer[] heap = new Integer[10];
      BinaryHeapUtilities.leftChildOf(1, heap, 1);
   } 
   @Test(expected=IllegalArgumentException.class)
   public void testLeftChildOf3() {
      Integer[] heap = new Integer[10];
      BinaryHeapUtilities.leftChildOf(2, heap, 10);
   }
   @Test
   public void testLeftChildOf4() {
      Integer[] heap = new Integer[10];
      heap[1] = 12;
      heap[2] = 20;
      assertEquals(20, (int)BinaryHeapUtilities.leftChildOf(1, heap, 2));
   }
   @Test
   public void testLeftChildOf5() {
      Integer[] heap = new Integer[10];
      heap[1] = 10;
      heap[2] = 20;
      heap[3] = 11;

      heap[4] = 50;
      heap[5] = 67;

      heap[6] = 12;
      heap[7] = 13;
      assertEquals(12, (int)BinaryHeapUtilities.leftChildOf(3, heap, 7));
      assertEquals(50, (int)BinaryHeapUtilities.leftChildOf(2, heap, 7));
   }


   //rightChildOf
   @Test(expected=IndexOutOfBoundsException.class)
   public void testRightChildOf0() {
      Integer[] heap = new Integer[10];
      BinaryHeapUtilities.rightChildOf(-1, heap, 9);
   }
   public void testRightChildOf1() {
      Integer[] heap = new Integer[10];
      BinaryHeapUtilities.rightChildOf(10, heap, 9);
   }
   @Test(expected=NoSuchElementException.class)
   public void testRightChildOf2() {
      Integer[] heap = new Integer[10];
      BinaryHeapUtilities.rightChildOf(1, heap, 2);
   } 
   @Test(expected=IllegalArgumentException.class)
   public void testRightChildOf3() {
      Integer[] heap = new Integer[10];
      BinaryHeapUtilities.rightChildOf(2, heap, 10);
   }
   @Test
   public void testRightChildOf4() {
      Integer[] heap = new Integer[10];
      heap[1] = 12;
      heap[2] = 20;
      heap[3] = 33;
      assertEquals(33, (int)BinaryHeapUtilities.rightChildOf(1, heap, 3));
   }
   @Test
   public void testRightChildOf5() {
      Integer[] heap = new Integer[10];
      heap[1] = 10;
      heap[2] = 20;
      heap[3] = 11;

      heap[4] = 50;
      heap[5] = 67;

      heap[6] = 12;
      heap[7] = 13;
      assertEquals(13, (int)BinaryHeapUtilities.rightChildOf(3, heap, 7));
      assertEquals(67, (int)BinaryHeapUtilities.rightChildOf(2, heap, 7));
   }
}
