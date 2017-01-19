/**
 * A simple JUnit test class to demonstrate how to write JUnit tests.
 *
 * @author Brian Jones
 * @version 17 September 2016
 */

/* This import allows us to use the @Test annotation, and others, without
 * needing to type out @org.junit.Test everywhere.
 */
import org.junit.*;

/* This static import allows us to call the static assertion methods without
 * needing to specify the Assert class.
 * e.g.
 *    assertTrue(1 + 1 == 2);
 * instead of
 *    Assert.assertTrue(1 + 1 == 2);
 */
import static org.junit.Assert.*;

/* It is common to name test classes with the same name as the class being
 * tested with the word Test or Tests appended to the end.  This way the class
 * and test class will appear next to each other in the file system.
 */
public class OddEvenTests {
   /* You annotate each JUnit test method with @Test (Be sure to see the
    * required import above.  Try to make each test simple and clear.  You
    * should write tests for one method or even part of the functionality of
    * one method.
    *
    * Use meaningful names, the name of the method being tested with the word
    * test prepended is a common pattern.
    */
   @Test public void testOdd_positiveEven() {
      OddEven ref = new OddEven(86);
      /* Test that the odd method returns the expected false.
       * Note: There are many more assert methods.  Be sure to read about them
       *       in the JUnit documentation.
       */
      assertFalse(ref.odd());
   }

   // Note that the @Test annotation can also go on the preceding line.
   @Test
   public void testOdd_positiveOdd() {
      assertTrue(new OddEven(125).odd());
   }

   @Test public void testOdd_negativeEven() {
      assertFalse(new OddEven(-62).odd());
   }

   @Test public void testOdd_negativeOdd() {
      assertTrue(new OddEven(-3).odd());
   }

   @Test public void testOdd_zero() {
      assertFalse(new OddEven(0).odd());
   }

   @Test public void testEven_positiveEven() {
      assertTrue(new OddEven(86).even());
   }

   @Test public void testEven_positiveOdd() {
      assertFalse(new OddEven(125).even());
   }

   @Test public void testEven_negativeEven() {
      assertTrue(new OddEven(-62).even());
   }

   @Test public void testEven_negativeOdd() {
      assertFalse(new OddEven(-3).even());
   }

   @Test public void testEven_zero() {
      assertTrue(new OddEven(0).even());
   }
}
