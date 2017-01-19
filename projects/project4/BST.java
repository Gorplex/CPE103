import java.util.*;
import java.lang.*;

/**
 * Provided BST class skeleton for students to complete. This class makes use
 * of Object Oriented structural recursion to solve the problem.
 *
 * Original Revision:
 * @author Hatalsky/Jones
 * @version Project 4
 *
 * Completed By:
 * @author John Thomsen!
 */
public class BST<T extends Comparable<? super T>> implements Iterable<T>{
   // Instance variables for BST class.
   // These are the only ones allowed!
   private final BSTNode<T> EMPTY_NODE = new EmptyNode();
   private BSTNode<T> root = EMPTY_NODE;
   private int size;

   // Polymorphic BST node type!
   private interface BSTNode<T> {
      BSTNode<T> insert(T element);
      boolean contains(T element);
      T minimum(T minimum);
      T maximum(T maximum);
      void toSortedList(List<T> list);
      BSTNode<T> remove(T element);
      int treeHeight();
      long internalPathLength(long depth);
      T get(T element);
   }

   ////////////////////////////////////////////////////////////////////////////
   // BST class methods...
   //

   /**
    * Inserts an element into the BST.  If the element is already in the BST,
    * the element being inserted is discarded.
    *
    * @param element The element to insert into the BST
    *
    * @throws IllegalArgumentException if the element is null
    */
   public void insert(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }

