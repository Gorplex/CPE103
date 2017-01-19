import org.junit.*;
import static org.junit.Assert.*;

public class ListWorkTest {
   
   @Test 
   public void test1() {
      Integer nul = null;
      Integer[] arr = {new Integer(1), nul};
      assertTrue(ListWork.search(arr, new Integer(1)));
   }

   @Test 
   public void test2() {
      Integer nul = null;
      Integer[] arr = {new Integer(1), nul};
      assertTrue(ListWork.search(arr, nul));
   }

  @Test 
   public void test3() {
      Integer nul = null;
      Integer[] arr = {new Integer(1), nul};
      assertFalse(ListWork.search(arr, new Integer(2)));
   }

   @Test 
   public void test4() {
      Integer nul = null;
      Integer[] arr = {new Integer(1), new Integer(2)};
      assertFalse(ListWork.search(arr, nul));
   }
}
