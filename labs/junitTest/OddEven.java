/**
 * A simple class to demonstrate testing with JUnit.  Note that it contains a
 * bug to show how JUnit reports failures.
 *
 * @author Brian Jones
 * @version 17 September 2016
 */
public class OddEven {
   private int value;

   public OddEven(int value) {
      this.value = value;
   }

   public boolean odd() {
      return this.value % 2 == 1 || this.value % 2 == -1;
   }

   public boolean even() {
      return !this.odd();
   }
}
