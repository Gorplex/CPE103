/**
 * Trivial JUnit test for Hash Table.
 *
 * @author Brian Jones
 * @version 11/11/2016 Developed for CPE 103 Program 5
 */
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.MethodSorters;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpellCheckerSampleTests {
   // This test has no assertions because it's not testing correctness.  Feel
   // free to modify this test to assert correctness.  Storing the results is
   // done for compile time type checking of your return types.
   @Test
   public void test01_correctMethodNames() throws FileNotFoundException {
      // You'll need dictionary.txt in the same directory
      SpellChecker checker = new SpellChecker();
      SpellChecker checker2 = new SpellChecker("dictionary.txt");

      boolean b1 = checker.isWord("hello");
      HashTableSC<String> table = checker.getDictionary();
      HashMap<String, SpellChecker.MyStats> map = checker.processFile("dictionary.txt");


      SpellChecker.MyStats stats = map.get("hello");
      // If you NullPointerException here, it means your processFile didn't
      // find hello in the dictionary
      List<Integer> l = stats.getLineNumbers();
      int i = stats.getOccurrences();
      boolean b2 = stats.isWord();
   }
} 
