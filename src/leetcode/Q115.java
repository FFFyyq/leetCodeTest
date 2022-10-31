package leetcode;

public class Q115 {
    // 求s的子序列中t出现的次数——动态规划
    public static void main(String[] args) {
        System.out.println(new Q115().numDistinct("rabbbit", "rabbit"));
    }
    public int numDistinct(String s, String t) {
        // dp[i][j]代表以i下标结尾的s的子序列包含以j下标结尾的t的次数
        int[][] dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                // 当s的长度比t的长度短，s不可能包含t，所以直接跳过循环
                if (i < j)
                    continue;
                // 当s结尾字符跟t结尾字符一样的话，有下面三种情况
                if (s.charAt(i) == t.charAt(j)) {
                    if (i == 0 && j == 0) // s和t长度都为1，s只包含t一次
                        dp[i][j] = 1;
                    else if (i != 0 && j == 0) // s的长度大于1，t的长度为1
                        dp[i][j] = dp[i - 1][j] + 1;
                    else // s的长度跟t的长度都不为1
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; // 用当前字符做匹配和不用当前字符做匹配
                } else { // 当s结尾字符跟t结尾字符不一样的话，有下面两种情况
                    if (i == 0 && j == 0) // s和t的长度都为1
                        dp[i][j] = 0;
                    else // s的长度不为1
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length() - 1][t.length() - 1];
    }
}
