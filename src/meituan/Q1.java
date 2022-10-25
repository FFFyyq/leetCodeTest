package meituan;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        for (int i = 0; i < x; i++) {
            stack1.push(sc.nextInt());
        }
        for (int i = 0; i < y; i++) {
            stack2.push(sc.nextInt());
        }
        int count = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int min = findMin(stack1, stack2);
            if ((!stack1.isEmpty() && stack1.peek() == min) || (!stack2.isEmpty() && stack2.peek() == min)) {
                count++;
                if (!stack1.isEmpty() && stack1.peek() == min)
                    stack1.pop();
                if (!stack2.isEmpty() && stack2.peek() == min)
                    stack2.pop();
            } else if (!stack1.isEmpty() && stack1.contains(min)) {
                stack2.push(stack1.pop());
                //stack1.pop();
                count ++;
            } else {
                stack1.push(stack2.pop());
                //stack2.pop();
                count ++;
            }
        }
        System.out.println("count :" + count);
    }

    public static int findMin(Deque<Integer> stack1, Deque<Integer> stack2) {
        int min = Integer.MAX_VALUE;
        for (Integer i : stack1) {
            if (i < min)
                min = i;
        }
        for (Integer i : stack2) {
            if (i < min)
                min = i;
        }
        return min;
    }
}
