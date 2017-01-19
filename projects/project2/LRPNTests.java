/**
 * JUnit tests for reverse polish.
 *
 * @author  L
 * @version Project 2
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LRPNTests {

   
   /******************************************************************
   EVALUATE RPN

   ******************************************************************/

   
   @Test
   public void test01_evaluateRPN_addMult() {
   
      assertEquals((double)300, RPN.evaluateRPN("2 3 + 60 *"), .00001);
   }

   @Test
   public void test02_evaluateRPN_div() {
   
      assertEquals((double) 0.666666666, RPN.evaluateRPN("2 3 /"), .0000001);
   }   

   @Test
   public void test03_evaluateRPN_example() {
   
      assertEquals((double)14, RPN.evaluateRPN("5 1 2 + 4 * + 3 -"), .00001);
   }
   @Test
   public void test05_evaluateRPN_multiOperations() {
   
      assertEquals((double)2, RPN.evaluateRPN("4 2 5 * + 1 3 2 * + /"), .00001);
   }   
   @Test
   public void test06_evaluateRPN_floats() {
   
      assertEquals((double)4, RPN.evaluateRPN("4.4  1.1 /"), 0);
   }
   @Test
   public void test07_evaluateRPN_floatsRepeated() {
   
      assertEquals((double)4.3030303, RPN.evaluateRPN("2  6.6 / 4 +"), .00001);
   }



   /******************************************************************
   EVALUATE INFIX

   ******************************************************************/

   @Test
   public void test21_evaluateInfix_simple() {
   
      assertEquals((double)37, RPN.evaluateInfix("5 + 2 + 3 * 10"), 0);
   }
   
   @Test
   public void test22_evaluateInfix_example() {
   
      assertEquals((double)14, RPN.evaluateInfix("5 + ( 1 + 2 ) * 4 - 3"), 0);
   }

   @Test
   public void test23_evaluateInfix_complicated() {
   
      assertEquals((double)-207.46301, RPN.evaluateInfix("5 + ( 1 + 2 ) * 4 - 3 * 72.4 - 7 * 2.2 + 9 / ( 3 + 4 / 1.1 ) * 6"), .00001);
   }

   @Test
   public void test24_evaluateInfix_paraenthesis() {
   
      assertEquals((double)14, RPN.evaluateInfix("( ( ( ( ( ( ( ( ( ( 5 + ( 1 + 2 ) * 4 - 3 ) ) ) ) ) ) ) ) ) )"), 0);
   }

   @Test
   public void test25_evaluateInfix_negative() {
   
      assertEquals((double)-2, RPN.evaluateInfix("-2 / 3 * 3 / 1"), 0);
   }


   @Test
   public void test26_evaluateInfix_number() {
   
      assertEquals((double) 42, RPN.evaluateInfix("42"), 0);
   }


   /******************************************************************
    INFIX TO RPN

   ******************************************************************/

   @Test
   public void test41_ToRPN_simple() {
   
      assertEquals("5 2 + 3 10 * +", RPN.toRPN("5 + 2 + 3 * 10"));
   }


   
}
