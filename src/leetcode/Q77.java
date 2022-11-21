package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q77 {
    // 力扣77题,求[1,n]的长度为k的组合-回溯做法
    public static void main(String[] args) {
        System.out.println(new Q77().combine(1, 1));
    }
    // 存放结果
    public List<List<Integer>> res = new ArrayList<>();
    // 暂存每个符合条件的结果
    public Deque<Integer> path = new LinkedList<>();
    // 求组合入口
    public List<List<Integer>> combine(int n, int k) {
        // 递归入口
        backtracking(n, k, 1);
        return res;
    }
    // 回溯函数
    // 通过startIndex来控制递归搜索的区间，防止出现重复
    public void backtracking(int n, int k, int startIndex) {
        // 当path长度满足时，把path存进结果数组中，回溯出口
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            // 本层递归从[startIndex, n]中取一个数添加到path中
            path.push(i);
            // 下一层递归
            backtracking(n, k, i + 1);
            // 从下一层递归返回到本层递归时要对把刚添加到path中的元素移除，此处体现回溯
            path.pop();
        }
    }
}
