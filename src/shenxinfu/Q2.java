package shenxinfu;

import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,9,5,7,3}));
    }
    public static int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<>();
        int max_area = 0; // 最大矩形面积
        int tp; // 栈顶
        int area_with_top;

        int i = 0;
        int n = height.length;
        while (i < n) {
            if (s.empty() || height[s.peek()] <= height[i]) {
                s.push(i++);
            } else {
                tp = s.pop();
                area_with_top = height[tp] * (s.empty() ? i : i - s.peek() - 1);
                max_area = Math.max(max_area, area_with_top);
            }
        }

        while (!s.empty()) {
            tp = s.pop();
            area_with_top = height[tp] * (s.empty() ? i : i - s.peek() - 1);
            max_area = Math.max(max_area, area_with_top);
        }
        return max_area;
    }
}
