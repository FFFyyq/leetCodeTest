package leetcode;

public class Q583 {
    // 力扣583题，给定两个单词，每次可以删除任意一个单词的一个字符，求使得两个单词相同的最小步数——动态规划
    public static void main(String[] args) {
        System.out.println(new Q583().minDistance("leetcode", "etco"));
    }
    public int minDistance(String word1, String word2) {
        // 求使得两个单词相同的最小步数，只需要找出两个单词的最长公共子序列，最长公共子序列以外的字符都是需要删除的字符，问题转化为求最长公共子序列，同Q1143
        // dp[i][j]表示以下标为i的字符结尾的text1和以下标为j的字符结尾的text2中的最长公共子序列
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (i == 0 || j == 0) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = 1;
                    } else if (i != 0 && j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (i == 0 && j != 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length() - 1][word2.length() - 1];
    }
}
