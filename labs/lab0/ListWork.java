import java.util.*;
import java.io.*;
import java.lang.*;

public final class ListWork {
    public static void main(String[] args) {
        //init array
        Integer[] arr = new Integer[10];
        //init scanner
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter 10 Integers");
        //loop array 4 inputs
        for (int i=0;i<10;i++) {
            String rawIn = in.next();
            //test if int, convert, and  insert into array
            try {
                arr[i] = Integer.valueOf(rawIn);
            } catch (NumberFormatException e){

            }
        }

        //user menu to search/print
        //String rawIn = "";
        //while (!(rawIn.equals("e")||rawIn.equals("exit"))){
        //    System.out.println("(s)earch,(p)rint, or (e)xit");
        //    rawIn = in.next();
        //    if (rawIn.equals("s")) {
                //get target
        //        System.out.println("Target Int");
        //        rawIn = in.next();
                // test target, search and print result
        //        try {
        //            if(search(arr, Integer.valueOf(rawIn))) {
        //                System.out.println("target in array");
        //            } else {
        //                System.out.println("target not in array");
        //            }
        //        } catch (NumberFormatException e) {
        //            System.out.println("Non-int Imput");
        //        }
        //    }
            //print
        //    else if(rawIn.equals("p")) {
        //        print(arr);
        //    }
        //}

        System.out.println("do you want to search? (y)es or(n)o");
        String rawIn = in.next();
        while (rawIn.equals("y")) {
                //get target
                System.out.println("Target Int");
                rawIn = in.next();
                // test target, search and print result
                try {
                    if(search(arr, Integer.valueOf(rawIn))) {
                        System.out.println("target in array");
                    } else {
                        System.out.println("target not in array");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Non-int Imput");
                }
            System.out.println("do you want to search? (y)es or(n)o");
            rawIn = in.next();
        }
        print(arr);
    }
    //print int array
    public static <T> void print(T[] arr) {
        for (T x: arr) {
            System.out.println(x);
        }
    }
    //search int arry for target
    public static <T> boolean search(T[] arr, T target) {
        if (target == null) {
            for (T x:arr) {
                if(x == null) {
                    return true;
                }
            }
        } else {   
            for (T x:arr) {
                if (x != null) {
                    if(x.equals(target)) {
                        return true;
                    }
                }
            }
        }
        return false;    
    }
}
