/**
 * JUnit tests for RecursiveLinkedList.
 *
 * @author Brian Jones
 * @version Lab 1
 * @author John Thomsen
 * @version Lab 6
 */
import org.junit.*;
import static org.junit.Assert.*;

public class RecursiveLinkedListTests {
   @Test
   public void testLong() {
      RecursiveLinkedList<Integer> l = new RecursiveLinkedList<>();
      int SIZE = 100;
      for (int i = 0; i < SIZE; i++) {
         l.add(2*i);
      }
      assertEquals(SIZE,l.size());
      for (int i = 0; i < SIZE; i++) {
         assertEquals(2*i,(int)l.get(i));
      }
      assertEquals(SIZE, l.size());
      for (int i = SIZE; i > 0; i--) {
         l.add(i,2*i-1);
      }
      assertEquals(2*SIZE, l.size());
      for (int i = 0; i < 2*SIZE; i++) {
         assertEquals(i, (int)l.get(i));
      }
      assertEquals(2*SIZE, l.size());
      for (int i = 2*SIZE -1; i >= 0;i--) {
         assertEquals(i,(int)l.remove(l.size()-1));  
      }
      assertEquals(0, l.size());
   }

   //Lab 1 Tests
   @Test
   public void testSize_empty() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      assertTrue(list.size() == 0);
   }

   @Test
   public void testSize_notEmpty() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(5);
      assertTrue(listEquals(list, new int[] {5}));
      assertTrue(list.size() == 1);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testAdd_atConstuctionOutOfBounds() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(25, null);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testRemove_atConstruction() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.remove(0);
   }

   @Test
   public void testAddSize() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();

      list.add(5);
      list.add(10);
      list.add(15);
      list.add(20);
      assertTrue(listEquals(list, new int[] {5, 10, 15, 20}));
      assertTrue(list.size() == 4);
   }

   @Test
   public void testAddInt() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();

      list.add(2);
      list.add(6);
      list.add(2, 8);
      list.add(1, 4);
      list.add(0, 0);

      assertTrue(listEquals(list, new int[] {0, 2, 4, 6, 8}));
      assertTrue(list.size() == 5);
   }
   
   @Test
   public void testRemove() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();

      list.add(2);
      list.add(6);
      list.add(2, 8);
      list.add(1, 4);
      list.add(0, 0);
      
      assertTrue(list.remove(1).equals(2));
      assertTrue(list.remove(2).equals(6));

      assertTrue(listEquals(list, new int[] {0, 4, 8}));
      assertTrue(list.size() == 3);
   }

   @Test
   public void testGet() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();

      list.add(5);
      list.add(10);
      list.add(15);
      list.add(20);

      assertTrue(list.get(0).equals(5));
      assertTrue(list.get(3).equals(20));
   }

   @Test
   public void testRemoveSize() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();

      list.add(5);
      list.add(10);
      list.add(15);
      list.add(20);
      
      assertTrue(list.remove(0).equals(5));
      assertTrue(list.remove(0).equals(10));
      assertTrue(list.remove(0).equals(15));
      assertTrue(list.remove(0).equals(20));

      assertTrue(listEquals(list, new int[] {}));
      assertTrue(list.size() == 0);
   }

   private boolean listEquals(RecursiveLinkedList<Integer> list, int[] a) {
      if (list.size() != a.length) {
         return false;
      }

      for (int i = 0; i < a.length; i++) {
         if (list.get(i) != a[i]) {
            return false;
         }
      }

      return true;
   }
}
