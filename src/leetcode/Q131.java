package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q131 {
    // 力扣131题，将字符串分割成一系列回文子串——回溯做法
    public static void main(String[] args) {
        System.out.println(new Q131().partition("aab"));
    }

    // 用于暂存满足条件的回文子串
    public Deque<String> path = new LinkedList<>();
    // 存储结果
    public List<List<String>> res = new ArrayList<>();

    // 递归入口
    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    // 回溯函数，startIndex用于控制分割线的起始位置
    public void backtracking(String s , int startIndex) {
        // 当分割线到达s的长度时，即找到满足要求的一组回文子串
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // 判断s的[startIndex,i]位置的子串是否为回文串，是的话添加进path同时进行递归
            if (isPalidrome(s, startIndex, i)) {
                path.addLast(s.substring(startIndex, i + 1));
            } else { //否的话跳过此次分割
                continue;
            }
            backtracking(s, i + 1);
            path.removeLast(); // 回溯
        }
    }

    // 判断s的子串是否是回文串
    public boolean isPalidrome(String s, int start, int end) {
        int i = start;
        int j = end;
        boolean res = true;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                res = false;
                break;
            }
            else {
                i++; j--;
            }
        }
        return res;
    }
}
