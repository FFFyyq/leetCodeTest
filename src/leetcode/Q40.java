package leetcode;

import java.util.*;

public class Q40 {
    public static void main(String[] args) {
        // 力扣40题，求组合总和，数组中的每个数组在每个组合中只能用一次，数组中会出现重复数字——回溯做法
        System.out.println(new Q40().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
    // 用于暂存满足要求的组合
    public Deque<Integer> path = new LinkedList<>();
    // 用于存放结果
    public List<List<Integer>> res = new ArrayList<>();
    // 用于辅助判断遍历到的元素是否在本层已经使用过
    public boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        // 为了将重复的数字放在一起，先进行排序
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }
    public void backtracking(int[] candidates, int target, int startIndex, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 若当前遍历到的元素不是第一次出现，查看used[i-1]可知道当前元素是否使用过，若使用过本次循环应跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            sum += candidates[i];
            path.push(candidates[i]);
            backtracking(candidates, target, i + 1, sum);
            used[i] = false;
            sum -= candidates[i];
            path.pop();
        }
    }
}
