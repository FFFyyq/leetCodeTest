package lange;

import java.util.Arrays;
import java.util.Comparator;

public class Q {
    public static void main(String[] args) {
//        Integer[] arr = new Integer[]{100,1,1,1,1,1,1,1,1,1};
//        Solution solution = new Solution();
//        solution.sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }
//        int a;
//        a = 6;
//        System.out.println(a);
//        System.out.println(++a);
//        System.out.println(a);
        double d = 0x12345678;
        float f= -412;
        long test = 012;
        System.out.println(Solution.foo(5));
    }

}

class Solution {

    public String sort(Integer[] nums) {

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);

                if((s1 + s2).compareTo(s2 + s1) < 0)
                    return 1;
                else
                    return -1;
            }
        });
        return Arrays.toString(nums);
    }
    public static  int foo (int n) {
        if (n <= 2)
            return n;
        return foo(n - 1) + foo(n- 2);
    }
}
