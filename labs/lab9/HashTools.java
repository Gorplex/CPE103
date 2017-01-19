import java.util.*;
/* HashTools
 *
 * @author John Thomsen
 * @version lab9
 */

public class HashTools {
   public static <T> int collisions(List<T> list, int tableSize, Hashable<T> hashable) {
      int size = PrimeTools.nextPrime(tableSize);
      int collisions = 0;
      boolean[] collide = new boolean[size];
      for (T ele: list) {
         int hash = Math.abs(hashable.hash(ele))%size;
         if(collide[hash]) {
            collisions++;   
         }else{
            collide[hash] = true;
         }
      }
      return collisions;
   }

   public static <T> int maxCollisions(List<T> list, int tableSize, Hashable<T> hashable) {
      int size = PrimeTools.nextPrime(tableSize);
      int max = 0;
      int[] collisions = new int[size];
      for (T ele: list) {
         int hash = Math.abs(hashable.hash(ele))%size;
         collisions[hash]++;
         if (collisions[hash] > max) {
            max = collisions[hash];
         }
      }
      return max;
   }
   public static <T> double avgCollisions(List<T> list, int tableSize, Hashable<T> hashable) {
      int size = PrimeTools.nextPrime(tableSize);
      int elements = 0;
      int cellsUsed = 0;
      boolean[] collide = new boolean[size];
      for (T ele: list) {
         elements++;
         int hash = Math.abs(hashable.hash(ele))%size;
         if(!collide[hash]) {
            cellsUsed++;   
            collide[hash] = true;
         }
      }
      return ((double)elements)/cellsUsed;
   }
   public static <T> int unused(List<T> list, int tableSize, Hashable<T> hashable) {
      int size = PrimeTools.nextPrime(tableSize);
      int empty = size;
      boolean[] isEle = new boolean[size];
      for (T ele: list) {
         int hash = Math.abs(hashable.hash(ele))%size;
         if (!isEle[hash]) {
            empty--;
            isEle[hash] = true;
         }
      }
      return empty;
   }
}
