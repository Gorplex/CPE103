import java.util.*;

/*SimpleStack
 *
 *@author John Thomsen
 *@version lab3
 */

public class SimpleArrayStack<T> implements SimpleStack<T> {
   private T[] arr;
   private int size;

   @SuppressWarnings("unchecked")
   public SimpleArrayStack() {
      arr = (T[]) new Object[10];
      size = 0;
   }
   
   public T peek() {
      if (size == 0) {throw new NoSuchElementException();}
      return arr[size-1];
   }

   public T pop() {
      if (size == 0) {throw new NoSuchElementException();}
      size--;
      return arr[size];
   }
   
   @SuppressWarnings("unchecked")
   public void push(T element) {
      if (size >= arr.length) {
         T[] newArr = (T[]) new Object[arr.length*2];
         System.arraycopy(arr, 0, newArr, 0, arr.length);
         arr = newArr;
      }
      arr[size] = element;
      size++;
   }

   public int size() {
      return size;
   }

   public int capacity() {
      return arr.length;
   }



}
