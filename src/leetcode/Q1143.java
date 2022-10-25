package leetcode;

public class Q1143 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
    // 求两个字符串的最长公共子序列-动态规划
    public static int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j]表示以下标为i的字符结尾的text1和以下标为j的字符结尾的text2中的最长公共子序列
        int[][] dp = new int[text1.length()][text2.length()];
        int res = 0;
        // 遍历两个字符串
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (i == 0 || j == 0) { // 两个指针如果有一个指向首字符
                    if (text1.charAt(i) == text2.charAt(j)) { //两个字符相等
                        dp[i][j] = 1;
                        res = Math.max(res, dp[i][j]);
                    } else if (i == 0 && j != 0) { // 第一个指针指向首字符
                        dp[i][j] = dp[i][j - 1];
                    } else if (i != 0 && j == 0){ // 第二个指针指向尾字符
                        dp[i][j] = dp[i - 1][j];
                    }
                } else { // 两个指针都不指向首字符
                    if (text1.charAt(i) == text2.charAt(j)) //两个字符相等
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else //两个字符不相等
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
