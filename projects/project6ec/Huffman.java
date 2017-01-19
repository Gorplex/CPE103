import java.lang.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

/* Huffam
 *
 * @author John Thomsen
 * @version proj 6 ec
 */


public class Huffman {
   private Node root;
   private HashMap<Character,String> codes = new HashMap<>();

   public Huffman(String fileName) throws FileNotFoundException, IOException {
      HashMap<Character,Node> map = new HashMap<>();//count occurances
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
      
      //add end of file char to tree EC
      map.put((char)4, new Node((char)4));

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
      BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outfileName));
      BufferedInputStream in = new BufferedInputStream(new FileInputStream(infileName));
      char nxt = (char) in.read();
      byte outBuf = 0;
      //to make index passable (for outBuf)
      byte[] i = new byte[1];
      i[0] = 0;
      while ((byte)nxt != -1) {
         //System.out.println(nxt);
         outBuf = writeCode(outBuf, i, codes.get(nxt), out);
         nxt = (char) in.read();
      }
      outBuf = writeCode(outBuf, i, codes.get((char)4), out);
      if (i[0] != 0) {
         out.write((char)outBuf);
         //System.out.println("outBuf: " + outBuf);
      }
      in.close();
      out.close();
   }

   private byte writeCode(byte outBuf, byte[] i, String code, BufferedOutputStream out) throws IOException {
      for (char ch: code.toCharArray()) {
         //System.out.println(i[0]);
         outBuf = addAt(outBuf, i[0], ch);
         i[0]++;
         if (i[0] >= 8) {
            out.write((char)outBuf);
            //System.out.println("outBuf: " + outBuf);
            outBuf = 0;
            i[0] = 0;
         }
      }
      return outBuf;
   }

   private byte addAt(byte buf, byte index, char toAdd) {
      //don't look it works trust me
      switch (index) {
         case 0:
            if (toAdd == '0') {
               return (byte)(127 & buf);
            } else {
               return (byte)(-128 | buf);
            }
         case 1:
            if (toAdd == '0') {
               return (byte)(-65 & buf);
            } else {
               return (byte)(64 | buf);
            }
         case 2:
            if (toAdd == '0') {
               return (byte)(-33 & buf);
            } else {
               return (byte)(32 | buf);
            }
         case 3:
            if (toAdd == '0') {
               return (byte)(-17 & buf);
            } else {
               return (byte)(16 | buf);
            }
         case 4:
            if (toAdd == '0') {
               return (byte)(-9 & buf);
            } else {
               return (byte)(8 | buf);
            }
         case 5:
            if (toAdd == '0') {
               return (byte)(-5 & buf);
            } else {
               return (byte)(4 | buf);
            }
         case 6:
            if (toAdd == '0') {
               return (byte)(-3 & buf);
            } else {
               return (byte)(2 | buf);
            }
         case 7:
            if (toAdd == '0') {
               return (byte)(-2 & buf);
            } else {
               return (byte)(1 | buf);
            }
      }
      //should not be reached
      return 0;
   }
   
   public void decompress(String infileName, String outfileName) throws FileNotFoundException, IOException {
      BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outfileName));
      BufferedInputStream in = new BufferedInputStream(new FileInputStream(infileName));
      Node node = root;
      byte inBuf = (byte) in.read();
      //System.out.println("inBuf: " + inBuf);
      byte i = 0;
      while (true) {
         while (node.left != null) {
            //check msb (1 = neg = go right)
            if (inBuf >= 0) {
               node = node.left;        
            } else {
               node = node.right;
            }
            //incr working bit
            //check if you need new buff
            if (i >= 7) {
               inBuf = (byte) in.read();
               //System.out.println("inBuf: " + inBuf);
               i = 0;
            } else {
               //shift! and incr shift counter
               inBuf  = (byte)(inBuf<<1);
               i++;
            }
         }
         char ch = node.sym;
         if ((byte)ch == 4) {
            break;
         }
         out.write(ch);
         node = root;
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
      protected int val;
      protected char sym;
      private Node left;
      private Node right;
      private Node(char sym) {
         val = 1;
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
