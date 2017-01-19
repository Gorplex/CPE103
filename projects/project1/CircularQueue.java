import java.util.*;
import java.lang.*;
import java.io.*;
/*
 *Circular array implementation of the SimpleQueue interface.
 *
 *@author John Thomsen
 *@version project1
 */

public class CircularQueue<T> implements SimpleQueue<T> {
   
   public static final int INITIAL_LENGTH = 10;
   
   private T[] arr;
   private int back;
   private int front;
   //private int size;
   
   public CircularQueue() {
      this(INITIAL_LENGTH);
   }
   
   @SuppressWarnings("unchecked")
   public CircularQueue(int initialCapacity) {
      if (initialCapacity <= 0) {throw new MyException();}
      arr = (T[]) (new Object[initialCapacity]);
      front = 0;
      back = 0;
      //size = 0;
   }

   //@SuppressWarnings("serial")
   static public class MyException extends RuntimeException implements Serializable {
      public MyException() { super(); }
      public MyException(String s) { super(s); }
   }

   public T dequeue() {
      if (back == front) {throw new NoSuchElementException();}else{
         //size--;
         T out = arr[front];
         //++ and loop if over max
         front = (front+1)%arr.length; 
         return out;
      }
   }

   public void enqueue(T element) {
      if (size() == arr.length-1) {
         doubSize();
      }
      //size++;
      arr[back] = element;
      //++ and loop if over max
      back = (back+1)%arr.length;
   }
  
   @SuppressWarnings("unchecked") 
   private void doubSize() {
      T[] newArr = (T[]) (new Object[arr.length*2]);
      int size = size();
      int newIndex = 0;
      for (int i = front; i < (back+arr.length); i++) {
         newArr[newIndex] = arr[i%arr.length];
         newIndex++;
      }
      front = 0;
      back = size;
      arr = newArr;
   }

   public T peek()
   {
      if (back == front) {throw new NoSuchElementException();}else{
         return arr[front];
      }
   }

   public int size() {
      return (arr.length+back-front)%arr.length;
   }

   public Object[]  unusualMethodForTestingPurposesOnly() {
      return arr;
   }
}
