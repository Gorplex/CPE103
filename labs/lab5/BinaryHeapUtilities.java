import java.lang.*;
import java.util.*;
/*
 *
 *@author John Thomsen
 *@version lab5
 */

public class BinaryHeapUtilities {
   public static int height(int size) {
      if (size <= 0) {throw new IllegalArgumentException();}
      return (int)Math.floor(Math.log(size)/Math.log(2));
   }
   
   public static <T extends Comparable<? super T>> boolean isHeap(T[] heap, int size) {
      if (size == 0) {return false;}
      if (heap.length <= size) {return false;}
      for (int i = 2; i <= size;i++) {
         if (0 > heap[i].compareTo(heap[i/2])) {
            return false;
         }
      }
      return true;        
   }
   
   public static <T extends Comparable<? super T>> T parentOf(int index, T[] heap, int size) {
      if (index <= 0 || index > size) {throw new IndexOutOfBoundsException();} 
      if (index == 1) {throw new NoSuchElementException();} 
      if (!isHeap(heap, size)) {throw new IllegalArgumentException();}
      return heap[index/2]; 
   }
   
   public static <T extends Comparable<? super T>> T leftChildOf(int index, T[] heap, int size) {
      if (index <= 0 || index > size) {throw new IndexOutOfBoundsException();} 
      int indexOut = 2*index;
      if (indexOut > size) {throw new NoSuchElementException();}
      if (!isHeap(heap, size)) {throw new IllegalArgumentException();}
      return heap[indexOut];
   }
   
   public static <T extends Comparable<? super T>> T rightChildOf(int index, T[] heap, int size) {
      if (index <= 0 || index > size) {throw new IndexOutOfBoundsException();} 
      int indexOut = 2*index+1;
      if (indexOut > size) {throw new NoSuchElementException();}
      if (!isHeap(heap, size)) {throw new IllegalArgumentException();}
      return heap[indexOut];
   }
}
