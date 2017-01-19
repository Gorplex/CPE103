/* A hash table that uses separate chaining as its method of collisions resolution.
 *
 * @authror John Thomsen
 * @version project5
 */

public class HashTableSC<T> implements HashTable<T>, HashMetrics {
   
   private int size;
   private Object[] table;
   private int[] listSize;
   private int col;
   private int maxCol;

   public HashTableSC(int tableSize) {
      if (tableSize < 0) {throw new IllegalArgumentException();}
      table = new Object[PrimeTools.nextPrime(tableSize)];
      listSize = new int[table.length];
   }

   public boolean contains(T element) {
      @SuppressWarnings("unchecked")
      Node node = (Node) table[Math.abs(element.hashCode()%table.length)];
      if (node == null) {
         return false;
      } else {
         if (node.ele.equals(element)) {
            return true;
         }
         while (node.next != null) {
            if (node.next.ele.equals(element)) {
               return true;
            }
            node = node.next;
         }
         return false;
      }
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public boolean add(T element) {
      int hash = Math.abs(element.hashCode()%table.length);
      @SuppressWarnings("unchecked")
      Node node = (Node) table[hash];
      if (node == null) {
         table[hash] = (Object) new Node(element);
         //update hash stats
         size++;
         //no col code
      } else {
         if (node.ele.equals(element)) {
            col++;//add col... idk y
            maxCol = Math.max(maxCol, 1);
            return false;
         }
         int newCol = 1;
         col++;
         while (node.next != null) {
            newCol++;//each next node ++
            col++;
            node = node.next;
            if (node.ele.equals(element)) {
               maxCol = Math.max(maxCol, newCol);
               return false;
            }
         }
         node.next = new Node(element);
         //update hash stats
         size++;
         maxCol = Math.max(maxCol, newCol);
      }
      return true;
   }

   public boolean remove(T element) {
      int hash = Math.abs(element.hashCode()%table.length);
      @SuppressWarnings("unchecked")
      Node node = (Node) table[hash];
      if (node == null) {
         return false;
      } else {
         if (node.ele.equals(element)) {
            table[hash] = node.next;
            size--;
            //negleting to update collisions... damn spec
            return true;
         }
         while (node.next != null) {
            if (node.next.ele.equals(element)) {
               node.next = node.next.next;
               size--;
               //no collisions update again...
               return true;
            }
            node = node.next;
         }
         return false;
      }
   }

   public int size() {
      return size;
   }

   public double loadFactor() {
      return ((double)size)/table.length;
   }

   public int tableSize() {
      return table.length;
   }

   public long collisions() {
      return col;
   }

   public int maxCollisions() {
      return maxCol;
   }

   private class Node {
      T ele;
      Node next = null;
      private Node(T ele) {
         this.ele = ele;
      }
   }
}
