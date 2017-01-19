/**
 * MODIFIED TO FIT NEW LAB 6
 * @author John Thomsen
 * remove not returns type
 */


/**
 * Modified SimpleList interface from Lab 1 - notice that the remove method's
 * return type has changed to void to accommodate the recursive nature of the
 * lab!
 *
 * @author Brian Jones
 * @version 10/15/2016 CPE 103 Lab 6
 *
 * @param T the type of elements in this list
 */
public interface SimpleList<T> {
   /**
    * Appends the specified element to the end of this list.  Allows null
    * elements to be added to the list.
    *
    * @param element the element to be appended to this list
    */
   public void add(T element);

   /**
    * Inserts the specified index at the specified position in this list.
    * Shifts the element currently at that position (if any) and any subsequent
    * elements to the right (adds one to their indices).
    *
    * @param index the index at which the element is to be inserted
    * @param element the element to be inserted
    *
    * @throws IndexOutOfBoundsException if the index is less than zero or
    * greater than the {@code size()} of this list
    */
   public void add(int index, T element);

   /**
    * Returns the element at the specfied position in this list.
    *
    * @param index the index of the element to return
    *
    * @return the element at the specified position in this list
    *
    * @throws IndexOutOfBoundsException if the index is less than zero or
    * greater than or equal to the {@code size()} of this list
    */
   public T get(int index);

   /**
    * Removes the element at the specified position in this list.  Shifts any
    * subsequent elements to the left (subtracts one from their indices).
    *
    * @param index the index of the element to be removed
    *
    * @throws IndexOutOfBoundsException if the index is less than zero or
    * greater than or equal to the {@code size()} of this list
    */
   public T remove(int index);

   /**
    * Returns the number of elements in this list.
    *
    * @return the number of elements in this list
    */
   public int size();
}
