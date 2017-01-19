import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import java.io.*;
/* DiGraphTests
 * @author John Thomsen
 * @version lab 13
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DiGraphTests {
   @Test//(expected=IllegalArgumentException.class)
   public void testNoIn() {
      try {
         FileWriter f = new FileWriter("graph.txt");
         f.write("");
         f.close();
         DiGraph di = new DiGraph("graph.txt");
      } catch (Exception e) {
         assertEquals("the file is empty", e.getMessage());
      }
   }
   
   @Test//(expected=IllegalArgumentException.class)
   public void testIn0() {
      try {
         FileWriter f = new FileWriter("graph.txt");
         f.write("101");
         f.close();
         DiGraph di = new DiGraph("graph.txt");
      } catch (Exception e) {
         assertEquals("the input is mal-formed", e.getMessage());
      }
   }
   
   @Test//(expected=IllegalArgumentException.class)
   public void testIn1() {
      try {
         FileWriter f = new FileWriter("graph.txt");
         f.write("a b c");
         f.close();
         DiGraph di = new DiGraph("graph.txt");
      } catch (Exception e) {
         assertEquals("the input is mal-formed", e.getMessage());
      }
   }
   
   @Test//(expected=IllegalArgumentException.class)
   public void testIn2() {
      try {
         FileWriter f = new FileWriter("graph.txt");
         f.write("101 102 -10");
         f.close();
         DiGraph di = new DiGraph("graph.txt");
      } catch (Exception e) {
         assertEquals("the graph contains a negative edge", e.getMessage());
      }
   }
   
   @Test//(expected=IllegalArgumentException.class)
   public void testIn3() {
      try {
         FileWriter f = new FileWriter("graph.txt");
         f.write("101 102 1\n101 102 3");
         f.close();
         DiGraph di = new DiGraph("graph.txt");
      } catch (Exception e) {
         assertEquals("Duplicate edge", e.getMessage());
      }
   }
   
   @Test
   public void testNoStart() {
      try {
         DiGraph di = new DiGraph("inputText9.20.txt");
         di.setStart("101");
      } catch (Exception e) {
         assertEquals("the specified vertex is not in the graph", e.getMessage());
      }
   }
   
   @Test
   public void testPaths0()  throws FileNotFoundException {
      DiGraph di = new DiGraph("inputText9.20.txt");
      di.setStart("v1");
      assertEquals("v1", di.getPathTo("v1"));
      assertEquals("v1 v4", di.getPathTo("v4"));
      assertEquals("v1 v2", di.getPathTo("v2"));
      assertEquals("v1 v4", di.getPathTo("v4"));
      assertEquals("v1 v4 v3", di.getPathTo("v3"));
      assertEquals("v1 v4 v5", di.getPathTo("v5"));
      assertEquals("v1 v4 v7", di.getPathTo("v7"));
      assertEquals("v1 v4 v7 v6", di.getPathTo("v6"));
      
      di.setStart("v7");
      assertEquals("v7", di.getPathTo("v7"));
      assertEquals("v7 v6", di.getPathTo("v6"));
      assertEquals("v5", di.getPathTo("v5"));
   }
   
   @Test
   public void testDist0()  throws FileNotFoundException {
      DiGraph di = new DiGraph("inputText9.20.txt");
      di.setStart("v1");
      assertEquals(0, di.getDistanceTo("v1"), 0);
      assertEquals(1, di.getDistanceTo("v4"), 0);
      assertEquals(2, di.getDistanceTo("v2"), 0);
      assertEquals(3, di.getDistanceTo("v3"), 0);
      assertEquals(3, di.getDistanceTo("v5"), 0);
      assertEquals(5, di.getDistanceTo("v7"), 0);
      assertEquals(6, di.getDistanceTo("v6"), 0);
      
      di.setStart("v7");
      assertEquals(0, di.getDistanceTo("v7"), 0);
      assertEquals(1, di.getDistanceTo("v6"), 0);
      assertEquals(Double.POSITIVE_INFINITY, di.getDistanceTo("v5"), 0);
   }

   @Test
   public void testLong0() throws FileNotFoundException {
      DiGraph di = new DiGraph("inputSparse.txt");
      di.setStart("AA");
   }
   
   @Test
   public void testLong1() throws FileNotFoundException {
      DiGraph di = new DiGraph("inputMedium.txt");
      di.setStart("AA");
   }
   
   @Test
   public void testLong2() throws FileNotFoundException {
      DiGraph di = new DiGraph("inputDense.txt");
      di.setStart("AA");
   }
   
   @Test
   public void test04_Dense() throws FileNotFoundException {
      String file = "inputDense.txt";
      DiGraph d = new DiGraph( file );
      d.setStart("AA");

      assertEquals( 2.5, d.getDistanceTo("TJ"), 0 );

      String end;


      d.setStart("AA");
      end = "BB";      
      System.out.println("Path: " + d.getPathTo( end ) +"\t\t dist: " + d.getDistanceTo( end ) );

      
      d.setStart("AA");
      end = "ZZ";      
      System.out.println("Path: " + d.getPathTo( end ) +"\t\t dist: " + d.getDistanceTo( end ) );

      d.setStart("TK");
      end = "QZ";      
      System.out.println("Path: " + d.getPathTo( end ) +"\t\t dist: " + d.getDistanceTo( end ) );

   }





}
