package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q216 {
    // 力扣216题，从1-9找出相加为n的k个数的组合，每个数字只能用一次——回溯做法
    public static void main(String[] args) {
        System.out.println(new Q216().combinationSum3(3,7));
    }
    // 暂存每一个满足条件的组合
    public Deque<Integer> path = new LinkedList<>();
    // 存放结果
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 回溯入口
        backtracking(k, n, 1, 0);
        return res;
    }
    // 回溯函数
    // 通过startIndex来控制递归搜索的区间，防止出现重复
    // 通过sum来计算当前path中的和为多少
    public void backtracking(int k, int n, int startIndex, int sum) {
        // 当path中的和已经大于n，不需要接着递归下去，直接结束
        if (sum > n)
            return;
        // 递归出口
        if (path.size() == k) {
            if (sum == n)
                res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9 ; i++) {
            // 本层递归从[startIndex, n]中取一个数添加到path中
            path.push(i);
            sum += i;
            // 下一层递归
            backtracking(k, n, i + 1, sum);
            // 从下一层递归返回到本层递归时要对把刚添加到path中的元素移除，且要从sum把这个元素的值减去，此处体现回溯
            path.pop();
            sum -= i;
        }
    }
}
