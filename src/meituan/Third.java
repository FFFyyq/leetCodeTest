package meituan;

import java.util.*;

public class Third {

    public static int minCost(int n, int[] a, int[] b, int[] c) {
        // 将所有套娃按照大小从小到大排序
        List<int[]> dolls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dolls.add(new int[]{a[i], b[i], c[i]});
        }
        Collections.sort(dolls, (x, y) -> x[0] - y[0]);

        // 维护一个数组 dp，其中 dp[i] 表示将第 i 个套娃作为最内层套娃时的最小花费。
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            dp[i] = dolls.get(i)[2]; // 最初的状态就是只包含自己
        }

        // 对于每个套娃 i，遍历它前面的所有套娃 j，如果套娃 j 能够放入套娃 i 中，则更新 dp[i]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dolls.get(j)[1] > dolls.get(i)[0]) {
                    dp[i] = Math.min(dp[i], dp[j] + dolls.get(i)[2] * (dolls.get(i)[1] - dolls.get(j)[0]));
                }
            }
        }

        // 最后，dp 数组中的最小值即为最小花费。
        int minCost = 0;
        for (int i = 0; i < n; i++) {
            minCost += dp[i];
        }
        return minCost;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] a = {5, 4, 3};
        int[] b = {4, 2, 2};
        int[] c = {3, 2, 1};
        System.out.println(minCost(n, a, b, c)); // 输出 23
    }
}