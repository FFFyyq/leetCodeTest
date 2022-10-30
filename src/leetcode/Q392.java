package leetcode;

public class Q392 {
    // 判断s是否为t的子序列——动态规划
    public static void main(String[] args) {
        System.out.println(new Q392().isSubsequence("abc","ahbgdc"));
    }
    public boolean isSubsequence(String s, String t) {
        // dp[i][j]表示以i为下标结尾的s和以j为下标结尾的t的最长公共子序列的长度
        // 只要s和t的最长公共子序列长度等于s的长度，s就为t的子序列
        // 问题转化成求s和t的最长公共子序列，同1143题
        int[][] dp = new int[s.length()][t.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (i == 0 || j == 0) {
                    if (s.charAt(i) == t.charAt(j)) {
                        dp[i][j] = 1;
                        res = Math.max(dp[i][j], res);
                    } else if (i == 0 && j != 0) {
                        dp[i][j] = dp[i][j - 1];
                        res = Math.max(dp[i][j], res);
                    } else if (i != 0 && j == 0) {
                        dp[i][j] = dp[i - 1][j];
                        res = Math.max(dp[i][j], res);
                    }
                } else {
                    if (s.charAt(i) == t.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        res = Math.max(dp[i][j], res);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                        res = Math.max(dp[i][j], res);
                    }
                }
            }
        }
        return res == s.length();
    }
}
