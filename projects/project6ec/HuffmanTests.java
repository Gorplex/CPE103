import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import java.io.*;
import java.util.*;
import java.nio.file.*;

/* HuffmanTests
 *
 * @author John Thomsen
 * @version proj 6
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HuffmanTests {
   @BeforeClass
   public static void testMakeFile() {
      try {
         PrintWriter f = new PrintWriter("textfile.txt");
         f.print("aaabbc");
         f.close();
      } catch(Exception e) {
         //skip
      }
      try {
         PrintWriter f = new PrintWriter("rick.txt");
         //System.out.println("\"Never Gonna Give You Up\"\n\nWe're no strangers to love\nYou know the rules and so do I\nA full commitment's what I'm thinking of\nYou wouldn't get this from any other guy\n\nI just wanna tell you how I'm feeling\nGotta make you understand\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nWe've known each other for so long\nYour heart's been aching, but\nYou're too shy to say it\nInside, we both know what's been going on\nWe know the game and we're gonna play it\n\nAnd if you ask me how I'm feeling\nDon't tell me you're too blind to see\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\n(Ooh, give you up)\n(Ooh, give you up)\nNever gonna give, never gonna give\n(Give you up)\nNever gonna give, never gonna give\n(Give you up)\n\nWe've known each other for so long\nYour heart's been aching, but\nYou're too shy to say it\nInside, we both know what's been going on\nWe know the game and we're gonna play it\n\nI just wanna tell you how I'm feeling\nGotta make you understand\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n");
         f.print("\"Never Gonna Give You Up\"\n\nWe're no strangers to love\nYou know the rules and so do I\nA full commitment's what I'm thinking of\nYou wouldn't get this from any other guy\n\nI just wanna tell you how I'm feeling\nGotta make you understand\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nWe've known each other for so long\nYour heart's been aching, but\nYou're too shy to say it\nInside, we both know what's been going on\nWe know the game and we're gonna play it\n\nAnd if you ask me how I'm feeling\nDon't tell me you're too blind to see\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\n(Ooh, give you up)\n(Ooh, give you up)\nNever gonna give, never gonna give\n(Give you up)\nNever gonna give, never gonna give\n(Give you up)\n\nWe've known each other for so long\nYour heart's been aching, but\nYou're too shy to say it\nInside, we both know what's been going on\nWe know the game and we're gonna play it\n\nI just wanna tell you how I'm feeling\nGotta make you understand\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n");
         f.close();
      } catch (Exception e) {
         //skip    
      }
   }
   
   
   @Test
   public void testBasic() throws FileNotFoundException, IOException {
      Huffman h = new Huffman("textfile.txt");
      assertEquals("|a" + ((char)4) + "cb|", h.toString());
      
      h.compress("textfile.txt", "compfile.txt");
      assertTrue(fileEquArray(new int[] {31, 96}, "compfile.txt"));      
      h.decompress("compfile.txt", "textfile2.txt"); 
      assertEquals("aaabbc", fileToString("textfile2.txt"));
   }
   
   @Test
   public void testLong() {
      try {
         long[] t = new long[4];
         t[0] = System.currentTimeMillis();
         
         Huffman h = new Huffman("processFileTest_War_And_Peace.txt");
         t[1] = System.currentTimeMillis();
         System.out.println("Create: " + (t[1]-t[0]));
         assertEquals("|\"HjCqzNp,kV;DO)(Y61GJ5*^Q}{|[" + ((char)4) + "_=%\\~$]&4X3U?shinoygl\n\ratvPSWK82L!MRfwmdcTEx-b.A'IB:97Z/0Fure |", h.toString());

         t[0] = System.currentTimeMillis();
         h.compress("processFileTest_War_And_Peace.txt", "compfile.txt");
         t[1] = System.currentTimeMillis();
         h.decompress("compfile.txt", "war2.txt"); 
         t[2] = System.currentTimeMillis();
         System.out.println("Compress: " + (t[1]-t[0]));
         System.out.println("Decompress: " + (t[2]-t[1]));
         
         assertEquals(fileToString("processFileTest_War_And_Peace.txt"), fileToString("war2.txt"));
      }catch(Exception e) {
         //System.out.println("WAR AND PEACE NOT FOUND");
      }
   }
   
   @Test
   public void testLong2() {
      try {
         Huffman h = new Huffman("PrincessBride.txt");
         //System.out.println(h.toString());
         assertEquals("|ehiuvI\nnof.,O;BWS5KJURPHYCG:xalcgtymdkV8&" + ((char)4) + "$9/2Q)(Lé6741Z03Dz'wrs\"bpTq-FNM?A!Ej |", h.toString());

         h.compress("PrincessBride.txt", "compfile.txt");
         h.decompress("compfile.txt", "bride2.txt"); 
         assertEquals(fileToString("PrincessBride.txt"), fileToString("bride2.txt"));
      }catch(Exception e) {
         //System.out.println("PrincessBride.txt NOT FOUND");
      }
   }
   
   @Test
   public void testRickSimple() throws FileNotFoundException, IOException {
      Huffman h = new Huffman("rick.txt");
      assertEquals("|nuldercGU" + ((char)4) + "D\"AwvapY()b,IyhkOjWfts'm\n gNio|", h.toString());
      
      h.compress("textfile.txt", "compfile.txt");
      assertTrue(fileEquArray(new int[] {136, 137, 82, 156, 57, 160}, "compfile.txt"));
      h.decompress("compfile.txt", "textfile2.txt");
      assertEquals("aaabbc", fileToString("textfile2.txt"));
   }
   
   @Test
   public void testRickAll() throws FileNotFoundException, IOException {
      Huffman h = new Huffman("rick.txt");
      assertEquals("|nuldercGU" + ((char)4) + "D\"AwvapY()b,IyhkOjWfts'm\n gNio|", h.toString());
      
      h.compress("rick.txt", "compfile.txt");
      h.decompress("compfile.txt", "rick2.txt");
      assertEquals(fileToString("rick.txt"), fileToString("rick2.txt"));
   }

   private boolean fileEquArray(int[] nums, String infileName) throws FileNotFoundException, IOException {
      BufferedInputStream in = new BufferedInputStream(new FileInputStream(infileName));
      for (int i: nums) {
         int j = in.read();
         //System.out.println("exp: " + i);
         //System.out.println("other: " + j);
         if (i != j) {
            return false;
         }
      }
      return true;
   }

   private String fileToString(String file) throws FileNotFoundException, IOException {
      return new String(Files.readAllBytes(Paths.get(file)));
   }
}