      root = root.insert(element);
   }

   /**
    * Determines whether or not an element is in the BST.
    *
    * @param element the element to search for in the BST
    *
    * @return true if the element is in the BST, false otherwise
    */
   public boolean contains(T element) {
      if (element == null) {
         return false;
      }

      return root.contains(element);
   }

   /**
    * Finds the minimum element in the BST.
    *
    * @return the minimum element in the BST
    *     
    * @throws NoSuchElementException if the BST is empty
    */
   public T minimum() {
      if (size == 0) {
         throw new NoSuchElementException();
      }

      return root.minimum(((Node)root).element);
   }

   /**
    * Finds the maximum element in the BST.
    *
    * @return the maximum element in the BST
    *
    * @throws NoSuchElementException if the BST is empty
    */
   public T maximum() {
      if (size == 0) {
         throw new NoSuchElementException();
      }

      return root.maximum(((Node)root).element);
   }

   /**
    * Takes the elements in the BST and places them in ascending order into the
    * list.
    *
    * @param list the list in which you will place elements
    */
   public void toSortedList(List<T> list) {
      root.toSortedList(list);
   }

   public int size() {
      return size;
   }

   /**
    * Removes a specifyed element
    *
    * @param T element to remove
    *
    * @throws NoSuchElementException if empty
    */
   public void remove(T element) { 
      root = root.remove(element);
      size--;
   }

   /**
    * Tree height
    * 
    * @return tree height -1 if empty
    */
   public int treeHeight() {
      return root.treeHeight();
   }

   /**
    * Internal Path Length
    *
    * @return internal path length -1 if empty
    */
   public long internalPathLength() {
      if (size == 0) {return -1;}
      return root.internalPathLength(0);
      //insainity that works AND you dont need the check
      //return root.internalPathLength(0)+size+Math.min(1,size);
   }
   
   /**
    * Returns an iterator for an in-order traversal of this BST. 
    *
    * @return an iterator for an in-order traversal of this BST
    */
   public Iterator<T> iterator() {
      return new BSTIterator();
   }

   /**
    * Returns the specified element in this BST. More formally, gets an element e such that element.compareTo(e) == 0, if this BST contains such an element.
    *
    * @return the specified element in this BST, if present
    * 
    * @throws NoSuchElementException – if the specified element is not in this BST
    */
   public T get(T element) {
      return root.get(element);  
   }

   ////////////////////////////////////////////////////////////////////////////
   // private Iterator class...
   //
   private class BSTIterator implements Iterator<T> {
      private SimpleArrayStack<Node> s;
      public BSTIterator() {
         s = new SimpleArrayStack<>();
         BSTNode<T> n = root;
         while (n != EMPTY_NODE) {
            s.push((Node)n);
            n = s.peek().left;
         }
      }
      public boolean hasNext() {
         return s.size() != 0;
      }
      public T next() {
         if (s.size() <= 0) {throw new NoSuchElementException();}
         Node out = s.pop();
         BSTNode<T> n = out.right;
         while (n != EMPTY_NODE) {
            s.push((Node)n);
            n = s.peek().left;
         }
         return out.element;
      }
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
   ////////////////////////////////////////////////////////////////////////////
   // private EmptyNode class...
   //
   private class EmptyNode implements BSTNode<T> {
      // No instance variables needed or allowed!

      public BSTNode<T> insert(T element) {
         size++;
         return new Node(element);
      }

      public boolean contains(T element) {
         return false;
      }

      public T minimum(T element) {
         return element;
      }

      public T maximum(T element) {
         return element;
      }

      public void toSortedList(List<T> list) {
         //DO NOTHING
         //ITS NOT NODES ALL THE WAY DOWN
      }
      
      public BSTNode<T> remove(T element) {
         throw new NoSuchElementException();
      }

      public int treeHeight() {
         return -1;
      }

      public long internalPathLength(long depth) {
         return 0;
         //if you feel like being crazy
         //return -1;
      }
      public T get(T element) {
         throw new NoSuchElementException();
      }
   }

   ////////////////////////////////////////////////////////////////////////////
   // private Node class...
   //
   private class Node implements BSTNode<T> {
      // These are the only instance variables needed and the only ones
      // allowed!
      T element;
      BSTNode<T> left, right;

      // You may (and probably want to) write constructor(s)
      public Node(T element) {
         this.element = element;
         this.left = EMPTY_NODE;
         this.right = EMPTY_NODE;
      }

      public BSTNode<T> insert(T element) {
         //System.out.println("size: " + size + " element: " + this.element);
         if (element.compareTo(this.element) < 0 ) {
            left = left.insert(element);
         }else if (element.compareTo(this.element) > 0 ) {
            right = right.insert(element);
         }else{
            //do nothing
            //if you wanted to overwrite
            //this.element = element;              
         }
         return this;
      }

      public boolean contains(T element) {
         if (element.compareTo(this.element) < 0 ) {
            return left.contains(element);
         }else if (element.compareTo(this.element) > 0 ) {
            return right.contains(element);
         }else{
            return true;
         }
      }

      public T minimum(T element) {
         return left.minimum(this.element);
      }

      public T maximum(T element) {
         return right.maximum(this.element);
      }

      public void toSortedList(List<T> list) {
         left.toSortedList(list);
         list.add(this.element);
         right.toSortedList(list);
      }
      
      public BSTNode<T> remove(T element) {
         if (this.element.compareTo(element) == 0) {
            //System.out.println(size);
            //base case (found it)
            if (left == EMPTY_NODE) {
               if (right == EMPTY_NODE) {
                  return EMPTY_NODE;//no childs
               }else{
                  return right;//just right
               }
            //left exists check right
            } else if (right == EMPTY_NODE) {
               return left;//just left
            }else{
               //change this node to smallest in right tree
               this.element = right.minimum(this.element);
               //remove the coppied element
               right = right.remove(this.element);
            }
         //recursion
         }else if (this.element.compareTo(element) > 0) {
            left = left.remove(element);//go left
         }else{
            right = right.remove(element);//go right
         }
         return this;
      }

      public int treeHeight() {
         return 1+Math.max(left.treeHeight(), right.treeHeight());
         /*int l = left.treeHeight();
         int r = right.treeHeight();
         if (l >= r) {
            return l+1;
         }else{
            return r+1;
         }*/
      }

      public long internalPathLength(long depth) {
         return left.internalPathLength(depth+1) + depth + right.internalPathLength(depth+1);
      }
      
      public T get(T element) {
         if (element.compareTo(this.element) < 0 ) {
            return left.get(element);
         }else if (element.compareTo(this.element) > 0 ) {
            return right.get(element);
         }else{
            return this.element;
         }
      }
   }
}

