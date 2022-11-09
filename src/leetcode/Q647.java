package leetcode;

public class Q647 {
    // 力扣647题——计算回文子串的数量
    public static void main(String[] args) {
        System.out.println(new Q647().countSubstrings("aaa"));
    }
    public int countSubstrings(String s) {
        // dp[i][j]代表区间范围为[i,j]的子串是回文字串
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        // 遍历顺序是从下到上，从左到右，因为下面的递推公式会用到dp[i+1][j-1]，在数组中dp[i+1][j-1]位于dp[i][j]的左下角，需要先计算dp[i+1][j-1]才会使得全局正确
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) { // 两个字符不同，那就不是回文字串
                    dp[i][j] = false;
                } else { // 两个字符相同，可能是回文子串
                    if (j - i <= 1) { // 两字符距离小于等于1，则是回文子串
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) { // 除去i，j位置的两个字符外，剩下的部分是回文子串的话，那dp[i][j]也是回文子串
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return res;
    }
}
