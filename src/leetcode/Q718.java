package leetcode;

public class Q718 {
    // 求两个数组的公共连续最长子数组-动态规划
    public int findLength(int[] nums1, int[] nums2) {
        // dp[i][j]代表以下标为i结尾的nums1和以下标为j结尾的nums2，中公共连续最长子数组的长度
        int[][] dp = new int[nums1.length][nums2.length];
        // 记录结果
        int res = 0;
        // 用两个指针指向两个数组，遍历两个数组
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                // 当两个指针都指向第一个元素时且相等时
                if ((i == 0 || j== 0) && nums1[i] == nums2[j]) {
                    dp[i][j] = 1;
                    res = Math.max(res, dp[i][j]);
                }
                // 当两个指针指向的元素相同时
                else if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]); //遍历过程中查找nums1和nums2的公共连续最长子数组的长度
                }
            }
        }
        return res;
    }
}
