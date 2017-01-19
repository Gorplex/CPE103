/* A simplified Hash Table ADT.
 *
 * @author John Thomsen
 * @version project5
 *
 */

public interface HashTable<T> {
   boolean contains(T element);
   boolean isEmpty();
   boolean add(T element);
   boolean remove(T element);
   int size();
   double loadFactor();
   int tableSize();
}
