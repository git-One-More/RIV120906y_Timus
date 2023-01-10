package Timus;

import java.util.Scanner;

public class Ex1034_Queens_in_Peaceful_Positions {
    public static int Q[];
    public static int N;
    public static boolean isSafe(int q, int ignore1, int ignore2) {
        boolean safe = true;
        for (int i = 0; i < N; i++) {
            if (i == q || i == ignore1 || i == ignore2) {
                continue;
            }
            if ((Q[q] == Q[i]) || (Math.abs(q - i) == Math.abs(Q[q] - Q[i]))) {
                safe = false;
                break;
            }
        }
        return safe;
    }
    public static int QPerm(int q1, int q2, int q3) {
        
        int qperm = 0;
        int q1old = Q[q1];
        int q2old = Q[q2];
        int q3old = Q[q3];
        for (int i = 0; i < N; i ++) 
        {
            Q[q1] = i;
            if (q1old == i || !isSafe(q1, q2, q3)) {
                continue;
            }
            for (int j = 0; j < N; j++) 
            {
                Q[q2] = j;
                if (q2old == j || !isSafe(q2, q3, q3)) {
                    continue;
                }
                for (int k = 0; k < N; k++) {
                    Q[q3] = k;
                    if (q3old == k) {
                        continue;
                    }
                    if (isSafe(q3, q3, q3)) {
                        qperm++;
                    }
                }
            }
        }
        Q[q1] = q1old;
        Q[q2] = q2old;
        Q[q3] = q3old;
        return qperm;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Q = new int[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Q[x - 1] = y - 1;
        }
        int output = 0;
        for (int q1 = 0; q1 < N - 2; q1++) 
        {
            for (int q2 = q1 + 1; q2 < N - 1; q2++) 
            {
                for (int q3 = q2 + 1; q3 < N; q3++) 
                {
                    /* choose 3 queens q1, q2, q3 */
                    
                    output = output + QPerm(q1, q2, q3);
                }
            }
        }
        System.out.println(output);
        sc.close();
    }
}