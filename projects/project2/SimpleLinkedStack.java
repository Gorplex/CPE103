import java.util.*;
/*Simple linked stack
 *
 *@author John Thomsen
 *@version project2
 */

public class SimpleLinkedStack<T> implements SimpleStack<T> {
   private Node head = new Node();
   private int size = 0;
   
   private class Node {
      T element;
      Node next;
      public Node() {}
      public Node(T element, Node next) {
         this.element = element;
         this.next = next;
      }
   }

   public SimpleLinkedStack() {}
   public T peek() {
      if (size() == 0) {throw new NoSuchElementException();}
      return head.element;
   }
   public T pop() {
      if (size() == 0) {throw new NoSuchElementException();}
      T out = head.element;
      head = head.next;
      size--;
      return out; 
   }
   public void push(T element) {
      head = new Node(element, head); 
      size++;
   }
   public int size() {
      return size;
   }
}
