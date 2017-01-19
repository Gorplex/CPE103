/**
 * Provided starting point for Java-based tsort.
 *
 * @author Hatalsky/Jones - Starting point.
 * @author John Thomsen - Completed by.
 *
 * @version CPE 103 Lab 12
 */
import java.io.*;
import java.util.*;

public class TSort {
   // Hides the constructor form javadoc utility and users.
   private TSort() {}

   /**
    * Performs a topological sort of the specified directed acyclic graph.  The
    * graph is given as a string containing pairs of vertices representing
    * edges separated by spaces.  The resulting string will be formatted
    * identically to the Unix utility {@code tsort}.  That is, one vertex per
    * line in topologically sorted order.
    *
    * @param edges the edges of the DAG specified as space separated
    * vertex-pairs
    *
    * @return a topological ordering for the specified DAG
    *
    * @throws IllegalArgumentException if:
    * <ul>
    *   <li>edges is emtpy with the message "input contains no edges"</li>
    *   <li>edges has an odd number of vertices (incomplete pair) with the
    *   message "input contains an odd number of tokens"</li>
    *   <li>the graph contains a cycle (isn't acyclic) with the message "input
    *   contains a loop"</li>
    * </ul>
    */
   public static String tsort(String edges) {
      Scanner in = new Scanner(edges);
      
      //empty input exception
      if (!in.hasNext()) {throw new IllegalArgumentException("input contains no edges");}
      
      HashMap<String, Vertex> map = new HashMap<>();

      while (in.hasNext()) {
         String key1 = in.next();
         String key2;
         //check bad pair exception
         if (in.hasNext()) {
            key2 = in.next();
         } else {throw new IllegalArgumentException("input contains an odd number of tokens");}
         Vertex v1 = map.get(key1);
         Vertex v2 = map.get(key2);
         if (v2 == null) {
            v2 = new TSort().new Vertex(key2);
            map.put(key2, v2);
         }
         v2.inDeg++;
         if (v1 == null) {
            v1 = new TSort().new Vertex(key1);
            map.put(key1, v1);
         }
         v1.adjVer.add(v2);
      }
     
      /** LAGACY CODE (queue does not resort)*/ 
      /*
      //PriorityQueue<Vertex> que = new PriorityQueue<>(map.values());
      //lsit of verts to sub
      //ArrayList<Vertex> vertToSub = new ArrayList<>();
      //output stringbuilder
      
      //loop through vertices
      while (que.size() > 0) {
         //check first vertex
         if (que.peek().inDeg != 0) {throw new IllegalArgumentException("input contains a loop");}   
         
         //get all verticies of equal priority
         while (que.size() > 0 && que.peek().inDeg == 0) {
            Vertex vertIn = que.poll();
            //add to list of verts to sub
            vertToSub.add(vertIn);
            //put in output string
            out.append(vertIn.name + " ");
            System.out.println(que.peek().inDeg); 
         }
         System.out.println(Arrays.asList(que.toArray(new Vertex[1])));
         System.out.println(que.peek()); 
         //clear the to subtract list
         while (vertToSub.size() > 0) {
            Vertex vert = vertToSub.remove(vertToSub.size()-1);
            for (Vertex v : vert.adjVer) {
               System.out.println(v.inDeg);
               v.inDeg--;
               System.out.println(v.inDeg);
            }
         }
      }*/
      
      int size = map.size();
      System.out.println(map.values());
      
      StringBuilder out  = new StringBuilder();
      int[] numEle = {0};
      //recursive better!!!
      for (Vertex v : map.values()) {
         v.traverse(out, numEle, v);
      }
      if (size != numEle[0]) {throw new IllegalArgumentException("input contains a loop");}   
      return out.toString();
   }
   
   private class Vertex implements Comparable<Vertex> {
      private int inDeg = 0;
      private String name;
      private ArrayList<Vertex> adjVer = new ArrayList<>();
      private Vertex(String name) {
         this.name = name;
      }
      private void traverse(StringBuilder sb, int[] i, Vertex start) {
         if (inDeg == 0) {
            sb.append(name + "\n");
            i[0]++;
            inDeg--;
            for (Vertex v : adjVer) {
               if (v.name.equals(start.name)) {throw new IllegalArgumentException("input contains a loop");}   
               v.inDeg--;
               v.traverse(sb, i, start);
            }
         }
      }
      public int compareTo(Vertex o) {
         if (o == null) {throw new NullPointerException();}
         if (!(o instanceof Vertex)) {throw new ClassCastException();}else{
            return ((Integer)this.inDeg).compareTo(o.inDeg);
         }
      }
      public String toString() {
         return "" + name;
      }
   }

   /**
    * Entry point for the Java-based tsort utility allowing the user to specify
    * a file, redirect a file, or specify the input manually followed by
    * cntl-d to signal the end of input.
    */
   public static void main(String[] args) {
      Scanner scanner = null;

      if (args.length == 0) {
         scanner = new Scanner(System.in);
      } else if (args.length == 1) {
         try {
            scanner = new Scanner(new File(args[0]));
         } catch(FileNotFoundException e) {
            System.out.format("TSort: %s: No such file or directory\n", args[0]);
            System.exit(1);
         }
      } else {
         System.out.format("TSort: extra operand `%s'\n", args[1]);
         System.exit(1);
      }

      StringBuilder input = new StringBuilder();

      while(scanner.hasNext()) {
         input.append(scanner.next() + " ");
      }

      scanner.close();

      try {
         System.out.println(tsort(input.toString()));
      } catch(IllegalArgumentException e) {
         System.out.print("TSort: " + e.getMessage());
         System.exit(1);
      }
   }
}
