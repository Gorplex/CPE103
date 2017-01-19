import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
/* MorseToText
 *
 * @author John Thomsen
 * @version porject4
 */

public class MorseToTextTests {
   static MorseToText t = new MorseToText();   
   
   @Test
   public void testTree() {
      BST<MorseOrder> tree = t.getBST();
      assertEquals(54, tree.size());
      assertEquals(5, tree.treeHeight());
      assertEquals(213l, tree.internalPathLength());
      for (int i = 0; i < MorseOrder.size(); i++) {
         assertEquals(true, tree.contains(new MorseOrder(MorseOrder.get(i))));
      }
   }
   
   @Test
   public void testTrans0()
   {
      assertEquals("", t.translate(""));
   }
   
   @Test
   public void testTrans1()
   {
      assertEquals("A", t.translate(".-"));
   }
   
   @Test
   public void testTrans2()
   {
      assertEquals("ABC", t.translate(".- -... -.-."));
   }
   
   @Test
   public void testTrans3()
   {
      assertEquals("A", t.translate("    .-    "));
   }

   @Test
   public void testTrans4()
   {
      assertEquals("@_$+\"", t.translate("-..-.- ..--.- ...-..- .-.-. .-..-."));
   }
   
   @Test
   public void testTrans5()
   {
      assertEquals("AB CD", t.translate(".- -...  -.-. -.."));
   }
   
   @Test
   public void testTrans6()
   {
      assertEquals("AB    CD", t.translate(".- -...     -.-. -.."));
   }
   
   @Test
   public void testTrans7()
   {
      assertEquals("AB CD", t.translate("{{{{ .- -...  {{{{{{{ {{{{ -.-. -.. {{{{{"));
   }
}
