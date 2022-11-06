package leetcode;

public class Q72 {
    // 力扣72题，编辑距离（第一个单词转换成第二个单词所需要的最少操作数）——动态规划
    public static void main(String[] args) {
        System.out.println(new Q72().minDistance("a", "ab"));
    }
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();
        // dp[i][j]表示以下标i结尾的word1转换成以下标j结尾的word2需要的最少操作数
        int[][] dp = new int[word1.length()][word2.length()];

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                // 当当前字符相等时
                if (word1.charAt(i) == word2.charAt(j)) {
                    if (i == 0 && j == 0) // 都为首字符，则无需操作
                        dp[i][j] = 0;
                    else if (i != 0 && j == 0) // i不为首字符，j为首字符，word1删除i个字符即可
                        dp[i][j] = i;
                    else if (i == 0 && j != 0) // i为首字符，j不为首字符，word1添加j个字符即可
                        dp[i][j] = j;
                    else // 都不为首字符，不用操作
                        dp[i][j] = dp[i - 1][j - 1];
                } else { // 当前字符不等时
                    if (i == 0 & j == 0) // 都为首字符，则word1只需要替换一次
                        dp[i][j] = 1;
                    else if (i != 0 && j == 0) // i不为首字符，j为首字符，word1删除当前字符
                        dp[i][j] = dp[i - 1][j] + 1;
                    else if (i == 0 && j != 0) // i为首字符，j不为首字符，word1添加一个字符（转化成word2删除当前字符，word1添加一个字符跟word2删除一个字符的操作数是一样的）
                        dp[i][j] = dp[i][j - 1] + 1;
                    else // i和j都不为首字符，可替换word1当前字符（对应dp[i - 1][j - 1] + 1)、
                        // word1添加一个字符(转化成word2删除当前字符，word1添加一个字符跟word2删除一个字符的操作数是一样的)、word1删除当前字符(对应dp[i - 1][j] + 1)，取最小
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }

        return dp[word1.length() - 1][word2.length() - 1];
    }
}
