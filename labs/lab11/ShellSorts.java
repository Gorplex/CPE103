
/* ShellSorts
 * @author John Thomsen
 * @version lab11
 */

public class ShellSorts {
   public static <T extends Comparable<? super T>> void shell(T[] array) {
      int[] gaps = {128, 64, 32, 16, 8, 4, 2, 1};
      for (int gap : gaps) {
         for (int i = gap; i < array.length; i++) {
            T temp = array[i];
            int j;
            for (j = i; j >= gap && array[j - gap].compareTo(temp) > 0; j -= gap) {
               array[j] = array[j-gap];
            }
            array[j] = temp;
         }
      }
   }
   public static <T extends Comparable<? super T>> void hibbard(T[] array) {
      int[] gaps = {255, 127, 63, 31, 15, 7, 3, 1};
      for (int gap : gaps) {
         for (int i = gap; i < array.length; i++) {
            T temp = array[i];
            int j;
            for (j = i; j >= gap && array[j - gap].compareTo(temp) > 0; j -= gap) {
               array[j] = array[j-gap];
            }
            array[j] = temp;
         }
      }
   }
   public static <T extends Comparable<? super T>> void sedgewick(T[] array) {
      int[] gaps = {16577, 4193, 1073, 281, 77, 23, 8, 1};
      for (int gap : gaps) {
         for (int i = gap; i < array.length; i++) {
            T temp = array[i];
            int j;
            for (j = i; j >= gap && array[j - gap].compareTo(temp) > 0; j -= gap) {
               array[j] = array[j-gap];
            }
            array[j] = temp;
         }
      }
   }
   public static <T extends Comparable<? super T>> void heapSort(T[] array) {
     PriorityQueue.sort(array, array.length); 
   }
}
