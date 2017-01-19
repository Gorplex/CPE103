import org.junit.*;
import static org.junit.Assert.*;

/* HashTableSCTests
 *
 * @author John Thomsen
 * @version project5
 */

public class HashTableSCTests {
   //@Test
   public void testPrintHash() {
      for (Integer i = 0; i < 20; i++) {
         System.out.println(i.hashCode());
      }
   }
  
   @Test
   public void testLong() {
      int SIZE = 1000; //change this const
      int TS = PrimeTools.nextPrime(SIZE);
      HashTableSC<Integer> t = new HashTableSC<>(SIZE);
      assertEquals(true, t.isEmpty());
      assertEquals(0, t.size());
      assertEquals(0, t.collisions());
      assertEquals(0, t.maxCollisions());
      assertEquals(TS, t.tableSize());
      assertEquals(0d, t.loadFactor(), 0);
      int col = 0;
      for (int i = 0; i < TS*10; i++) {
         assertTrue(t.add(i));
         assertEquals(i+1, t.size());
         col += i/TS;
         assertEquals(col, t.collisions());
         assertEquals(i/TS, t.maxCollisions());
         assertEquals(((double)i+1)/TS, t.loadFactor(), 0);
      }
      assertFalse(t.isEmpty());
      for (int i = 0; i < TS*10; i++) {
         assertTrue(t.contains(i));
      }
      assertFalse(t.isEmpty());
      assertEquals(TS*10, t.size());
      assertEquals(TS*45, t.collisions());
      assertEquals(9, t.maxCollisions());
      assertEquals(10d, t.loadFactor(), 0);
      for (int i = 0; i < TS*10; i++) {
         assertTrue(t.remove(i));
         assertEquals(TS*10-i-1, t.size());
         assertEquals(((double)TS*10-i-1)/TS, t.loadFactor(), 0);
      }
      assertTrue(t.isEmpty());
      assertEquals(0, t.size());
      assertEquals(TS*45, t.collisions());
      assertEquals(9, t.maxCollisions());
      assertEquals(0d, t.loadFactor(), 0);
   }

   @Test
   public void testConst() {
      HashTableSC<Integer> t = new HashTableSC<>(4);
      assertEquals(true, t.isEmpty());
      assertEquals(0, t.size());
      assertEquals(0, t.collisions());
      assertEquals(0, t.maxCollisions());
      assertEquals(5, t.tableSize());
      assertEquals(0d, t.loadFactor(), 0);
   }
   
   @Test
   public void testAdd() {
      HashTableSC<Integer> t = new HashTableSC<>(4);
      assertTrue(t.add(1));
      assertEquals(1, t.size());
      assertEquals(0, t.collisions());
      assertEquals(0, t.maxCollisions());
      assertEquals(5, t.tableSize());
      assertFalse(t.add(1));
      assertEquals(1, t.size());
      assertEquals(1, t.collisions());
      assertEquals(1, t.maxCollisions());
      assertEquals(5, t.tableSize());
   }
   
   @Test
   public void testCont() {
      HashTableSC<Integer> t = new HashTableSC<>(4);
      assertFalse(t.contains(1)); 
      assertTrue(t.add(1));
      assertTrue(t.contains(1)); 
      assertTrue(t.add(2));
      assertEquals(2, t.size());
      assertTrue(t.contains(2));
      assertTrue(t.remove(2));
      assertEquals(1, t.size());
      assertFalse(t.contains(2));
      assertTrue(t.contains(1));
   }
   
   @Test
   public void testRemove() {
      HashTableSC<Integer> t = new HashTableSC<>(4);
      assertFalse(t.remove(1));
      assertTrue(t.add(1));
      assertTrue(t.add(2));
      assertEquals(2, t.size());
      assertTrue(t.remove(2));
      assertEquals(1, t.size());
      assertFalse(t.remove(2));
      assertTrue(t.remove(1));
      assertTrue(t.isEmpty());
      assertFalse(t.remove(1));
   }     
   
   @Test
   public void testColl() {
      HashTableSC<Integer> t = new HashTableSC<>(4);
      assertEquals(5, t.tableSize());
      assertTrue(t.add(0));
      assertEquals(0, t.collisions());
      assertEquals(0, t.maxCollisions());
      assertTrue(t.add(5));
      assertEquals(1, t.collisions());
      assertEquals(1, t.maxCollisions());
      assertTrue(t.add(10));
      assertEquals(3, t.collisions());
      assertEquals(2, t.maxCollisions());
      assertTrue(t.add(15));
      assertEquals(6, t.collisions());
      assertEquals(3, t.maxCollisions());
      assertTrue(t.add(1));
      assertEquals(6, t.collisions());
      assertEquals(3, t.maxCollisions());
      assertTrue(t.add(6));
      assertEquals(7, t.collisions());
      assertEquals(3, t.maxCollisions());
      assertTrue(t.add(11));
      assertEquals(9, t.collisions());
      assertEquals(3, t.maxCollisions());
      assertTrue(t.add(16));
      assertEquals(12, t.collisions());
      assertEquals(3, t.maxCollisions());
   }
   
   @Test
   public void testLF() {
      HashTableSC<Integer> t = new HashTableSC<>(4);
      assertEquals(0d, t.loadFactor(), 0);
      assertTrue(t.add(0));
      assertEquals(1d/5, t.loadFactor(), 0);
      assertTrue(t.add(1));
      assertEquals(2d/5, t.loadFactor(), 0);
      assertTrue(t.add(2));
      assertEquals(3d/5, t.loadFactor(), 0);
      assertTrue(t.add(3));
      assertEquals(4d/5, t.loadFactor(), 0);
      assertTrue(t.add(4));
      assertEquals(5d/5, t.loadFactor(), 0);
      assertTrue(t.add(5));
      assertEquals(6d/5, t.loadFactor(), 0);
      assertTrue(t.add(6));
      assertEquals(7d/5, t.loadFactor(), 0); 
   }
}
