package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    // 力扣17题，求电话号码的字母组合——回溯
    public static void main(String[] args) {
        System.out.println(new Q17().letterCombinations("2"));
    }
    // 用于存放结果
    public List<String> res = new ArrayList<>();
    // 用于暂存满足条件的情况
    public StringBuffer sb = new StringBuffer();
    // 数字与字母的映射
    public String[] hash = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtracking(digits, 0);
        return res;
    }

    // 回溯函数
    public void backtracking(String digits, int index) {
        // 递归出口
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        // 先找出数字映射的字符串，取字符串的一个后进入递归
        String str = hash[digits.charAt(index) - '0' - 2];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtracking(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
