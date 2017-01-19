import java.util.*;
/* PrimeToolsFast
 *
 * @version lab9
 */

public class PrimeToolsFast {
   int limit = 100000000;
   int[] primes = new int[limit];
   int primeSize = 0;

   public PrimeToolsFast () {
      boolean[] sieve = new boolean[limit];
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
      
      // add primes to list using sieve[]
      for (int i = 0; i < limit; i++) {
         if (sieve[i]) {
            primes[primeSize] = i;
            primeSize++;
         }
      }
   }
   
   public static boolean isPrime(int value) {
      if (value == 1) {return false;}
      if (value == 2 || value == 3 || value == 5) {return true;}
      if (value%2 == 0 || value%3 == 0 || value%5 == 0) {return false;}
      for (int i = 3; i < value; i+=2) {
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
