import java.util.*;
/*RPN
 *
 *@author John Thomsen
 *@version Project2
 */

public class RPN {
   public static double evaluateRPN(String expression) {
      SimpleLinkedStack<Double> stack = new SimpleLinkedStack<>();
      Scanner scan = new Scanner(expression);
      while (scan.hasNext()) {
         if (scan.hasNextDouble()) {
            stack.push(scan.nextDouble());
         }else{
            Double num;
            switch(scan.next()) {
            case "+":
               stack.push(stack.pop() + stack.pop());
               break;
            case "-":
               num = stack.pop();
               stack.push(stack.pop() - num);
               break;
            case "*":
               stack.push(stack.pop() * stack.pop());
               break;
            case "/":
               num = stack.pop();
               stack.push(stack.pop() / num);
               break;
            default:
               System.out.println("bad RPN in");
               return 0;
            }
         }
      }
      if (stack.size() == 0) {
         return 0;
      }
      return stack.pop();
   }
   public static String toRPN(String infix) {
      SimpleLinkedStack<String> stack = new SimpleLinkedStack<>();
      Scanner scan = new Scanner(infix);
      String out = "";
      while(scan.hasNext()) {
         if (scan.hasNextDouble()) {
            out += scan.next()+" ";
         }else{
            String ch = scan.next();
            switch(ch) {
               case("("):  
                  stack.push(ch);
                  break;
               case(")"):
                  while (!stack.peek().equals("(")) {
                     out += stack.pop()+" ";
                  }
                  stack.pop();
                  break;
               case("+")://FALLTHOUGH INTENDED
               case("-"):
                  while (stack.size()>0 && (stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("*") || stack.peek().equals("/"))) {
                     out += stack.pop()+" ";
                  }
                  stack.push(ch);
                  break;
               case("*")://FALLTHOUGH INTENDED
               case("/"):
                  while (stack.size()>0 && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                     out += stack.pop()+" ";
                  }
                  stack.push(ch);
                  break;
               default:
                  System.out.println("Char not reconized " +ch);
                  break;
            }
         }
      }
      while (stack.size() > 0) {
         out += stack.pop()+" ";
      }
      //pop last valuse without a spcae
      //if (stack.size()>0) {
      //   out += stack.pop();
      //}
      return out.trim();      
   }
   public static double evaluateInfix(String infix) {
      return evaluateRPN(toRPN(infix));
   }
}
