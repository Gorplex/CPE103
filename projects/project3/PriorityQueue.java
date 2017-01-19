import java.util.*;
import java.lang.*;
/* PriorityQueue (heap based)
 *
 *@author John Thomsen
 *
 *@version project 3
 */

public class PriorityQueue<T extends Comparable<? super T>> implements SimpleQueue<T> {
   private ArrayList<T> arr;
   private boolean isMax;
   
   public PriorityQueue() {
      this(false);
   }
   public PriorityQueue(boolean isMax) {
      arr = new ArrayList<>();
      arr.add(null);
      this.isMax = isMax;
   }
   public PriorityQueue(T[] arr, int size) {
      this(arr, size, false);
   }
   public PriorityQueue(T[] arr, int size, boolean isMax) {
      this(isMax);
      for (int i = 0; i < size; i++) {
         enqueue(arr[i]);
      }
   }

   public T dequeue() {
      if (arr.size() < 2) {throw new NoSuchElementException();}
      T out = arr.get(1);

      if (arr.size() == 2) {
         arr.remove(arr.size()-1);
      }else if (isMax) {
         percDownMax(1, arr.remove(arr.size()-1));
      }else{
         percDown(1, arr.remove(arr.size()-1));
      }
      return out;
   }

   private void percDown(int index, T e) {
      //find index of higherChild (0 if no childern)
       int higherChild;
      if (2*index > arr.size()-1) {
         higherChild = 0;
      }else if (2*index + 1 > arr.size()-1 || arr.get(2*index).compareTo(arr.get(2*index+1)) < 0 ) {
         higherChild = 2*index;
      }else{
         higherChild = 2*index+1;
      }

      //comp to higherChild
      if (higherChild == 0 || arr.get(higherChild).compareTo(e) >= 0) {
         //base case
         arr.set(index, e);
      }else{
         //swap
         arr.set(index, arr.get(higherChild));
         percDown(higherChild, e);
      }
   }
   
   private void percDownMax(int index, T e) {
      //find index of higherChild (0 if no childern)
      int higherChild;
      if (2*index > arr.size()-1) {
         higherChild = 0;
      } else if (2*index + 1 > arr.size()-1 || arr.get(2*index).compareTo(arr.get(2*index+1)) > 0 ) {
         higherChild = 2*index;
      }else {
         higherChild = 2*index+1;
      }
      
      //comp to higherChild
      if (higherChild == 0 || arr.get(higherChild).compareTo(e) <= 0) {
         //base case
         arr.set(index, e);
      }else{
         //swap
         arr.set(index, arr.get(higherChild));
         percDownMax(higherChild, e);
      }
   }

   public void enqueue(T element) {
      int index = arr.size();
      arr.add(null);
      if (isMax) {
         percUpMax(index, element);
         //while (index/2 >= 1 && arr.get(index/2).compareTo(element) < 0) {
         //   arr.set(index, arr.get(index/2));
         //   index /= 2;
         //}
         //arr.set(index, element);
         //System.out.println(arr);
      }else{
         //percUp(index, element);
         while (index/2 >= 1 && arr.get(index/2).compareTo(element) > 0) {
            arr.set(index, arr.get(index/2));
            index /= 2;
         }
         arr.set(index, element);
         //System.out.println(arr);
      }
   }
   
   private void percUp(int index, T e) {
      //base case
      if (index <= 1 || arr.get(index/2).compareTo(e) <= 0) {
         arr.set(index, e);
      }else{
         arr.set(index, arr.get(index/2));
         percUp(index/2, e);
      }
   }
   
   private void percUpMax(int index, T e) {
      //base case
      if (index <= 1 || arr.get(index/2).compareTo(e) >= 0) {
         arr.set(index, e);
      }else{
         arr.set(index, arr.get(index/2));
         percUpMax(index/2, e);
      }
   }

   public T peek() {
      if (arr.size() < 2) {throw new NoSuchElementException();}
      return arr.get(1);
   }

   public int size() {
      return arr.size() -1;
   }

   public static <E extends Comparable<? super E>> void sort(E[] arr, int size) {
      if (size > arr.length) {throw new IllegalArgumentException();}
      PriorityQueue<E> q = new PriorityQueue<>(arr, size);
      for (int i = 0; i < size; i++) {
         arr[i] = q.dequeue(); 
      }
   }

   public static <E extends Comparable<? super E>> E kth(E[] arr, int size, int k) {
      if (size > arr.length || k > size) {throw new IllegalArgumentException();}
      int qSize = size-k+1;
      if (k <= size-k+1) {
         PriorityQueue<E> q = new PriorityQueue<>();
         for (int i = 0; i < k; i++){
            q.enqueue(arr[i]);
         }
         for (int i = k; i < size; i++) {
            if (arr[i].compareTo(q.peek()) > 0) {
               q.dequeue();
               q.enqueue(arr[i]);
            }
         }
         return q.dequeue();
      }else{
         PriorityQueue<E> q = new PriorityQueue<>(true);
         int k2 = size-k+1;
         for (int i = 0; i < k2; i++){
            q.enqueue(arr[i]);
         }
         for (int i = k2; i < size; i++) {
            if (arr[i].compareTo(q.peek()) < 0) {
               q.dequeue();
               q.enqueue(arr[i]);
            }
         }
         return q.dequeue();
      }
   }
}
