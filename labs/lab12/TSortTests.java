import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
/* TSortTests
 * @author John Thomsen
 * @version lab 12
 */

public class TSortTests {
   @Test//(expected=IllegalArgumentException.class)
   public void testNoIn() {
      try {
         TSort.tsort("");
      } catch (Exception e) {
         assertEquals("input contains no edges", e.getMessage());
      }
   }
   
   @Test//(expected=IllegalArgumentException.class)
   public void testIn0() {
      try {
         TSort.tsort("101");
      } catch (Exception e) {
         assertEquals("input contains an odd number of tokens", e.getMessage());
      }
   }
   
   @Test//(expected=IllegalArgumentException.class)
   public void testIn1() {
      try {
         TSort.tsort("101 102 102");
      } catch (Exception e) {
         assertEquals("input contains an odd number of tokens", e.getMessage());
      }
   }
   
   @Test//(expected=IllegalArgumentException.class)
   public void testIn2() {
      try {
         TSort.tsort("101 102 102 103 103");
      } catch (Exception e) {
         assertEquals("input contains an odd number of tokens", e.getMessage());
      }
   }

   @Test//(expected=IllegalArgumentException.class)
   public void testLoop0() {
      try {
         TSort.tsort("101 101");
      } catch (Exception e) {
         assertEquals("input contains a loop", e.getMessage());
      }
   }
   
   @Test//(expected=IllegalArgumentException.class)
   public void testLoop1() {
      try {
         TSort.tsort("101 102 102 101");
      } catch (Exception e) {
         assertEquals("input contains a loop", e.getMessage());
      }
   }
   
   @Test//(expected=IllegalArgumentException.class)
   public void testLoop2() {
      try {
         TSort.tsort("101 102 102 103 103 102");
      } catch (Exception e) {
         assertEquals("input contains a loop", e.getMessage());
      }
   }
   
   @Test
   public void test1() {
      assertEquals("101\n102\n225\n103\n357\n348\n445\n349\n430\n431\n", TSort.tsort("101 102\n102 103\n102 225\n103 348\n348 349\n103 357\n225 357\n349 430\n357 430\n430 431\n348 445"));
   }
   
   @Test
   public void test2() {
      assertEquals("red\ngreen\npurple\nblue\nblack\n", TSort.tsort("blue black\nred blue\nred green\ngreen blue\ngreen purple\npurple blue"));
   }
   
   @Test
   public void test3() {
      assertEquals("1\n9\n10\n8\n2\n3\n4\n7\n6\n12\n14\n13\n5\n11\n", TSort.tsort("1 2\n1 9\n1 8\n9 8\n9 10\n8 11\n10 11\n2 3\n3 11\n3 4\n4 7\n4 5\n7 5\n7 13\n7 6\n6 14\n6 12"));
   }
   
   @Test
   public void test4() {
      assertEquals("7\n5\n11\n2\n3\n10\n8\n9\n", TSort.tsort("3 8\n3 10\n5 11\n7 8\n7 11\n8 9\n11 2\n11 9\n11 10"));
   }


   /*@Test
   public void testConvert() throws FileNotFoundException,IOException {
      Scanner in = new Scanner(new File("TSortTestCases.txt"));
      FileWriter out = new FileWriter("noNewLine.txt");
      while (in.hasNextLine()) {
         out.write(in.nextLine() + "\\n");
      }
      out.close();
   }*/
}
