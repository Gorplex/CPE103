import java.util.*;
import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
/* HasHashTools.oolsTest
 *
 * @autHashTools.r John Thomsen
 * @version lab9
 */

public class HashToolsTests {
   static ArrayList<String> words = new ArrayList<>();
   
   @BeforeClass
   public static void setUp() {
      try {
         Scanner in = new Scanner(new File("dictionary.txt"));
         while (in.hasNext()) {
            words.add(in.next());
         }
      }catch (FileNotFoundException e) {
         System.out.println("File Not Found");
      }
   }
   
   @Test
   public void testTotal() {
       assertEquals(95277, HashTools.collisions(words, 100000, new StringHash()), .0000001);
       assertEquals(95263, HashTools.collisions(words, 100000, new BetterHash()), .0000001);
       assertEquals(95267, HashTools.collisions(words, 100000, new MyHash()), .0000001);
   }
   @Test
   public void testMax() {
       assertEquals(10, HashTools.maxCollisions(words, 100000, new StringHash()), .0000001);
       assertEquals(10, HashTools.maxCollisions(words, 100000, new BetterHash()), .0000001);
       assertEquals(11, HashTools.maxCollisions(words, 100000, new MyHash()), .0000001);
   }
   @Test
   public void testAvg() {
       assertEquals(2.142, HashTools.avgCollisions(words, 100000, new StringHash()), .001);
       assertEquals(2.142, HashTools.avgCollisions(words, 100000, new BetterHash()), .001);
       assertEquals(2.142, HashTools.avgCollisions(words, 100000, new MyHash()), .001);
   }
   @Test
   public void testUnused() {
       assertEquals(16591, HashTools.unused(words, 100000, new StringHash()), .0000001);
       assertEquals(16577, HashTools.unused(words, 100000, new BetterHash()), .0000001);
       assertEquals(16581, HashTools.unused(words, 100000, new MyHash()), .0000001);
   }
   
   @Test
   public void testTotal2() {
       assertEquals(15069, HashTools.collisions(words, 1000000, new StringHash()), .0000001);
       assertEquals(14750, HashTools.collisions(words, 1000000, new BetterHash()), .0000001);
       assertEquals(14806, HashTools.collisions(words, 1000000, new MyHash()), .0000001);
   }
   @Test
   public void testMax2() {
       assertEquals(5, HashTools.maxCollisions(words, 1000000, new StringHash()), .0000001);
       assertEquals(5, HashTools.maxCollisions(words, 1000000, new BetterHash()), .0000001);
       assertEquals(5, HashTools.maxCollisions(words, 1000000, new MyHash()), .0000001);
   }
   @Test
   public void testAvg2() {
       assertEquals(1.092, HashTools.avgCollisions(words, 1000000, new StringHash()), .001);
       assertEquals(1.090, HashTools.avgCollisions(words, 1000000, new BetterHash()), .001);
       assertEquals(1.090, HashTools.avgCollisions(words, 1000000, new MyHash()), .001);
   }
   @Test
   public void testUnused2() {
       assertEquals(836383, HashTools.unused(words, 1000000, new StringHash()), .0000001);
       assertEquals(836064, HashTools.unused(words, 1000000, new BetterHash()), .0000001);
       assertEquals(836120, HashTools.unused(words, 1000000, new MyHash()), .0000001);
   }
   
   @Test
   public void testTotal3() {
       assertEquals(178687, HashTools.collisions(words, 0, new StringHash()), .0000001);
       assertEquals(178687, HashTools.collisions(words, 0, new BetterHash()), .0000001);
       assertEquals(178687, HashTools.collisions(words, 0, new MyHash()), .0000001);
   }
   @Test
   public void testMax3() {
       assertEquals(89421, HashTools.maxCollisions(words, 0, new StringHash()), .0000001);
       assertEquals(89421, HashTools.maxCollisions(words, 0, new BetterHash()), .0000001);
       assertEquals(89421, HashTools.maxCollisions(words, 0, new MyHash()), .0000001);
   }
   @Test
   public void testAvg3() {
       assertEquals(89344.500, HashTools.avgCollisions(words, 0, new StringHash()), .001);
       assertEquals(89344.500, HashTools.avgCollisions(words, 0, new BetterHash()), .001);
       assertEquals(89344.500, HashTools.avgCollisions(words, 0, new MyHash()), .001);
   }
   @Test
   public void testUnused3() {
       assertEquals(0, HashTools.unused(words, 0, new StringHash()), .0000001);
       assertEquals(0, HashTools.unused(words, 0, new BetterHash()), .0000001);
       assertEquals(0, HashTools.unused(words, 0, new MyHash()), .0000001);
   }
}
