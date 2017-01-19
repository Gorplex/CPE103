/**
 * JUnit tests for Shell Sorts
 *
 * @author   Luke Thompson
 * @version lab 11
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.runners.MethodSorters;
import java.math.BigInteger;
import java.io.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TSortTestsL {


   @Test
   public void test1() throws IOException, InterruptedException { 

      Runtime rt = Runtime.getRuntime();
      Process pr;

      for(int i = 1; i < 5; i++) {
	 pr = rt.exec("./test.sh tests/in" + i + ".txt tests/out" + i +".txt");

	 pr.waitFor();

	 assertTrue("failed test: " + i, pr.exitValue() == 0);
      }
      
   }


   

}



/*
test.sh

#!/bin/sh


java TSort $1 > out.tmp

diff -wB out.tmp $2


*/
