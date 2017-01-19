/**
 * A partial implementation of a directed graph class to explore
 * Dijkstra's shortest-path algorithm.
 *
 * @author Hatalsky/Jones - Provided partial solution
 * @author John Thomsen - Completed by
 * @version CPE 103 Lab 13
 */
import java.io.*;
import java.util.*;

public class DiGraph {
   /* Provided/Required */
   private TreeMap<String, Vertex> vertices = new TreeMap<String, Vertex>();

   /* Provided/Required - should not need to modify
    * The edge class is used such that we may store the weights easily. */
   private static class Edge {
      private Vertex dest;
      private double weight;

      public Edge(Vertex dest, double weight) {
         this.dest = dest;
         this.weight = weight;
      }
   }

   /* Provided/Required - should not need to modify */
   private static class Vertex implements Comparable<Vertex> {
      private String name;
      private TreeMap<String, Edge> edges = new TreeMap<String, Edge>();
      private boolean known;
      private double distance = Double.POSITIVE_INFINITY;
      private Vertex prior;

      public Vertex(String name) {
         this.name = name;
      }

      public void addEdge(Vertex adj, double weight) {
         // TreeMap put() returns null when no matching element in tree 
         if (edges.put(adj.name, new Edge(adj, weight)) != null) {
            throw new IllegalArgumentException("Duplicate edge");
         }
      }

      // Used by priority queue used in Dikstra's shortest path algorithm.
      public int compareTo(Vertex that) {
         return ((Double)this.distance).compareTo(that.distance);
      }

      public String toString() {
         return this.name;
      }

      // For debugging purposes if and as necessary...
      public String debugToString() {
         StringBuilder sb = new StringBuilder()
            .append("Vertex name: ").append(name)
            .append("\nKnown: ").append(known)
            .append("\nPrior: ").append(prior)
            .append("\nDistance: ").append(distance)
            .append("\nAdjacencies:");

         for (String name : edges.keySet()) {
            sb.append(' ').append(name);
         }

         return sb.toString();
      }
   } // End class Vertex

   /**
    * Constructs a directed graph from a file containing the weighted
    * edges.  A weighted edge is specified as three values, separated
    * by whitespace, in the following order: the from-vertex as a
    * String, the to-vertex as a String, and the weight as a double.
    *
    * @param fileName the name of a file containing the weighted
    * edges (see the method's detailed description for the file's
    * format).
    *
    * @throws FileNotFoundException if the file is not found
    * @throws IllegalArgumentException if:
    * <ul>
    *   <li>the file is empty</li>
    *   <li>the input is mal-formed</li>
    *   <li>the graph contains a negative edge</li>
    * </ul>
    */
   public DiGraph(String fileName) throws FileNotFoundException {
      // TODO: Complete the constructor
      Scanner in = new Scanner(new File(fileName));
      if (!in.hasNext()) {throw new IllegalArgumentException("the file is empty");}
      while (in.hasNext()) {
         //inputs
         String key1 = in.next();
         String key2;
         double path;
         
         //check valid inputs
         if (!in.hasNext()) {throw new IllegalArgumentException("the input is mal-formed");}else{
            key2 = in.next();
         }
         if (!in.hasNextDouble()) {throw new IllegalArgumentException("the input is mal-formed");}else{
            path = in.nextDouble();
            if (path < 0) {throw new IllegalArgumentException("the graph contains a negative edge");}
         }

         //make vertex if needed
         Vertex v1 = vertices.get(key1);
         if (v1 == null) {
            v1 = new Vertex(key1);
            vertices.put(key1, v1);
         }
         Vertex v2 = vertices.get(key2);
         if (v2 == null) {
            v2 = new Vertex(key2);
            vertices.put(key2, v2);
         }

         //v1.edges.put(key2, new Edge(v2, path));
         v1.addEdge(v2, path);
         
         
      }
   }

   /**
    * Applies Dijkstra's shortest path algorithm to the graph using
    * the specified vertex as the starting vertex. 
    *
    * @param from The name of the starting vertex.
    *
    * @throws IllegalArgumentException if the specified vertex is not
    * in the graph
    */
   public void setStart(String from) {
      // TODO: Complete setStart
      Vertex v0 = vertices.get(from);
      if (v0 == null) {throw new IllegalArgumentException("the specified vertex is not in the graph");}
   
      //init
      for (Vertex v: vertices.values()) {
         v.known = false;
         v.distance = Double.POSITIVE_INFINITY;
         v.prior = null;
      }
      
      v0.distance = 0;
      //PriorityQueue<Vertex> q = new PriorityQueue<>();
      PriorityQueue<Vertex> q = new PriorityQueue<>(vertices.values());
      //q.add(v0);
      
      while (q.size() > 0) {
         v0 = q.poll();
         v0.known = true;

         for (Edge e0: v0.edges.values()) {
            if (e0.dest.known == false) {
               //check shorter
               double dist = v0.distance + e0.weight;
               if (dist < e0.dest.distance) {
                  //System.out.println(e0.dest);
                  //System.out.println(e0.dest.distance);
                  
                  e0.dest.distance = dist;
                  e0.dest.prior = v0;
                  q.remove(e0.dest);
                  q.add(e0.dest);
               }
            }
         }
      }
   }

   /**
    * Provided: Returns a shortest path to the specified vertex from
    * the current start-vertex. 
    *
    * @param to the to-vertex whose path you want
    * @return the path from the current start-vertex to the specified
    * to-vertex
    */
   public String getPathTo(String to) {
      StringBuilder path = new StringBuilder();
      getPathTo(vertices.get(to), path);

      return path.toString();
   }
   
   /*
    * Provided: Recursive helper method for public getPathTo().
    */
   private void getPathTo(Vertex v, StringBuilder path) {
      if (v.prior != null) {
         getPathTo(v.prior, path);
         path.append(' ');
      }

      path.append(v.name);
   }

   /**
    * Provided: Returns the distance of the shortest path to the
    * specified vertex to the current start-vertex. 
    *
    * @param to the to-vertex whose distance you want
    * @return the distance from the current start-vertex to the
    * specified to-vertex
    */
   public double getDistanceTo(String to) {
      return vertices.get(to).distance;
   }
}
