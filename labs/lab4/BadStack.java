import java.util.*;

/*SimpleStack
 *
 *@author John Thomsen
 *@version lab3
 */

public class BadStack<T> implements SimpleStack<T> {
   private T[] arr;
   private int size;

   @SuppressWarnings("unchecked")
   public BadStack() {
      arr = (T[]) new Object[10];
      size = 0;
   }
   
   public T peek() {
      if (size == 0) {throw new NoSuchElementException();}
      return arr[0];
   }

   public T pop() {
      if (size == 0) {throw new NoSuchElementException();}
      T out = arr[0];
      size--;
      for (int i = 0; i < size; i++) {
         arr[i] = arr[i+1];  
      }
      return out;
   }
   
   @SuppressWarnings("unchecked")
   public void push(T element) {
      if (size >= arr.length) {
         T[] newArr = (T[]) new Object[arr.length*2];
         System.arraycopy(arr, 0, newArr, 0, arr.length);
         arr = newArr;
      }
      for (int i = size; i > 0;i--) {
         arr[i] = arr[i-1];
      }
      arr[0] = element;
      size++;
   }

   public int size() {
      return size;
   }

   public int capacity() {
      return arr.length;
   }



}
