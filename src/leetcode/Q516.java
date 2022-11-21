package leetcode;

public class Q516 {
    public static void main(String[] args) {
        // 力扣516题，计算最长回文子序列——动态规划
        System.out.println(new Q516().longestPalindromeSubseq("cbbd"));
    }
    public int longestPalindromeSubseq(String s) {
        // dp[i][j]代表[i,j]范围的s的最长回文子序列长度
        int[][] dp = new int[s.length()][s.length()];
        // 遍历顺序是从下到上，从左到右，因为下面的递推公式会用到dp[i+1][j-1]，在数组中dp[i+1][j-1]位于dp[i][j]的左下角，需要先计算dp[i+1][j-1]才会使得全局正确
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1; // 初始化
            for (int j = i + 1; j < s.length(); j++) { // j从i+1开始，因为根据定义j始终是大于等于i的
                if (s.charAt(i) == s.charAt(j))  //两个字符相等的话，最长回文子序列长度等于去掉这两个字符剩下的字符串的最长回文子序列长度+2
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else // 两个字符不相等
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
            }
        }
        return dp[0][s.length() - 1];
    }
}
