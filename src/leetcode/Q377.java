package leetcode;

public class Q377 {
    public static void main(String[] args) {
        System.out.println(combinationSum5(new int[]{1,2,3}, 4));
    }
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static int combinationSum5(int[] nums, int target) {
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= target; j++) {
            if (j % nums[0] == 0)
                dp[0][j] = 1;
        }
        for (int j = 1; j <= target; j++) {
            for (int i = 1; i < nums.length; i++) {
                for (int k = 0; k <= i; k++) {
                    if (j >= nums[k])
                        dp[i][j] += dp[i][j - nums[k]];
                }

            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[nums.length - 1][target];
    }
}
