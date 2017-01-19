import java.lang.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

/* Huffam
 *
 * @author John Thomsen
 * @version proj 6
 */


public class Huffman {
   private Leaf root;
   private HashMap<Character,String> codes = new HashMap<>();

   public Huffman(String fileName) throws FileNotFoundException, IOException {
      Scanner in = new Scanner(new File(fileName));//instream
      in.useDelimiter("");
      HashMap<Character,Leaf> map = new HashMap<>();//count occurances
      
      //count ocurances
      while (in.hasNext()) {
         char key = in.next().charAt(0);
         Leaf node = map.get(key);
         if (node == null) {
            map.put(key, new Leaf(key));
         } else {
            node.val++;        
         }
      }
      
      //make queue
      PriorityQueue<Leaf> que = new PriorityQueue<>(map.values());//sort
      
      //System.out.println(map.size());

      //tree stuff
      while(que.size() >= 2) {
         Leaf left = que.poll();
         Leaf right = que.poll();
         char lesser;
         if (left.sym <= right.sym) {
            lesser = left.sym;
         } else {
            lesser = right.sym;
         }
         que.add((Leaf)new Node(left.val+right.val, lesser, left, right));
      }
      root = que.poll();

      //put all codes into Hashmap
      treeToHashMap(root, "");
   }
   
   private void treeToHashMap(Leaf node, String code) {
      if (node instanceof Node) {
         treeToHashMap(((Node)node).left, code+"0");
         treeToHashMap(((Node)node).right, code+"1");
      } else {
         codes.put(((Leaf)node).sym, code);
      }
   }

   public void compress(String infileName, String outfileName) throws FileNotFoundException, IOException {
      PrintWriter out = new PrintWriter(outfileName);
      //out.print(encode(new Scanner(new File(infileName)).useDelimiter("\\Z").next()));
      out.print(encode(new String(Files.readAllBytes(Paths.get(infileName)))));
      out.close();
   }

   //legacy from old spec
   private String encode(String text) {
      StringBuilder sb = new StringBuilder();
      for (char ch: text.toCharArray()) {
         sb.append(codes.get(ch));
      }
      return sb.toString();
   }
   
   public void decompress(String infileName, String outfileName) throws FileNotFoundException, IOException {
      Writer out = new BufferedWriter(new FileWriter(outfileName));
      Reader in = new BufferedReader(new FileReader(infileName));
      Leaf node = root;
      int nxt = in.read();
      while (nxt != -1) {
         while (node instanceof Node && nxt != -1) {
            if (nxt == 48) {
               node = ((Node)node).left;        
            } else {
               node = ((Node)node).right;
            }
            nxt = in.read();
         }
         out.append(node.sym);
         node = root;
      }
      in.close();
      out.close();
   }
   
   /*
   public void decompress(String infileName, String outfileName) throws FileNotFoundException, IOException {
      PrintWriter out = new PrintWriter(outfileName);
      //out.print(decode(new Scanner(new File(infileName)).useDelimiter("\\Z").next()));
      out.print(decode(new String(Files.readAllBytes(Paths.get(infileName)))));
      out.close();
   }

   //legacy from old spec
   private String decode(String encoded) {
      StringBuilder sb = new StringBuilder();
      int len = encoded.length();
      int i = 0;
      while (len > i) {
         i = decode(root, sb, i, encoded.toCharArray());   
         //if (i%100==0) {System.out.println(i);} 
      }
      return sb.toString();
   }

   private int decode(Leaf node, StringBuilder sb, int i, char[] arr) {
      if (node instanceof Node) {
         if(arr[i++] == '0') {
            return decode(((Node)node).left, sb, i, arr);  
         } else {
            return decode(((Node)node).right, sb, i, arr);  
         }
      } else {
         sb.append(((Leaf)node).sym);
         return i;
      }
   }*/

   public String toString() {
      return "|"+toString(root)+"|";
   }
   
   private String toString(Leaf node) {
      StringBuilder sb = new StringBuilder();
      if (node instanceof Node) {
         sb.append(toString(((Node)node).left));
         sb.append(toString(((Node)node).right));
      } else {
         sb.append(((Leaf)node).sym);
      }
      return sb.toString();
   }
   
   /*
   private abstract class Node implements Comparable<Node> {
      protected int val;
      protected char sym;
      public int compareTo(Node n) {
         if (n == null) {throw new NullPointerException();}
         if (!(n instanceof Node)) {throw new ClassCastException();}else{
            return ((Integer)this.val).compareTo(n.val);
         }
      }
   }*/
   
   private class Leaf implements Comparable<Leaf> {
      protected int val;
      protected char sym;
      private Leaf(char sym) {
         val = 1;
         this.sym = sym;
      }

      public int compareTo(Leaf n) {
         if (n == null) {throw new NullPointerException();}
         if (!(n instanceof Leaf)) {throw new ClassCastException();}else{
            int dif = ((Integer)this.val).compareTo(n.val);
            if (dif == 0) {
               return ((Character)this.sym).compareTo(n.sym);   
            } else {
               return dif;
            }
         }
      }
   }

   private class Node extends Leaf {
      private Leaf left, right;
      private Node(int val, char sym, Leaf left, Leaf right) {
         super(sym);
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }
}
