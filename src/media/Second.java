package media;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(N);
        scanner.nextLine();
        while (N-- > 0) {
            String s = scanner.nextLine();
            System.out.println(s);
            String[] strArr = s.split(" ");
            int[] arr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
            System.out.println(findMinIndex(arr));
        }

    }

    public static int findMinIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
