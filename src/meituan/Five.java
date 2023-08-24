package meituan;

import java.util.*;


import java.util.*;

public class Five {
    public static int findMaxK(int[] nums) {
        Arrays.sort(nums); // 升序排序
        int k = 1; // 最小未出现的自然数
        for (int num : nums) {
            if (num <= k) {
                k += num;
            } else {
                break;
            }
        }
        return k;
    }


    public static void main(String[] args) {
        int[] nums = {5, 0, 0, 2, 2};
        int maxK = findMaxK(nums);
        System.out.println(maxK); // 输出 4
    }
}
