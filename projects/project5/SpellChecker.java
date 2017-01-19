import java.util.*;
import java.io.*;
/* SpellChecker
 *
 * @author John Thomsen
 * @version project5
 */

public class SpellChecker {
   private HashTableSC<String> table;
   
   public class MyStats {
      private boolean isWord;
      private ArrayList<Integer> lines = new ArrayList<>();
      
      private MyStats(boolean isWord, Integer line) {
         this.isWord = isWord;
         lines.add(line);
      }

      public int getOccurrences() {
         return lines.size();
      }
      public List<Integer>  getLineNumbers() {
         return lines;
      }
      public boolean isWord() {
         return isWord;
      }
   }
   
   public SpellChecker() throws FileNotFoundException {
      this("dictionary.txt");
   }
   public SpellChecker(String fileName) throws FileNotFoundException {
      Scanner in = new Scanner(new File(fileName));
      table = new HashTableSC<>(267119);
      while (in.hasNext()) {
         table.add(in.next());
      }
   }
   
   public boolean isWord(String s) {
      return table.contains(s) || table.contains(s.toLowerCase());
   }
   public HashTableSC<String> getDictionary() {
      return table;
   }
   public HashMap<String,SpellChecker.MyStats> processFile(String fileName) throws FileNotFoundException {
      Scanner in = new Scanner(new File(fileName));
      HashMap<String, SpellChecker.MyStats> map = new HashMap<>();
      Integer lineNum = 0; 
      while (in.hasNext()){
         lineNum++;
         Scanner line = new Scanner(in.nextLine());
         line.useDelimiter("[^\\w-']+");
         while (line.hasNext()) {
            String key = line.next();
            MyStats stats = map.get(key);
            if (stats == null) {
               map.put(key, new MyStats(isWord(key), lineNum));
            } else {
               stats.lines.add(lineNum); 
            }
         }
      }
      return map;
   }
}
