import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

/* SpellCheckerTests
 *
 * @author John Thomsen
 * @version project5
 */

public class SpellCheckerTests {

   @BeforeClass
   public static void testMakeFiles() {
      try {//just in case no permisions in runtime dir
         //make dict file
         PrintWriter f = new PrintWriter("testDict.txt");
         f.println("these are valid words");
         f.println("skyblue gonna asdf");
         f.println("matt");
         f.println("the end");
         f.close();
      
         //make file to process
         PrintWriter o = new PrintWriter("rick.txt");
         //System.out.println("\"Never Gonna Give You Up\"\n\nWe're no strangers to love\nYou know the rules and so do I\nA full commitment's what I'm thinking of\nYou wouldn't get this from any other guy\n\nI just wanna tell you how I'm feeling\nGotta make you understand\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nWe've known each other for so long\nYour heart's been aching, but\nYou're too shy to say it\nInside, we both know what's been going on\nWe know the game and we're gonna play it\n\nAnd if you ask me how I'm feeling\nDon't tell me you're too blind to see\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\n(Ooh, give you up)\n(Ooh, give you up)\nNever gonna give, never gonna give\n(Give you up)\nNever gonna give, never gonna give\n(Give you up)\n\nWe've known each other for so long\nYour heart's been aching, but\nYou're too shy to say it\nInside, we both know what's been going on\nWe know the game and we're gonna play it\n\nI just wanna tell you how I'm feeling\nGotta make you understand\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n");
         o.print("\"Never Gonna Give You Up\"\n\nWe're no strangers to love\nYou know the rules and so do I\nA full commitment's what I'm thinking of\nYou wouldn't get this from any other guy\n\nI just wanna tell you how I'm feeling\nGotta make you understand\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nWe've known each other for so long\nYour heart's been aching, but\nYou're too shy to say it\nInside, we both know what's been going on\nWe know the game and we're gonna play it\n\nAnd if you ask me how I'm feeling\nDon't tell me you're too blind to see\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\n(Ooh, give you up)\n(Ooh, give you up)\nNever gonna give, never gonna give\n(Give you up)\nNever gonna give, never gonna give\n(Give you up)\n\nWe've known each other for so long\nYour heart's been aching, but\nYou're too shy to say it\nInside, we both know what's been going on\nWe know the game and we're gonna play it\n\nI just wanna tell you how I'm feeling\nGotta make you understand\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n\nNever gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you\n");
         o.close();
      
       } catch (Exception e) {
         //System.out.println("No Permisions?");    
      }
   }
   
   @Test
   public void testDictTable() throws FileNotFoundException {
      //make SpellChecker
      SpellChecker SC = new SpellChecker();
      
      HashTableSC<String> t = SC.getDictionary();
      
      Scanner in = new Scanner(new File("dictionary.txt"));
      while (in.hasNext()) {
         assertTrue(t.contains(in.next()));
      }


   }
   
   @Test
   public void testDict() throws FileNotFoundException {
      //make SpellChecker
      SpellChecker SC = new SpellChecker();
         
      //processFile
      HashMap<String,SpellChecker.MyStats> map = SC.processFile("rick.txt");
          
      //test file
      SpellChecker.MyStats s = map.get("the");
      assertTrue(s.isWord());
      assertEquals(3, s.getOccurrences());
      assertArrayEquals(new Integer[] {4, 22, 52}, s.getLineNumbers().toArray());
      
      s = map.get("Never");
      assertTrue(s.isWord());
      assertEquals(39, s.getOccurrences());
      assertArrayEquals(new Integer[] {1, 11, 12, 13, 14, 15, 16, 27, 28, 29, 30, 31, 32, 34, 35, 36, 37, 38, 39, 43, 45, 57, 58, 59, 60, 61, 62, 64, 65, 66, 67, 68, 69, 71, 72, 73, 74, 75, 76}, s.getLineNumbers().toArray());
      
      s = map.get("gonna");
      assertFalse(s.isWord());
      assertEquals(42, s.getOccurrences());
      assertArrayEquals(new Integer[] {11, 12, 13, 14, 15, 16, 22, 27, 28, 29, 30, 31, 32, 34, 35, 36, 37, 38, 39, 43, 43, 45, 45, 52, 57, 58, 59, 60, 61, 62, 64, 65, 66, 67, 68, 69, 71, 72, 73, 74, 75, 76}, s.getLineNumbers().toArray());

      s = map.get("We're");
      assertFalse(s.isWord());
      assertEquals(1, s.getOccurrences());
      assertArrayEquals(new Integer[] {3}, s.getLineNumbers().toArray());
     
      s = map.get("asdf");
      assertEquals(null, s);

      //System.out.println(map.get("Never").getOccurrences());
   }

