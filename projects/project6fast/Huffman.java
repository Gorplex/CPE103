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
   private Node root;
   private HashMap<Character,String> codes = new HashMap<>(256);

   public Huffman(String fileName) throws FileNotFoundException, IOException {
      HashMap<Character,Node> map = new HashMap<>(256);//count occurances
      BufferedReader in = new BufferedReader(new FileReader(fileName));
      char key = (char) in.read();
      
      //count ocurances
      while ((byte)key != -1) {
         Node node = map.get(key);
         if (node == null) {
            map.put(key, new Node(key));
         } else {
            node.val++;        
         }
         key = (char) in.read();
      }
      
      //make queue
      PriorityQueue<Node> que = new PriorityQueue<>(map.values());//sort
      
      //tree stuff
      while(que.size() >= 2) {
         Node left = que.poll();
         Node right = que.poll();
         que.add(new Node(left.val+right.val, (char)Math.min((int)left.sym, (int)right.sym), left, right));
      }
      root = que.poll();

      //put all codes into Hashmap
      treeToHashMap(root, "");
   }
   
   private void treeToHashMap(Node node, String code) {
      if (node.left != null) {
         treeToHashMap(node.left, code+"0");
         treeToHashMap(node.right, code+"1");
      } else {
         codes.put(node.sym, code);
      }
   }

   public void compress(String infileName, String outfileName) throws FileNotFoundException, IOException {
      BufferedWriter out = new BufferedWriter(new FileWriter(outfileName));
      BufferedReader in = new BufferedReader(new FileReader(infileName));
      int nxt = in.read();
      while (nxt != -1) {
         out.write(codes.get((char)nxt));
         nxt = in.read();
      }
      in.close();
      out.close();
   
   }
   public void decompress(String infileName, String outfileName) throws FileNotFoundException, IOException {
      BufferedWriter out = new BufferedWriter(new FileWriter(outfileName));
      BufferedReader in = new BufferedReader(new FileReader(infileName));
      Node node = root;
      int nxt;
      while ((nxt = in.read()) != -1) {
         if (nxt == 48) {
            node = node.left;        
         } else {
            node = node.right;
         }
         if (node.left == null) {
            out.write(node.sym);
            node = root;
         }
      }
      in.close();
      out.close();
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("|");
      toString(root, sb);
      sb.append("|");
      return sb.toString();
   }
   
   private void toString(Node node, StringBuilder sb) {
      if (node.left != null) {
         toString(node.left, sb);
         toString(node.right, sb);
      } else {
         sb.append(node.sym);
      }
   }
   
   private class Node implements Comparable<Node> {
      private int val = 1;
      private char sym;
      private Node left = null;
      private Node right = null;
      private Node(char sym) {
         this.sym = sym;
      }
      private Node(int val, char sym, Node left, Node right) {
         this(sym);
         this.val = val;
         this.left = left;
         this.right = right;
      }
      public int compareTo(Node n) {
         int dif = ((Integer)this.val).compareTo(n.val);
         if (dif == 0) {
            return ((Character)this.sym).compareTo(n.sym);   
         } else {
            return dif;
         }
      }
   }
}
