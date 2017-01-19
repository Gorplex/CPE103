import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

/* QuadraticSortTests
 *
 * @author John Thomsen
 * @version lab10
 */

public class QuadraticSortsTests {
   
   private static Integer[] rand025 = new Integer[2500];
   private static Integer[] rand050 = new Integer[5000];
   private static Integer[] rand100 = new Integer[10000];
   private static Integer[] rand200 = new Integer[20000];
   
   private static Integer[] sort025 = new Integer[2500];
   private static Integer[] sort050 = new Integer[5000];
   private static Integer[] sort100 = new Integer[10000];
   private static Integer[] sort200 = new Integer[20000];

   @BeforeClass
   public static void setUp() {
      Random rand = new Random(237);
      for (int i = 0; i < 2500; i++) {
         sort025[i] = rand.nextInt();
      }
      for (int i = 0; i < 5000; i++) {
         sort050[i] = rand.nextInt();
      }
      for (int i = 0; i < 10000; i++) {
         sort100[i] = rand.nextInt();
      }
      for (int i = 0; i < 20000; i++) {
         sort200[i] = rand.nextInt();
      }
      Arrays.sort(sort025);
      Arrays.sort(sort050);
      Arrays.sort(sort100);
      Arrays.sort(sort200);
   }
      
   @Before
   public void B4() {
      Random rand = new Random(237);
      for (int i = 0; i < 2500; i++) {
         rand025[i] = rand.nextInt();
      }
      for (int i = 0; i < 5000; i++) {
         rand050[i] = rand.nextInt();
      }
      for (int i = 0; i < 10000; i++) {
         rand100[i] = rand.nextInt();
      }
      for (int i = 0; i < 20000; i++) {
         rand200[i] = rand.nextInt();
      }
   }
   
   @Test
   public void testBub1() {
      long[] times = new long[5];
      times[0] = System.currentTimeMillis();
      QuadraticSorts.bubbleSort1(rand025); 
      times[1] = System.currentTimeMillis();
      QuadraticSorts.bubbleSort1(rand050); 
      times[2] = System.currentTimeMillis();
      QuadraticSorts.bubbleSort1(rand100); 
      times[3] = System.currentTimeMillis();
      QuadraticSorts.bubbleSort1(rand200);
      times[4] = System.currentTimeMillis();
      
      for (int i = 0; i < 4; i++) {
         //System.out.println("Bub1: " + (times[i+1] - times[i]));
      }  

      assertArrayEquals(sort025, rand025);
      assertArrayEquals(sort050, rand050);
      assertArrayEquals(sort100, rand100);
      assertArrayEquals(sort200, rand200);
   }
   
   @Test
   public void testBub2() {
      long[] times = new long[5];
      times[0] = System.currentTimeMillis();
      QuadraticSorts.bubbleSort2(rand025); 
      times[1] = System.currentTimeMillis();
      QuadraticSorts.bubbleSort2(rand050); 
      times[2] = System.currentTimeMillis();
      QuadraticSorts.bubbleSort2(rand100); 
      times[3] = System.currentTimeMillis();
      QuadraticSorts.bubbleSort2(rand200); 
      times[4] = System.currentTimeMillis();
      
      for (int i = 0; i < 4; i++) {
         //System.out.println("Bub2: " + (times[i+1] - times[i]));
      }  
   
      assertArrayEquals(sort025, rand025);
      assertArrayEquals(sort050, rand050);
      assertArrayEquals(sort100, rand100);
      assertArrayEquals(sort200, rand200);
   }
   
   @Test
   public void testSel() {
      long[] times = new long[5];
      times[0] = System.currentTimeMillis();
      QuadraticSorts.selectionSort(rand025); 
      times[1] = System.currentTimeMillis();
      QuadraticSorts.selectionSort(rand050); 
      times[2] = System.currentTimeMillis();
      QuadraticSorts.selectionSort(rand100); 
      times[3] = System.currentTimeMillis();
      QuadraticSorts.selectionSort(rand200); 
      times[4] = System.currentTimeMillis();
      
      for (int i = 0; i < 4; i++) {
         //System.out.println("Sel:  " + (times[i+1] - times[i]));
      }  
   
      assertArrayEquals(sort025, rand025);
      assertArrayEquals(sort050, rand050);
      assertArrayEquals(sort100, rand100);
      assertArrayEquals(sort200, rand200);
   }
   
   @Test
   public void testInser() {
      long[] times = new long[5];
      times[0] = System.currentTimeMillis();
      QuadraticSorts.insertionSort(rand025); 
      times[1] = System.currentTimeMillis();
      QuadraticSorts.insertionSort(rand050); 
      times[2] = System.currentTimeMillis();
      QuadraticSorts.insertionSort(rand100); 
      times[3] = System.currentTimeMillis();
      QuadraticSorts.insertionSort(rand200); 
      times[4] = System.currentTimeMillis();
      
      for (int i = 0; i < 4; i++) {
         //System.out.println("Inser: " + (times[i+1] - times[i]));
      }  
      
      assertArrayEquals(sort025, rand025);
      assertArrayEquals(sort050, rand050);
      assertArrayEquals(sort100, rand100);
      assertArrayEquals(sort200, rand200);
   }
}