   @Test
   public void testOtherDict() throws FileNotFoundException {
      //make SpellChecker
      SpellChecker SC = new SpellChecker("testDict.txt");
         
      //processFile
      HashMap<String,SpellChecker.MyStats> map = SC.processFile("rick.txt");
      
      //test file
      SpellChecker.MyStats s = map.get("the");
      assertTrue(s.isWord());
      assertEquals(3, s.getOccurrences());
      assertArrayEquals(new Integer[] {4, 22, 52}, s.getLineNumbers().toArray());

      //test file
      s = map.get("Never");
      assertFalse(s.isWord());
      assertEquals(39, s.getOccurrences());
      assertArrayEquals(new Integer[] {1, 11, 12, 13, 14, 15, 16, 27, 28, 29, 30, 31, 32, 34, 35, 36, 37, 38, 39, 43, 45, 57, 58, 59, 60, 61, 62, 64, 65, 66, 67, 68, 69, 71, 72, 73, 74, 75, 76}, s.getLineNumbers().toArray());
      
      s = map.get("gonna");
      assertTrue(s.isWord());
      assertEquals(42, s.getOccurrences());
      assertArrayEquals(new Integer[] {11, 12, 13, 14, 15, 16, 22, 27, 28, 29, 30, 31, 32, 34, 35, 36, 37, 38, 39, 43, 43, 45, 45, 52, 57, 58, 59, 60, 61, 62, 64, 65, 66, 67, 68, 69, 71, 72, 73, 74, 75, 76}, s.getLineNumbers().toArray());

      s = map.get("We're");
      assertFalse(s.isWord());
      assertEquals(1, s.getOccurrences());
      assertArrayEquals(new Integer[] {3}, s.getLineNumbers().toArray());
     
      s = map.get("asdf");
      assertEquals(null, s);
   }

   @Test
   public void testIsWord() throws FileNotFoundException {
      //make SpellChecker
      SpellChecker SC = new SpellChecker("testDict.txt");
         
      //test isWord
      assertFalse(SC.isWord("this"));
      assertFalse(SC.isWord("t"));
      assertTrue(SC.isWord("are"));
      assertTrue(SC.isWord("valid"));
      assertTrue(SC.isWord("words"));
      assertTrue(SC.isWord("skyblue"));
      assertTrue(SC.isWord("gonna"));
      assertTrue(SC.isWord("asdf"));
      assertTrue(SC.isWord("matt"));
      assertTrue(SC.isWord("the"));
      assertTrue(SC.isWord("end"));
      assertFalse(SC.isWord("e"));
      assertFalse(SC.isWord("sky"));
   }

   @Test
   public void testGetDict() throws FileNotFoundException {
      //make SpellChecker
      SpellChecker SC = new SpellChecker("testDict.txt");
      
      //test getDict
      HashTableSC t = SC.getDictionary();
      assertEquals(10, t.size());
         
   }
   
   //Normal doc to 1 line converter
   /*@Test
   public void testFileConversion() throws FileNotFoundException {
      Scanner in = new Scanner(new File("processFileTest_War_And_Peace.txt"));
      PrintWriter o = new PrintWriter("war1line.txt");//, "UTF-8");
      in.useDelimiter("");
      while (in.hasNext()) {
         o.write(in.nextLine()+"\\n");
      }
      o.close();
   }*/

   /*broken??
   @Test(expected=FileNotFoundException.class)
   public void testError() {
      new SpellChecker("notAFile.file");
   }*/
}
