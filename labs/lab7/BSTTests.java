import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

/*lab7 tests
 *@author John Thomsen
 *@version lab7
 */

public class BSTTests {
   /*@Test
   public void testBig() {
      BST<Integer> t = new BST<>();
      for (int i = 0; i < 10000;i++) {
         t.insert(i);   
      }
   }*/
   @Test
   public void testLong() {
      BST<Integer> t = new BST<>();
      ArrayList<Integer> a = new ArrayList<>();//test list
      ArrayList<Integer> A = new ArrayList<>();
      assertEquals(0, t.size());
      
      final int SIZE = 1000;
      
      for (int i = 0;i < SIZE;i++) {

         //first insert
         t.insert(SIZE-1-i);
         assertEquals(i*2+1, t.size());
         assertEquals(SIZE-1-i, (int)t.minimum());
         assertEquals(SIZE-1+i, (int)t.maximum());


         a.add(0,SIZE-1-i);//update test list
         //test vs testList
         t.toSortedList(A);
         assertArrayEquals(a.toArray(), A.toArray());
         A = new ArrayList<>();


         //second insert
         t.insert(SIZE+i);
         assertEquals(i*2+2, t.size());
         assertEquals(SIZE-1-i, (int)t.minimum());
         assertEquals(SIZE+i, (int)t.maximum());

         a.add(SIZE+i);//update test list
         //test vs testList
         t.toSortedList(A);
         assertArrayEquals(a.toArray(), A.toArray());
         A = new ArrayList<>();
      }
      for (int i = 0; i < 2*SIZE-1; i++) {
         assertEquals(true, t.contains(i));
      }
      assertEquals(false, t.contains(-1));
      assertEquals(false, t.contains(SIZE*2));
   }

   //error tests + 0 cases
   @Test(expected=NoSuchElementException.class)
   public void testMin0() {
      BST<Integer> t = new BST<>();
      assertEquals(0, t.size());
      t.minimum();
   }
   @Test(expected=NoSuchElementException.class)
   public void testMax0() {
      BST<Integer> t = new BST<>();
      assertEquals(0, t.size());
      t.maximum();
   }
   @Test(expected=IllegalArgumentException.class)
   public void testInsert0() {
      BST<Integer> t = new BST<>();
      assertEquals(0, t.size());
      t.insert(null);
   }

   //test insert
   @Test
   public void testInsert1() {
      BST<Integer> t = new BST<>();
      assertEquals(0, t.size());
      t.insert(1);
      assertEquals(1, t.size());
      t.insert(1);
      assertEquals(1, t.size());
      t.insert(5);
      assertEquals(2, t.size());

   }

   //conatins
   @Test
   public void testContains0() {
      BST<Integer> t = new BST<>();
      assertEquals(0, t.size());
      assertEquals(false, t.contains(null));
      assertEquals(false, t.contains(1));
   }
   @Test
   public void testContains1() {
      BST<Integer> t = new BST<>();
      assertEquals(0, t.size());
      t.insert(1);
      assertEquals(true, t.contains(1));
      assertEquals(false, t.contains(0));
      t.insert(0);
      assertEquals(2, t.size());
      assertEquals(true, t.contains(1));
      assertEquals(true, t.contains(0));
   }



}
