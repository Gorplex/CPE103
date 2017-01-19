
/* QuadraticSorts
 *
 * @author John Thomsen
 * @version lab10
 */

public class QuadraticSorts {
   public static <T extends Comparable<? super T>> void bubbleSort1(T[] array) {
      boolean swap = true;
      while (swap) {
         swap = false;
         for (int i = 1; i < array.length; i++ ) {
            if (array[i].compareTo(array[i-1]) < 0) {
               T ele = array[i];
               array[i] = array[i-1];
               array[i-1] = ele;
               swap = true;
            }
         }
      }
   }
   public static <T extends Comparable<? super T>> void bubbleSort2(T[] array) {
      int len = array.length;
      boolean swap = true;
      while (swap) {
         swap = false;
         for (int i = 1; i < len; i++ ) {
            if (array[i].compareTo(array[i-1]) < 0) {
               T ele = array[i];
               array[i] = array[i-1];
               array[i-1] = ele;
               swap = true;
            }
         }
         len--;
      }
   }
   public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
      for (int i = 0; i < array.length; i++) {
         int min = i;
         for (int j = i+1; j < array.length; j++ ) {
            if (array[j].compareTo(array[min]) < 0) {
               min = j;
            }
         }
         T ele = array[i];
         array[i] = array[min];
         array[min] = ele;
      }
   }
   public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
      for (int i = 1; i < array.length; i++) {
         T ele = array[i];
         int j = i;
         while (j > 0 && ele.compareTo(array[j-1]) < 0) {
            array[j] = array[j-1];
            j--;
         }
         array[j] = ele;
      }
   }
}
