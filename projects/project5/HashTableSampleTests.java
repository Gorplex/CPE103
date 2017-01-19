/**
 * Trivial JUnit test for Hash Table.
 *
 * @author Brian Jones
 * @version 11/11/2016 Developed for CPE 103 Program 5
 */
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HashTableSampleTests {
   // This test has no assertions because it's not testing correctness.  Feel
   // free to modify this test to assert correctness.  Storing the results is
   // done for compile time type checking of your return types.
   @Test
   public void test01_correctMethodNames() {
      HashTableSC<Integer> table = new HashTableSC<Integer>(100);
      boolean b;
      long l;
      double d;
      int i;
      b = table.add(5);
      l = table.collisions();
      b = table.contains(6);
      b = table.isEmpty();
      d = table.loadFactor();
      i = table.maxCollisions();
      b = table.remove(5);
      i = table.size();
      i = table.tableSize();
   }
} 
