package leetcode;

import java.util.*;

public class Q39 {
    // 力扣39题，求组合总和——回溯做法
    public static void main(String[] args) {
        System.out.println(new Q39().combinationSum(new int[]{8,7,4,3}, 11));
    }
    // 暂存满足条件的情况
    Deque<Integer> path = new LinkedList<>();
    // 存放结果
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    // 回溯函数
    public void backtracking(int[] candidates, int target, int sum, int startIndex) {
        // 递归出口
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 通过startIndex控制for循环搜索范围，避免找到重复的组合
        // 当sum + candidates[i] <= target时，即path总和超过target，可以不用进入递归,这里是个剪枝优化，但前提是要先对candidates数组进行排序
        // 因为只有确保candidates数组是按顺序排列的，当sum + candidates[i] <= target时，后面的递归才不会出现满足条件的结果
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.push(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i); // startIndex不用加1，代表当前数字可重复使用
            path.pop();
            sum -= candidates[i];
        }
    }
}
