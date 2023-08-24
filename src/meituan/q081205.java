package meituan;

import java.util.*;

public class q081205 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        int redNodes = dfs(1, -1, adjacencyList, weights);
        System.out.println(redNodes);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    private static int dfs(int node, int parent, List<List<Integer>> adjacencyList, int[] weights) {
        int redNodes = 0;

        for (int neighbor : adjacencyList.get(node)) {
            if (neighbor != parent) {
                int gcdValue = gcd(weights[node - 1], weights[neighbor - 1]);
                if (isPerfectSquare(gcdValue)) {
                    redNodes += dfs(neighbor, node, adjacencyList, weights) + 1;
                } else {
                    redNodes += dfs(neighbor, node, adjacencyList, weights);
                }
            }
        }

        return redNodes;
    }
}
