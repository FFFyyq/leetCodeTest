package leetcode;

public class Q53 {
    // 求具有最大和的连续子数组
    public static void main(String[] args) {
        System.out.println(new Q53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public int maxSubArray(int[] nums) {
        // dp[i] 代表以下标i结尾的nums中的具有最大和的连续子数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (res < dp[i])
                res = dp[i];
        }
        return res;
    }
}
