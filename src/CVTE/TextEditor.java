package CVTE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextEditor {

    // 实现单词搜索功能
    public static List<String> search(String text, String keyword) {
        List<String> result = new ArrayList<>();
        String[] words = text.split("[ ,.]");  // 以空格、逗号、句号分词
        for (String word : words) {
            if (word.equalsIgnoreCase(keyword)) {
                result.add(word);  // 精准匹配
            } else if (isSimilar(word, keyword)) {
                result.add(word);  // 相似匹配
            }
        }
        return result;
    }

    // 判断两个单词是否相似
    private static boolean isSimilar(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (Math.abs(m - n) > 2) {
            return false;  // 长度差异大于2，不可能相似
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1;
                dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]+cost));
            }
        }
        return dp[m][n] < 3;
    }

    // 测试代码
    public static void main(String[] args) {
        System.out.println(search("hello,worls", "world"));
    }
}
