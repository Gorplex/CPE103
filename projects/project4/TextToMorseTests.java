import org.junit.*;
import static org.junit.Assert.*;
/* TextToMorseTests
 *
 * @author John Thomsen
 * @version porject4
 */

public class TextToMorseTests {
   static TextToMorse t = new TextToMorse();
   
   @Test
   public void testTree() {
      BST<CharacterOrder> tree = t.getBST();
      assertEquals(54, tree.size());
      assertEquals(5, tree.treeHeight());
      assertEquals(213l, tree.internalPathLength());
      for (int i = 0; i < CharacterOrder.size(); i++) {
         assertEquals(true, tree.contains(new CharacterOrder(CharacterOrder.get(i))));
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
      assertEquals(".-", t.translate("A"));
   }

   @Test
   public void testTrans2()
   {
      assertEquals(".- -... -.-.", t.translate("ABC"));
   }
   
   @Test
   public void testTrans3()
   {
      assertEquals(".-", t.translate("    A "));
   }

   @Test
   public void testTrans4()
   {
      assertEquals("-..-.- ..--.- ...-..- .-.-. .-..-.", t.translate("@{_$+\""));
   }
   
   @Test
   public void testTrans5()
   {
      assertEquals(".- -...  -.-. -..", t.translate("AB CD"));
   }
   
   @Test
   public void testTrans6()
   {
      assertEquals(".- -...     -.-. -..", t.translate("AB    CD"));
   }
   
   @Test
   public void testTrans7()
   {
      assertEquals(".- -...     -.-. -..", t.translate("{A{B  {[ }}}} C}}D}}}"));
   }
}
