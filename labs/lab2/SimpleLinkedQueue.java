import java.lang.*;
import java.util.*;
/* generic linked list implementation of simpleQueue
 *@author John Thomsen
 *@version lab2
 */

public class SimpleLinkedQueue<T> implements SimpleQueue<T> {
   private Node head = new Node();
   private Node tail = head;
   private int size = 0;

   //inner node class
   private class Node {
      public Node next;
      public T element;
      public Node() {
      element = null;
      }
      public Node(T ele) {
         element = ele;
      }
   }

   public T dequeue() {
      if (size <= 0) {
         throw new NoSuchElementException();
      } else {  
         size--;
         Node out = head.next;
         head = head.next;
         return out.element;
      }
   }

   public void enqueue(T element) {
      size++;
      tail.next = new Node(element);
      tail = tail.next;
   }
   
   public T peek() {
      if (size <= 0) {
         throw new NoSuchElementException();
      } else {  
         return head.next.element;
      }
   }

   public int size() {
      return size;
   }
}
