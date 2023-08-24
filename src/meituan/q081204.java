package meituan;


import java.util.Scanner;

public class q081204 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int minWeight = getMinWeight(n, s);
        System.out.println(minWeight);
        Scanner scan = new Scanner(System.in);
        scan.nextInt();
    }

    private static int getMinWeight(int n, String s) {
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, s, visited, count);
            }
        }
        return count;
    }

    private static void dfs(int i, String s, boolean[] visited, int count) {
        visited[i] = true;
        for (int j = i + 1; j < s.length(); j++) {
            if (!visited[j] && s.charAt(j) == s.charAt(i)) {
                dfs(j, s, visited, count);
            }
        }
        for (int j = i - 1; j >= 0; j--) {
            if (!visited[j] && s.charAt(j) == s.charAt(i)) {
                dfs(j, s, visited, count);
            }
        }
    }
}

