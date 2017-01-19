import org.junit.*;
import static org.junit.Assert.*;

/* PrimeToolsTests
 *
 * @author John Thomsen
 * @version lab9
 */

public class PrimeToolsTests {
   static int limit = 100000;
   static boolean[] sieve = new boolean[limit];
   
   @BeforeClass
   public static void setUp() throws Exception {
      
      for (int x = 1; x*x < limit; x++) {
         for (int y = 1; y*y < limit; y++) {
            
            // Main part of Sieve of Atkin
            int n = (4*x*x)+(y*y);
            if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
               sieve[n] ^= true;
            }

            n = (3*x*x)+(y*y);
            if (n <= limit && n % 12 == 7) {
               sieve[n] ^= true;
            }

            n = (3*x*x)-(y*y);
            if (x > y && n <= limit && n % 12 == 11) {
               sieve[n] ^= true;
            }

         }
      }

      // Mark all multiples of squares as non-prime
      for (int r = 5; r*r < limit; r++) {
         if (sieve[r]) {
            for (int i = r*r; i < limit; i += r*r) {
               sieve[i] = false;
            }
         }
      }

      sieve[2] = true;
      sieve[3] = true;
   }
   
   @Test
   public void testPrime() {
      for (int i = 0; i < limit; i++) {
         assertEquals("Fail at Number:"+i,sieve[i], PrimeTools.isPrime(i));
      }
   }

   @Test
   public void testNextPrime() {
      for (int i = 0; i < 10000; i++) {
         int j = i;   
         while (!sieve[j]) {
            j++;
         }
         assertEquals(j, PrimeTools.nextPrime(i));
      }
   }
}
