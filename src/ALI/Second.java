package ALI;

import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i =  0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (isLongCity(arr, i, j))
                    res += 1;
            }
        }
        System.out.println(res);
    }


    public static boolean isLongCity(int[] nums, int left, int right) {
        if (right - left == 1) {
            if (nums[left] == nums[right])
                return false;
            else
                return true;
        }
        if (right - left == 0)
            return true;
        for (int i = left + 2; i <= right; i++) {
            if (nums[i - 1] == nums[i] || (nums[i - 2] != nums[i] && nums[i - 1] != nums[i])) {
                return false;
            }
        }
        return true;
    }


}
