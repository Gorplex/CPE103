import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

/*lab8 tests
 *@author John Thomsen
 *@version lab8
 */

public class BSTTests {
   @Test
   public void testRand() {
      /** TIME REQUIREMENTS GET VERRY LARGE VERRY FAST */
      final int POWER = 6; //2^POWER-1 ele added removed and checked
      BST<Integer> t = new BST<>();
      assertEquals(0, t.size());
      assertEquals(-1, t.treeHeight());
      assertEquals(-1, t.internalPathLength());
      
      addStuff(t, (int)Math.pow(2, POWER-1), (int)Math.pow(2, POWER-1)/2);
      
      assertEquals((int)(Math.pow(2, POWER)-1), t.size());
      assertEquals(POWER-1, t.treeHeight());
      //assertEquals(fact(t.treeHeight()+1), t.internalPathLength());
      //FIND BETTER MODEL 4 PATH GROWTH RATE

      rmStuff(t, (int)Math.pow(2, POWER-1), (int)Math.pow(2, POWER-1)/2);
      
      assertEquals(0, t.size());
      assertEquals(-1, t.treeHeight());
      assertEquals(-1, t.internalPathLength());
      
   }
   //java is going to make me write a recursive factorial method...
   private long fact(long x) {
      if (x == 1) {
         return 1;
      } else {
         return x * fact(x-1);
      }
   }
   //not elegant but it F***ing works
   private void addStuff(BST<Integer> t, int num, int d) {
      if (num%2 == 1) {
         t.insert(num);
      } else {
         t.insert(num);
         addStuff(t, num-d, d/2);
         addStuff(t, num+d, d/2);
      }
   }
   private void rmStuff(BST<Integer> t, int num, int d) {
      if (num%2 == 1) {
         t.remove(num);
      } else {
         t.remove(num);
         rmStuff(t, num-d, d/2);
         rmStuff(t, num+d, d/2);
      }
   }

   @Test
   public void testRemoveAllCase() {
      //damn hardcoded testsi
      //making me draw a tree...
      BST<Integer> t = new BST<>();
      assertEquals(0, t.size());
      assertEquals(-1, t.treeHeight());
      assertEquals(-1, t.internalPathLength());
      //no child
      t.insert(0);
      t.remove(0);
      assertEquals(0, t.size());
      assertEquals(-1, t.treeHeight());
      assertEquals(-1, t.internalPathLength());
      //r child
      t.insert(0);
      t.insert(1);
      t.remove(0);
      assertEquals(1, t.size());
      assertEquals(0, t.treeHeight());
      assertEquals(0, t.internalPathLength());
      //l child
      t.insert(0);
      t.remove(1);
      assertEquals(1, t.size());
      assertEquals(0, t.treeHeight());
      assertEquals(0, t.internalPathLength());
      //2 child
      t.insert(-1);
      t.insert(1);
      t.remove(0);
      assertEquals(2, t.size());
      assertEquals(1, t.treeHeight());
      assertEquals(1, t.internalPathLength());
      //2 child with 2 child
      t.insert(4);
      t.insert(2);
      t.insert(3);
      t.insert(5);
      assertEquals(6, t.size());
      assertEquals(3, t.treeHeight());
      assertEquals(9, t.internalPathLength());
      t.remove(1);//remove root --> get+remove 2
      assertEquals(5, t.size());
      assertEquals(2, t.treeHeight());
      assertEquals(6, t.internalPathLength());
   }

   @Test
   public void testLong() {
      BST<Integer> t = new BST<>();
      ArrayList<Integer> a = new ArrayList<>();//test list
      ArrayList<Integer> A = new ArrayList<>();
      assertEquals(0, t.size());
      assertEquals(-1, t.treeHeight());
      assertEquals(-1, t.internalPathLength());
      
      final int SIZE = 1000;
     
      int pathLength = 0;//var for tracking tree length
      for (int i = 0;i < SIZE;i++) {

         //first insert
         t.insert(SIZE-1-i);
         assertEquals(i*2+1, t.size());
         assertEquals(SIZE-1-i, (int)t.minimum());
         assertEquals(SIZE-1+i, (int)t.maximum());

         //test vs testList
         a.add(0,SIZE-1-i);//update test list
         t.toSortedList(A);
         assertArrayEquals(a.toArray(), A.toArray());
         A = new ArrayList<>();

         //lab 8
         assertEquals((i*2+1)/2, t.treeHeight());
         pathLength += t.treeHeight();//update tree length
         assertEquals("first one", pathLength, t.internalPathLength());
         
         
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
         
         //lab 8
         assertEquals((i*2+2)/2, t.treeHeight());
         pathLength += t.treeHeight();//update tree length
         assertEquals("second one", pathLength, t.internalPathLength());
         
      }
      for (int i = 0; i < 2*SIZE-1; i++) {
         assertEquals(true, t.contains(i));
      }
      assertEquals(false, t.contains(-1));
      assertEquals(false, t.contains(SIZE*2));

      //LAB 8 REMOVE PART
      for (int i = SIZE-1; i >= 0; i--) {
         //first insert
         t.remove(i*2);
         assertEquals(i*2+1, t.size());
         
         //second insert
         t.remove(i*2+1);
         assertEquals(i*2, t.size());
      }
      t.toSortedList(A);
      a = new ArrayList<>();
      assertArrayEquals(a.toArray(), A.toArray());
      assertEquals(0, t.size());
      assertEquals(-1, t.treeHeight());
      assertEquals(-1, t.internalPathLength());
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
   @Test(expected=NoSuchElementException.class)
   public void testRemove0() {
      BST<Integer> t = new BST<>();
      t.remove(1);
   }
   @Test
   public void testTreePath0() {
      BST<Integer> t = new BST<>();
      assertEquals(-1, t.treeHeight());
      assertEquals(-1, t.internalPathLength());
   }
   @Test
   public void testTreePath1() {
      BST<Integer> t = new BST<>();
      t.insert(0);
      assertEquals(0, t.treeHeight());
      assertEquals(0, t.internalPathLength());
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
