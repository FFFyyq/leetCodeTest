package webank;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int ans = countValidNumbers(l, r, x, y);
            System.out.println(ans);
        }
        scanner.close();
    }

    private static int countValidNumbers(int l, int r, int x, int y) {
        int ans = 0;
        for (int n = (int)(Math.pow(2, l) - 1); n <= y; n+=2) {
//            if (n < x)
//                continue;
            int ones = countOnes(n);
            if (ones >= l && ones <= r && (n & x) == x && (n | y) == y) {
                ans++;
            }
        }
        for (int n = (int)(Math.pow(2, l + 1) - 2); n <= y; n+=4) {
//            if (n < x)
//                continue;
            int ones = countOnes(n);
            if (ones >= l && ones <= r && (n & x) == x && (n | y) == y) {
                ans++;
            }
        }
        return ans;
    }

    private static int countOnes(int n) {
        int ones = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                ones++;
            }
            n >>= 1;
        }
        return ones;
    }
}