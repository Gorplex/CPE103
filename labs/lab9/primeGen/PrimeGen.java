import java.util.*;
import java.io.*;
/* generates txt file with list of primes
 * sieve-of-atkin algorithm
 * @author John Thomsen
 */

public class PrimeGen {
   public static void main(String args[]) {
      long t0 = System.nanoTime();

      int limit = 100000000;
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
      
      // Print primes using sieve[]
      int n = 0;
      for (int i = limit-1; i >= 0 && n < 10; i--) {
         if (sieve[i]) {
            System.out.println(i);
            n++;
         }
      }
      System.out.println("Time(ns): "+(System.nanoTime()-t0));
   }
}
