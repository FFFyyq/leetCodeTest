package media;

import java.util.Scanner;

public class Third {
    public static int count(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num != 0) {
                if (num % 10 == 1) {
                    count++;
                }
                num /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = count(n);
        System.out.println(count);
    }
}
