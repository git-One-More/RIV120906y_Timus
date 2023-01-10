package Timus;
import java.util.Scanner;

import static java.lang.Math.sqrt;
public class Ex1001_Reverse_Root {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] roots = new double[256*1000];
        int k = 0;
        while (sc.hasNextLong()) {
            roots[k++] = sqrt(sc.nextLong());
        }
        for (int i = k - 1; i >= 0; i--)
             System.out.printf("%.4f\n", roots[i]);
    }
}

