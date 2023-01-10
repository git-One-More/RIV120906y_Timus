package Timus;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class Ex1039_AniversaryParty {
    static int[][] Q;
    static byte[]  ratings;
    static ArrayList<LinkedList<Integer>> tree;
    public static void DFS(int root) {
        Q[root][0] = 0;
        Q[root][1] = ratings[root];
        for (Integer node : tree.get(root)) {
            DFS(node);
            Q[root][1] += Q[node][0];
            Q[root][0] += Math.max(Q[node][0], Q[node][1]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ratings = new byte[N + 1];
        int[] parents = new int[N + 1];
        tree = new ArrayList<>();
        tree.add(0, new LinkedList<>());
        for (int i = 1; i <= N; i++) {
            ratings[i] = sc.nextByte();
            tree.add(i, new LinkedList<>());
        }
        int L = sc.nextInt();
        int K = sc.nextInt();
        while (L != 0 && K != 0) {
            tree.get(K).add(L);
            parents[L] = parents[L] + 1;
            L = sc.nextInt();
            K = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            if (parents[i] == 0) {
                tree.get(0).add(i);
            }
        }
        Q = new int[N + 1][2];
        DFS(0);
        System.out.println(Q[0][0]);
    }
}