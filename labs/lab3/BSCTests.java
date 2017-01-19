import org.junit.*;
import static org.junit.Assert.*;

/*BSC tests
 *@author John Thomsen
 *@version lab3
 */

public class BSCTests {
   @Test
   public void testPar() {
      assertTrue(BSC.isBalanced("()"));
   }
   
   @Test
   public void testBrack() {
      assertTrue(BSC.isBalanced("[]"));
   }

   @Test
   public void testBrace() {
      assertTrue(BSC.isBalanced("{}"));
   }

   @Test
   public void testArr() {
      assertTrue(BSC.isBalanced("<>"));
   }

   @Test
   public void testPar2() {
      assertFalse(BSC.isBalanced("("));
   }
   
   @Test
   public void testBrack2() {
      assertFalse(BSC.isBalanced("["));
   }
 
   @Test
   public void testBrace2() {
      assertFalse(BSC.isBalanced("{"));
   }

   @Test
   public void testArr2() {
      assertFalse(BSC.isBalanced("<"));
   }

   @Test
   public void testPar3() {
      assertFalse(BSC.isBalanced(")"));
   }
   
   @Test
   public void testBrack3() {
      assertFalse(BSC.isBalanced("]"));
   }
   
   @Test
   public void testBrace3() {
      assertFalse(BSC.isBalanced("}"));
   }

   @Test
   public void testArr3() {
      assertFalse(BSC.isBalanced(">"));
   }

   @Test
   public void testGen1() {
      assertTrue(BSC.isBalanced("(())"));
   }
   
   @Test
   public void testGen2() {
      assertTrue(BSC.isBalanced("[]{}"));
   }
   
   @Test
   public void testGen3() {
      assertTrue(BSC.isBalanced("( [ { < ( ) <( ){}>> } ] )"));
   }

   @Test
   public void testGen4() {
      assertTrue(BSC.isBalanced("[(Hello) {W}orld!]"));
   }

   @Test
   public void testGen5() {
      assertTrue(BSC.isBalanced("((((((((((((((((((((()))))))))))))))))))))"));
   }

   @Test
   public void testGen6() {
      assertFalse(BSC.isBalanced("[[[[[[[[[[[]]>>))}}]]"));
   }

   @Test
   public void testGen7() {
      assertTrue(BSC.isBalanced("[[[[][]][[][]]][[[][]][[][]]]]"));
   }

   @Test
   public void testGen8() {
      assertFalse(BSC.isBalanced("([{<,qweqrerttytrey      dfgd d gh "));
   }
   
   @Test
   public void testGen9() {
      assertTrue(BSC.isBalanced("((\n))"));
   }

   @Test
   public void testGen10() {
      assertFalse(BSC.isBalanced("((\n)"));
   }

   @Test
   public void testGen11() {
      assertTrue(BSC.isBalanced("(1(134)7)"));
   }
}
