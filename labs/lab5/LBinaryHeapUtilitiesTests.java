/**
 * JUnit tests for 
 *
 * @author  and Luke Thompson
 * @version Lab 5
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LBinaryHeapUtilitiesTests {

   /******************************************

   HEIGHT

   *********************************************/
   @Test
   public void test101_height_3() {
   
      assertEquals(1, BinaryHeapUtilities.height(3) );
   }
   @Test
   public void test102_height_BigNumber() {
   
      assertEquals(26, BinaryHeapUtilities.height(123456789) );
   }

   
   @Test (expected=IllegalArgumentException.class)
   public void test103_height_Neg() {
   
      assertEquals(1, BinaryHeapUtilities.height(-3) );
   }

   /******************************************

   isHeap

   *********************************************/
   @Test
   public void test201_isHeap_True_small() {
   
      assertTrue(BinaryHeapUtilities.isHeap(new Integer[]{null, 1, 2,3} , 3) );
   }

   @Test
   public void test202_isHeap_False_small() {
   
      assertFalse(BinaryHeapUtilities.isHeap(new Integer[]{null, 2, 1,3} , 3) );
   }

   @Test
   public void test203_isHeap_False_Big() {
   
      assertFalse(BinaryHeapUtilities.isHeap(new Integer[]{null, 1, 1, 3, 5, 9, 23, 76478, 9, 4, 24} , 10) );
   }
   @Test
   public void test204_isHeap_True_Big() {
   
      assertTrue(BinaryHeapUtilities.isHeap(new Integer[]{null, 1, 1, 3, 5, 9, 23, 76478, 7, 9, 24} , 10) );
   }
   
   @Test
   public void test205_isHeap_True_Empty() {
   
      assertFalse(BinaryHeapUtilities.isHeap(new Integer[]{null} , 0) );
   }


   /******************************************

   parentOf

   *********************************************/
   @Test
   public void test301_parentOf_small_LeftChild() {
   
      assertEquals((Integer)1, BinaryHeapUtilities.parentOf(2,new Integer[]{null, 1, 2,3} , 3) );
   }
   @Test
   public void test302_parentOf_small_RightChild() {
   
      assertEquals((Integer)1, BinaryHeapUtilities.parentOf(2,new Integer[]{null, 1, 2,3} , 3) );
   }

   /**********    EXCEPTIONS     **********/
   @Test (expected=IndexOutOfBoundsException.class)
   public void test303_parentOf_small_IndexOutOFBounds() {
   
      assertEquals((Integer)1, BinaryHeapUtilities.parentOf(4,new Integer[]{null, 1, 2,3} , 3) );
   }
   @Test (expected=IndexOutOfBoundsException.class)
   public void test304_parentOf_small_NoSuchElement() {
   
      assertEquals((Integer)1, BinaryHeapUtilities.parentOf(4,new Integer[]{null, null, 2,3} , 3) );
   }
   @Test (expected=IndexOutOfBoundsException.class)
   public void test305_parentOf_small_IllegalArgument() {
   
      assertEquals((Integer)1, BinaryHeapUtilities.parentOf(4,new Integer[]{null, 3, 2,3} , 3) );
   }

   /******************************************

   leftChildOf

   *********************************************/

   @Test
   public void test401_leftChildOf_small_root() {
   
      assertEquals((Integer)2, BinaryHeapUtilities.leftChildOf(1,new Integer[]{null, 1, 2,3} , 3) );
   }
   
   @Test (expected=IndexOutOfBoundsException.class)
   public void test402_leftChildOf_small_outOfBounds() {
   
      BinaryHeapUtilities.leftChildOf(4,new Integer[]{null, 1, 2,3} , 3);
   }

   @Test (expected=NoSuchElementException.class)
   public void test403_leftChildOf_small_NoSuchElement() {
   
      BinaryHeapUtilities.leftChildOf(2,new Integer[]{null, 1, 2,3} , 3);
   }
   
   @Test (expected=IllegalArgumentException.class)
   public void test404_leftChildOf_small_IllegalHeap() {
   
      BinaryHeapUtilities.leftChildOf(1,new Integer[]{null, 3, 2,3} , 3);
   }

   @Test
   public void test405_leftChildOf_BigHeap() {
   
      assertEquals((Integer)7, BinaryHeapUtilities.leftChildOf(4,new Integer[]{null, 1, 1, 3, 5, 9, 23, 76478, 7, 9, 24} , 10) );
   }














   /******************************************

   rightChildOf

   *********************************************/

   @Test
   public void test501_rightChildOf_small_root() {
   
      assertEquals((Integer)3, BinaryHeapUtilities.rightChildOf(1,new Integer[]{null, 1, 2,3} , 3) );
   }
   
   @Test (expected=IndexOutOfBoundsException.class)
   public void test502_rightChildOf_small_outOfBounds() {
   
      BinaryHeapUtilities.rightChildOf(4,new Integer[]{null, 1, 2,3} , 3);
   }

   @Test (expected=NoSuchElementException.class)
   public void test503_rightChildOf_small_NoSuchElement() {
   
      BinaryHeapUtilities.rightChildOf(2,new Integer[]{null, 1, 2,3} , 3);
   }
   
   @Test (expected=IllegalArgumentException.class)
   public void test504_rightChildOf_small_IllegalHeap() {
   
      BinaryHeapUtilities.rightChildOf(1,new Integer[]{null, 3, 2,3} , 3);
   }

   @Test
   public void test505_rightChildOf_BigHeap() {
   
      assertEquals((Integer)9, BinaryHeapUtilities.rightChildOf(4,new Integer[]{null, 1, 1, 3, 5, 9, 23, 76478, 7, 9, 24} , 10) );
   }

   
   @Test (expected=NoSuchElementException.class)
   public void test506_rightChildOf_BigHeap_end() {
   
      BinaryHeapUtilities.rightChildOf(5,new Integer[]{null, 1, 1, 3, 5, 9, 23, 76478, 7, 9, 24} , 10);
   }










   
}
