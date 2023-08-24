package mhy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q081302 {
    static int maxCount = 1; // 将maxCount初始化为1

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
//            if (u - 1 > v - 1)
                adjList.get(u - 1).add(v - 1);
//            if (v - 1 > u - 1)
                adjList.get(v - 1).add(u - 1);
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(adjList, 1, 0, visited, k);

        System.out.println(maxCount);
    }

    private static void dfs(List<List<Integer>> adjList, int node, int distance, boolean[] visited, int k) {
        visited[node] = true;

        if (distance <= k) {
            maxCount++;
        }

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(adjList, neighbor, distance+1, visited, k);
            }
        }
    }
}
