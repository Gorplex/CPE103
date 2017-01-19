import java.lang.*;
import java.util.*;
/* MorseToText
 *
 * @author John Thomsen
 * @version porject4
 */

public class MorseToText implements BSTTranslator<MorseOrder> {
   private BST<MorseOrder> codeTree;
   
   public MorseToText() {
      codeTree = new BST<>();
      MorseOrder[] codes = new MorseOrder[MorseOrder.size()];
      for (int i = 0; i < codes.length; i++){
         codes[i] = new MorseOrder(MorseOrder.get(i));
      }
      Arrays.sort(codes);
      adder(codeTree, codes, 0, codes.length-1);

   }
   private void adder(BST<MorseOrder> t, MorseOrder[] codes, int min, int max) {
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

   public BST<MorseOrder> getBST() {
      return codeTree;
   }

   public String translate(String s) {
      StringBuilder out = new StringBuilder();
      Scanner in = new Scanner(s);
      in.useDelimiter(" ");
      while (in.hasNext()) {
         String nxt = in.next();
         if (nxt.equals("")) {
            out.append(" ");
         } else {
            try {
               out.append(codeTree.get(new MorseOrder(' ', nxt)).getCharacter());
            } catch (NoSuchElementException e) {
            }
         }
      }
      //LAGACY CODE (replaced by trim)
      //int len = out.length();
      //if (len > 0) {
      //   out.delete(len-1, len);//to remove last space
      //}
      return out.toString().trim();
   }
}
