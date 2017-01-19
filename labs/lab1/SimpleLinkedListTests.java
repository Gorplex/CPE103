/**
 * JUnit tests for SimpleLinkedList.
 *
 * @author Brian Jones
 * @version Lab 1
 */
import org.junit.*;
import static org.junit.Assert.*;

public class SimpleLinkedListTests {
   @Test
   public void testSize_empty() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      assertTrue(list.size() == 0);
   }

   @Test
   public void testSize_notEmpty() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(5);
      assertTrue(listEquals(list, new int[] {5}));
      assertTrue(list.size() == 1);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testAdd_atConstuctionOutOfBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(25, null);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testRemove_atConstruction() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.remove(0);
   }

   @Test
   public void testAddSize() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();

      list.add(5);
      list.add(10);
      list.add(15);
      list.add(20);
      assertTrue(listEquals(list, new int[] {5, 10, 15, 20}));
      assertTrue(list.size() == 4);
   }

   @Test
   public void testAddInt() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();

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
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();

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
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();

      list.add(5);
      list.add(10);
      list.add(15);
      list.add(20);

      assertTrue(list.get(0).equals(5));
      assertTrue(list.get(3).equals(20));
   }

   @Test
   public void testRemoveSize() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();

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

   private boolean listEquals(SimpleLinkedList<Integer> list, int[] a) {
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
