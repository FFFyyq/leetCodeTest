package meituan;

import java.util.Scanner;


public class First {
    public static int minOperations(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            if (s.charAt(0) == t.charAt(0)) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
            }

        }
        for (int i = 0; i < m; i++) {
            if (s.substring(0, i + 1).contains(t.substring(0, 1))) {
                dp[i][0] = i;
            } else {
                dp[i][0] = i + 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        while (c -- > 0) {
            String s = scanner.next();
            String t = scanner.next();
            int minOps = minOperations(s, t);
            System.out.println(minOps);
        }

    }
}
