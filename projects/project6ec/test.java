public class test {
   public static void main(String[] args) {
      byte a = 60; /* 60 = 0011 1100 */
      byte b = 13; /* 13 = 0000 1101 */
      int c = 0;

      c = a & b; 
      System.out.println("a & b = " + c );

   }
}
