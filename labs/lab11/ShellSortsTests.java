import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

/* ShellSortTests
 *
 * @author John Thomsen
 * @version lab10
 */

public class ShellSortsTests {
                                //1000000
   public static final int SIZE = 1000000;
   public static final boolean CHECK = true;
   public static final boolean PRINT = false;
   public static final boolean QUICK = false;
   public static final boolean CHECK_RPT = false;//broken (nlogn only)


   private static Integer[] rand025 = new Integer[2500];
   private static Integer[] rand050 = new Integer[5000];
   private static Integer[] rand100 = new Integer[10000];
   private static Integer[] rand200 = new Integer[20000];
   private static Integer[] rand5kh = new Integer[500000];
   private static Integer[] randVar = new Integer[SIZE];

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
      for (int i = 0; i < 500000; i++) {
         rand5kh[i] = rand.nextInt();
      }
      for (int i = 0; i < SIZE; i++) {
         randVar[i] = rand.nextInt();
      }
   }
   
   @Test
   public void testShell() {
      if (!QUICK) {

      long[] times = new long[7];
      times[0] = System.currentTimeMillis();
      ShellSorts.shell(rand025); 
      times[1] = System.currentTimeMillis();
      ShellSorts.shell(rand050); 
      times[2] = System.currentTimeMillis();
      ShellSorts.shell(rand100); 
      times[3] = System.currentTimeMillis();
      ShellSorts.shell(rand200);
      times[4] = System.currentTimeMillis();
      ShellSorts.shell(rand5kh);
      times[5] = System.currentTimeMillis();
      ShellSorts.shell(randVar);
      times[6] = System.currentTimeMillis();
      
      if (PRINT) {
         for (int i = 0; i < 6; i++) {
            System.out.println("Shell: " + (times[i+1] - times[i]));
         }
      }  

      if (CHECK) {
         assertTrue(isSorted(rand025));
         assertTrue(isSorted(rand050));
         assertTrue(isSorted(rand100));
         assertTrue(isSorted(rand200));
         assertTrue(isSorted(rand5kh));
         assertTrue(isSorted(randVar));
      }
      }
   }
   
   @Test
   public void testHibbard() {
      if (!QUICK) {
      
      long[] times = new long[7];
      times[0] = System.currentTimeMillis();
      ShellSorts.hibbard(rand025); 
      times[1] = System.currentTimeMillis();
      ShellSorts.hibbard(rand050); 
      times[2] = System.currentTimeMillis();
      ShellSorts.hibbard(rand100); 
      times[3] = System.currentTimeMillis();
      ShellSorts.hibbard(rand200); 
      times[4] = System.currentTimeMillis();
      ShellSorts.hibbard(rand5kh); 
      times[5] = System.currentTimeMillis();
      ShellSorts.hibbard(randVar); 
      times[6] = System.currentTimeMillis();
      
      if (PRINT) {
         for (int i = 0; i < 6; i++) {
            System.out.println("Hib: " + (times[i+1] - times[i]));
         }
      }  
   
      if (CHECK) {
         assertTrue(isSorted(rand025));
         assertTrue(isSorted(rand050));
         assertTrue(isSorted(rand100));
         assertTrue(isSorted(rand200));
         assertTrue(isSorted(rand5kh));
         assertTrue(isSorted(randVar));
      }
      }
   }
   
   @Test
   public void testSedg() {
      if (!QUICK) {
      
      long[] times = new long[7];
      times[0] = System.currentTimeMillis();
      ShellSorts.sedgewick(rand025); 
      times[1] = System.currentTimeMillis();
      ShellSorts.sedgewick(rand050); 
      times[2] = System.currentTimeMillis();
      ShellSorts.sedgewick(rand100); 
      times[3] = System.currentTimeMillis();
      ShellSorts.sedgewick(rand200); 
      times[4] = System.currentTimeMillis();
      ShellSorts.hibbard(rand5kh); 
      times[5] = System.currentTimeMillis();
      ShellSorts.sedgewick(randVar); 
      times[6] = System.currentTimeMillis();
      
      if (PRINT) {
         for (int i = 0; i < 6; i++) {
            System.out.println("Sedg:  " + (times[i+1] - times[i]));
         }
      }  
   
      if (CHECK) {
         assertTrue(isSorted(rand025));
         assertTrue(isSorted(rand050));
         assertTrue(isSorted(rand100));
         assertTrue(isSorted(rand200));
         assertTrue(isSorted(rand5kh));
         assertTrue(isSorted(randVar));
      }
      }
   }
   
   @Test
   public void testHeap() {
      if (!QUICK) {
      
      long[] times = new long[7];
      times[0] = System.currentTimeMillis();
      ShellSorts.heapSort(rand025); 
      times[1] = System.currentTimeMillis();
      ShellSorts.heapSort(rand050); 
      times[2] = System.currentTimeMillis();
      ShellSorts.heapSort(rand100); 
      times[3] = System.currentTimeMillis();
      ShellSorts.heapSort(rand200); 
      times[4] = System.currentTimeMillis();
      ShellSorts.heapSort(rand5kh); 
      times[5] = System.currentTimeMillis();
      ShellSorts.heapSort(randVar); 
      times[6] = System.currentTimeMillis();
      
      if (PRINT) {
         for (int i = 0; i < 6; i++) {
            System.out.println("Heap: " + (times[i+1] - times[i]));
         }
      }  
      
      if (CHECK) {
         assertTrue(isSorted(rand025));
         assertTrue(isSorted(rand050));
         assertTrue(isSorted(rand100));
         assertTrue(isSorted(rand200));
         assertTrue(isSorted(rand5kh));
         assertTrue(isSorted(randVar));
      }
      }
   }

   //@Test broken (only works for nlogn things)
   public void testCalc() throws FileNotFoundException {
      if (CHECK_RPT) {
      
      Scanner in = new Scanner(new File("report.txt"));
      int i = 0;
      while (i < 7 && in.hasNextLine()) {
         in.nextLine();
         i++;
      }
      if (i != 7) {
         System.out.println("bad report format");
      }
      int index = 0;
      int[] nums = new int[3];
      while (in.hasNext()) {
         String nxt = in.next();
         if (nxt.equals("1,000,000") || nxt.equals("5,000,000") || nxt.equals("25,000,000")) {
            //System.out.println(nxt);
            if ("elements".equals(in.next())) {
               in.next();
               //System.out.println(in.next());
               // will need fixing if you dont have spaces between num and 'ms'
               try {
                  nums[index] = Integer.parseInt(in.next());
               } catch (NumberFormatException e) {
                  System.out.println("no number found (or no spaces)");
                  nums[index] = 0;
               }
               index++;
               //in.nextLine();
            } else {
               System.out.println("bad syntax in report file");
            }
         }
         if (index == 3) {
            long n1 = 1000000;
            long n2 = 5000000;
            //System.out.println(nums[0]);
            long t2 = (long)(nums[0]*n2*Math.log(n2)/(n1*Math.log(n1))); 
            //System.out.println(t2);
            assertEquals(t2, nums[1]);
            n2 = 25000000;
            t2 = (long)(nums[0]*n2*Math.log(n2)/(n1*Math.log(n1))); 
            //System.out.println(t2);
            assertEquals(t2, nums[2]);
            index = 0;
         }
      }
      }
   }

   private static <T extends Comparable<? super T>> boolean isSorted(Integer[] a) {
      for (int i = 0; i < a.length-1; i++) {
         if (a[i].compareTo(a[i+1]) > 0) {
            return false;
         }
      }
      return true;
   }
}
