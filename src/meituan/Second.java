package meituan;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int ans = Math.min(a, b);
            int low = 1;
            int high = ans;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (a / mid + b / mid >= n) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            System.out.println(ans);
        }
    }
}
