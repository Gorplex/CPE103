import java.util.*;
/* PrimeTools
 *
 * @version lab9
 */

public class PrimeTools {
   public static boolean isPrime(int value) {
      if (value <= 1) {return false;}
      if (value == 2 || value == 3 || value == 5) {return true;}
      if (value%2 == 0 || value%3 == 0 || value%5 == 0) {return false;}
      int max = (int)Math.sqrt(value)+1;
      for (int i = 3; i < max; i+=2) {
         if (value%i == 0){return false;}
      }
      return true;
   }
   public static int nextPrime(int value) {
      if (value < 0) {throw new IllegalArgumentException();}
      //never need to throw max int IS prime
      //if (true) {throw new NoSuchElementException();}
      
      while (!isPrime(value)) {
         value++;
      }
      return value;   
   }
}
