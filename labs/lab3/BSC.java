import java.lang.*;
/*Balenced Symbol Checker
 *
 *@author John Thomsen
 *@version lab3
 */

public class BSC {
   private static SimpleArrayStack<Character> st;
   private static final Character[][] symbols = {{'(',')'}, {'[',']'}, {'{','}'}, {'<','>'}};

   public static boolean isBalanced(String string) {
      st = new SimpleArrayStack<>();
      for (Character ch: string.toCharArray()) {
         for (Character[] set: symbols) {
            if (!checkChar(ch, set)) {return false;}       
         }
      }
      if (st.size() != 0) {return false;}
      return true;
   }

   private static boolean checkChar(Character ch, Character[] set) {
      if (ch.equals(set[0])) {
            st.push(ch);
         }
      if (ch.equals(set[1])) {
         if (st.size() == 0) {return false;
         }else{
            if (!st.peek().equals(set[0])) { return false;
            }else{ st.pop(); 
            }
         }
      }
      return true;
   }
}
