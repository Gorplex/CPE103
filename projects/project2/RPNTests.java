import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

/*RPN tests
 *
 *@author John Thomsen
 *@version paroject2
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RPNTests {
   @Test
   public void testRPNadd() {
      assertEquals(4, RPN.evaluateRPN("1 3 +"), .000000001);   
   }
   @Test
   public void testRPNsub() {
      assertEquals(2, RPN.evaluateRPN("3 1 -"), .000000001);   
   }
   @Test
   public void testRPNmul() {
      assertEquals(3, RPN.evaluateRPN("1 3 *"), .000000001);   
   }
   @Test
   public void testRPNdiv() {
      assertEquals(3, RPN.evaluateRPN("3 1 /"), .000000001);   
   }
   @Test
   public void testInfixAdd() {
      assertEquals(4, RPN.evaluateInfix("3 + 1"), .000000001);   
   }
   @Test
   public void testInfixSub() {
      assertEquals(2, RPN.evaluateInfix("3 - 1"), .000000001);   
   }
   @Test
   public void testInfixMul() {
      assertEquals(3, RPN.evaluateInfix("3 * 1"), .000000001);   
   }
   @Test
   public void testInfixDiv() {
      assertEquals(4, RPN.evaluateInfix("4 / 1"), .000000001);   
   }

   @Test
   public void testRPN1() {
      assertEquals(14, RPN.evaluateRPN("5 1 2 + 4 * + 3 -"), .000000001);   
   }

   @Test
   public void testRPN2() {
      assertEquals(-5.4/.56, RPN.evaluateRPN("-5.4 .56 /"), .000000001);   
   }

   @Test
   public void testRPN3() {
      assertEquals(-143.2, RPN.evaluateRPN("286.4 -2 /"), .000000001);   
   }

   @Test
   public void testToRPN00() {
      assertEquals("4 5 +", RPN.toRPN("( ) ( ) 4 + 5 ( )"));   
   }
   @Test
   public void testToRPN000() {
      assertEquals("8 3 4 * + 6 2 - 2 6 3 / 1 - * + 3 - +", RPN.toRPN("8 + 3 * 4 + ( 6 - 2 + 2 * ( 6 / 3 - 1 ) - 3 )"));   
   }
   @Test
   public void testToRPN0() {
      assertEquals("6 3 / 1 - 3 -", RPN.toRPN("( 6 / 3 - 1 ) - 3"));   
   }
   @Test
   public void testToRPN1() {
      assertEquals("5 1 2 + 4 * + 3 -", RPN.toRPN("5 + ( 1 + 2 ) * 4 - 3"));   
   }
   @Test
   public void testToRPN2() {
      assertEquals("1 2 + 3 +", RPN.toRPN("1 + 2 + 3"));   
   }
   @Test
   public void testToRPN3() {
      assertEquals("1 2 3 + +", RPN.toRPN("1 + ( 2 + 3 )"));   
   }
   @Test
   public void testToRPN4() {
      assertEquals("1 2 3 4 * + +", RPN.toRPN("1 + ( 2 + 3 * 4 )"));   
   }
   @Test
   public void testToRPN5() {
      assertEquals("1 2 3 4 * 5 / + +", RPN.toRPN("1 + ( 2 + 3 * 4 / 5 )"));   
   }
   @Test
   public void testToRPN6() {
      assertEquals("1 2 3 4 * 5 / + +", RPN.toRPN("1  +  (  2  +   3  *  4  /  5         )"));   
   }
   @Test
   public void testToRPN7() {
      assertEquals("4 14 + 1 1 30 / 1 16 1 1 20 / 1 15 / + 1 10 / + 1 12 18 + / + / + / + / +", RPN.toRPN("4 + 14 + 1 / ( 1 / 30 + 1 / ( 16 + 1 / ( 1 / 20 + 1 / 15 + 1 / 10 + 1 / ( 12 + 18 ) ) ) )"));   
   }
   @Test
   public void testInfix00() {
      assertEquals(30, RPN.evaluateInfix("4 + 14 + 1 / ( 1 / 30 + 1 / ( 16 + 1 / ( 1 / 20 + 1 / 15 + 1 / 10 + 1 / ( 12 + 18 ) ) ) )"), .000000001);   
   }
   @Test
   public void testToRPN8() {
      assertEquals("1000 1 1 2000 / 1 250 1 1 750 / 1 1500 / + 1 500 / + / + / + / +", RPN.toRPN("1000 + 1 / ( 1 / 2000 + 1 / ( 250 + 1 / ( 1 / 750 + 1 / 1500 + 1 / 500 ) ) )"));   
   }
   @Test
   public void testInfix0() {
      assertEquals(-600.5, RPN.evaluateInfix("-1000.5 + 1 / ( 1 / 2000 + 1 / ( 250 + 1 / ( 1 / 750 + 1 / 1500 + 1 / 500 ) ) ) "), .000000001);   
   }
   @Test
   public void testInfix1() {
      assertEquals(14, RPN.evaluateInfix("5 + ( 1 + 2 ) * 4 - 3"), .000000001);   
   }

   @Test
   public void testInfix2() {
      assertEquals(14, RPN.evaluateInfix("5 + ( 1 + 2 ) * 4 - 3"), .000000001);   
   }

   @Test
   public void testInfix3() {
      assertEquals(0, RPN.evaluateInfix(""), .000000001);   
   }

   @Test
   public void testInfix4() {
      assertEquals(-3.1415, RPN.evaluateInfix("-3.1415"), .000000001);   
   }

   @Test
   public void testInfix5() {
      assertEquals(-12.126, RPN.evaluateInfix("( ( ( ( ( -12.126 ) ) ) ) )"), .000000001);   
   }
}
