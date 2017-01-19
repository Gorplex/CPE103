import java.lang.*;
import java.util.*;
/* TextToMorse
 *
 * @author John Thomsen
 * @version porject4
 */

public class TextToMorse implements BSTTranslator<CharacterOrder> {
   private BST<CharacterOrder> codeTree;
   
   public TextToMorse() {
      codeTree = new BST<>();
      CharacterOrder[] codes = new CharacterOrder[CharacterOrder.size()];
      for (int i = 0; i < codes.length; i++){
         codes[i] = new CharacterOrder(CharacterOrder.get(i));
      }
      Arrays.sort(codes);
      adder(codeTree, codes, 0, codes.length-1);

   }
   private void adder(BST<CharacterOrder> t, CharacterOrder[] codes, int min, int max) {
      int mid = (min+max+1)/2;//ceil instead of floor
      //skip on last call with odd list size
      if (min <= max) {
         t.insert(codes[mid]);
      }
      //base case skips this (on all last calls)
      if (min < max) {
         adder(t, codes, min, mid-1);
         adder(t, codes, mid+1, max);
      }
   }

   public BST<CharacterOrder> getBST() {
      return codeTree;
   }

   public String translate(String s) {
      StringBuilder out = new StringBuilder();
      for (char ch : s.toCharArray()) {
         if (ch == ' ') {
            out.append(' ');
         } else {
            try {
               out.append(codeTree.get(new CharacterOrder(ch, "")).getCode()+" ");
            } catch (NoSuchElementException e) {
            }
         }
      }
      //LAGACY CODE (.trim() replaces)
      //int len = out.length();
      //if (len > 0) {
      //   char[] lastChar = new char[1];
      //   out.getChars(len-1, len, lastChar, 0);
      //   if (lastChar[0] == ' ') {
      //      out.delete(len-1, len);//to remove last space
      //   }
      //}
      return out.toString().trim();
   }
}
