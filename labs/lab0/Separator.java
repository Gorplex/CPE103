import java.util.*;

public class Separator {
    public static void main(String[] args) {
        //const
        final int MAX = 6;

        //init
        Scanner in = new Scanner(System.in);
        Integer[] arrI = new Integer[MAX];
        int indexI = 0;
        Float[] arrF = new Float[MAX];
        int indexF = 0;

        //loop till invalid input
        while ( in.hasNextInt() || in.hasNextFloat() ) {
            if (in.hasNextInt()) {
                if (indexI >= MAX) {
                    break;
                }
                arrI[indexI] = in.nextInt();
                indexI++;
            } else {
                if (indexF >= MAX) {
                    break;
                }
                arrF[indexF] = in.nextFloat();
                indexF++;
            }
        }

        //output
        System.out.print("Integers: ");
        for (Integer x: arrI) {
            if (x != null) {
                System.out.print(x + " ");
            }
        }
        System.out.print("\nFloats: ");
        for (Float x: arrF) {
            if (x != null) {
                System.out.print(x + " ");
            }
        }
        System.out.println();
    }
}



