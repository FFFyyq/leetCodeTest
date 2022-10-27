package leetcode;

public class Q1035 {
    public static void main(String[] args) {
        System.out.println(new Q1035().maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
    }
    // 绘制不相交的线-动规，可以转化为求最长公共子序列（不连续），因为子序列顺序不会变，连线不会相交,同1143题
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // dp[i][j]表示以下标i结尾的nums1和以下标j结尾的num2的最长公共子序列长度
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (i == 0 || j == 0) {
                    if (nums1[i] == nums2[j])
                        dp[i][j] = 1;
                    else if (i == 0 && j != 0)
                        dp[i][j] = dp[i][j - 1];
                    else if (i != 0 && j == 0)
                        dp[i][j] = dp[i - 1][j];
                } else {
                    if (nums1[i] == nums2[j])
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }
}
